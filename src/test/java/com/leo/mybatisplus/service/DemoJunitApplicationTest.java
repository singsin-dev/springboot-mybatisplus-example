package com.leo.mybatisplus.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author leo thomas
 * @date 2023/7/29 下午 05:23
 */


public class DemoJunitApplicationTest {

    Calculator underTest = new Calculator();
    
    @Test
    public void itShouldAddNumbers(){
        int numberOne = 20;
        int numberTwo = 20;

        int result = underTest.add(numberOne, numberTwo);
        
        // 算预期的结果是否相同
        assertThat(result).isEqualTo(40);
        

    }
    
    class Calculator{
        int add(int a,int b){
            return a + b;
        }
    }
    
}
