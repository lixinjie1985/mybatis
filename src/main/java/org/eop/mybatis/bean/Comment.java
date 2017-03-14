package org.eop.mybatis.bean;

/**
 * @author lixinjie
 */
public class Comment {

	private Integer id;
	private String name;
	private String comment;
	private Integer postId;
	private Post post;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", comment=" + comment + ", postId=" + postId + ", post=" + post
				+ "]";
	}
}
