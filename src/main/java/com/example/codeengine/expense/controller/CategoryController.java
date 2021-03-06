package com.example.codeengine.expense.controller;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class CategoryController {

    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PostMapping("/category")
//    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
//        Category result = categoryRepository.save(category);
//        return new ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);

//    }

}
