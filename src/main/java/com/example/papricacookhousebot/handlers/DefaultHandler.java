package com.example.papricacookhousebot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class DefaultHandler extends StatusHandler {

    @Override
    public void process(Update update) {
        super.process(update);
    }
}
