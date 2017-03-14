package org.eop.mybatis.mapper;

import org.eop.mybatis.bean.Blog;

/**
 * @author lixinjie
 */
public interface BlogMapper {

	public int saveBlog(Blog blog);
	
	public Blog getBlogWithTags(Integer id);
	
	public Blog getBlogWithAuthorPosts(Integer id);
}
