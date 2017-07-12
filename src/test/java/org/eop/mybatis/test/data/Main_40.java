package org.eop.mybatis.test.data;

import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.mapper.LogMapper;
import org.eop.mybatis.sample.SqlHolder;

/**
 * @author lixinjie
 * @since 2017-07-11
 */
public class Main_40 {

	public static void main(String[] args) throws Exception {
		//100000row-11172ms
		CountDownLatch cl = new CountDownLatch(40);
		long begin = System.currentTimeMillis();
		for (int j = 0; j < 40; j++) {
			final int t = j;
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
					SqlSession sqlSession = SqlHolder.getSqlSession();
					LogMapper log = sqlSession.getMapper(LogMapper.class);
					for (int i = t * 2500, len = i + 2500; i < len; i++) {
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
