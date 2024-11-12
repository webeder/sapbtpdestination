package com.sap.cloud.sdk.us.controllers;
/*


import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
/*import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;*/
/*import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/middleware")
public class MiddlewareController {

    private final RestTemplate restTemplate;

    public MiddlewareController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<?> postToSapService(
            @RequestHeader("x-csrf-token") String csrfToken,
            @RequestHeader("destination-name") String destinationName,
            @RequestParam("endpointPath") String endpointPath,
            @RequestBody Map<String, Object> data) {

        try {
            // Recupera a destination usando o SAP SDK
            Destination destination = DestinationAccessor.getDestination(destinationName);
            if (!(destination instanceof HttpDestination)) {
                throw new DestinationAccessException("Destination não é do tipo HTTP");
            }
            HttpDestination httpDestination = destination.asHttp();

            // Monta a URL completa com o endpointPath
            URI url = URI.create(httpDestination.getUri() + "/" + endpointPath);

            // Configura os headers, incluindo o x-csrf-token e qualquer header adicional necessário
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-csrf-token", csrfToken);
            headers.set("Content-Type", "application/json");

            // Cria a entidade HTTP com o corpo da requisição e os headers
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(data, headers);

            // Faz a requisição POST usando o RestTemplate
            ResponseEntity<?> sapResponse = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

            // Retorna a resposta do SAP BTP para a aplicação que chamou o middleware
            return ResponseEntity.ok(sapResponse.getBody());
        } catch (DestinationAccessException e) {
            // Erro ao acessar a destination configurada no SAP BTP
            return ResponseEntity.status(500).body("Erro ao acessar a destination: " + e.getMessage());
        } catch (HttpClientErrorException e) {
            // Loga o erro e retorna uma mensagem de erro com o código de status
            return ResponseEntity.status(e.getStatusCode()).body("Erro ao processar a requisição: " + e.getMessage());
        }
    }
}
*/