package api.endpoints;

/*
 * GET:https://reqres.in/api/users?page=1-----get user
 * POST:https://reqres.in/api/users----create user
 * PUT:https://reqres.in/api/users/{ID}----update user
 */

public class Routes {
	public static String baseurl="https://reqres.in";
	
	public static String posturl=baseurl+"/api/users";
	public static String geturl=baseurl+"/api/users?page=1";	
	public static String updateurl=baseurl+"/api/users/{id}";
	

}
