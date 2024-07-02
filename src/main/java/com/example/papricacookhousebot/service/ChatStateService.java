package com.example.papricacookhousebot.service;

import com.example.papricacookhousebot.enums.Status;
import com.example.papricacookhousebot.objects.ChatState;
import com.example.papricacookhousebot.repositories.ChatStateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatStateService {

    private Logger logger = LoggerFactory.getLogger(ChatStateService.class);

    @Autowired
    private ChatStateRepository chatStateRepository;

    public void registerIfChatNotExists(Long chatId) {
        if (chatStateRepository.findStateByChatId(chatId) == null) {
            chatStateRepository.save(new ChatState(chatId, Status.NOT_AUTHORIZED));
            logger.info("Зарегистрирован чат №{} в БД", chatId);
        }
    }

    public Status getStatus(Long chatId) {
        ChatState state = chatStateRepository.findStateByChatId(chatId);
        return state.getStatus();
    }

    public void setStatus(Long chatId, Status newStatus) {
        chatStateRepository.save(new ChatState(chatId, newStatus));
    }
}
