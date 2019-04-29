## Overview

Waracle Cake manager implementation to demonstrate a REST API built using the Spring Data Rest module. Exposes a fully featured REST API **without having to write controller end-points for boiler-plate operations (GET/POST etc.)**. It also supports advanced searching, sorting and paging without any code having to be written to support these operations.

## Running

```
git clone https://github.com/alanhay/waracle-cake-manager-demo.git
cd waracle-cake-manager-demo
mvn spring-boot:run
```

## Basic Operations

+ to see an HTML view of all cakes hit the root URL http://localhost:8080
+ to see a JSON view of all cake resources hit the URL http://localhost:8080/cakes
+ to see a JSON view of an individual cake resource hit the URL http://localhost:8080/cakes/{id}
+ to add a cake make a JSON POST request to the URL http://localhost:8080/cakes
+ to delete a cake send a DELETE request to http://localhost:8080/cakes/{id}
+ to update a cake make a JSON PATCH request to http://localhost:8080/cakes/{id} with the field(s) to be updated.

**See the postman collection in the project root for some sample requests.**

## Additional Features

+ Paging: specify page and size attributes e.g. http://localhost:8080/cakes?page=0&size=5
+ Filtering: specify search attributes e.g. http://localhost:8080/cakes?title=carrot
+ Sorting: specify sort attributes: e.g. http://localhost:8080/cakes?sort=title,desc
