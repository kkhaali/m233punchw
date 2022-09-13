package com.example.punchclock.controller;

import com.example.punchclock.model.Category;
import com.example.punchclock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> get() {
        return categoryService.findAll();
    }

    @PostMapping("/categories")
    public ResponseEntity create(@RequestBody Category category) {
        if (category.getTitle().length() > 0) {
            categoryService.createCategory(category);
            return new ResponseEntity(category, HttpStatus.OK);
        } else {
            return new ResponseEntity("Title unchanged!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity update(@RequestBody Category category, @PathVariable Long id) {
        if (category.getTitle().length() > 0) {
            categoryService.update(id, category);
            category.setId(id);
            return new ResponseEntity(category, HttpStatus.OK);
        } else {
            return new ResponseEntity("Title unchanged!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
