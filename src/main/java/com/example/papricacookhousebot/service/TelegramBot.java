package com.example.papricacookhousebot.service;

import com.example.papricacookhousebot.config.BotConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private Logger logger = LoggerFactory.getLogger(TelegramBot.class);

    @Autowired
    private BotConfiguration botConfig;


    @Override
    public void onUpdateReceived(Update update) {
        logger.info("Пришло новое сообщение. ID: {}", update.getUpdateId());
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }
}
