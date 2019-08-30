package com.zilker.blog.constants;

public class SqlQuery {
	
	public static final String INSERT_NEW_BLOG = "INSERT INTO blog_details (blog_name, blog_description, blog_author, blog_likes) values (?, ?, ?, ?)";
	public static final String GET_BLOG_DETAILS = "SELECT * FROM blog_details WHERE blog_id = ?";
	public static final String GET_ALL_BLOG_DETAILS = "SELECT * FROM blog_details";
	public static final String UPDATE_BLOG_DETAILS = "UPDATE blog_details SET blog_name = ?, blog_description = ?, blog_author = ?, blog_likes = ? WHERE blog_id = ?";
	public static final String DELETE_BLOG_DETAILS = "DELETE FROM blog_details WHERE blog_id = ?";
}
