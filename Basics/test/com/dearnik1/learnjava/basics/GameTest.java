package com.dearnik1.learnjava.basics;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GameTest {
	private static ByteArrayOutputStream outputStream;
	
	@BeforeClass
	public static void mockOutputStream() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}
	
	@Before
	public void resetOutputStream() {
		outputStream.reset();
	}
	
	@Test
	public void testInvalidInput() {
		mockInputStream("sfsdf\n" +
						"5\n" +
						"-10\n" +
						"0\n" +
						"%\n" +
						"exit");
		Game.main(new String[0]);
		String[] output = getOutput();
		
		assertEquals(13, output.length);
		assertArrayEquals(new String[] {
				"New Game",
				"20 matches left",
				"Make your choose:",
				"Wrong input!",
				"Make your choose:",
				"Wrong input!",
				"Make your choose:",
				"Wrong input!",
				"Make your choose:",
				"Wrong input!",
				"Make your choose:",
				"Wrong input!",
				"Make your choose:"
		}, output);
	}

	@Test
	public void testGameFlow() {
		mockInputStream("1\n" +
						"3\n" +
						"2\n" +
						"2\n" +
						"3");
		Game.main(new String[0]);
		String[] output = getOutput();

		assertEquals(24, output.length);
		assertArrayEquals(new String[] {
				"New Game",
				"20 matches left",
				"Make your choose:",
				"19 matches left",
				"Computer took 3",
				"16 matches left",
				"Make your choose:",
				"13 matches left",
				"Computer took 1",
				"12 matches left",
				"Make your choose:",
				"10 matches left",
				"Computer took 2",
				"8 matches left",
				"Make your choose:",
				"6 matches left",
				"Computer took 2",
				"4 matches left",
				"Make your choose:",
				"1 matches left",
				"Computer took 1",
				"0 matches left",
				"You lose", 
				"Game Over"
		}, output);
	}


	@Test
	public void testExit() {
		mockInputStream("1\n" +
				"3\n" +
				"exit\n" +
				"2\n" +
				"3");
		Game.main(new String[0]);
		String[] output = getOutput();

		assertEquals(11, output.length);
		assertArrayEquals(new String[] {
				"New Game",
				"20 matches left",
				"Make your choose:",
				"19 matches left",
				"Computer took 3",
				"16 matches left",
				"Make your choose:",
				"13 matches left",
				"Computer took 1",
				"12 matches left",
				"Make your choose:"
		}, output);
	}

	private void mockInputStream(String value) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
		System.setIn(inputStream);
	}

	private String[] getOutput() {
		return outputStream.toString().split(System.lineSeparator());
	}
}
