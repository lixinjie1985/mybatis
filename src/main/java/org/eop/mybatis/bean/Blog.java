package org.eop.mybatis.bean;

import java.util.List;

/**
 * @author lixinjie
 */
public class Blog {

	private Integer id;
	private String title;
	private Integer authorId;
	private Author author;
	private List<Post> posts;
	private List<Tag> tags;
	
	public Blog(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", authorId=" + authorId + ", author=" + author + ", posts="
				+ posts + ", tags=" + tags + "]";
	}
}
