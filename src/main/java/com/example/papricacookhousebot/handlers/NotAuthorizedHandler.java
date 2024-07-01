package com.example.papricacookhousebot.handlers;

import com.example.papricacookhousebot.service.TelegramBot;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class NotAuthorizedHandler extends StatusHandler {

    @Override
    @SneakyThrows
    public void process(Update update) {
        SendMessage newMessage = new SendMessage();
        newMessage.setChatId(update.getMessage().getChatId()+"");
        newMessage.setText("Вы не авторизованы ещё!");
        telegramBot.execute(newMessage);
    }

}
