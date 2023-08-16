package api.endpoints;



	import static io.restassured.RestAssured.*;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

	import org.testng.annotations.Test;

	import api.payload.User;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	/*
	 * UserEndPoints -----for create,read and update operations
	 */


	public class UserEndPoints2 {
		//create user
		
		
		  public static Response createUser(User payload) 
		  { 
			  Response response=given()
					  	.contentType(ContentType.JSON) 
					  	.accept(ContentType.JSON) 
					  	.body(payload)
					  .when() .post(Routes.posturl);
		  	  
		  return response; 
		  }
		 
		
		
		//Read user
		public static Response readUser(int num)
		{
			Response response=given()
			 			//.pathParam("geturl", username)
					.queryParam("page", num)
			
			.when()
				.get(Routes.geturl);
			
			return response;
		}
		
		//update User
		
		public static Response updateUser(String i,User payload)
		{
			Response response=given()
			 	.contentType(ContentType.JSON)
			 	.accept(ContentType.JSON)
			 	.pathParam("id", i)
			 	.body(payload)		 	
			
			.when()
				.put(Routes.updateurl);
			
			return response;
		}

	}



