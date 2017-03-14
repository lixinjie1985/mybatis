package org.eop.mybatis.sample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.bean.Author;
import org.eop.mybatis.mapper.AuthorMapper;

/**
 * @author lixinjie
 */
public class AuthorSample {

	public static void main(String[] args) throws Exception {
		System.out.println(removeAuthor());
	}
	
	public static Author saveAuthor() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Author author = new Author();
		author.setUsername("李新杰");
		author.setPassword("123456");
		author.setEmail("lixinjie1985@126.com");
		author.setBio("bio");
		int count = sqlSession.getMapper(AuthorMapper.class).saveAuthor(author);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return author;
	}
	
	public static List<Author> saveAuthors() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		List<Author> authors = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Author author = new Author();
			author.setUsername("李新杰_" + i);
			author.setPassword("123456");
			author.setEmail("lixinjie1985@126.com");
			author.setBio("bio");
			authors.add(author);
		}
		int count = sqlSession.getMapper(AuthorMapper.class).saveAuthors(authors);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return authors;
	}
	
	public static Author updateAuthor() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Author author = new Author();
		author.setId(32);
		author.setUsername("李新杰");
		author.setBio("biobio");
		int count = sqlSession.getMapper(AuthorMapper.class).updateAuthor(author);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(count);
		return author;
	}
	
	public static Author getAuthor() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		Author author = sqlSession.getMapper(AuthorMapper.class).getAuthor(32);
		sqlSession.close();
		return author;
	}
	
	public static int removeAuthor() throws Exception {
		SqlSession sqlSession = SqlHolder.getSqlSession();
		int count = sqlSession.getMapper(AuthorMapper.class).removeAuthor(32);
		sqlSession.commit();
		sqlSession.close();
		return count;
	}
}
