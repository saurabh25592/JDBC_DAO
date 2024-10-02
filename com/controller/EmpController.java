package com.controller;

import com.service.EmpService;

public class EmpController {

	public static void main(String[] args) throws Exception {
	
		EmpService es=new EmpService(); 	
		es.insertData();
//		es.updateData();
//		es.deleteData();
//		es.FletchAllData();
		
	}
	
	
	
}
