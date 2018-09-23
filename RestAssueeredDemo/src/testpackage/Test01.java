package testpackage;

import org.json.simple.JSONObject;
import org.omg.CORBA.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test01 {
  
  @Test
  public void RestAssuredGet() {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification req = RestAssured.given();
	  Response resp = req.request(Method.GET,"/polonnaruwa");
	  
	  String rbody = resp.getBody().asString();
	  System.out.println(rbody);
  }
  
  @Test
  public void RestAssuredPost() {
	  RestAssured.baseURI = "http://restapi.demoqa.com/customer";
	  RequestSpecification req2 = RestAssured.given();
	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("FirstName", "fname");
	  requestParams.put("LastName","lname");
	  requestParams.put("UserName", "simpleuser001");
	  requestParams.put("Password", "password1");
	  requestParams.put("Email", "someuser@gmail.com");
	  
	  
	  req2.header("Content-Type","application/json");
	  
	  req2.body(requestParams.toJSONString());
	  
	 
	  Response response = req2.post("/register");
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode,201);
	  String successCode = response.jsonPath().get("SuccessCode");
	  Assert.assertEquals("Correct Success code was returned", successCode,"OPERATION SUCCESS");
	  
	
}
}
