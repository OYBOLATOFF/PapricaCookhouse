package com.example.papricacookhousebot.objects;

import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MenuCategory category;

}
