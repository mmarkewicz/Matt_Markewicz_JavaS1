# U1-M4-Summative-Markewicz-Matthew

### Spring Annotations

#### @RestController
Class level annotation, makes Spring aware of it's existence, treats all returned values as JSON and sends those values back to the client

#### @RequestMapping
Method level annotation, maps an endpoint to a method that will handle the request, 2 parameters (value - URI, method - specifies HTTP method), must be unique across all controllers

#### @ResponseStatus
Method level annotation, HTTP status code that is sent back when the method successfully handles the incoming request

#### @PathVariable
Method parameter level notation. Maps a path variable, denoted by {} to a method parameter. Type conversion is taken care of by Spring. If the path variable is the same as the name of the method variable, no further configuration is needed

#### @RequestBody
Method level annotation. Maps JSON in the request body to a method parameter. Jackson Mapper takes care of converting JSON to Java and Java to JSON.

### OpenAPI / OpenAPI 3.x Specification

### Query String

### Query Parameters vs. Path Variables

### HTTP Response Codes

### Architectural Principles of REST

### Web Apps v. Web Services

### Response-request Protocol

### Spring

### Spring Boot

### Spring MVC