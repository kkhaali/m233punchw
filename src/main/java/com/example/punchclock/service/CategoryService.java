package com.example.punchclock.service;

import com.example.punchclock.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        categoryRepository.save(category);
        return category;
    }

    public Category update(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setTitle(category.getTitle());
        categoryRepository.save(categoryToUpdate);
        return categoryToUpdate;
    }

    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
