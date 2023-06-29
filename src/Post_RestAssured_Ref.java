import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class Post_RestAssured_Ref {

	public static void main(String[] args) {
		//declare baseURI
		RestAssured.baseURI= "https://reqres.in/";
		
		//declare RequestBody
         String RequestBody="{\r\n"
         		+ "    \"name\": \"morpheus\",\r\n"
         		+ "    \"job\": \"leader\"\r\n"
         		+ "}";
         System.out.println(RequestBody);
         //given,when,then
         String ResponseBody = given().header("Content-Type","application/json").body(RequestBody).when().post("api/users")
        		 .then().extract().response().asString();
         System.out.println(ResponseBody);
         //parse responsebody
         JsonPath JspResponse = new JsonPath(ResponseBody);
         String Res_name= JspResponse.getString("name");
         String Res_Job = JspResponse.getString("job");
         //validate responsebody
         Assert.assertEquals(Res_name,"morpheus");
         Assert.assertEquals(Res_Job,"leader");
	}

}
