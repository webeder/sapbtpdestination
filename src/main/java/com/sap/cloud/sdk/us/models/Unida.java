/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sap.cloud.sdk.us.models;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
/*
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.datamodel.odata.client.ODataProtocol;
import com.sap.cloud.sdk.datamodel.odata.client.query.StructuredQuery;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestRead;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataRequestResultGeneric;
import static com.sap.cloud.sdk.us.TesteJava.destinationName;
import static com.sap.cloud.sdk.us.TesteJava.entityName;
import static com.sap.cloud.sdk.us.TesteJava.servicePath;
import org.apache.http.client.HttpClient;
*/
/**
 *
 * @author eder.quadros
 */
public class Unida {
   
      private String servicePath;
      private String entityName;
      private String destinationName;

      
    // chama direto o construtor  
    public Unida(String servicePath, String entityName,String destinationName ) {
        this.servicePath = servicePath;
        this.entityName = entityName;
        Destination destination = DestinationAccessor.getDestination(destinationName);
        destination.getPropertyNames();
        this.destinationName = destination.toString() ;
       
    }      
      
    //get   
    public String getServicePath() {
        return servicePath;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getDestinationName() {
        return destinationName;
    }
    
    
  
    //SET 
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setDestinationName(String destinationName) {
        Destination destination = DestinationAccessor.getDestination(destinationName);
        this.destinationName = destination.toString() ;
         
    }
    
    
      
      
      
      
      
}  
      
       
 /*   static String servicePath = "/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV";
    static String entityName = "A_ProductCharcValue";
    static String destinationName = "S4HANA_API_CLFN_PRODUCT_SRV";*/
      /*
         try {
            Destination destination = DestinationAccessor.getDestination(destinationName);
            HttpClient httpClient = HttpClientAccessor.getHttpClient(destination);

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
            System.out.println("Response: " + result.asListOfMaps());
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      */  
        
 

 
    
     
   
    
    
    
    
    
    
    
    

