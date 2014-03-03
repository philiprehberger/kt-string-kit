package com.philiprehberger.stringkit

import kotlin.test.*

class CaseConvertTest {
    @Test fun `toCamelCase from snake`() = assertEquals("helloWorld", "hello_world".toCamelCase())
    @Test fun `toSnakeCase from camel`() = assertEquals("hello_world", "helloWorld".toSnakeCase())
    @Test fun `toKebabCase from camel`() = assertEquals("hello-world", "helloWorld".toKebabCase())
    @Test fun `toPascalCase from snake`() = assertEquals("HelloWorld", "hello_world".toPascalCase())
    @Test fun `toTitleCase from snake`() = assertEquals("Hello World", "hello_world".toTitleCase())
    @Test fun `toConstantCase from camel`() = assertEquals("HELLO_WORLD", "helloWorld".toConstantCase())
    @Test fun `empty`() = assertEquals("", "".toCamelCase())
}
