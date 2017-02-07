package dvpauto;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.*; 
import io.restassured.response.*;
//import static io.restassured.matcher.RestAssuredMatchers.* ;
//import static org.hamcrest.Matchers.* ;




//import com.auth0.jwt.exceptions.*;

public class Main {

	public static void main(String[] args)  {
		
		
		ParameterBuilder parBuilder = new ParameterBuilder();
		String myXML = "";
		Response resp = given().config(RestAssured.config.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).contentType("").header(parBuilder.getAuthHeader()).body(myXML.getBytes()).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
		System.out.println(resp.asString());
		 resp = given().contentType(ContentType.XML).header(parBuilder.getAuthHeader()).body(myXML).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
		System.out.println(resp.asString());
		 resp = given().contentType(ContentType.JSON).header(parBuilder.getAuthHeader()).body(myXML).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
		System.out.println(resp.asString());
		 resp = given().contentType(ContentType.JSON).body(myXML).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
			System.out.println(resp.asString());
		
		
		
	}

}
