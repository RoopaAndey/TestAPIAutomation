package api.testcases;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReadUsr {
	//@Test
	void getUser(ITestContext context) 
	{	
			int id=(Integer) context.getAttribute("user_id");
			given()
			  .contentType("application/json")
			  
	
	
			.when()
				.get("https://reqres.in/api/users?page=1")
	
			.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	public void getFirstnameEmail() {
		Response fsname=RestAssured.given()
							.get("https://reqres.in/api/users?page=1");
							JsonPath json=fsname.jsonPath();
							List<String> firstname=json.getList("data.first_name");
							System.out.println("List of firstnames from GET call:"+firstname);
							List<String> email=json.getList("data.email");
							System.out.println("List of emails from GET call:"+email);
	}
	
	@Test
    public void userDetailsbyID()  {
        String json = get("https://reqres.in/api/users/6").asString();
        System.out.println("User details:" +json );
     

    }
	@Test
	public void validateResponse() {
			given()
				.get("https://reqres.in/api/users/6")
			.then()
				.body("data.email", equalTo("tracey.ramos@reqres.in"))
				.body("data.first_name", equalTo("Tracey"))
				.body("data.last_name", equalTo("Ramos"))
				.body("data.avatar", equalTo("https://reqres.in/img/faces/6-image.jpg"))
				.statusCode(200)
				.log().all();
				System.out.println("Success code:200");
			
	}
	
	
}
