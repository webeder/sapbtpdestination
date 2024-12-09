/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sap.cloud.sdk.us.controllers;


import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class SapTest {
    static String   IP="ds4poc:1234", //IP or HOST
                    USER="***********", // user name of SAP
                    PASSWORD="**********", // password of SAP
                    CLIENT="110", //mandant in sap
                    SYSNR="00", // instance number
                    LANG="es"; // language (es or en)

      private String res;
      public String var;

    public String getRes() {
        
         try {
            // This will create a file called mySAPSystem.jcoDestination
            String DESTINATION_NAME1 = "*****API_CLFN_PRODUCT_SRV";
            Properties connectProperties = new Properties();
            connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST,   IP);
            connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,    SYSNR);
            connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT,   CLIENT);
            connectProperties.setProperty(DestinationDataProvider.JCO_USER,     USER);
            connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD,   PASSWORD);
            connectProperties.setProperty(DestinationDataProvider.JCO_LANG,     LANG);
            createDestinationDataFile(DESTINATION_NAME1,connectProperties);

        // This will use that destination file to connect to SAP

            JCoDestination destination = JCoDestinationManager.getDestination("*****_API_CLFN_PRODUCT_SRV");
 
           String customDestination = destination.getClient();
 
            System.out.println("Attributes:");
            System.out.println(destination.getAttributes());
            
              var = "Dentro da destination: "+  customDestination;
           
              System.out.println();
            destination.ping();
        } catch (JCoException ex) {
            System.out.println("exception "+ex.toString());
              var = "Erro no JCoException: "+ex.toString();
        } catch(Exception ex) {
            System.out.println("exception "+ex.toString());
            var = "exception "+ex.toString();
        }
        
     return var;
    }

    public void setRes(String res) {
        this.res = res;
    }
    private static void createDestinationDataFile(String destinationName, Properties connectProperties)
    {
        File destCfg = new File(destinationName+".properties");
        try
        {
            FileOutputStream fos = new FileOutputStream(destCfg, false);
            connectProperties.store(fos, "somente para testes !");
            fos.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Não é possível criar os arquivos de destino", e);
        }
    }
}
