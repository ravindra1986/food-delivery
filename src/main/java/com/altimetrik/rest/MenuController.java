package com.altimetrik.rest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.altimetrik.model.Menu;
import com.altimetrik.model.MenuItem;
import com.altimetrik.repository.MenuItemRepository;
import com.altimetrik.repository.MenuRepository;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/menus")
public class MenuController {
	@Autowired
    private MenuRepository mr;

    @Autowired
    private MenuItemRepository mir;

    @GetMapping("/")
    public List<Menu> getMenus() {
        return mr.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Menu> findMenuById(@PathVariable("id") Long id) {
        return mr.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Menu> menuList) {
        mr.saveAll(menuList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        mr.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        mr.deleteById(id);
    }

    @RequestMapping("/{id}/items/")
    public List<MenuItem> getItems(@PathVariable("id") Long id) {
        Optional<Menu> menu = mr.findById(id);
        if (menu == null)
            return null;
        return mir.findByMenu_Id(id);
    }

    
}
