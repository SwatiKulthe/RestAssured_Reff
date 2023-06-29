

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.path.xml.*;

public class Soapapi_Refe {

	public static void main(String[] args) {
		// Declare the baseUrl
		RestAssured.baseURI="https://www.dataaccess.com/";
		//Declare RequestBody
		String RequestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		//Exract responseBody
		String ResponseBody=given().header("Content-Type","text/xml; charset=utf-8").body(RequestBody).
				when().post("webservicesserver/NumberConversion.wso").then().extract().response().asString();
		System.err.println(ResponseBody);
		//Parse the responseBody
		XmlPath XmlResponse = new XmlPath(ResponseBody);
		String ResponseParameter = XmlResponse.getString("NumberToWordsResult");
		System.out.println(ResponseParameter);
		//validate the responseBody
		Assert.assertEquals(ResponseParameter,"one hundred ");
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

	}

}
