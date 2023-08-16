package api.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
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
	//@Test(priority=1)
	public void testpostUsr(){
		Response response=UserEndPoints2.createUser(userpayload);
			
		response.then().log().all();		
		Assert.assertEquals(response.getStatusCode(), 201);
		//Assert.assertEquals("userpayload.setId(faker.idNumber().hashCode())", response.jsonPath().getInt("id"));
		
		
		
		
	}
	

	//@Test(priority=2)
	   public void testgetUsr() { 
	  Response response=UserEndPoints2.readUser(this.userpayload.getId());
	  response.then().log().all();
	  //response.statusCode();
	  System.out.println("This is testgetUsr");
	  Assert.assertEquals(response.getStatusCode(),200);
	 
	  }
	 
	 
		/*
		 * @Test(priority=3) public void testUpdateUsr(){ //update data using payload
		 * userpayload.setEmail(faker.internet().safeEmailAddress());
		 * userpayload.setFirst_name(faker.name().firstName());
		 * userpayload.setLast_name(faker.name().lastName());
		 * userpayload.setAvatar(faker.internet().url());
		 * 
		 * Response
		 * response=UserEndPoints2.updateUser(this.userpayload.getId(),userpayload);
		 * response.then().log().all(); Assert.assertEquals(response.getStatusCode(),
		 * 200); //checking response after update
		 * 
		 * Response
		 * responseaftrupdate=UserEndPoints2.readUser(this.userpayload.getId());
		 * response.then().log().all();
		 * Assert.assertEquals(responseaftrupdate.getStatusCode(),200);
		 * 
		 * }
		 */

}
