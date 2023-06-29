

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import org.testng.Assert;
import io.restassured.path.json.JsonPath;

public class Rest_Patch_Refe {

	public static void main(String[] args) {
		// Declare BaseURl
		RestAssured.baseURI="https://reqres.in/";
		
		//Declare request Body String Variable
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		//Declare the expected results
		JsonPath JspRequest = new JsonPath(RequestBody); 
		String Req_name= JspRequest.getString("name");
		String Req_Job = JspRequest.getString("job");
		LocalDateTime CurrentDate = LocalDateTime.now();
		String expecteddate=CurrentDate.toString().substring(0,11);
		//Declare the given,when and then method
		String ResponseBody=given().header("Content-type","Application/json").body(RequestBody).
		when().patch("api/users/2").then().extract().response().asString();
System.out.println(ResponseBody);		
		//Create an object of JSON path to parse the response body
		JsonPath JspResponse= new JsonPath(ResponseBody);
		String Res_name=JspResponse.getString("name");
		String Res_job=JspResponse.getString("job");
		String Res_updatedAt=JspResponse.getString("updatedAt");
		Res_updatedAt= Res_updatedAt.substring(0,11);
		//Validate the responseBody Parameter
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job,Req_Job);
		Assert.assertEquals(Res_updatedAt, expecteddate);
		

	}

}

