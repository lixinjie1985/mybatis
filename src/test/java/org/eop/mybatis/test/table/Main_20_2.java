package org.eop.mybatis.test.table;

import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.eop.mybatis.mapper.LogMapper;
import org.eop.mybatis.sample.SqlHolder;
import org.eop.mybatis.test.time.StoppableRunnable;

/**
 * @author lixinjie
 * @since 2017-07-11
 */
public class Main_20_2 {

	public static void main(String[] args) throws Exception {
		
		//20s-140138row
		
		int ts = 20;
		StoppableRunnable[] srs = new StoppableRunnable[ts];
		for (int j = 0; j < ts; j++) {
			final int t = j;
			srs[j] = new StoppableRunnable(){
	
				private volatile boolean stopped = false;
				
				@Override
				public void run() {
					try {
						SqlSession sqlSession = SqlHolder.getSqlSession();
						LogMapper log = sqlSession.getMapper(LogMapper.class);
						for (int i = t * 1000000; i < Integer.MAX_VALUE; i++) {
							if (stopped) {
								break;
							}
							log.saveLog2(i);
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
		}
		long begin = System.currentTimeMillis();
		for (int j = 0; j < ts; j++) {
			new Thread(srs[j]).start();
		}
		TimeUnit.SECONDS.sleep(20);
		for (int j = 0; j < ts; j++) {
			srs[j].stopRun();
		}
		long end = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(2);
		SqlSession sqlSession = SqlHolder.getSqlSession();
		LogMapper log = sqlSession.getMapper(LogMapper.class);
		int count = log.getCount2();
		sqlSession.close();
		System.out.println(count);
		System.out.println(end - begin);
	}

}
