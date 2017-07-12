package org.eop.mybatis.test.data;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.mapper.LogMapper;
import org.eop.mybatis.sample.SqlHolder;

/**
 * @author lixinjie
 * @since 2017-07-11
 */
public class Main_1 {

	public static void main(String[] args) throws Exception {
		//100row-578ms
		//1000row-1828ms
		//5000row-8375ms
		//10000row-16578ms
		//20000row-27500ms
		//40000row-57031ms
		SqlSession sqlSession = SqlHolder.getSqlSession();
		LogMapper log = sqlSession.getMapper(LogMapper.class);
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			log.saveLog(i);
			sqlSession.commit();
		}
		long end = System.currentTimeMillis();
		int count = log.getCount();
		sqlSession.close();
		System.out.println(count);
		System.out.println(end - begin);
	}

}
