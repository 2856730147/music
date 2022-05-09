package com.lh;

import com.lh.entity.Sing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

public class LambdaTest {
    void sing(Sing sing) {
        sing.rap("123", 3);
    }

    class Singger implements Sing {

        @Override
        public void rap(String name, Integer num) {
            System.out.println("唱" + name + "多长时间" + num);
        }
    }

    @Test
    void test() {
        //最原始的方法
        sing(new Singger());
        //匿名内部类
        sing(new Sing() {
            @Override
            public void rap(String name, Integer num) {
                System.out.println("唱" + name + "多长时间" + num);
            }
        });
        //
        sing((name, num) -> System.out.println("唱" + name));


    }

    @Test
    @DisplayName("测试异常断言")
    void testAssertThrows() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
                    int num = 1 / 1;
                }, "竟然没有异常？"
        );

    }

    @Test
    @DisplayName("超时断言")
    void testAssertTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(3L), new Executable() {
            @Override
            public void execute() throws Throwable {
                Thread.sleep(4000);
            }
        }, "太快了，还没跟上");
    }

    @Test
    @DisplayName("超时快速失败")
    void  testFail(){
        Assertions.fail("失败了");
    }
}
