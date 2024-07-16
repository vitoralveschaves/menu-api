package com.example.menu.entity;

import com.example.menu.entity.dto.MenuRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "menu")
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String image;
    private Double price;

    public Menu(MenuRequestDto menuRequestDto) {
        this.name = menuRequestDto.name();
        this.image = menuRequestDto.image();
        this.price = menuRequestDto.price();
    }
}
