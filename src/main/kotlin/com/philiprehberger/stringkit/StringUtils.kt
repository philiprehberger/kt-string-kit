package com.philiprehberger.stringkit

/** Collapses consecutive whitespace into single spaces and trims. */
public fun String.collapseWhitespace(): String = replace(Regex("\\s+"), " ").trim()

/** Returns the uppercase initials: "John Doe" -> "JD". */
public fun String.initials(): String = trim().split(Regex("\\s+")).mapNotNull { it.firstOrNull()?.uppercase() }.joinToString("")

/** Surrounds this string with [wrapper]: "hello".surround("**") -> "**hello**". */
public fun String.surround(wrapper: String): String = "$wrapper$this$wrapper"

/** Wraps text at [width] characters, breaking at word boundaries. */
public fun String.wordWrap(width: Int): String {
    val words = split(" ")
    val lines = mutableListOf<String>()
    var current = StringBuilder()
    for (word in words) {
        if (current.isNotEmpty() && current.length + 1 + word.length > width) {
            lines.add(current.toString())
            current = StringBuilder(word)
        } else {
            if (current.isNotEmpty()) current.append(" ")
            current.append(word)
        }
    }
    if (current.isNotEmpty()) lines.add(current.toString())
    return lines.joinToString("\n")
}

/** Repeats this string [n] times with [separator] between repetitions. */
public fun String.repeat(n: Int, separator: String): String = (1..n).joinToString(separator) { this }

/**
 * Masks characters in the range \[start, end) with [char].
 *
 * - [start] defaults to `0` (beginning of string).
 * - [end] defaults to `null`, meaning the end of the string.
 * - Indices are coerced to valid bounds, so out-of-range values are safe.
 *
 * ```
 * "4111111111111111".mask(4, 12)       // "4111********1111"
 * "user@example.com".mask(1, 4)        // "u***@example.com"
 * "secret".mask()                      // "******"
 * "secret".mask(char = '#')            // "######"
 * ```
 */
public fun String.mask(start: Int = 0, end: Int? = null, char: Char = '*'): String {
    if (isEmpty()) return this
    val s = start.coerceIn(0, length)
    val e = (end ?: length).coerceIn(s, length)
    return substring(0, s) + char.toString().repeat(e - s) + substring(e)
}
