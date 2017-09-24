package com.dearnik1.learnjava.basics.circle;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircleTest {

	private Class<Circle> clazz = Circle.class;

	@Test
	public void testCircleConstructor() {
		Constructor[] constructors = clazz.getConstructors();
		assertEquals(1, constructors.length);
		
		Constructor constructor = constructors[0];
		assertEquals("Wrong constructor parameter number.", 3, constructor.getParameterCount());
		Class[] parameters = constructor.getParameterTypes();
		assertArrayEquals("Wrong constructor parameter types.", new Class[] {int.class, int.class, int.class}, parameters);
	}
	
	@Test
	public void testMove() throws Exception {
		Method move = clazz.getMethod("move", int.class, int.class);
		Class returnValue = move.getReturnType();
		assertEquals("Wrong return value.", void.class, returnValue);
		
		Circle circle = createCircle(15, 4, 10);
		move.invoke(circle, 10, 6);
		assertCircle(circle, 25, 10, 10);

		move.invoke(circle, -50, -40);
		assertCircle(circle, -25, -30, 10);
	}


	@Test
	public void testContainsInt() throws Exception {
		Method contains = clazz.getMethod("contains", int.class, int.class);
		Class returnValue = contains.getReturnType();
		assertEquals("Wrong return value.", boolean.class, returnValue);

		Circle circle = createCircle(3, 4, 20);
		boolean result = (boolean) contains.invoke(circle, 11, 24);
		assertTrue(result);

		result = (boolean) contains.invoke(circle, 3, -11);
		assertTrue(result);

		result = (boolean) contains.invoke(circle, -17, 0);
		assertTrue(result);

		result = (boolean) contains.invoke(circle, -3, -4);
		assertTrue(result);

		result = (boolean) contains.invoke(circle, 24, 25);
		assertFalse(result);

		result = (boolean) contains.invoke(circle, -18, -17);
		assertFalse(result);
	}

	@Test
	public void testContainsCircle() throws Exception {
		Method contains = clazz.getMethod("contains", clazz);
		Class returnValue = contains.getReturnType();
		assertEquals("Wrong return value.", boolean.class, returnValue);

		Circle circle = createCircle(3, 4, 20);
		Circle testCircle = createCircle(3, 4, 19);
		boolean result = (boolean) contains.invoke(circle, testCircle);
		assertTrue(result);

		testCircle = createCircle(-2, -2, 4);
		result = (boolean) contains.invoke(circle, testCircle);
		assertTrue(result);

		testCircle = createCircle(2, 0, 6);
		result = (boolean) contains.invoke(circle, testCircle);
		assertTrue(result);

		testCircle = createCircle(18, 0, 6);
		result = (boolean) contains.invoke(circle, testCircle);
		assertFalse(result);

		testCircle = createCircle(-2, 5, 19);
		result = (boolean) contains.invoke(circle, testCircle);
		assertFalse(result);
	}

	@Test
	public void testPrint() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream));

		Method contains = clazz.getMethod("printCircle");
		Class returnValue = contains.getReturnType();
		assertEquals("Wrong return value.", void.class, returnValue);

		Circle circle = createCircle(3, 4, 20);
		contains.invoke(circle);
		assertEquals("x: 3, y: 4, radius: 20", stream.toString());
		stream.reset();

		circle = createCircle(-6, -6, 60);
		contains.invoke(circle);
		assertEquals("x: -6, y: -6, radius: 60", stream.toString());
		stream.reset();
	}
	
	private Circle createCircle(int x, int y, int radius) throws Exception {
		return clazz.getConstructor(int.class, int.class, int.class).newInstance(x, y, radius);
	}
	
	private void assertCircle(Circle circle, int x, int y, int radius) throws Exception {
		assertEquals(3, clazz.getDeclaredFields().length);
		Field xField = clazz.getDeclaredField("x");
		xField.setAccessible(true);
		int xValue = xField.getInt(circle);
		assertEquals("Wrong filed 'x' value.", x, xValue);

		Field yField = clazz.getDeclaredField("y");
		yField.setAccessible(true);
		int yValue = yField.getInt(circle);
		assertEquals("Wrong filed 'y' value.", y, yValue);

		Field radiusField = clazz.getDeclaredField("radius");
		radiusField.setAccessible(true);
		int radiusValue = radiusField.getInt(circle);
		assertEquals("Wrong filed 'radius' value.", radius, radiusValue);
	}
}
