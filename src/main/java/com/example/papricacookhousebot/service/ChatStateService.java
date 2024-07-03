package com.example.papricacookhousebot.service;

import com.example.papricacookhousebot.enums.Status;
import com.example.papricacookhousebot.objects.ChatState;
import com.example.papricacookhousebot.repositories.ChatStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatStateService {

    @Autowired
    private ChatStateRepository chatStateRepository;

    public void registerIfChatNotExists(Long chatId) {
        if (chatStateRepository.findStateByChatId(chatId) == null) {
            chatStateRepository.save(new ChatState(chatId, Status.NOT_AUTHORIZED));
            log.info("Зарегистрирован чат №{} в БД", chatId);
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
