package com.example.papricacookhousebot.handlers;

import com.example.papricacookhousebot.objects.MenuItem;
import com.example.papricacookhousebot.repositories.MenuCategoryRepository;
import com.example.papricacookhousebot.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static com.example.papricacookhousebot.config.BotMessagesConfiguration.CATEGORY_NOT_FOUND;
import static com.example.papricacookhousebot.enums.Status.SELECTED_ITEM;
import static com.example.papricacookhousebot.util.KeyboardHelper.itemsToKeyboard;

@Component
public class WatchingMenuHandler extends StatusHandler {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Override
    public void process(Update update) {
        String commandText = update.getMessage().getText().toLowerCase();
        if (!isCategory(commandText)) {
            telegramBot.sendMessage(update, CATEGORY_NOT_FOUND);
            return;
        }

        List<MenuItem> menuItemList = menuItemService.findAllItems(commandText);
        telegramBot.sendMessage(update, "Категория отображена", itemsToKeyboard(menuItemList));
        transitionHelper.makeTransition(update, SELECTED_ITEM);
    }

    private boolean isCategory(String categoryName) {
        return menuCategoryRepository.existsByCategoryName(categoryName);
    }
}
