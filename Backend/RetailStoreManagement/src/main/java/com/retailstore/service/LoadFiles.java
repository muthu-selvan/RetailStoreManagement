package com.retailstore.service;


import com.retailstore.constants.RetailStoreConstants;
import com.retailstore.modal.RetailStoreCsvReader;
import com.retailstore.parser.CSVParser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Repository
@ComponentScan(basePackages = {"com.retailstore.*"})
@PropertySource("classpath:application.properties")
public class LoadFiles {
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private RetailStoreService retailStoreService;

	@Autowired
	private Environment env;

	public LoadFiles() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init() {
		boolean isRestore;
		
		try {
			isRestore = Boolean.parseBoolean(env.getProperty(RetailStoreConstants.RESTORE.getValue()));
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Restore value : "+isRestore);
			
			if(!isRestore) {
				return;
			}

			Resource resource = resourceLoader.getResource("classpath:"+"assets/csv/RetailStore.csv");
			List<RetailStoreCsvReader> retailStores = CSVParser.readCSVFile(RetailStoreCsvReader.class, resource.getFile().getAbsolutePath());

			retailStores.forEach(retailStore ->
			{
				try {
					retailStoreService.addRetailStore(retailStore.getRetailStore());
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}