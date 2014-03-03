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
