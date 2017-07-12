package org.eop.mybatis.test.data;

import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.mapper.LogMapper;
import org.eop.mybatis.sample.SqlHolder;

/**
 * @author lixinjie
 * @since 2017-07-11
 */
public class Main_20 {

	public static void main(String[] args) throws Exception {
		//5000row-2875ms
		//10000row-3422ms
		//100000row-10625ms
		//200000row-21578ms
		CountDownLatch cl = new CountDownLatch(20);
		long begin = System.currentTimeMillis();
		for (int j = 0; j < 20; j++) {
			final int t = j;
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
					SqlSession sqlSession = SqlHolder.getSqlSession();
					LogMapper log = sqlSession.getMapper(LogMapper.class);
					for (int i = t * 250, len = i + 250; i < len; i++) {
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
