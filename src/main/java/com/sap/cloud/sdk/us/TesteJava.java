/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sap.cloud.sdk.us;



//import com.sap.cloud.sdk.cloudplatform.connectivity.DefaultHttpDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestinationProperties;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.HttpClientInstantiationException;
import com.sap.cloud.sdk.datamodel.odata.client.ODataProtocol;
import com.sap.cloud.sdk.datamodel.odata.client.query.StructuredQuery;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestRead;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestResultGeneric;

//import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;



public class TesteJava {

    static String servicePath = "/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV";
    static String entityName = "A_ProductCharcValue";
    static String destinationName = "S4HANA_API_CLFN_PRODUCT_SRV";
    static String erro = "DEU RUIM";
    
    private String res;
   
    public String getRes() {
        
       try {
            Destination destination = DestinationAccessor.getDestination(destinationName);
            HttpClient httpClient = HttpClientAccessor.getHttpClient((HttpDestinationProperties) destination);

            // Define the query
            String encodedQuery = StructuredQuery.onEntity(entityName, ODataProtocol.V2)
                    .withCustomParameter("$top", "1")
                    .withCustomParameter("$format", "json")
                    .withCustomParameter("sap-client", "110")
                    .getEncodedQueryString();

            // Create a read request
            ODataRequestRead request = new ODataRequestRead(
                    servicePath,
                    entityName,
                    encodedQuery,
                    ODataProtocol.V2);

            // Execute the request
            ODataRequestResultGeneric result = request.execute(httpClient);

            // Handle the response
        // System.out.println("Response: " + result.asListOfMaps());
         
        return result.asListOfMaps().toString();

    } catch (DestinationAccessException e) {
            
       
              return erro;
        }
    
        
        
     //   return result.asListOfMaps();
      
    }

    public void setRes(String res) {
        this.res = res;
    }
    
    
    
    
}