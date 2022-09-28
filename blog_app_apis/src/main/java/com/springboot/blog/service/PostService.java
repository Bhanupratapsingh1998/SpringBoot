package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payloads.PostDto;
import com.springboot.blog.payloads.PostResponse;


public interface PostService {
	// Create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update
	PostDto updatePost(PostDto postDto, Integer postId);

	// Delete
	void deletePost(Integer postId);

	// Get all posts
	PostResponse getAllPost(Integer pageNum, Integer pageSize,String sortBy,String sortDir);

	// Get single post
	PostDto getPostById(Integer postId);

	// Get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// Get all posts by user
	List<PostDto> getPostsByUser(Integer userId);

	// Search posts
	List<PostDto> searchPosts(String keyword);

}
