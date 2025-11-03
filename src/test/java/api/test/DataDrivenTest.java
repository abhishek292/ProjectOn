package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.dataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {
//	@Test(priority = 1, dataProvider = "data",dataProviderClass = dataProviders.class)
	public void createUsers(String userId,String userName, String fname, String lname, String email,String pwd, String phno) {
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phno);
		
		Response response = UserEndpoints.createUser(userPayload);
		response.then().statusCode(200);
	}
	
	@Test(priority =2, dataProvider="username", dataProviderClass = dataProviders.class)
	public void deleteUsers(String userName) {
		Response response = UserEndpoints.deleteUser(userName);
		response.then().statusCode(200);
	}

}
