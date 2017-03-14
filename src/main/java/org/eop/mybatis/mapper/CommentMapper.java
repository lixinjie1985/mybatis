package org.eop.mybatis.mapper;

import org.eop.mybatis.bean.Comment;

/**
 * @author lixinjie
 */
public interface CommentMapper {

	public int saveComment(Comment comment);
}
