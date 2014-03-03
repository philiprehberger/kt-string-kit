package com.philiprehberger.stringkit

import kotlin.test.*

class TruncateTest {
    @Test fun `no truncation needed`() = assertEquals("hello", "hello".truncate(10))
    @Test fun `truncates at word boundary`() = assertEquals("Hello...", "Hello World Foo".truncate(10))
    @Test fun `truncateWords`() = assertEquals("Hello World...", "Hello World Foo Bar".truncateWords(2))
    @Test fun `truncateWords no truncation`() = assertEquals("Hello", "Hello".truncateWords(5))
    @Test fun `empty string`() = assertEquals("", "".truncate(5))
}
