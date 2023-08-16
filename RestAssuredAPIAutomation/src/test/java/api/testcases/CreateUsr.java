package api.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints2;

import api.payload.User;
import api.utilities.FileUtil;
import io.restassured.response.Response;

public class CreateUsr {
	
	
	Faker faker=new Faker();;
	User userpayload=new User();;
	@BeforeClass
	public void setUpData() {
		
		   
		  
		  userpayload.setId(faker.idNumber().hashCode());
		  userpayload.setEmail(faker.internet().safeEmailAddress());
		  userpayload.setFirst_name(faker.name().firstName());
		  userpayload.setLast_name(faker.name().lastName());
		  userpayload.setAvatar(faker.internet().url());
		 
			
	}
	//@Test
	void createusertest(ITestContext varcon) {
		
		Faker faker=new Faker();
		HashMap in=new HashMap();
		//in.put("id", 123456);
		in.put("email", "abc@abc.com");
		in.put("first_name", "test1");
		in.put("last_name", "roopa");
		in.put("avatar", "www.stanton-framii.com");
		
		int id=given()
			
		 .contentType("application/json")
		 .body(in)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		System.out.println("Generated ID:"+id);	
		varcon.setAttribute("user_id", id);
				
	}
	
	//@Test
	public void PostUser() {
		HashMap map = new HashMap();

        map.put("email", "abcde@abc.com");
        map.put("first_name", "test1");
        map.put("last_name", "raghav");
		map.put("avatar", "www.stanton-framii.com");
        
         given()
                					.contentType("application/json")
                					.body(map)
                				.when()
                					.post("https://reqres.in/api/users")
        							
        						//int res=response.getStatusCode();
        						//System.out.println("response is:"+res);
        						.then()
        							.statusCode(201)
        							.log().all();
        						
        							
        							
	}
	@Test
	public void createUsr() {
		Response response=UserEndPoints2.createUser(userpayload);
		
		
		  String id=response.body().jsonPath().getString("id").toString();
		  FileUtil.writeToFile("./src/test/resources/UserId.txt",id);
		  System.out.println("Generated User ID is:"+id);
		 
		response.then().log().all();
		//response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	
}
