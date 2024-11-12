/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sap.cloud.sdk.us.controllers;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;

public class SAPConnectionTest {

    public static void main(String[] args) {
        try {
            // Nome do destination (deve estar configurado no arquivo de properties)
            String destinationName = "S4HANA_API_CLFN_PRODUCT_SRV";

            // Obter a destination
            JCoDestination destination = JCoDestinationManager.getDestination(destinationName);

            // Verificar conexão
            System.out.println("Testando conexão com SAP: " + destination.getAttributes().getSystemID());

            // Obter repositório da SAP para chamar funções RFC
            JCoRepository repository = destination.getRepository();

            // Exemplo de chamada RFC (Função STFC_CONNECTION)
            JCoFunction function = repository.getFunction("STFC_CONNECTION");
            if (function == null) {
                throw new RuntimeException("Função STFC_CONNECTION não encontrada no sistema SAP.");
            }

            // Definir parâmetros de entrada da função
            function.getImportParameterList().setValue("REQUTEXT", "Testando conexão SAP via JCo");

            // Executar a função RFC
            function.execute(destination);

            // Capturar resposta da função
            String echoText = function.getExportParameterList().getString("ECHOTEXT");
            String responseText = function.getExportParameterList().getString("RESPTEXT");

            // Exibir resultados
            System.out.println("Texto de Echo: " + echoText);
            System.out.println("Texto de Resposta: " + responseText);

        } catch (JCoException e) {
            // Capturar e exibir erros relacionados à conexão SAP
            System.out.println("Erro ao se conectar ao SAP:");
            e.printStackTrace();
        }
    }
}
