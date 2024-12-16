package com.example.papricacookhousebot.repositories;

import com.example.papricacookhousebot.objects.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    List<MenuItem> findAllByCategoryCategoryName(String categoryName);

}
