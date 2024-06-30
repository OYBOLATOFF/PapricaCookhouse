package com.example.papricacookhousebot;

import com.example.papricacookhousebot.service.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInitializer {

    private Logger logger = LoggerFactory.getLogger(BotInitializer.class);

    @Autowired
    private TelegramBot telegramBot;

    @EventListener({ContextRefreshedEvent.class})
    public void initialize() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBot);
            logger.info("Телеграм бот '{}' успешно запущен. Api key: {}", telegramBot.getBotUsername(), telegramBot.getBotToken());
        } catch (TelegramApiException apiException) {
            logger.error("Не удалось запустить телеграм-бота");
        }
    }

}
