package org.eop.mybatis.sample;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author lixinjie
 */
public class SqlHolder {

	
	public static SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return  new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSession getSqlSession() throws Exception {
		return getSqlSessionFactory().openSession();
	}
}
