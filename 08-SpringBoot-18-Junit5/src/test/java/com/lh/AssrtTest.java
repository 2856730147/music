package com.lh;

import com.lh.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("断言测试")
@SpringBootTest
public class AssrtTest {

    @Autowired
    private Student student1;
    @Autowired
    private Student student2;

    public int add(int num1,int num2){
        return num1+num2;
    }

    @Test
    @DisplayName("简单断言是否是相同的")
    void  testAssertEquals(){
        Assertions.assertEquals(4,add(1,2));
    }
    @Test
    @DisplayName("简单断言是否是同一个对象")
    void  testAssertEqualsObject() {
        Assertions.assertSame(student1,student2,"你们的是同一个吗");
    }
    @Test
    @DisplayName("简单断言是否是true还是false")
    void  testAssertEqualsTrue() {
        Assertions.assertFalse(student1==student2 && 1<0,"你们的是同一个吗");
    }
    @Test
    @DisplayName("数组断言")
    void  testAssertEqualsArray() {
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2},"不是是同一个");
    }
    @Test
    @DisplayName("组合断言")
    void  testAssertEqualsAssertAll() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(3,add(1,2)),
                () -> Assertions.assertFalse(student1==student2 && 1<0,"你们的是同一个吗"),
                () -> Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2},"不是是同一个")
        );
    }
    }
