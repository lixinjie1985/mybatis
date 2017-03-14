package org.eop.mybatis.sample;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.bean.Tag;
import org.eop.mybatis.mapper.TagMapper;

/**
 * @author lixinjie
 */
public class TagSample {

	public static void main(String[] args) throws Exception {
		System.out.println(saveTag());
	}
	
	public static Tag saveTag() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Tag tag = new Tag();
		tag.setName("微服务");
		tag.setBlogId(1);
		int count = sqlSession.getMapper(TagMapper.class).saveTag(tag);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return tag;
	}
	
	
}
