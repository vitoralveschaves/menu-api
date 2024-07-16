package com.example.menu.entity.dto;

import com.example.menu.entity.Menu;

import java.util.UUID;

public record MenuResponseDto(UUID id, String name, String image, Double price) {
    public MenuResponseDto(Menu menu) {
        this(menu.getId() ,menu.getName(), menu.getImage(), menu.getPrice());
    }
}
