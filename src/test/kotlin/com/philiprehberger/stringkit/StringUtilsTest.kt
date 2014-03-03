package com.philiprehberger.stringkit

import kotlin.test.*

class StringUtilsTest {
    @Test fun `collapseWhitespace`() = assertEquals("a b c", "  a   b  c  ".collapseWhitespace())
    @Test fun `initials`() = assertEquals("JD", "John Doe".initials())
    @Test fun `surround`() = assertEquals("**hello**", "hello".surround("**"))
    @Test fun `wordWrap`() = assertTrue("hello world foo".wordWrap(10).contains("\n"))
    @Test fun `repeat with separator`() = assertEquals("a-a-a", "a".repeat(3, "-"))
}
