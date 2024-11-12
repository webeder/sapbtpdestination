package com.sap.cloud.sdk.us.controllers;


import com.google.gson.Gson;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestinationProperties;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import com.sap.cloud.sdk.datamodel.odata.client.ODataProtocol;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestCreate;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestResultGeneric;

import org.apache.http.client.HttpClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class YourController {

    private  String destinationName ;
    private  String servicePath ;
    private String entityName ;
    private  String csrf  ; // este valor deve ser obtido dinamicamente em produção
    private  String erro = "Erro na requisição";
    private String var;

    @PostMapping("/postRes")
  public String createpost(@RequestHeader HttpHeaders headers, @RequestBody String gx) {
      
     
        
         csrf =  headers.get("csrf").toString();
         csrf = csrf.replace("[", "");
         csrf = csrf.replace("]", "");
        
         servicePath =  headers.get("Baseurl").toString();
         servicePath = servicePath.replace("[", "");
         servicePath = servicePath.replace("]", "");
         
         entityName =  headers.get("par").toString();
         entityName = entityName.replace("[", "");
         entityName = entityName.replace("]", "");
         
         destinationName =  headers.get("destino").toString();
         destinationName = destinationName.replace("[", "");
         destinationName = destinationName.replace("]", "");
      
      
      
      
      
      
        try {
            Destination destination = DestinationAccessor.getDestination(destinationName);
            HttpClient httpClient = HttpClientAccessor.getHttpClient((HttpDestinationProperties) destination);

            // Cria uma solicitação para POST
            ODataRequestCreate request = new ODataRequestCreate(servicePath, entityName, var, ODataProtocol.V2);
            request.addHeader("x-csrf-token", csrf);

            // Executa a solicitação POST
            ODataRequestResultGeneric result = request.execute(httpClient);

            // Converte a resposta para uma string JSON
            return new Gson().toJson(result.asListOfMaps());

        } catch (DestinationAccessException e) {
            return erro;
        }
    }
}
