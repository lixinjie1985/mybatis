package org.eop.mybatis.bean;

import java.util.Date;
import java.util.List;

/**
 * @author lixinjie
 */
public class Post {

	private Integer id;
	private String section;
	private String subject;
	private String body;
	private Date createdOn;
	private Integer blogId;
	private Integer authorId;
	private Blog blog;
	private Author author;
	private List<Tag> tags;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", section=" + section + ", subject=" + subject + ", body=" + body + ", createdOn="
				+ createdOn + ", blogId=" + blogId + ", authorId=" + authorId + ", blog=" + blog + ", author=" + author
				+ ", tags=" + tags + "]";
	}
}
