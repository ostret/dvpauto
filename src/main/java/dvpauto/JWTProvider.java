package dvpauto;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTProvider {

	public String getToken() {
		String token = "";
		try {
			token = JWT.create().withClaim("email", "email").withClaim("publicKey", "publicKey")
					.sign(Algorithm.HMAC256("privatekey"));
		} catch (Exception exception) {
			// Invalid Signing configuration / Couldn't convert Claims.
		}
		return token;
	}
}
