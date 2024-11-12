package com.sap.cloud.sdk.us.models;


import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("PMD.UnusedPrivateField")
public class HelloWorldResponse
{
    @JsonProperty("hello")
    private final String name;
    
    Unida unida = new Unida("/sap/opu/odata/sap/API_CLFN_PRODUCT_SRV","A_ProductCharcValue","S4HANA_API_CLFN_PRODUCT_SRV");
      
        String destinationName = unida.getDestinationName();

    public HelloWorldResponse( final String name ) {
        this.name = destinationName;
    }
}
