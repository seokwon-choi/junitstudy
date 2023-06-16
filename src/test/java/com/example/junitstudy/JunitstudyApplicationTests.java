package com.example.junitstudy;

import com.example.junitstudy.calculator.Calculator;
import com.example.junitstudy.calculator.DollarCalculator;
import com.example.junitstudy.calculator.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class JunitstudyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	public MarketApi marketApi;

	@BeforeEach
	public void init(){
		Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
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
		Assertions.assertEquals(0, calculator.minus(10, 10));
	}

	@Test
	public void mocktest(){
		DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
		dollarCalculator.init();

		Calculator calculator = new Calculator(dollarCalculator);
		System.out.println(calculator.sum(10, 10));
		Assertions.assertEquals(60000, calculator.sum(10, 10));
		Assertions.assertEquals(0, calculator.minus(10, 10));
	}

}
