package com.example.papricacookhousebot.handlers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AuthorizedHandler extends StatusHandler {
    @Override
    public void process(Update update) {
        super.process(update);
    }
}
