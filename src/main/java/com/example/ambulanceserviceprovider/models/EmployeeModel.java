package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
	public Employee getEmployee(String email) throws SQLException {
		Employee employee = new Employee();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM employee WHERE email='%s'".formatted(email);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			employee.setId(result.getInt("emp_id"));
			employee.setFirstName(result.getString("emp_firstname"));
			employee.setLastName(result.getString("emp_lastname"));
			employee.setPhoneNum(result.getString("emp_phonenum"));
			employee.setEmail(result.getString("emp_email"));
			employee.setAddress(result.getString("emp_address"));
			employee.setType(result.getInt("emp_type"));
			employee.setStatus(result.getInt("emp_status"));
		}

		return employee;
	}
}
