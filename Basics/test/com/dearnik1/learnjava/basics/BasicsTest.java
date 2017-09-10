package com.dearnik1.learnjava.basics;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.dearnik1.learnjava.basics.Main.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BasicsTest {
	@Test
	public void testTask1() throws Exception {
		int result = task1(0);
		assertEquals(0, result);

		result = task1(-222);
		assertEquals(6, result);
		
		result = task1(1234567890);
		assertEquals(45, result);

		result = task1(100100100);
		assertEquals(3, result);
	}

	@Test
	public void testTask2() throws Exception {
		long result = task2(0);
		assertEquals(0, result);

		result = task2(-222);
		assertEquals(0, result);

		result = task2(12);
		assertEquals(-442386619, result);

		result = task2(19);
		assertEquals(115578717622022981L, result);
	}
	
	@Test
	public void testTask3() throws Exception {
		int result = task3();
		assertEquals(55252, result);
	}
	
	@Test
	public void testTask4() throws Exception {
		ByteArrayOutputStream outputStream = mockOutputStream();
		task4(0);
		String[] result = getOutput(outputStream);
		assertEquals(1, result.length);
		assertEquals("0", result[0]);
		outputStream.reset();

		task4(-10);
		result = getOutput(outputStream);
		assertEquals(1, result.length);
		assertEquals("0", result[0]);
		outputStream.reset();

		task4(35);
		result = getOutput(outputStream);
		assertEquals(6, result.length);
		assertArrayEquals(new String[] {"1", "2", "4", "8", "16", "32"}, result);
	}

	private String[] getOutput(ByteArrayOutputStream outputStream) {
		return outputStream.toString().split(System.lineSeparator());
	}

	@Test
	public void testTask5() throws Exception {
		ByteArrayOutputStream outputStream = mockOutputStream();
		mockInputStream(".");
		
		task5();
		String[] result = getOutput(outputStream);
		assertEquals(2, result.length);
		assertEquals("0", result[0]);
		assertEquals(".", result[1]);
		outputStream.reset();

		mockInputStream("Te  st .");
		task5();
		result = getOutput(outputStream);
		assertEquals(2, result.length);
		assertEquals("3", result[0]);
		assertEquals("Te  st .", result[1]);
		outputStream.reset();

		mockInputStream(" Hava Nagila,AAA.   ");
		task5();
		result = getOutput(outputStream);
		assertEquals(2, result.length);
		assertEquals("2", result[0]);
		assertEquals(" HAvA NAgilA,AAA.", result[1]);
		outputStream.reset();

		mockInputStream("a a a a a a");
		task5();
		result = getOutput(outputStream);
		assertEquals(2, result.length);
		assertEquals("5", result[0]);
		assertEquals("A A A A A A", result[1]);
	}

	private void mockInputStream(String value) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
		System.setIn(inputStream);
	}


	private ByteArrayOutputStream mockOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));
		return stream;
	}
}
