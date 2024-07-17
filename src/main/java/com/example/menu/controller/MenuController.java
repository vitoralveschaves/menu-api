package com.example.menu.controller;

import com.example.menu.entity.dto.MenuRequestDto;
import com.example.menu.entity.dto.MenuResponseDto;
import com.example.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuResponseDto>> getAllFoods() {
        var foods = this.menuService.getAllFoods();
        return ResponseEntity.status(HttpStatus.OK).body(foods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResponseDto> searchFood(@PathVariable("id") String id) {
        var food = this.menuService.getFoodById(id);
        return ResponseEntity.status(HttpStatus.OK).body(food);
    }

    @PostMapping
    public ResponseEntity<MenuResponseDto> addFood(@RequestBody MenuRequestDto menuRequestDto) {
        var food = this.menuService.addFood(menuRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(food);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFood(@PathVariable("id") String id) {
        this.menuService.removeFood(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
