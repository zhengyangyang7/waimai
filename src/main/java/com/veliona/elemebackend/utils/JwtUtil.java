package com.veliona.elemebackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.veliona.elemebackend.entity.User;

import java.util.Date;
import java.util.Calendar;

public class JwtUtil {
    private static final String SECRET_KEY = "1013";
    private static final Integer TIME_LAST = 7;
    private static final Integer NEED_CREATE = 4;


    public static String generateToken(String username) {
        Calendar indate = Calendar.getInstance();
        indate.add(Calendar.DATE, TIME_LAST);
        return JWT.create()
                .withClaim("userAccount", username)
                .withIssuedAt(new Date())
                .withExpiresAt(indate.getTime())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public static DecodedJWT verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build();
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            return null; // Invalid token
        }
    }

    public static Boolean verifyUser(String token, User user) {
        if (verifyToken(token)==null)
            return false;
        else {
            String userAccount = getUserAccountFromToken(token);
            return userAccount.equals(user.getUserAccount());
        }
    }

    public static String getUserAccountFromToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("userAccount").asString();
    }

    public static Boolean needCreate (String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Date timeOutDate = decodedJWT.getExpiresAt();
        Calendar expectedDate = Calendar.getInstance();
        expectedDate.add(Calendar.DATE,TIME_LAST - NEED_CREATE);
        return timeOutDate.before(expectedDate.getTime());
    }
}
