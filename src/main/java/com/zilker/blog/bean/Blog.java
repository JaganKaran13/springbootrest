package com.zilker.blog.bean;

public class Blog {
	
    private long blog_id;
    private String blogName;
    private String blogDescription;
    private String blogAuthor;
    private int blogLike;

	public long getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(long blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public int getBlogLike() {
		return blogLike;
	}

	public void setBlogLike(int blogLike) {
		this.blogLike = blogLike;
	}
    
}
