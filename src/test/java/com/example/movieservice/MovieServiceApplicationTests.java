package com.example.movieservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MovieServiceApplicationTests {

    Calculator undertest = new Calculator();

    @Test
    void itShouldAddNubers() {
        //given
        int numberone = 2;
        int numbertwo = 3;
        //when
       int result = undertest.add(numberone,numbertwo);

        //then
        int expected = 5;
        assertThat(result).isEqualTo(expected);
    }


    class Calculator{
        int add(int a,int b ){
            return a+b;
        }
    }

}
