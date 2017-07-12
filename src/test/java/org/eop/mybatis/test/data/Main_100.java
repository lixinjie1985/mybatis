package org.eop.mybatis.test.data;

import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.mapper.LogMapper;
import org.eop.mybatis.sample.SqlHolder;

/**
 * @author lixinjie
 * @since 2017-07-11
 */
public class Main_100 {

	public static void main(String[] args) throws Exception {
		//100000row-12265ms
		CountDownLatch cl = new CountDownLatch(100);
		long begin = System.currentTimeMillis();
		for (int j = 0; j < 100; j++) {
			final int t = j;
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
					SqlSession sqlSession = SqlHolder.getSqlSession();
					LogMapper log = sqlSession.getMapper(LogMapper.class);
					for (int i = t * 1000, len = i + 1000; i < len; i++) {
						log.saveLog(i);
						sqlSession.commit();
					}
					sqlSession.close();
					cl.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}).start();
		}
		cl.await();
		long end = System.currentTimeMillis();
		SqlSession sqlSession = SqlHolder.getSqlSession();
		LogMapper log = sqlSession.getMapper(LogMapper.class);
		int count = log.getCount();
		sqlSession.close();
		System.out.println(count);
		System.out.println(end - begin);
	}

}
