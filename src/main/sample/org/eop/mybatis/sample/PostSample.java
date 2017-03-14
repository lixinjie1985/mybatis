package org.eop.mybatis.sample;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.bean.Post;
import org.eop.mybatis.mapper.PostMapper;

/**
 * @author lixinjie
 */
public class PostSample {

	public static void main(String[] args) throws Exception {
		System.out.println(savePost());
	}
	
	public static Post savePost() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Post post = new Post();
		post.setSection("section");
		post.setSubject("我的主题_4");
		post.setBody("我的内容");
		post.setCreatedOn(new Date());
		post.setBlogId(1);
		post.setAuthorId(33);
		int count = sqlSession.getMapper(PostMapper.class).savePost(post);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return post;
	}
	
	
}
