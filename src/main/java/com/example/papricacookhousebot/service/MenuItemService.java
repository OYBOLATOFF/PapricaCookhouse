package com.example.papricacookhousebot.service;

import com.example.papricacookhousebot.objects.MenuItem;
import com.example.papricacookhousebot.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> findAllItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> findAllItems(String categoryName) {
        return menuItemRepository.findAllByCategoryCategoryName(categoryName);
    }
}
