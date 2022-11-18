# Autorest testing

The purpose of this project is to demonstrate a current issue in Azure's autorest for java when creating a java client. 

> see https://aka.ms/autorest

## Getting Started

Make sure you have autorest installed.

Install AutoRest by running the command 
```
npm i -g autorest
```

With all of this in place, you should be able to build the project.

## Install and Run the local server
```
cd server
npm install
npm run start
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

