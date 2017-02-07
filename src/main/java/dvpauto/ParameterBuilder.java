package dvpauto;

import io.restassured.http.Header;

public class ParameterBuilder {
	
	public Header getAuthHeader(){
		JWTProvider jwt = new JWTProvider();
		Header authHeader = new Header("Authorization", "Bearer " + jwt.getToken());
		return Header;
	}
}
