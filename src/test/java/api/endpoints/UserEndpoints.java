package api.endpoints;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import api.payload.User;
import io.restassured.http.ContentType;

public class UserEndpoints {

	public static io.restassured.response.Response createUser(User payload) {
		io.restassured.response.Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(payload).when().post(Routes.postUrl);
		
		return response;
	}

	public static io.restassured.response.Response getUser(String userName) {
		io.restassured.response.Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).when().get(Routes.getUrl);
	
		return response;
	}

	public static io.restassured.response.Response updateUser(String userName, User payload) {
		io.restassured.response.Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(Routes.updateUrl);
	
		return response;
	}

	public static io.restassured.response.Response deleteUser(String userName) {
		io.restassured.response.Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).when().delete(Routes.deleteUrl);
	
		return response;
	}
}
