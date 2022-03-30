package com.lh.demo01._static;

import org.junit.Test;

public class Court {
    @Test
    public void  test(){
        Lawsuit parties = new Parties();

        Lawyer lawyer = new Lawyer(parties);
            lawyer.submit();
            lawyer.defend();
    }
}
