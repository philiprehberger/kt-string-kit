# string-kit

[![CI](https://github.com/philiprehberger/kt-string-kit/actions/workflows/publish.yml/badge.svg)](https://github.com/philiprehberger/kt-string-kit/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.philiprehberger/string-kit)](https://central.sonatype.com/artifact/com.philiprehberger/string-kit)

String manipulation: truncation, case conversion, wrapping, and interpolation.

## Requirements

- Kotlin 1.9+ / Java 17+

## Installation

### Gradle (Kotlin DSL)

```kotlin
dependencies {
    implementation("com.philiprehberger:string-kit:0.1.0")
}
```

### Maven

```xml
<dependency>
    <groupId>com.philiprehberger</groupId>
    <artifactId>string-kit</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Usage

```kotlin
import com.philiprehberger.stringkit.*

// Truncation
"Hello World Foo Bar".truncate(15)   // "Hello World..."
"Hello World Foo Bar".truncateWords(2) // "Hello World..."

// Case conversion
"hello_world".toCamelCase()    // "helloWorld"
"helloWorld".toSnakeCase()     // "hello_world"
"helloWorld".toKebabCase()     // "hello-world"
"hello_world".toPascalCase()   // "HelloWorld"

// Utilities
"  lots  of   spaces ".collapseWhitespace() // "lots of spaces"
"John Doe".initials()          // "JD"
"Hello {name}!".interpolate(mapOf("name" to "Alice")) // "Hello Alice!"
```

## API

| Function / Class | Description |
|------------------|-------------|
| `String.truncate(maxLength, ellipsis)` | Smart truncation at word boundaries |
| `String.truncateWords(maxWords, ellipsis)` | Truncate after N words |
| `String.toCamelCase()` | Convert to camelCase |
| `String.toSnakeCase()` | Convert to snake_case |
| `String.toKebabCase()` | Convert to kebab-case |
| `String.toPascalCase()` | Convert to PascalCase |
| `String.toTitleCase()` | Convert to Title Case |
| `String.toConstantCase()` | Convert to CONSTANT_CASE |
| `String.collapseWhitespace()` | Collapse whitespace and trim |
| `String.initials()` | Extract uppercase initials |
| `String.surround(wrapper)` | Wrap string with prefix/suffix |
| `String.wordWrap(width)` | Wrap at word boundaries |
| `String.interpolate(map)` | Replace `{key}` placeholders |

## Development

```bash
./gradlew test       # Run tests
./gradlew build      # Build JAR
```

## License

MIT
