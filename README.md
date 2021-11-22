# SciForceTask

## Main goal: 
Implement `join` of two JSON data sources. #1 hosted on the Internet and #2 hosted locally in some file.
Your program should accept URL/path as an argument using any of the following approaches: command line / config / interactive.

The single datasource is a products enumeration for a particular stock. Both datasources are of the following format:
[{productUuid: "123e4567-e89b-12d3-a456-426655440000", productName: "Kattle", amount: 3},{productUuid: "123e4567-e89b-12d3-a456-426655440002", productName: "Teapot", amount: 1}]

You must read both and calculate the total amount for each referenced product and output JSON data in the same format.

## Optionally:

- [x] Implement it as a web-application (Servlet or REST API)
- [x] Automate application launch process (Gradle/Maven task or Spring Boot)
- [x] Make use of some OOP design patterns
- [ ] Support for more than 2 datasources
- [ ] Add an additional output field availability, Map datasetNumber -> amount availability: {"#1": 3, "#2": 2}}
to have information how many items either stock has
- [x] Exception handling if datasource contains the same productUuid twice

# Description
This is a simple rest api, so i'm expected url and path in argument of get request.

```java
/products?url=YOURURL&path=YOURPATH method GET
```
