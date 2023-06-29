

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Rest_Get_Refe {

	public static void main(String[] args) {
		// declare baseUrl
		RestAssured.baseURI="https://reqres.in/";
		
		//declare requestbody
		
		//declare given,when and then method
		String ResponseBody= given().header("Content-type","Application/json").body("requestbody").
				when().get("api/users?page=2").then().extract().asString();
System.out.println(ResponseBody);		

	}

}
