# lite-http-clj-server

Minimalist pure Clojure HTTP server

## Overview

A lightweight HTTP server implementation in pure Clojure, designed for minimal overhead and fast startup times. This implementation avoids Java class instantiation and object parsing, using only Clojure's native data structures (maps, vectors, strings) for maximum simplicity and performance.

## Motivation

Traditional JVM-based HTTP servers carry significant overhead from object allocation, class loading, and framework abstractions. This server is purpose-built for containerized serverless environments where:

- **Fast cold starts** are critical (AWS Lambda, GCP Cloud Run)
- **Memory footprint** must be minimal
- **HTTP is the platform interface**, not an application concern
- **Simple request/response handling** is sufficient

By eliminating unnecessary abstractions and using pure Clojure data structures, this server provides a lean bridge between cloud platform HTTP interfaces and your application logic.

## Characteristics

- **Pure Clojure**: No Java interop for HTTP parsing or handling
- **Zero dependencies**: No external HTTP frameworks or libraries
- **Data-oriented**: Requests and responses are plain Clojure maps
- **Minimal overhead**: No object instantiation or complex parsing logic
- **Serverless-optimized**: Designed for containerized function runtimes

## Use Cases

This server is ideal for:

- **AWS Lambda** container images that need to expose an HTTP endpoint
- **GCP Cloud Run** functions requiring HTTP interfaces
- **Lightweight microservices** where startup time and memory matter
- **Educational purposes** to understand HTTP protocol implementation

## When Not to Use

Consider mature HTTP servers (Jetty, http-kit, Aleph) if you need:
- Production-grade performance optimization
- Advanced HTTP features (HTTP/2, WebSockets, streaming)
- Battle-tested security and edge case handling
- Extensive middleware ecosystems

## Requirements

- Clojure 1.11 or higher
- Java 11+ runtime (for the Clojure runtime only)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
