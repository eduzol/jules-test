# Math Service

## Description
A simple Spring Boot application that provides RESTful APIs for basic mathematical operations.

## How to Build
Java 17 and Maven are required to build this project. You can use the included Maven wrapper.

To build the project, run the following command from the root directory:
```bash
./mvnw clean install
```

## How to Run
Once the project is built, you can run the application using the following command:
```bash
java -jar target/math-service-0.0.1-SNAPSHOT.jar
```
The application will start on the default port (usually 8080).

## API Endpoints

### `/sum`
- **Method**: `GET`
- **Parameters**:
    - `a` (integer): The first number.
    - `b` (integer): The second number.
- **Example**: `/sum?a=10&b=5`
- **Response**: `{"result": 15}`

### `/multiply`
- **Method**: `GET`
- **Parameters**:
    - `a` (integer): The first number.
    - `b` (integer): The second number.
- **Example**: `/multiply?a=10&b=5`
- **Response**: `{"result": 50}`

### Error Responses
If invalid parameters are provided (e.g., non-integer values when integers are expected), the API will return an HTTP 500 status code.
The error response body will be a JSON object in the following format:
```json
{"result":"Error: Invalid input. Please provide integers only."}
```

## API Documentation
OpenAPI documentation is available when the application is running. You can access it via your web browser at:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
(Assuming the application is running on `localhost` and port `8080`).
