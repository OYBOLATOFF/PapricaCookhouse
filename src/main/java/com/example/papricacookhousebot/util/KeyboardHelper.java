package com.example.papricacookhousebot.util;

import com.example.papricacookhousebot.repositories.MenuCategoryRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class KeyboardHelper {

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public static final ReplyKeyboard OPEN_MENU_KEYBOARD = ReplyKeyboardMarkup.builder()
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text("📖 Открыть меню").build()
            )))
            .resizeKeyboard(true)
            .build();

    public static ReplyKeyboard MENU_KEYBOARD;

    @PostConstruct
    private void init() {
        setMenuKeyboard();
    }

    private void setMenuKeyboard() {
        List<KeyboardRow> keyboardRows = new ArrayList<>(List.of(
                new KeyboardRow(List.of(new KeyboardButton("Все категории")))));

        keyboardRows.addAll(mapCategoriesToKeyboardRows());
        MENU_KEYBOARD = new ReplyKeyboardMarkup(keyboardRows, true, false, true, "Выберите категорию");
    }

    private List<KeyboardRow> mapCategoriesToKeyboardRows() {
        List<KeyboardButton> categories = menuCategoryRepository.findAll()
                .stream()
                .map(category -> new KeyboardButton(category.getCategoryName()))
                .toList();

        return Lists.partition(categories, 2)
                .stream()
                .map(KeyboardRow::new)
                .toList();
    }

}
