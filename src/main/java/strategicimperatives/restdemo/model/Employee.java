package strategicimperatives.restdemo.model;

import java.time.LocalDate;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "employee")
public class Employee {
	
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String employeeId;
	
	@DynamoDBAttribute
	private String firstName;
	
	@DynamoDBAttribute
	private String lastName;
	
	@DynamoDBAttribute
	private String email;
	
	@DynamoDBAttribute
	private String phoneNumber;
	
	@DynamoDBAttribute
	private String dateOfBirth;
	
}
