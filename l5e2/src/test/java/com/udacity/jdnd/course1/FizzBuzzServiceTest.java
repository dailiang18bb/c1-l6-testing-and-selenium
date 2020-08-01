package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}


	@Test
	void testNewBuzzFizz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check no valid input
		assertEquals(3, fbs.buzzFizz("", 3));
		assertEquals(4, fbs.buzzFizz("fizz", 4));
		assertEquals(5, fbs.buzzFizz("HelloWorld", 5));

		//



		// check input Fizz
		assertEquals(6, fbs.buzzFizz("Fizz", 2));
		assertEquals(27, fbs.buzzFizz("Fizz", 9));
		assertEquals(573, fbs.buzzFizz("Fizz", 191));

		// check input Buzz

		// check numbers divisible by 3 and 5




	}
}
