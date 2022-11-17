# Java client cannot parse text/plain endpoints that map to enums

After generating the client with an endpoint that returns a content-type of text/plain (string), like a simple health endpoint, the default java client is unable to deserialize the successful response.

We have a csharp client generate and it deserializes the string fine, although it is not typed as a the HealthStatus enum like it does in java, it is just a `Task<Response<string>> GetReadyHealthStatusAsync(CancellationToken cancellationToken = default)`.

## [Sample Spec File](https://github.com/ddevoogt/autoresttesting/blob/main/openapi.json)
```
{
  "openapi": "3.0.1",
  "info": {
    "title": "Func Testing ThisIsMyNamespace API",
    "version": "0.0.0"
  },
  "paths": {
    "/health/ready": {
      "get": {
        "tags": [
          "Health"
        ],
        "operationId": "GetReadyHealthStatus",
        "responses": {
          "200": {
            "description": "Success",
            "content": {
              "text/plain": {
                "schema": {
                  "$ref": "#/components/schemas/HealthStatus"
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "HealthStatus": {
        "enum": [
          "Unhealthy",
          "Degraded",
          "Healthy"
        ],
        "type": "string"
      }
    }
  }
}
```

## Produces error when the client is used to hit the health endpoint
```
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.447 s <<< FAILURE! - in my.health.test.AppTest
[ERROR] healthCheck_Healthy_internal  Time elapsed: 0.445 s  <<< ERROR!
com.azure.core.exception.HttpResponseException: Deserialization Failed.
Caused by: com.fasterxml.jackson.core.JsonParseException: 
Unrecognized token 'Healthy': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
 at [Source: (byte[])"Healthy"; line: 1, column: 8]
 ```

 ## Reproduction
 I've add a [public git repository](https://github.com/ddevoogt/autoresttesting) with a simplified version of what we are seeing. Please follow the steps in the [readme](https://github.com/ddevoogt/autoresttesting#readme) if this ticket is not clear enough.
