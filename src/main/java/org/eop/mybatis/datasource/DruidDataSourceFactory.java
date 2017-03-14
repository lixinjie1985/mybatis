package org.eop.mybatis.datasource;

import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author lixinjie
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {
	
	public DruidDataSourceFactory() {
		this.dataSource = new DruidDataSource();
	}
}
