package com.springdev.batch.item;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import com.springdev.cfc.GenericBean;

public class BatchWriter implements ItemWriter<GenericBean>{
	private static final Logger logger = Logger.getLogger(BatchWriter.class);

	@Override
	public void write(List<? extends GenericBean> arg0) throws Exception {
		logger.info("Inside BatchWritter");
	}
}
