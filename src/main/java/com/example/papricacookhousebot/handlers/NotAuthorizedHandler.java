package com.example.papricacookhousebot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.papricacookhousebot.config.BotMessagesConfiguration.*;
import static com.example.papricacookhousebot.enums.Status.AUTHORIZED;
import static com.example.papricacookhousebot.util.KeyboardHelper.*;

@Component
public class NotAuthorizedHandler extends StatusHandler {

    @Override
    public void process(Update update) {
        if (telegramBot.adminPasswordIsCorrect(update)) {
            if (transitionHelper.makeTransition(update, AUTHORIZED)) {
                telegramBot.sendMessage(update, AUTHORIZATION_SUCCESSFUL, OPEN_MENU_KEYBOARD);
            } else {
                telegramBot.sendMessage(update, SOMETHING_WENT_WRONG);
            }
        } else {
            telegramBot.sendMessage(update, AUTHORIZATION_NOT_SUCCESSFUL);
        }
    }

}
