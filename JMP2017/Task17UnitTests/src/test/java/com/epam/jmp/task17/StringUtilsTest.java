

package com.epam.jmp.task17;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringUtilsTest extends Assert {
	private static final Map<CharSequence, Boolean> isEmptyData = new HashMap<CharSequence, Boolean>();
	private static final Map<String, byte[]> toHexStringData = new HashMap<String, byte[]>();

	@BeforeClass
	public static void setUpIsEmptyData() {
		isEmptyData.put("", true);
		isEmptyData.put(" ", false);
		isEmptyData.put("some string", false);
	}

	@BeforeClass
	public static void setUpToHexStringData() {
		toHexStringData.put("", new byte[0]);
		toHexStringData.put("01020d112d7f", new byte[] { 1, 2, 13, 17, 45, 127 });
		toHexStringData.put("00fff21180", new byte[] { 0, -1, -14, 17, -128 });
	}

	@AfterClass
	public static void tearDownIsEmptyData() {
		isEmptyData.clear();
	}

	@AfterClass
	public static void tearDownToHexStringData() {
		toHexStringData.clear();
	}

	@Test
	public void testIsEmpty() {
		final boolean empty = StringUtils.isEmpty(null);
		assertTrue(empty);

		for (Map.Entry<CharSequence, Boolean> entry : isEmptyData.entrySet()) {
			final CharSequence testString = entry.getKey();
			final boolean expected = entry.getValue();
			final boolean actual = StringUtils.isEmpty(testString);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testToHexString() {
		for (Map.Entry<String, byte[]> entry : toHexStringData.entrySet()) {
			final byte[] testData = entry.getValue();
			final String expected = entry.getKey();
			final String actual = StringUtils.toHexString(testData);
			assertEquals(expected, actual);
		}
	}

	@Test(expected = NullPointerException.class)
	public void testToHexStringWrong() {
		StringUtils.toHexString(null);
	}
}
