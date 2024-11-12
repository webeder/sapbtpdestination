package com.sap.cloud.sdk.us;

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

public class Conectapost {

    private final String servicePath; // BaseURL 
    private final String entityName; // Execute
    private final String destinationName; // Destination name
    private final String var; // Payload for POST request
    private final String sapclient;
    private final String csrf;
   // private final String authorization;
    
    
    static String erro = "{\"Error\":\"A classe não respondeu.\"}";

    public Conectapost(String servicePath, String entityName, String destinationName, String var, String sapclient, String csrf) {
        this.servicePath = servicePath;
        this.entityName = entityName;
        this.destinationName = destinationName;
        this.var = var;
        this.sapclient = sapclient;
        this.csrf = csrf;
     //   this.authorization = authorization;
    }

    public String postRes() {
        try {
            Destination destination = DestinationAccessor.getDestination(destinationName);
            HttpClient httpClient = HttpClientAccessor.getHttpClient((HttpDestinationProperties) destination);

            // Create a create request for POST                   baseUrl    executa         
            ODataRequestCreate request = new ODataRequestCreate(servicePath, entityName, var, ODataProtocol.V2);

           // request.addHeader("sap-client",sapclient); 
            request.addHeader("x-csrf-token",csrf);
           // request.addHeader("authorization",authorization);
          
            // Execute the POST request
            ODataRequestResultGeneric result = request.execute(httpClient);
            // Convert response to JSON string
            String Json = new Gson().toJson(result.asListOfMaps());
            return Json;

        } catch (DestinationAccessException e) {
            return erro;
        }
    }
}

 
