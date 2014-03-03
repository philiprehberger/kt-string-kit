package com.philiprehberger.stringkit

/** Replaces `{key}` placeholders with values from [values]. Unmatched placeholders are left as-is. */
public fun String.interpolate(values: Map<String, Any?>): String {
    return replace(Regex("\\{(\\w+)\\}")) { match ->
        val key = match.groupValues[1]
        if (values.containsKey(key)) values[key]?.toString() ?: "" else match.value
    }
}
