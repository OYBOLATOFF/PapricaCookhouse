package com.example.papricacookhousebot.repositories;

import com.example.papricacookhousebot.objects.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Integer> {
}
