/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sap.cloud.sdk.us.controllers;

/**
 *
 * @author Eder Quadros - Analista Genexus 
 */

import com.sap.cloud.sdk.us.Conectapost;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/createpost")
public class createpost {

        int count = 1;
        static String teste = "{\"Error\":\"Não foi possivel conectar\"}";
        static String token = "{\"Error\":\"Token Inválido.\"}";
        String restoken;
        String  baseurl;
        String par;
        String destino; 
        String  gxtoken;
        String sapclient;
        String csrf;
        String authorization;
        String gx;
        
       
       
     
    @PostMapping
    public String createpost(@RequestHeader HttpHeaders headers, @RequestBody String gx) {
        
        
        gxtoken = headers.get("gxtoken").toString();
        baseurl  = headers.get("baseurl").toString();
        destino  = headers.get("destino").toString();
        par  = headers.get("par").toString();
        
 
        
         sapclient =  headers.get("sapclient").toString();
         sapclient = sapclient.replace("[", "");
         sapclient = sapclient.replace("]", "");
        
         csrf =  headers.get("csrf").toString();
         csrf = csrf.replace("[", "");
         csrf = csrf.replace("]", "");
                                
         gxtoken =  headers.get("gxtoken").toString();
         gxtoken = gxtoken.replace("[", "");
         gxtoken = gxtoken.replace("]", "");         
        
        
         baseurl =  headers.get("Baseurl").toString();
         baseurl = baseurl.replace("[", "");
         baseurl = baseurl.replace("]", "");
         
         par =  headers.get("par").toString();
         par = par.replace("[", "");
         par = par.replace("]", "");
         
         destino =  headers.get("destino").toString();
         destino = destino.replace("[", "");
         destino = destino.replace("]", "");
         
        // authorization = destino+baseurl+par+"&sap-client="+sapclient;
         
        if ( "Rx35M274".equals(gxtoken)) {
       
      Conectapost exe = new Conectapost(baseurl, par, destino, gx, sapclient, csrf);   
       // Exemplo: Log dos headers recebidos
    //    headers.forEach((key, value) ->  System.out.println(key + " N: "+count+++": " + value)); // só para mostrar todas as respotas de header 
        // Processa o usuário recebido
          //System.out.println("User data received: " +  exe.postRes());
        // Resposta
          return exe.postRes();

        }else{
            System.out.println(" Invalido"); 
             return  token;
        }
        
      
      
    }
}

