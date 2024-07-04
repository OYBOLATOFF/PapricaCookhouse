package com.example.papricacookhousebot.objects;

import com.example.papricacookhousebot.enums.Status;
import com.example.papricacookhousebot.handlers.DefaultHandler;
import com.example.papricacookhousebot.handlers.StatusHandler;
import com.example.papricacookhousebot.repositories.StatusRepository;
import com.example.papricacookhousebot.util.TransitionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class StateMachine {

    private final Map<Status, StatusHandler> handlers = new HashMap<>();

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DefaultHandler defaultHandler;

    @Autowired
    private TransitionHelper transitionHelper;

    @PostConstruct
    private void init() {
        prepareHandlersMap();
    }

    public void process(Update update) {
        Status status = transitionHelper.getChatStatus(update);
        handlers.getOrDefault(status, defaultHandler).process(update);
    }

    private void prepareHandlersMap() {
        List<List<String>> statuses = statusRepository.findAllStatusesAndHandlers();
        statuses.forEach(status -> {
            String statusName = status.get(0);
            String handlerClassName = status.get(1);

            if (handlerClassName == null) {
                log.warn("Для статуса {} не задан обработчик в базе данных", statusName);
                return;
            }
            try {
                Class<?> handlerClass = Class.forName("com.example.papricacookhousebot.handlers."+handlerClassName);
                StatusHandler statusHandler = (StatusHandler) applicationContext.getBean(handlerClass);
                handlers.put(Status.valueOf(statusName), statusHandler);
                log.info("Зарегистрирован обработчик {} для статуса {}", handlerClassName, statusName);
            } catch (ClassNotFoundException e) {
                log.warn("Не удалось подтянуть обработчик {} для статуса {}", handlerClassName, statusName);
            }
        });

        log.info("Маппинг обработчиков прошел успешно: {}", handlers);
    }

}
