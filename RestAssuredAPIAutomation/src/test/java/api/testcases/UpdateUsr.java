package api.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UpdateUsr {
	Faker faker=new Faker();
	User userpayload=new User();
	
	/*
	 * @BeforeClass public void setUpData() {
	 * 
	 * userpayload.setEmail(faker.internet().safeEmailAddress());
	 * userpayload.setFirst_name(faker.name().firstName());
	 * userpayload.setLast_name(faker.name().lastName());
	 * userpayload.setAvatar(faker.internet().url()); }
	 */
	//@Test
		void updateusertest(ITestContext context) {
		
		Faker faker=new Faker();
		HashMap in=new HashMap();
		
		in.put("email", "babam@abc.com");
		in.put("first_name", "tester");
		in.put("last_name", "roopaA");
		in.put("avatar", "www.stanton-framii.com");
		
		int id=(Integer) context.getAttribute("user_id");
		 given()
			
				 .contentType("application/json")
				 .body(in)
				 .pathParam("id", id)
		
		.when()
				.put("https://reqres.in/api/users/{id}")
				 		
		.then()
		
			.statusCode(200)
			.log().all();
	}
	@Test
	public void updateUsr() throws IOException {
		//update data using payload
				userpayload.setId(faker.idNumber().hashCode());
				userpayload.setEmail(faker.internet().safeEmailAddress());
				userpayload.setFirst_name(faker.name().firstName());
				userpayload.setLast_name(faker.name().lastName());
				userpayload.setAvatar(faker.internet().url());
				
				Path path = Paths.get("./src/test/resources/UserId.txt");
				String id = Files.readString(path);
				System.out.println("ID copied from file is:"+id);
				int i=Integer.parseInt(id);
				System.out.println("ID is:"+i);
				Response response=UserEndPoints2.updateUser(id,userpayload);
				response.then().log().all();
				//response.prettyPrint();
				/*
				 * Assert.assertEquals(response.getStatusCode(), 200); //checking response after
				 * update
				 * 
				 * Response
				 * responseaftrupdate=UserEndPoints2.readUser(this.userpayload.getId());
				 * response.then().log().all();
				 * Assert.assertEquals(responseaftrupdate.getStatusCode(),200);
				 */
			}
	}
	


