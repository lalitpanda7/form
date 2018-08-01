# Introduction 
This is a form management service. It will handle all the request related to form library, form editing, e-sign etc.

[![Build Status](https://jenkins.gedmin.as/job/check-manifest/badge/icon)](https://redbell.visualstudio.com/HomeGenius/_build)

## Application Architecture

```
 ╭┄┄┄┄┄┄┄╮ JSON ┌──────────┐      ┌──────────┐
 ┆   ☁   ┆  ←→  │    ☁     │  ←→  │    💾    │
 ┆  Web  ┆ HTTP │  Forms   │      │ CosmosDB │
 ╰┄┄┄┄┄┄┄╯      │  Service │      └──────────┘
                └──────────┘
```

## Internal Architecture 
The **Spring Service** itself has a pretty common internal architecture:

  * `Controller` classes provide _REST_ endpoints and deal with _HTTP_ requests and responses
  * `Service` classes responsible for data transfer between controller and repository with business logic
  * `Repository` classes interface with the _database_ and take care of writing and reading data to/from persistent storage


  ```
  Request  ┌────────── Report Service ─────────────────────────────┐
   ─────────→ ┌─────────────┐    ┌────────────┐    ┌─────────────┐ │   ┌─────────────┐
   ←───────── │  Controller │ ←→ │  Service   │ ←→ │  Repository │←──→ │  Database   │
  Response │  └─────────────┘    └────────────┘    └─────────────┘ │   └─────────────┘
           │                                                       │                     
           └───────────────────────────────────────────────────────┘
  ```

### Test Layers

```
      ╱╲
  End-to-End
    ╱────╲
   ╱ Inte-╲
  ╱ gration╲
 ╱──────────╲
╱   Unit     ╲
──────────────
```
#### App Parameters

* FORM_SERVICE_SERVER_PORT=8086
	``` 
    Defaults to '8086'
    ```
* FORM_SERVICE_SERVER_CONTEXTPATH=/forms
	``` 
    Defaults to '/forms'
    ```

[API references](http://localhost:8086/forms/swagger-ui.html)
[Health Check](http://localhost:8086/forms/actuator/health)

#### Build and Run commands

```sh
$ mvn clean package
```

```sh
$ java -jar target/forms-1.0.0-release.jar
```

#### Run all Tests

```sh
$ mvn clean test
```

### End
