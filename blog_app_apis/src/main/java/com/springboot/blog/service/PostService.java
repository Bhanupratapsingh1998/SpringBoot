package com.springboot.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Post;
import com.springboot.blog.payloads.PostDto;

@Service
public interface PostService {
	//Create
	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	//Update 
	Post updatePost(PostDto postDto,Integer postId);
	
	//Delete
	void deletePost(Integer postId);
	
	//Get all posts
	List<PostDto>getAllPost();
	
	//Get single post
	PostDto getPostById(Integer postId);
	
	//Get all posts by category
	List<PostDto>getPostsByCategory(Integer categoryId);
	
	//Get all posts by user
	List<PostDto>getPostsByUser(Integer userId);
	
	//Search posts
	List<Post>searchPosts(String keyword);
	
}
