package com.medtalk.org.services;


import com.medtalk.org.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);
    CategoryDto updateCategory(CategoryDto category,Integer categoryId);
    CategoryDto getCategoryById(Integer categoryId);
    List<CategoryDto> getAllCategory();
    void deleteCategory(Integer categoryId);

}
