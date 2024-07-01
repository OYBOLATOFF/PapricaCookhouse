package com.example.papricacookhousebot.handlers;

import com.example.papricacookhousebot.service.TelegramBot;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("defaultHandler")
public abstract class StatusHandler {

    @Lazy
    @Autowired
    protected TelegramBot telegramBot;

    @SneakyThrows
    public void process(Update update) {
        SendMessage newMessage = new SendMessage(
                update.getMessage().getChatId()+"",
                "Сработал обработчик "+(this.getClass().getSimpleName())
        );

        telegramBot.execute(newMessage);
    }

}
