package dvpauto;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.*; 
import io.restassured.response.*;
//import static io.restassured.matcher.RestAssuredMatchers.* ;
//import static org.hamcrest.Matchers.* ;

//import java.io.UnsupportedEncodingException;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
//import com.auth0.jwt.exceptions.*;

public class Main {

	public static void main(String[] args)  {
		
		 
		String token = "";
		try{
			token = JWT.create()
		    .withClaim("email", "ostret@softserveinc.com")
		    .withClaim("publicKey","publicKey")
		    .sign(Algorithm.HMAC256("privatekey"));
		}
		catch (Exception exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		System.out.println(token);		
		Header authHeader = new Header("Authorization", "Bearer " + token);
		String myXML = "";
		Response resp = given().config(RestAssured.config.encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).contentType("").header(authHeader).body(myXML.getBytes()).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
		System.out.println(resp.asString());
		 resp = given().contentType(ContentType.XML).header(authHeader).body(myXML).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
		System.out.println(resp.asString());
		 resp = given().contentType(ContentType.JSON).header(authHeader).body(myXML).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
		System.out.println(resp.asString());
		 resp = given().contentType(ContentType.JSON).body(myXML).post("https://dev.assurancedv.com/AssuranceAPI/carrier-plan-data");
			System.out.println(resp.asString());
		
		
		
	}

}
