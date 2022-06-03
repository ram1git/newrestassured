package May_Rest_assured_swagger_pet;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TestngRestassured {
	
	
	
	 
	/*
	 * public void test11() {
	 * 
	 * RestAssured.baseURI="https://petstore.swagger.io/v2";
	 * 
	 * 
	 * JSONObject parent=new JSONObject(); JSONObject categoryobj=new JSONObject();
	 * JSONObject tagsobj=new JSONObject();
	 * 
	 * parent.put("id","1234"); parent.put("name","shadow");
	 * parent.put("status","available");
	 * 
	 * categoryobj.put("id", "123");
	 * 
	 * tagsobj.put("id", "456"); tagsobj.put("name", "cat");
	 * 
	 * 
	 * parent.put("category","categoryobj"); parent.put("tags","tagsobj");
	 * 
	 * 
	 * JSONArray arr=new JSONArray(); arr.add("image1"); arr.add("image2");
	 * arr.add("3");
	 * 
	 * 
	 * parent.put("photoUrls", arr);
	 * 
	 * 
	 * System.out.println(parent.toJSONString());
	 * 
	 * 
	 * //https://petstore.swagger.io/v2/
	 * 
	 * given().contentType(ContentType.JSON).body(parent.toJSONString()).when().post
	 * ("/pet").then().statusCode(201).log().all();
	 * 
	 * }
	 * 
	 * 
	 * @Test(enabled = false,dataProvider = "requestdata") public void
	 * testcase6(String bn,String fn, String place ) { RestAssured.baseURI =
	 * "http://localhost:3000";
	 * 
	 * JSONObject parent = new JSONObject(); parent.put("batchname",bn);
	 * parent.put("filename", fn); parent.put("place", place);
	 * 
	 * 
	 * given() .header("content-type","application/json")
	 * .body(parent.toJSONString()). when() .post("/sample"). then()
	 * .statusCode(201).log().all();
	 * 
	 * 
	 * }
	 * 
	 * @DataProvider(name="requestdata") public Object[][] dataprov() { Object[][]
	 * data = new Object[4][3]; data[0][0] = "batchname1"; data[0][1]= "filename1";
	 * data[0][2] = "place1";
	 * 
	 * data[1][0] = "batchname2"; data[1][1]= "filename2"; data[1][2] = "place2";
	 * 
	 * data[2][0] = "batchname3"; data[2][1]= "filename3"; data[2][2] = "place3";
	 * 
	 * data[3][0] = "batchname4"; data[3][1]= "filename4"; data[3][2] = "place4";
	 * 
	 * return data;
	 * 
	 * }
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	@Test(enabled = true,priority = 1,description = "create_user")
	
	
	public void create_user() {
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("username", "john1");
		jsonobj.put("firstName", "john");
		jsonobj.put("lastName", "doe");
		jsonobj.put("email", "abc@yopmail.com");
		jsonobj.put("password", "bellary");
		jsonobj.put("phone", "8765456787");
		jsonobj.put("userStatus", 0);
		
Response res1= (Response) given().contentType(ContentType.JSON).body(jsonobj.toJSONString()).when().post
		  ("/user");
Assert.assertEquals(res1.getStatusCode(), 200);

//Assert.assertEquals(res1.jsonPath().get("message"), "logged in user session:1652765365970");

Assert.assertEquals(res1.jsonPath().get("code"), 200);

		
		
		
		
	}
	
	
	
	
@SuppressWarnings("rawtypes")
@Test(enabled = true,priority = 2,dependsOnMethods = "create_user",description = "login_user")
	
	
	public void login_user() {
RestAssured.baseURI="https://petstore.swagger.io/v2/user/login?username=john1&password=bellary";
Response resp=given().contentType(ContentType.JSON).get();
ResponseBody bod=resp.getBody();
System.out.println(bod.asString()+ "data is ----loginuser");
Assert.assertEquals(resp.getStatusCode(), 200);
System.out.println(bod.asPrettyString());
System.out.println(bod.jsonPath().get("code"));
Assert.assertEquals(bod.jsonPath().get("code"), 200);





		
		
		
	}


@Test(alwaysRun = true,priority = 3,dependsOnMethods = "login_user")



public void put_Update_User() throws IOException {
	
	RestAssured.baseURI="https://petstore.swagger.io/v2";
	String bod="\"{\\\"id\\\":0,\\\"username\\\":\\\"john1\\\",\\\"firstName\\\":\\\"john\\\",\\\"lastName\\\":\\\"doe\\\",\\\"email\\\":\\\"abc@yopmail.com\\\",\\\"password\\\":\\\"bellary\\\",\\\"phone\\\":\\\"8765456787\\\",\\\"userStatus\\\":0}\"";
	System.out.println("test");
	/*
	 * given().contentType(ContentType.JSON).body(bod).when().put("/user/john1").
	 * then( ).statusCode(200).log().all();
	 */
	
Response resp=	given().contentType(ContentType.JSON).body(bod).when().put("/user/john1").thenReturn();

ResponseBody rb=resp.getBody();

System.out.println(rb.asPrettyString()+"--------resp body123");

String b=rb.asString();

System.out.println(b);


System.out.println(System.getProperty("user.dir")+"\\file1.json");

System.out.println(bod);

System.out.println(rb.jsonPath().get("code")+"return code is ");
Assert.assertEquals(rb.jsonPath().get("code"), 500);
Assert.assertEquals(resp.getStatusCode(), 500);

FileInputStream fis2=new FileInputStream(System.getProperty("user.dir")+"\\file1.json");
String resp2=	given().contentType(ContentType.JSON).body(IOUtils.toString(fis2)).when().put("/user/john1").andReturn().asPrettyString();
System.out.println(resp2.toString()+"-----last test");

Response ret=given().contentType(ContentType.JSON).body(IOUtils.toString(fis2)).when().put("/user/john1");

System.out.println(ret.asPrettyString());

System.out.println(ret.getBody().jsonPath().get("message")+   "-------message is ");

Assert.assertEquals(ret.getBody().jsonPath().get("message"), "no data");


}



/*
 * @Test(enabled = true,priority = 7)
 * 
 * 
 * public void test15() throws IOException {
 * RestAssured.baseURI="https://reqres.in/"; FileInputStream fis=new
 * FileInputStream(System.getProperty("user.dir")+"\\file.json"); String resp=
 * given().contentType(ContentType.JSON).body(IOUtils.toString(fis)).when().post
 * ("/api/users").andReturn().asPrettyString();
 * System.out.println(resp.toString()+"-----last test");
 * 
 * 
 * }
 */

	
	
	
}	


