package api.test;

import org.checkerframework.common.returnsreceiver.qual.This;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.j2objc.annotations.UsedByNative;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User userPayload;

	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().firstName());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().toString());
	}

//	@Test(priority =1)
	public void createUser() {
		Response response = UserEndpoints.createUser(userPayload);
		response.then().statusCode(200);
	}

//	@Test(priority = 2)
	public void getUser() {
		
		Response response = UserEndpoints.getUser(this.userPayload.getUsername());
		response.then().statusCode(200);
		
	}

//	@Test(priority = 3)
	public void updateUser() {
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().statusCode(200);
		
	}

//	@Test(priority = 4)
	public void deleteUser() {
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		response.then().statusCode(200);
	
	}
}
