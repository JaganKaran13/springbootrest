package com.zilker.blog.constants;

public class SqlQuery {
	
	public static final String INSERT_NEW_BLOG = "INSERT INTO blog_details (blog_name, blog_description, blog_author, blog_likes) values (?, ?, ?, ?)";
	public static final String GET_BLOG_DETAILS = "SELECT * FROM blog_details WHERE BLOG_ID = ?";
	public static final String GET_ALL_BLOG_DETAILS = "SELECT * FROM blog_details";

}
