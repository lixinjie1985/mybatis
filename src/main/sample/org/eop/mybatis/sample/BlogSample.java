package org.eop.mybatis.sample;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.bean.Blog;
import org.eop.mybatis.mapper.BlogMapper;

/**
 * @author lixinjie
 */
public class BlogSample {

	public static void main(String[] args) throws Exception {
		System.out.println(getBlogWithAuthorPosts());
	}
	
	public static Blog saveAuthor() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Blog blog = new Blog(null);
		blog.setTitle("我的博客_2");
		blog.setAuthorId(33);
		int count = sqlSession.getMapper(BlogMapper.class).saveBlog(blog);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return blog;
	}
	
	public static Blog getBlogWithTags() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Blog blog = sqlSession.getMapper(BlogMapper.class).getBlogWithTags(1);
		sqlSession.close();
		return blog;
	}
	
	public static Blog getBlogWithAuthorPosts() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Blog blog = sqlSession.getMapper(BlogMapper.class).getBlogWithAuthorPosts(1);
		sqlSession.close();
		return blog;
	}
}
