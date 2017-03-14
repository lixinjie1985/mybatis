package org.eop.mybatis.sample;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.bean.Comment;
import org.eop.mybatis.mapper.CommentMapper;

/**
 * @author lixinjie
 */
public class CommentSample {

	public static void main(String[] args) throws Exception {
		System.out.println(saveComment());
	}
	
	public static Comment saveComment() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Comment comment = new Comment();
		comment.setName("我的评论_5");
		comment.setComment("评论内容");
		comment.setPostId(1);
		int count = sqlSession.getMapper(CommentMapper.class).saveComment(comment);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return comment;
	}
	
	
}
