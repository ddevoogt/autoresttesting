# Autorest testing

The purpose of this project is to demonstrate a current issue in Azure's autorest for java when creating a java client. 

> see https://aka.ms/autorest

## Getting Started

To build the SDKs, you first need to do the following:

-   Install the latest [Node.js LTS](https://nodejs.org)
-   Install AutoRest by running the command `npm i -g autorest`
-   Install [OpenJDK](https://jdk.java.net/) JDK version [18](https://jdk.java.net/18/) or greater OR [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) JDK version [18](https://www.oracle.com/java/technologies/downloads/#java18) or greater
    - Do not forget to set environment variable JAVA_HOME to the location of the Java Runtime Environment (JRE)
    - Do not forget to add the location of the JDK executable to the PATH environment variable
-   Run AutoRest using the command `autorest --java --use:@autorest/java@4.1.8` to set up AutoRest for Java

With all of this in place, you should be able to build the project.

## Install and Run the local server
```
cd server && npm install && npm run start
```

## Build the client
In a new command session build the client using Autorest
```
autorest --java
```

## Run the java test with the generate java code.
In a new command session build the client using Autorest
```
cd client && mvn test
```
---

## General AutoRest Settings

[AutoRest Settings](https://azure.github.io/autorest/user/command-line-interface.html)

```yaml
license-header: NONE
sync-methods: none
use-extension:
    "@autorest/modelerfour": 4.25.0
version: 3.9.2
```

## Java

See configuration in [README.java.md](./README.java.md)

