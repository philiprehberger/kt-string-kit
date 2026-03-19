package com.philiprehberger.stringkit

import kotlin.test.*

class InterpolateTest {
    @Test fun `basic`() = assertEquals("Hello Alice!", "Hello {name}!".interpolate(mapOf("name" to "Alice")))
    @Test fun `missing key`() = assertEquals("Hello {name}!", "Hello {name}!".interpolate(emptyMap()))
    @Test fun `null value`() = assertEquals("Hello !", "Hello {name}!".interpolate(mapOf("name" to null)))
}
