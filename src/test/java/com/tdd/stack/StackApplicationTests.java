package com.tdd.stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StackApplicationTests {

    Stack stack;

    @Before
	public void setup(){
    	stack = new Stack();
	}

    @Test
	public void shouldHaveSizeZero_WhenEmpty(){
		assertEquals(0,stack.size());
	}

	@Test
	public void shouldReturnEmptyTopElement(){
		assertNull(stack.peek());
	}

	@Test
	public void addElementToEmptyStackAndVerifyIsTop(){
		stack.push(1);
		assertEquals(1, stack.peek());
	}

	@Test
	public void addMultipleElementToStackAndVerifyLastInIsFirstOut(){
		int count = 0;
		stack.push(1); count++;
		stack.push(2); count++;
		stack.push(3); count++;
		assertEquals(3, stack.peek());
		assertEquals(count, stack.size());
	}

	@Test
	public void popElementFromStack(){
		int count = 0;
		stack.push(1); count++;
		stack.push(2); count++;
		stack.push(3); count++;
		Object gimme = stack.pop(); count--;
		gimme = stack.pop(); count--;
		assertEquals(2, gimme);
		assertEquals(count, stack.size());
	}

	@Test
	public void ReturnNullWhenStackIsEmptiedOut(){
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Object gimme;
		gimme = stack.pop();
		gimme = stack.pop();
		gimme = stack.pop();
		assertEquals(1, gimme);
		gimme = stack.pop();
		assertNull(stack.peek());
		assertNull(gimme);
		assertEquals(0, stack.size());
	}

	@Test
	public void CheckIfStackContainsValue(){
		stack.push(1);
		stack.push(2);
		stack.push(3);
		boolean outputTrue1 = stack.contains(1);
		boolean outputTrue2 = stack.contains(2);
		boolean outputTrue3 = stack.contains(3);
		boolean outputFalse = stack.contains("What");
		assertTrue(outputTrue1);
		assertTrue(outputTrue2);
		assertTrue(outputTrue3);
		assertFalse(outputFalse);

	}




}
