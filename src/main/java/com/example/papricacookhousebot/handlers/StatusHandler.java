package com.example.papricacookhousebot.handlers;

import com.example.papricacookhousebot.service.TelegramBot;
import com.example.papricacookhousebot.util.TransitionHelper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component("defaultHandler")
public abstract class StatusHandler {

    @Lazy
    @Autowired
    protected TelegramBot telegramBot;

    @Autowired
    protected TransitionHelper transitionHelper;

    @SneakyThrows
    public void process(Update update) {
        telegramBot.sendMessage(update, "Сработал обработчик "+(this.getClass().getSimpleName()));
    }

}
