# Nexus HTTP Server

A simple Java-based HTTP server implementation built with Gradle. This project demonstrates basic HTTP server functionality with custom logging capabilities.

## Features

- **Simple HTTP Server**: Basic HTTP server that listens for incoming connections
- **Custom Logging**: Built-in logging system that writes to a file (`nexus.log`)
- **Configurable Port**: Default port 8080 with option to specify custom port
- **Connection Handling**: Accepts and logs incoming client connections
- **HTTP Request Parsing**: Reads and logs HTTP request headers

## Project Structure

```
javahttpserver/
├── src/
│   └── main/
│       └── java/
│           └── Nexus/
│               ├── Main.java                 # Application entry point
│               ├── NexusServer.java          # Server interface
│               ├── NexusServerImpl.java      # Server implementation
│               └── NexusLogger/
│                   └── NexusLogger.java      # Custom logging utility
├── build.gradle                              # Gradle build configuration
├── settings.gradle                           # Gradle settings
└── README.md                                 # This file
```

## Prerequisites

- Java 8 or higher
- Gradle (or use the included Gradle wrapper)

## Building and Running

### Using Gradle Wrapper (Recommended)

1. **Build the project:**
   ```bash
   ./gradlew build
   ```

2. **Run the server:**
   ```bash
   ./gradlew run
   ```
   Or if you have a run task configured:
   ```bash
   java -cp build/classes/java/main Nexus.Main
   ```

### Using Gradle (if installed globally)

1. **Build the project:**
   ```bash
   gradle build
   ```

2. **Run the server:**
   ```bash
   gradle run
   ```

## Usage

Once the server is running, it will:

1. Start listening on port 8080 (default)
2. Accept incoming HTTP connections
3. Log connection details and HTTP requests to `nexus.txt`
4. Continue running until manually stopped

### Testing the Server

You can test the server using:

- **curl:**
  ```bash
  curl http://localhost:8080/
  ```

- **Web browser:** Navigate to `http://localhost:8080/`

- **Any HTTP client:** Send requests to `localhost:8080`

## Configuration

### Custom Port

To run the server on a different port, modify the `NexusServerImpl` constructor:

```java
NexusServer server = new NexusServerImpl(3000); // Use port 3000
```

### Log File Location

The server logs to `nexus.log` in the current working directory by default. To change the log file location, modify the `NexusLogger` constructor.

## Logging

The server uses a custom logging system (`NexusLogger`) that:

- Implements the Singleton pattern
- Writes logs to a file (`nexus.log`)
- Logs server startup, client connections, and HTTP requests
- Appends to the log file with timestamps

Log entries include:
- Server startup messages
- Client connection details (IP addresses)
- HTTP request headers

## Development

### Running Tests

```bash
./gradlew test
```

### Project Dependencies

- **JUnit 5**: For unit testing
- **Java Standard Library**: For HTTP server functionality

## Architecture

The project follows a simple layered architecture:

- **Main**: Application entry point
- **NexusServer**: Interface defining server contract
- **NexusServerImpl**: Concrete implementation of the HTTP server
- **NexusLogger**: Singleton logging utility for file-based logging

## Future Enhancements

Potential improvements for this HTTP server:

- HTTP response handling
- Request routing
- Static file serving
- Configuration file support
- Better error handling
- Multi-threading support
- HTTPS support

## Next Phase: HTTPS Implementation

For the next phase of this project, the server will be upgraded to support HTTPS instead of HTTP. This will require:
- Implementing SSL/TLS in the server code
- Handling certificates for secure connections
- Updating client and server communication to use secure sockets

Further instructions and details will be provided in future updates.

## License

This project is open source and available under the [MIT License](LICENSE).

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## Troubleshooting

### Common Issues

1. **Port already in use**: Change the port number or stop the process using port 8080
2. **Permission denied**: Ensure you have write permissions for the log file
3. **Build failures**: Make sure Java and Gradle are properly installed

### Log Files

Check `nexus.log` for server logs and debugging information.