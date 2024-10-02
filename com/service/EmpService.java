package com.service;

import com.dao.EmpDao;

// Business logic 
public class EmpService {

	public void insertData() throws Exception {
		
		EmpDao ed=new EmpDao();
		ed.insert();
	}
	

	public void updateData() throws Exception {
		
		EmpDao ed=new EmpDao();
		ed.update();
	}
	

	public void deleteData() throws Exception {
		
		EmpDao ed=new EmpDao();
		ed.delete();
	}
	
	public void FletchAllData() throws Exception{
	
		EmpDao ed=new EmpDao();
		ed.fetchData();
		
	}
	
	
}
