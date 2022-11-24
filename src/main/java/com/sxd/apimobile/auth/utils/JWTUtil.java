package com.sxd.apimobile.auth.utils;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sxd.apimobile.svc.entity.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTUtil {

	private static final String EXP = "exp";
	private static final String PAYLOAD = "payload";

	public static String createToken(User user, long maxAge, String secret) {
		try {
			final Algorithm signer = Algorithm.HMAC256(secret);// 生成签名
			String token = JWT.create().withIssuer("Issuer:KuMan").withSubject("Subject:用户信息")// 主题，科目
					.withClaim("username", user.getUserName())
					.withClaim("id", user.getId())
					//.withClaim("password", user.getPassword())
					.withExpiresAt(new Date(System.currentTimeMillis() + maxAge)).sign(signer);
			log.info("Token生成:"+token);
			return token;
		} catch (Exception e) {
			log.info("生成Token时出现异常"+e.getMessage());
			throw e;
		}
	}

	/**
	 * 解析验证token
	 *
	 * @param token  加密后的token字符串
	 * @param secret 服务器私钥
	 * @return
	 */
	public static Boolean verifyToken(String token, String secret) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			// 应该验证token
			return true;
		} catch (IllegalArgumentException | JWTVerificationException e) {
			log.error("验证Token出现错误"+e.getMessage());
		}
		return false;
	}
	
	/**
	 * 解析token
	 *
	 * @param token  加密后的token字符串
	 * @param secret 服务器私钥
	 * @return
	 */
	public static User parsingToken(String token, String secret) {
		User user = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			Map<String, Claim> claim = jwt.getClaims();
			user = new User();
			user.setId(Integer.valueOf(claim.get("id").asString()));
			user.setUserName(claim.get("username").asString());
			//user.setPassword(claim.get("password").asString());
			// if(claim.get("mail")==null) {
			// 	user.setMail(null);
			// }else {
			// 	user.setMail(claim.get("mail").asString());
			// }
			// if(claim.get("tel")==null) {
			// 	user.setTel(null);
			// }else {
			// 	user.setTel(claim.get("tel").asString());
			// }
			// 应该验证token
		} catch (IllegalArgumentException | JWTVerificationException e) {
			log.error("解析Token出现错误"+e.getMessage());
		}
		return user;
	}
}