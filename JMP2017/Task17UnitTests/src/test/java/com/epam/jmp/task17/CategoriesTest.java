/*
 * Copyright (c) 2008-2011 Ivan Khalopik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.jmp.task17;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class CategoriesTest extends Assert {
	private final Map<CharSequence, Boolean> isEmptyData = new HashMap<CharSequence, Boolean>();

	@Before
	public void setUpIsEmptyData() {
		isEmptyData.put("", true);
		isEmptyData.put(" ", false);
		isEmptyData.put("some string", false);
	}

	@After
	public void tearDownIsEmptyData() {
		isEmptyData.clear();
	}

	@Category(Unit.class)
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
}
