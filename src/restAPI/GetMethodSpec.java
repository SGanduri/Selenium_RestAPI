package restAPI;


import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

@Test
public class GetMethodSpec {
	
	
	
	  public void Posts() 
	  { 

		  // Specify the base URL to the RESTful web service
		  
		  RestAssured.baseURI ="http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/";
		  
		  //Get the RequestSpecification of the request
	  
		  RequestSpecification httpRequest = RestAssured.given();
	 
	  //Specify the Method.
	  
	   Response response = httpRequest.request(Method.GET, "/Posts");
	  
	  //Print the message of the body and see what response has been received.
	  
	    String responseBody = response.getBody().asString();
	    System.out.println("Response Body is =>  " + responseBody); }
	  
	  
	  
	  
	  public void Comments()
	  { 
		// Specify the base URL to the RESTful web service
		  
		  RestAssured.baseURI ="http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/";
		  
		//Get the RequestSpecification of the request
	  
	      RequestSpecification httpRequest = RestAssured.given();
	  
	  //Specify the Method.
	  
	   Response response1 = httpRequest.request(Method.GET, "/comments");
	   
	   //Print the message of the body and see what response has been received.
	  
	  String responseBody = response1.getBody().asString();
	  System.out.println("Response Body is =>  " + responseBody); }
	 

	public void Users()
	{
		
		// Specify the base URL to the RESTful web service
		
		RestAssured.baseURI ="http://ec2-54-84-52-184.compute-1.amazonaws.com:3000";
		
		//Get the RequestSpecification of the request
		
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a Simple JSON.
		
	    JSONObject requestParams = new JSONObject();
	   
	    Random rand = new Random(); 
		int value = rand.nextInt(1000); 
		String userid = "sautomation" + value;
		

		// We can add Key - Value pairs using the put method
		
		requestParams.put("id", userid);
	    requestParams.put("name", "Sirisha Ganduri");
	    requestParams.put("username", "Sirisha");
	  
	    //Increment Email Id for Uniqueness
	    
		Random rand1 = new Random(); 
		int value1 = rand1.nextInt(1000); 
		String email = "test" + value1 + "@gmail.com";
		
	    requestParams.put("email", email);
	    requestParams.put("street", "1 peach st");
	    requestParams.put("city", "Atlanta");
	    requestParams.put("zipcode", "30300");
	    
	    request.header("Content-Type", "application/json");
	    request.body(requestParams.toJSONString());
	    Response response = request.post("/users");
	    
	    ResponseBody body = response.getBody();
	    int statusCode = response.getStatusCode();
	    System.out.println("The status code recieved: " + statusCode);
	    
	    System.out.println("Response body: " + response.body().asString());
	    
		/*
		 * if(response.statusCode() == 200) { // Deserialize the Response body into
		 * RegistrationFailureResponse RegistrationFailureResponse responseBody =
		 * body.as(RegistrationFailureResponse.class);
		 * 
		 * // Use the RegistrationFailureResponse class instance to Assert the values of
		 * // Response. Assert.assertEquals("User already exists",
		 * responseBody.FaultId); Assert.assertEquals("FAULT_USER_ALREADY_EXISTS",
		 * responseBody.fault); } else if (response.statusCode() == 201) { //
		 * Deserialize the Response body into RegistrationSuccessResponse
		 * RegistrationSuccessResponse responseBody =
		 * body.as(RegistrationSuccessResponse.class); // Use the
		 * RegistrationSuccessResponse class instance to Assert the values of //
		 * Response. Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
		 * Assert.assertEquals("Operation completed successfully",
		 * responseBody.Message); }
		 */
		 
	    
	}

	

}
