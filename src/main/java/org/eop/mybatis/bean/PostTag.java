package org.eop.mybatis.bean;

/**
 * @author lixinjie
 */
public class PostTag {

	private Integer id;
	private Integer postId;
	private Integer tagId;
	private Post post;
	private Tag tag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "PostTag [id=" + id + ", postId=" + postId + ", tagId=" + tagId + ", post=" + post + ", tag=" + tag
				+ "]";
	}
	
}
