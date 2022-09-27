package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payloads.CategoryDto;

public interface CategoryService {
	// Create
	CategoryDto createCategory(CategoryDto categoryDto);

	// Update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// Delete
	void deleteCategory(Integer categoryId);

	// Get
	CategoryDto getCategory(Integer categoryId);

	// Get all Category
	List<CategoryDto> getAllCategory();
}
