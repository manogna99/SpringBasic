package com.elan.SpringBasic.repo;

//import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elan.SpringBasic.domain.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDaoImp implements EmployeeDao{

	@Override
	//
	public Employee createEmployee(int id, String name) {
		// connection class object "dbconnection" gives connection to the class which wants to accesss database.
		// preparedstatement class object "psmt" we can write the sql statements in it.
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
		String createemp = "INSERT INTO EMPLOYEE (USER_ID, USER_NAME) VALUES(?, ?)";
		Employee emp = new Employee();
		try{
			dbConnection = DbConnection.getDBConnection();
			pstmt = (PreparedStatement) dbConnection.prepareStatement(createemp);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
			
		
		/*	ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				department.(rs.getString("dept_name
				department.setDeptId(rs.getLong("dept_id"));
			}*/
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(pstmt!=null){
					pstmt.close();
				}
				if(dbConnection!=null){
					dbConnection.close();
				}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return emp;
		
	}
	
	public  String getEmployeeName(int id){
		
		
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
		String getemp = "SELECT USER_NAME FROM  EMPLOYEE WHERE USER_ID = ?";
		Employee emp = new Employee();
		try{
			dbConnection = DbConnection.getDBConnection();
			pstmt = (PreparedStatement) dbConnection.prepareStatement(getemp);
			pstmt.setInt(1, id);
			//pstmt.setString(2, name);
			
			//pstmt.executeUpdate();
			
		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				emp.setName(rs.getString("USER_NAME"));
				//department.(rs.getString("dept_name
				//department.setDeptId(rs.getLong("dept_id"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(pstmt!=null){
					pstmt.close();
				}
				if(dbConnection!=null){
					dbConnection.close();
				}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		
		return emp.getName();
	}
}
