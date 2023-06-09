package com.example.junitstudy;

import com.example.junitstudy.calculator.Calculator;
import com.example.junitstudy.calculator.DollarCalculator;
import com.example.junitstudy.calculator.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitstudyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testHello(){
		System.out.println("hello");
	}

	@Test
	public void dollarTest(){
		MarketApi marketApi = new MarketApi();
		DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
		dollarCalculator.init();

		Calculator calculator = new Calculator(dollarCalculator);
		System.out.println(calculator.sum(10, 10));
		Assertions.assertEquals(22000, calculator.sum(10, 10));
	}

}
