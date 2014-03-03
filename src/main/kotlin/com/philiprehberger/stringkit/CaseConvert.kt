package com.philiprehberger.stringkit

private fun String.splitWords(): List<String> {
    if (isBlank()) return emptyList()
    return replace(Regex("([a-z])([A-Z])"), "$1 $2")
        .replace(Regex("([A-Z]+)([A-Z][a-z])"), "$1 $2")
        .split(Regex("[_\\-\\s]+"))
        .filter { it.isNotEmpty() }
}

/** Converts to camelCase: "hello_world" -> "helloWorld". */
public fun String.toCamelCase(): String {
    val words = splitWords()
    if (words.isEmpty()) return ""
    return words.first().lowercase() + words.drop(1).joinToString("") { it.lowercase().replaceFirstChar { c -> c.uppercase() } }
}

/** Converts to snake_case: "helloWorld" -> "hello_world". */
public fun String.toSnakeCase(): String = splitWords().joinToString("_") { it.lowercase() }

/** Converts to kebab-case: "helloWorld" -> "hello-world". */
public fun String.toKebabCase(): String = splitWords().joinToString("-") { it.lowercase() }

/** Converts to PascalCase: "hello_world" -> "HelloWorld". */
public fun String.toPascalCase(): String = splitWords().joinToString("") { it.lowercase().replaceFirstChar { c -> c.uppercase() } }

/** Converts to Title Case: "hello_world" -> "Hello World". */
public fun String.toTitleCase(): String = splitWords().joinToString(" ") { it.lowercase().replaceFirstChar { c -> c.uppercase() } }

/** Converts to CONSTANT_CASE: "helloWorld" -> "HELLO_WORLD". */
public fun String.toConstantCase(): String = splitWords().joinToString("_") { it.uppercase() }
