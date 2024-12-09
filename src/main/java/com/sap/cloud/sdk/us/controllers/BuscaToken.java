/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sap.cloud.sdk.us.controllers;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestinationProperties;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import com.sap.cloud.sdk.datamodel.odata.client.ODataProtocol;
//import com.sap.cloud.sdk.datamodel.odata.client.query.StructuredQuery;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestRead;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestResultGeneric;



//import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;


public class BuscaToken { 

   // public static final String URL_GET = "http://httpbin.org/get";
 //    private final String servicePath; //BaseURL 
//     private final String entityName; //Execute
//     private final String destinationName; // destination nome 
//     private final String sapclient;
    // private final String top; // ATRIBUTO
//     private final String var;
    // VARIAVEL LOCAL 
     
     
     static String erro = "{\"Error\":\"A classe não respondeu.\"}";
     
    static String servicePath = "/sap/opu/odata/sap/";
    static String entityName = "z_gw_authorization_poc_srv";
    static String destinationName = "*****API_CLFN_PRODUCT_SRV";
 

  /*  public BuscaToken(String servicePath, String entityName, String destinationName, String var,  String sapclient) {
        this.servicePath = servicePath;
        this.entityName = entityName;
        this.destinationName = destinationName;
        this.var        = var;
        this.sapclient = sapclient;
         
    } */

   
    public String getRes() {
        
       try {
            Destination destination = DestinationAccessor.getDestination(destinationName);
            HttpClient httpClient = HttpClientAccessor.getHttpClient((HttpDestinationProperties) destination);

            // Define the query
          //  if (top == "0"){
           // String encodedQuery = StructuredQuery.onEntity(var, ODataProtocol.V2)                     
                    // .withCustomParameter("$format", "json")
                   // .withCustomParameter("sap-client", sapclient)
                  //  .getEncodedQueryString();
       /*     }else{ */
                  //   String encodedQuery = StructuredQuery.onEntity(entityName, ODataProtocol.V2)
                 //    .withCustomParameter("$format", "json")
                //    .withCustomParameter("sap-client", sapclient)
                //    .getEncodedQueryString();
           // }
            // Create a read request
            
            
            
            ODataRequestRead request = new ODataRequestRead(
                    servicePath, // /sap/opu/odata/sap/
                    entityName, //z_gw_authorization_poc_srv
                    "",
                    ODataProtocol.V2);
              
            //set no header os valores 
               request.addHeader("sap-client","110"); 
               request.addHeader("x-csrf-token","fetch");           
    
            // Adiciona o cabeçalho "sap-client"
     

    // Executa a solicitação
    ODataRequestResultGeneric result = request.execute(httpClient);


            // Handle the response
       System.out.println("Response: " + result.asListOfMaps());
       
    //   String Json = new Gson().toJson(result.asListOfMaps());
         
    //    return Json;
          return request.getHeaders().toString();
        
        

    } catch (DestinationAccessException e) {
            
       
              return erro;
        }
    
        
        
     //   return result.asListOfMaps();
      
    }


    public String getServicePath() {
        return servicePath;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public static String getErro() {
        return erro;
    }

   
    
    
    
}

