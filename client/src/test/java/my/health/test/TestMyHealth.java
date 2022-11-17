package my.health.test;

import com.azure.core.http.rest.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.health.test.generated.FuncTestingThisIsMyNamespaceAPI;
import my.health.test.generated.FuncTestingThisIsMyNamespaceAPIBuilder;
import my.health.test.generated.models.HealthStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyHealth {
    String internalUrl = "http://localhost:3000";
	
    @Test
    public void healthCheck_Healthy_internal() {
        FuncTestingThisIsMyNamespaceAPI client1 = new FuncTestingThisIsMyNamespaceAPIBuilder().host(internalUrl).buildClient();

        Mono<Response<HealthStatus>> healthDetailsResponseAsync = client1.getReadyHealthStatusWithResponseAsync();
		Response<HealthStatus> objectResponse = healthDetailsResponseAsync.log().block();

		Assertions.assertNotNull(objectResponse);
		assertEquals(200, objectResponse.getStatusCode());

		ObjectMapper objectMapper = new ObjectMapper();
        HealthStatus healthDetailsResponse = objectMapper.convertValue(objectResponse.getValue(), HealthStatus.class);
		Assertions.assertNotNull(healthDetailsResponse);
    }

}
