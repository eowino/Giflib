package com.eo.giflib.data;

import com.eo.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    private final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "People"),
            new Category(3, "Destruction")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for(Category category : ALL_CATEGORIES) {
            if(category.getId() == id) {
                return category;
            }
        }

        return null;
    }

    public Category findByName(String name) {
        for(Category category : ALL_CATEGORIES) {
            if(category.getName().equals(name)) {
                return category;
            }
        }

        return null;
    }
}
