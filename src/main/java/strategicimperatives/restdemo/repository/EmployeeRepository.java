package strategicimperatives.restdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import strategicimperatives.restdemo.model.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public EmployeeRepository(DynamoDBMapper dynamoDBMapper) {
		super();
		this.dynamoDBMapper = dynamoDBMapper;
	}
	
	public Employee saveEmployee(Employee employee) {
		dynamoDBMapper.save(employee);
		return employee;
	}
	
	public Employee getEmployeeById(String employeeId){
		return dynamoDBMapper.load(Employee.class, employeeId);
	}
	
	public String deleteEmployeeById(String employeeId) {
		Employee employee = dynamoDBMapper.load(Employee.class, employeeId);
		dynamoDBMapper.delete(employee);
		return "record deleted";
	}
	
	public Employee updateEmployeeById(String employeeId, Employee employee) {
		dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
        .withExpectedEntry("employeeId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(employeeId)
                )));
		return employee;
	}
	
	public List<Employee> getAllEmployee(){
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		List<Employee> employeeList = dynamoDBMapper.scan(Employee.class, scanExpression);
		return employeeList;
	}
	
	
	
}
