package com.example.papricacookhousebot.service;

import com.example.papricacookhousebot.config.BotConfiguration;
import com.example.papricacookhousebot.objects.StateMachine;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private Logger logger = LoggerFactory.getLogger(TelegramBot.class);

    @Autowired
    private BotConfiguration botConfig;

    @Autowired
    @Lazy
    private StateMachine stateMachine;


    @Override
    public void onUpdateReceived(Update update) {
        logger.info("Пришло новое сообщение от {}", update.getMessage().getFrom().getUserName());
        stateMachine.process(update);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @SneakyThrows
    public void sendMessage(Long chatId, String text) {
        SendMessage newMessage = new SendMessage(chatId+"", text);
        execute(newMessage);
    }

    @SneakyThrows
    public void sendMessage(Update update, String text) {
        Long chatId = update.getMessage().getChatId();
        SendMessage newMessage = new SendMessage(chatId+"", text);
        execute(newMessage);
    }
}
