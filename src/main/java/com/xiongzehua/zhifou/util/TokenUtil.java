package com.xiongzehua.zhifou.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * Created by xiongzehua on 2019/2/18.
 *
 * 参考：
 * http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html
 * https://github.com/auth0/java-jwt
 * https://jwt.io/ 在线解码工具
 */
public class TokenUtil {

    /**
     * 创建jwt token
     *
     * @param userId   用户id
     * @param password 生成摘要的用户密码
     */
    public static String create(Integer userId, String password) throws UnsupportedEncodingException {
        String token = null;
        token = JWT.create()
                .withIssuer("zhifou")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 1000)))
                .withSubject(String.valueOf(userId))
                .sign(Algorithm.HMAC256(password));
        return token;
    }

    /**
     * 验证token 有效性
     * If the token
     * has an invalid signature,
     * the Claim requirement is not met,
     * was issued in a past date "iat" < TODAY,
     * hasn't expired yet "exp" > TODAY,
     * can already be used. "nbf" < TODAY
     *
     *  a JWTVerificationException will raise
     */
    public static boolean verify(String token, String password) {
        try {
            JWT.require(Algorithm.HMAC256(password)).build().verify(token);
        } catch (UnsupportedEncodingException e) {
            System.out.println("HMAC256失败");
            return false;
        } catch (JWTVerificationException verificationException) {
            System.out.println("token非法或者过期");
            return false;
        }
        return true;
    }


    /**
     * 获得 payload.subject 主题
     */
    public static Long getSub(String token) {
        DecodedJWT dJWT = JWT.decode(token);
        return Long.valueOf(dJWT.getSubject());
    }

    /**
     * 获得 payload.issuer 签发者
     */
    public static String getIssuer(String token) {
        DecodedJWT dJWT = JWT.decode(token);
        return dJWT.getIssuer();
    }

    /**
     * 获得 payload
     */
    public static Map<String, Claim> getPayload(String token) {
        DecodedJWT dJWT = JWT.decode(token);
        return dJWT.getClaims();
    }
}
