package com.example.papricacookhousebot.handlers;

import com.example.papricacookhousebot.enums.Status;
import com.example.papricacookhousebot.service.TelegramBot;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.papricacookhousebot.enums.Status.AUTHORIZED;
import static com.example.papricacookhousebot.enums.Status.EDITING_ITEM;

@Component
public class NotAuthorizedHandler extends StatusHandler {

    @Override
    public void process(Update update) {
        telegramBot.sendMessage(update, "Сейчас я попытаюсь перевести в статус AUTHORIZED");
        if (transitionHelper.makeTransition(update, AUTHORIZED)) {
            telegramBot.sendMessage(update, "Успешно переведено в статус AUTHORIZED");
        } else {
            telegramBot.sendMessage(update, "Не удалось перейти в состояние AUTHORIZED");
        }
    }

}
