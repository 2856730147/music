package com.lh.text;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.testng.annotations.Test;

import java.util.*;

public class JwtTest {
    @Test
    public void encode(){
//        头部
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("typ","JWT");


        HashMap<String, Object> payload = new HashMap<>();

        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.SECOND,30);

        payload.put("id",1);
        payload.put("username","汉堡出去");

        payload.put("info","管理员");
        payload.put("createTime",new Date());
        payload.put("lastAccessTime",new Date());
        payload.put("exp",instance.getTime());


        String sign = JWT
                .create()
                .withHeader(header)
                .withPayload(payload)
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(sign);
    }
    @Test
    public void encode1(){
//        头部
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("typ","JWT");



        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.SECOND,30);



        String sign = JWT
                .create()
                .withHeader(header)
                .withClaim("id",1)
                .withClaim("username","汉堡出去")
                .withClaim("info","管理员")
                .withClaim("createTime",new Date())
                .withExpiresAt(instance.getTime())
//                发布者
                .withIssuer("马克马克")
//                发布时间
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(sign);
    }
    @Test
    public void decode(){
        JWTVerifier build = JWT.require(Algorithm.HMAC256("123456")).build();

        DecodedJWT verify = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsYXN0QWNjZXNzVGltZSI6MTY0OTE2NjUwOSwiY3JlYXRlVGltZSI6MTY0OTE2NjUwOSwiaWQiOjEsImV4cCI6MTY0OTE2NjUzOSwidXNlcm5hbWUiOiLmsYnloKHlh7rljrsiLCJpbmZvIjoi566h55CG5ZGYIn0.bNaJF3LiCAAjX-r5LANJkTg58C3Mg68iqars_47HJbk");
        System.out.println(verify.getHeader());
        System.out.println(verify.getPayload());
        System.out.println(verify.getAlgorithm());
        System.out.println(verify.getSignature());
        System.out.println(verify.getExpiresAt());

        System.out.println(verify.getClaim("info"));
        System.out.println(verify.getClaim("username"));
        System.out.println(verify.getClaim("lastAccessTime"));
        System.out.println(verify.getClaim("id"));
        System.out.println(verify.getClaim("createTime"));


        Map<String, Claim> map = verify.getClaims();

        Set<Map.Entry<String, Claim>> entries = map.entrySet();

        for (Map.Entry<String, Claim> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
