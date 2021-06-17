package com.philiprehberger.stringkit

import kotlin.test.*

class StringUtilsTest {
    @Test fun `collapseWhitespace`() = assertEquals("a b c", "  a   b  c  ".collapseWhitespace())
    @Test fun `initials`() = assertEquals("JD", "John Doe".initials())
    @Test fun `surround`() = assertEquals("**hello**", "hello".surround("**"))
    @Test fun `wordWrap`() = assertTrue("hello world foo".wordWrap(10).contains("\n"))
    @Test fun `repeat with separator`() = assertEquals("a-a-a", "a".repeat(3, "-"))

    @Test fun `mask full string`() = assertEquals("******", "secret".mask())
    @Test fun `mask with custom char`() = assertEquals("######", "secret".mask(char = '#'))
    @Test fun `mask middle range`() = assertEquals("4111********1111", "4111111111111111".mask(4, 12))
    @Test fun `mask partial`() = assertEquals("u***@example.com", "user@example.com".mask(1, 4))
    @Test fun `mask from start`() = assertEquals("****World", "HelloWorld".mask(end = 4))
    @Test fun `mask empty string`() = assertEquals("", "".mask())
    @Test fun `mask start equals end`() = assertEquals("hello", "hello".mask(2, 2))
    @Test fun `mask out of range coerced`() = assertEquals("he***", "hello".mask(2, 100))
}
