# U1-M4-Summative-Markewicz-Matthew

### Spring Annotations
Class, method, method-parameter level notations. Mark blocks of code for Spring to configure and apply predefined functionality.

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

#### @RequestParam
Method parameter level notation, converts query parameters into usable Java variables. Can specify the query parameter name, or imply.

#### @SpringBootApplication
Class level parameter with the App class, where the main() method is located

#### @RunWith
Accepts (SpringRunner.class) as a method parameter

#### @WebMvcTest
Accepts (ControllerName.class) to point to a specific controller file

#### @Autowired
Method level annotation that handles dependency injection. Will resolve and inject classes into your file before running

#### @Before 
Method level annotation that allows you to instantiate objects before running individual tests

#### @Test
Denotes a specific test to be run. Each @Test can be run in isolation, or the entire test can be run together

#### @RestControllerAdvice
Class level annotation that handles exceptions

#### @ExceptionHandler
Accepts an Exception.class as a parameter, and specifies certain actions to be taken when that exception is hit

#### @NotEmpty
Notation on top of a variable that takes a message as a parameter, size cannot be zero

#### @Size
Notation on top of a variable that takes in a min and max of a string

#### @Valid
Method parameter level annotation that can verify if a variable meets a certain criteria, JSR validation

### OpenAPI / OpenAPI 3.x Specification
- Creates a .yaml document for API specs
- Define URIs, request methods, request bodies, response bodies, query parameters, and path variables

### Query Parameters vs. Path Variables
- Path variables are like placeholders, they signify a dynamic route, and depending on what the user inputs in the URI, the request can be handled differently for different variables
- Query parameters will have one defined route, but will have additional information passed from the user. This information can be used while processing the request. 
- Path variables will signify a defined path, whereas query parameters will belong to the same path that accepts dynamic information from the user

### HTTP Response Codes
- 100: Informational responses
- 200: Successful response
- 300: Redirects
- 400: Request error from client
- 500: Server error

### Architectural Principles of REST
- Roy Fielding in 2000
- Representational State Transfer
- Architectural style, not a standard
- Built on top of HTTP (Stateless)
- Resources (nouns) indicated by URIs (Uniform Resource Indicator)
- Action to be taken is specified by HTTP method
- Data transfer is generally in JSON or XML (HTTP media types)

### Web Apps v. Web Services
- Web apps are applications that are run from the browser
- Web services is an API that runs on a server and communicates to the client via HTTP

### Response-request Protocol
A protocol like HTTP in which a client and server communicate via requests (from the client) and responses (from the server)

### Spring
The base framework for the entire Spring ecosystem

### Spring Boot
A framework designed to build microservices and rapid application, additional features to base Spring framework

### Spring MVC
MVC is a Spring module designed for web applications. Implements the MVC design pattern in Spring