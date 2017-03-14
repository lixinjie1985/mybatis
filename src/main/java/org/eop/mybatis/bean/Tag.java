package org.eop.mybatis.bean;

/**
 * @author lixinjie
 */
public class Tag {

	private Integer id;
	private String name;
	private Integer blogId;
	private Blog blog;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", blogId=" + blogId + ", blog=" + blog + "]";
	}
	
}
