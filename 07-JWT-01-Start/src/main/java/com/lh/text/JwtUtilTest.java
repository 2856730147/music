package com.lh.text;

import com.lh.util.JwtUtil;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtilTest {
    @Test
    public  void testGet(){
        Map<String, Object> claim = new HashMap<>();
        claim.put("username","士大夫");
        claim.put("exp",System.currentTimeMillis()+1000*20);
        claim.put("lastAccessTime",new Date());
        String token = JwtUtil.getToken(claim);

        System.out.println(token);



    }
}
