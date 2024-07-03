package com.example.papricacookhousebot.service;

import com.example.papricacookhousebot.config.BotConfiguration;
import com.example.papricacookhousebot.objects.StateMachine;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private BotConfiguration botConfig;

    @Autowired
    @Lazy
    private StateMachine stateMachine;


    @Override
    public void onUpdateReceived(Update update) {
        log.info("Пришло новое сообщение от {}", update.getMessage().getFrom().getUserName());
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
        String chatId = update.getMessage().getChatId()+"";
        SendMessage newMessage = new SendMessage(chatId, text);
        execute(newMessage);
    }

    @SneakyThrows
    public void sendMessage(Update update, String text, ReplyKeyboard keyboard) {
        String chatId = update.getMessage().getChatId()+"";
        execute(SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .replyMarkup(keyboard)
                .build());
    }

    public boolean adminPasswordIsCorrect(Update update) {
        String password = update.getMessage().getText();
        return botConfig.getSecretPassword().equals(password);
    }
}
