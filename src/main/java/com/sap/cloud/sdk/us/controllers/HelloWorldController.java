package com.sap.cloud.sdk.us.controllers;


import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.DestinationAccessException;
import com.sap.cloud.sdk.cloudplatform.connectivity.exception.HttpClientInstantiationException;
import com.sap.cloud.sdk.us.TesteJava;
import java.net.http.HttpResponse;
import org.apache.http.client.HttpClient;
  

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



//import com.sap.cloud.sdk.us.models.HelloWorldResponse;
//import com.sap.cloud.sdk.us.models.Unida;

@RestController // Esse é um Controlador Rest
@RequestMapping( "/hello" ) // Esse é o caminho do controlador  
public class HelloWorldController
{
     static String teste = "não achou nada";
    @RequestMapping( method = RequestMethod.GET )
     public String testeapi() {

     //  TesteJava destino = new TesteJava();
       SapTest destino = new SapTest();
         destino.setRes("Inico");
         return "Entrou "+destino.getRes();   
     
}
     
}
   

 
