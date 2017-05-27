

package com.epam.jmp.task17;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterizedTest extends Assert {
	private final CharSequence testData;
	private final boolean expected;

	public ParameterizedTest(final CharSequence testData, final boolean expected) {
		this.testData = testData;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static List<Object[]> isEmptyData() {
		return Arrays.asList(new Object[][] {
				{ null, true },
				{ "", true },
				{ " ", false },
				{ "some string", false },
		});
	}

	@Test
	public void testIsEmpty() {
		final boolean actual = StringUtils.isEmpty(testData);
		assertEquals(expected, actual);
	}
}
