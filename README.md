# Software
The following software need to be installed in your machine in order to run ASIA-backend:
- Java v. 1.8
- Maven


# Build and Run
From root directory:
```
$ cd project
$ mvn package
$ java -jar target/AsiaBackend.jar
```
By default, ASIA-backend will run on port 8080, which is used in the example URLs below. To use a different port, set the server.port property as follows when running the program:
```
java -Dserver.port=7000 -jar target/AsiaBackend.jar
```

# Usage
First, run your conciliator services on your machine before use ASIA-backend

Conciliators you can interact with:
```
http://localhost:8080/services
```
API call template:
```
http://localhost:8080/reconcile/master?queries={ "q0" : { "query" : "foo", "type": "bar", "limit": l}, ..., "qn" : { "query" : "baz" } }&conciliators=conc1,conc2
```

## API params: 

**queries**: List of JSON objects where each of them has zero or more key/value pairs. Each object in the queries json object can have the following fields:

| Parameter | Description |
| --- | --- |
| "query" | A string to search for. Required. |
| "limit" | An integer to specify how many results to return. Optional. |
| "type" | A single string specifying the type of result e.g., person, product, ... . Optional. |



**conciliators**: is a comma-separated list of conciliator ids you want to take in account. If not specified every conciliator will be considered.


# Third party licenses
The list of third party licenses can be found in:
```
<project_dir>\src\license\THIRD-PARTY.txt
```
To update le list of third party license file run:
```shell script
$ mvn license:add-third-party  
```