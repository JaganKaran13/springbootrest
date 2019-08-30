package com.zilker.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zilker.blog.bean.Blog;
import com.zilker.blog.bean.NewBlog;
import com.zilker.blog.delegate.BlogDelegate;

@RestController
@RequestMapping("/api/")
public class BlogController {

	BlogDelegate blogdelegate = new BlogDelegate();
	
	@PostMapping("/blog")
	NewBlog newBlog(@RequestBody NewBlog newBlog) {
		NewBlog blogDetail = new NewBlog();
		try {
			blogDetail = blogdelegate.insertNewBlogDetails(newBlog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blogDetail;
	}
	
	@GetMapping("blog/{id}")
	Blog one(@PathVariable int id) {
		Blog blogDetail = new Blog();
		try {
			blogDetail = blogdelegate.getBlogDetails(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blogDetail;
	}
	
	@GetMapping("/blog")
	ArrayList<Blog> all() {
		ArrayList<Blog> allBlogDetails = new ArrayList<Blog>();
		try {
			allBlogDetails = blogdelegate.getAllBlogDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBlogDetails;
	}
	
}
