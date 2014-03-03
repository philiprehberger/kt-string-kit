package com.philiprehberger.stringkit

/** Truncates this string to [maxLength], appending [ellipsis] if truncated. Tries to break at a word boundary. */
public fun String.truncate(maxLength: Int, ellipsis: String = "..."): String {
    if (length <= maxLength) return this
    val limit = maxLength - ellipsis.length
    if (limit <= 0) return ellipsis.take(maxLength)
    val sub = substring(0, limit)
    val lastSpace = sub.lastIndexOf(' ')
    return if (lastSpace > limit / 2) sub.substring(0, lastSpace) + ellipsis else sub + ellipsis
}

/** Truncates to [maxWords] words, appending [ellipsis] if truncated. */
public fun String.truncateWords(maxWords: Int, ellipsis: String = "..."): String {
    val words = trim().split(Regex("\\s+"))
    return if (words.size <= maxWords) this.trim()
    else words.take(maxWords).joinToString(" ") + ellipsis
}
