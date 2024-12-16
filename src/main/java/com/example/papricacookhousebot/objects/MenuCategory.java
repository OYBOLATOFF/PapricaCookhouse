package com.example.papricacookhousebot.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String categoryName;

    public MenuCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}
