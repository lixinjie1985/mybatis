package org.eop.mybatis.test.time;

import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.mapper.LogMapper;
import org.eop.mybatis.sample.SqlHolder;

/**
 * @author lixinjie
 * @since 2017-07-11
 */
public class Main_1 {

	public static void main(String[] args) throws Exception {
		
		//1s-1row
		//2s-495row
		//3s-941row
		//4s-1389row
		//5s-2233row
		//6s-3817row
		//7s-3515row
		//8s-4641row
		//9s-6205row
		//10s-7020row
		StoppableRunnable sr = new StoppableRunnable(){

			private volatile boolean stopped = false;
			
			@Override
			public void run() {
				try {
					SqlSession sqlSession = SqlHolder.getSqlSession();
					LogMapper log = sqlSession.getMapper(LogMapper.class);
					for (int i = 0; i < Integer.MAX_VALUE; i++) {
						if (stopped) {
							break;
						}
						log.saveLog(i);
						sqlSession.commit();
					}
					sqlSession.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void stopRun() {
				stopped = true;
			}
			
		};
		
		long begin = System.currentTimeMillis();
		new Thread(sr).start();
		
		TimeUnit.SECONDS.sleep(10);
		sr.stopRun();
		long end = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(2);
		SqlSession sqlSession = SqlHolder.getSqlSession();
		LogMapper log = sqlSession.getMapper(LogMapper.class);
		int count = log.getCount();
		sqlSession.close();
		System.out.println(count);
		System.out.println(end - begin);
	}

}
