package com.example.papricacookhousebot.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardHelper {

    public static ReplyKeyboard OPEN_MENU_KEYBOARD = ReplyKeyboardMarkup.builder()
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text("Открыть меню").build()
            )))
            .resizeKeyboard(true)
            .build();

}
