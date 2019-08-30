package com.zilker.blog.delegate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zilker.blog.bean.Blog;
import com.zilker.blog.bean.NewBlog;
import com.zilker.blog.constants.SqlQuery;
import com.zilker.blog.utils.DatabaseConfig;

public class BlogDelegate {
	DatabaseConfig dbConfig = new  DatabaseConfig();
	
	public NewBlog insertNewBlogDetails(NewBlog blogDetails) throws Exception {
		Connection databaseConnection = dbConfig.getConnection();
		try {
			PreparedStatement insertStatement = databaseConnection.prepareStatement(SqlQuery.INSERT_NEW_BLOG);
			insertStatement.setString(1, blogDetails.getBlogName());
			insertStatement.setString(2, blogDetails.getBlogDescription());
			insertStatement.setString(3, blogDetails.getBlogAuthor());
			insertStatement.setInt(4, blogDetails.getBlogLike());
			insertStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		finally {
			dbConfig.closeConnection(databaseConnection);
		}
		return blogDetails;
	}
	
	public Blog getBlogDetails(int blogId) throws Exception {
		Connection databaseConnection = dbConfig.getConnection();
		Blog blogDetails = new Blog();
		try {
			PreparedStatement getBlogDetail = databaseConnection.prepareStatement(SqlQuery.GET_BLOG_DETAILS);
			getBlogDetail.setInt(1, blogId);
			ResultSet responseData = getBlogDetail.executeQuery();
			while (responseData.next()) {
				blogDetails.setBlog_id(responseData.getInt("blog_id"));
				blogDetails.setBlogAuthor(responseData.getString("blog_name"));
				blogDetails.setBlogDescription(responseData.getString("blog_description"));
				blogDetails.setBlogName(responseData.getString("blog_author"));
				blogDetails.setBlogLike(responseData.getInt("blog_likes"));
			}

		}
		finally {
			dbConfig.closeConnection(databaseConnection);
		}
		
		return blogDetails;
	}
	
	public ArrayList<Blog> getAllBlogDetails() throws Exception {
		Connection databaseConnection = dbConfig.getConnection();
		ArrayList<Blog> allBlogDetails = new ArrayList<Blog>();
		try {
			PreparedStatement getAllBlogDetail = databaseConnection.prepareStatement(SqlQuery.GET_ALL_BLOG_DETAILS);
			ResultSet responseData = getAllBlogDetail.executeQuery();
			while(responseData.next()) {
				Blog blogDetails = new Blog();
				blogDetails.setBlog_id(responseData.getInt("blog_id"));
				blogDetails.setBlogName(responseData.getString("blog_name"));
				blogDetails.setBlogDescription(responseData.getString("blog_description"));
				blogDetails.setBlogAuthor(responseData.getString("blog_author"));
				blogDetails.setBlogLike(responseData.getInt("blog_likes"));
				allBlogDetails.add(blogDetails);
			}
		}
		finally {
			dbConfig.closeConnection(databaseConnection);
		}
		return allBlogDetails;
	}
		
}
