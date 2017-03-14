package org.eop.mybatis.sample;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.bean.PostTag;
import org.eop.mybatis.mapper.PostTagMapper;

/**
 * @author lixinjie
 */
public class PostTagSample {

	public static void main(String[] args) throws Exception {
		System.out.println(savePostTag());
	}
	
	public static PostTag savePostTag() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		PostTag posttag = new PostTag();
		posttag.setPostId(1);
		posttag.setTagId(3);
		int count = sqlSession.getMapper(PostTagMapper.class).savePostTag(posttag);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return posttag;
	}
	
	
}
