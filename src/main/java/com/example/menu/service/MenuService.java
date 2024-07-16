package com.example.menu.service;

import com.example.menu.entity.Menu;
import com.example.menu.entity.dto.MenuRequestDto;
import com.example.menu.entity.dto.MenuResponseDto;
import com.example.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public MenuResponseDto getFoodById(String id) {
        var food = this.menuRepository.findById(UUID.fromString(id));
        if(food.isPresent()) {
            return new MenuResponseDto(food.get());
        }
        return null;
    }

    public List<MenuResponseDto> getAllFoods() {
        return this.menuRepository.findAll().stream().map(MenuResponseDto::new).toList();
    }

    public MenuResponseDto addFood(MenuRequestDto menuRequestDto) {
        return new MenuResponseDto(this.menuRepository.save(new Menu(menuRequestDto)));
    }

    public void removeFood(String id) {
        if(this.menuRepository.existsById(UUID.fromString(id))) {
            this.menuRepository.deleteById(UUID.fromString(id));
        }
    }
}
