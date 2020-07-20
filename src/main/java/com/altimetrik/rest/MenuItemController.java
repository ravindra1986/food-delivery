package com.altimetrik.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.altimetrik.model.MenuItem;
import com.altimetrik.repository.MenuItemRepository;

import java.util.List;
import java.util.Optional;
public class MenuItemController {
	@Autowired
    private MenuItemRepository mir;

    @GetMapping("/")
    public List<MenuItem> getMenItems() {
        return mir.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MenuItem> findMenuById(@PathVariable("id") Long id) {
        return mir.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<MenuItem> menuItemList) {
        mir.saveAll(menuItemList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        mir.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        mir.deleteById(id);
    }
}
