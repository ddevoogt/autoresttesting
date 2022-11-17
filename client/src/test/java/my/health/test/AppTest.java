package my.health.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.azure.core.http.rest.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.health.test.generated.FuncTestingThisIsMyNamespaceAPI;
import my.health.test.generated.FuncTestingThisIsMyNamespaceAPIBuilder;
import my.health.test.generated.models.HealthStatus;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import reactor.core.publisher.Mono;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    String internalUrl = "http://localhost:3000";

    @Test
    public void healthCheck_AsEnum_ShouldBeHealthy() {
        FuncTestingThisIsMyNamespaceAPI client1 = new FuncTestingThisIsMyNamespaceAPIBuilder().host(internalUrl).buildClient();

        Mono<Response<HealthStatus>> healthDetailsResponseAsync = client1.getReadyHealthStatusAsPlainEnumWithResponseAsync();
        Response<HealthStatus> objectResponse = healthDetailsResponseAsync.log().block();

        Assertions.assertNotNull(objectResponse);
        assertEquals(200, objectResponse.getStatusCode());
        ObjectMapper objectMapper = new ObjectMapper();
        HealthStatus healthDetailsResponse = objectMapper.convertValue(objectResponse.getValue(), HealthStatus.class);
        Assertions.assertEquals(healthDetailsResponse, HealthStatus.HEALTHY);
    }

    @Test
    public void healthCheck_AsString_ShouldBeHealthy() {
        FuncTestingThisIsMyNamespaceAPI client1 = new FuncTestingThisIsMyNamespaceAPIBuilder().host(internalUrl).buildClient();

        Mono<Response<String>> healthDetailsResponseAsync = client1.getReadyHealthStatusAsPlainStringWithResponseAsync();
        Response<String> objectResponse = healthDetailsResponseAsync.log().block();

        Assertions.assertNotNull(objectResponse);
        assertEquals(200, objectResponse.getStatusCode());
        var result = HealthStatus.fromString(objectResponse.getValue());
        Assertions.assertEquals(result, HealthStatus.HEALTHY);
    }
}
