package com.medtalk.org.services.impl;


import com.medtalk.org.entity.Category;
import com.medtalk.org.entity.User;
import com.medtalk.org.exceptions.ResourceNotFoundException;
import com.medtalk.org.payloads.CategoryDto;
import com.medtalk.org.payloads.UserDto;
import com.medtalk.org.repository.CategoryRepo;
import com.medtalk.org.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto){
        Category category=this.dtoToCategory(categoryDto);
        Category savedCategory = this.categoryRepo.save(category);
        this.categoryRepo.save(category);
        return this.categoryToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId){
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("category","id",categoryId));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCategory = this.categoryRepo.save(category);
        CategoryDto categoryDto1= this.categoryToDto(updatedCategory);


        return categoryDto1;
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId){
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category"," Id ",categoryId));

        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory(){
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());
        return categoryDtos;
    }



    @Override
    public void deleteCategory(Integer categoryId){
        Category category= this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category"," Id ",categoryId));
        this.categoryRepo.delete(category);
    }






    private Category dtoToCategory (CategoryDto categoryDto) {
        Category category= this.modelMapper.map(categoryDto,Category.class);

        return category;
    }

    public CategoryDto categoryToDto (Category category) {
        CategoryDto categoryDto= this.modelMapper.map(category,CategoryDto.class);

        return categoryDto;
    }
}
