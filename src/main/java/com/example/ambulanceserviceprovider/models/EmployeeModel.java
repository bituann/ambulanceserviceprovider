package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
	public Employee getEmployee(String email) throws SQLException {
		Employee employee;

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM employee WHERE email='%s'".formatted(email);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			employee = new Employee();

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

	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> employees;

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM employee";
			ResultSet result = con.prepareStatement(statement).executeQuery();

			employees = new ArrayList<>();

			while(result.next()) {
				Employee employee = new Employee();

				employee.setId(result.getInt("emp_id"));
				employee.setFirstName(result.getString("emp_firstname"));
				employee.setLastName(result.getString("emp_lastname"));
				employee.setPhoneNum(result.getString("emp_phonenum"));
				employee.setEmail(result.getString("emp_email"));
				employee.setAddress(result.getString("emp_address"));
				employee.setType(result.getInt("emp_type"));
				employee.setStatus(result.getInt("emp_status"));

				employees.add(employee);
			}
		}

		return employees;
	}

	public void addEmployee(String fName, String lName, String email, String phoneNum, String address, int status, int type, String password) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "INSERT INTO employee(emp_firstname, emp_lastname, emp_email, emp_phonenum, emp_address, emp_status, emp_type, emp_password" +
					"VALUES (%s, %s, %s, %s, %s, %d, %d, %s".formatted(fName, lName, email, phoneNum, address, status, type, password);

			con.prepareStatement(statement).execute();
		}
	}

	public void deleteEmployee(int empId) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "DELETE FROM employee WHERE emp_id = %d".formatted(empId);

			con.prepareStatement(statement).execute();
		}
	}
}
