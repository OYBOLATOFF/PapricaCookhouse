package com.example.papricacookhousebot.util;

import com.example.papricacookhousebot.enums.Status;
import com.example.papricacookhousebot.repositories.ChatStateRepository;
import com.example.papricacookhousebot.repositories.StatusRepository;
import com.example.papricacookhousebot.service.ChatStateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TransitionHelper {

    private Map<Status, List<Status>> transitionRules = new HashMap<>();

    private Logger logger = LoggerFactory.getLogger(TransitionHelper.class);

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ChatStateService chatStateService;

    @PostConstruct
    private void init() {
        prepareTransitionRulesMap();
    }

    private boolean canMakeTransition(Status fromStatus, Status toStatus) {
        return transitionRules.get(fromStatus).contains(toStatus);
    }

    private void prepareTransitionRulesMap() {
        List<List<String>> result = statusRepository.findAllTransitionRules();
        result.forEach(rule -> {
            Status key = Status.valueOf(rule.get(0));
            Status value = Status.valueOf(rule.get(1));
            if (transitionRules.containsKey(key)) {
                transitionRules.get(key).add(value);
            } else {
                transitionRules.put(key, new ArrayList<>(List.of(value)));
            }
        });
        logger.info("Правила перехода состояний считаны: {}", transitionRules);
    }

    public boolean makeTransition(Update update, Status newStatus) {
        Status currentStatus = getChatStatus(update);
        if (canMakeTransition(currentStatus, newStatus)) {
            Long chatId = update.getMessage().getChatId();
            chatStateService.setStatus(chatId, newStatus);
            return true;
        } else {
            logger.error("Нельзя совершить переход из {} в {} для {}", currentStatus, newStatus, update.getMessage().getFrom().getUserName());
            return false;
        }
    }

    public Status getChatStatus(Update update) {
        Long chatId = update.getMessage().getChatId();
        chatStateService.registerIfChatNotExists(chatId);
        return chatStateService.getStatus(chatId);
    }
}
