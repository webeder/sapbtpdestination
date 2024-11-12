/*package com.sap.cloud.sdk.us;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;




@WebServlet("/TestSAPConnection")
public class TestSAPConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String destinationName = "S4HANA_API_CLFN_PRODUCT_SRV"; // Nome configurado para a destination

        try {
            // Obter a destination configurada
            JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
            JCoRepository repository = destination.getRepository();

            // Testar a função RFC STFC_CONNECTION
            JCoFunction function = repository.getFunction("STFC_CONNECTION");
            if (function == null) {
                throw new RuntimeException("Função STFC_CONNECTION não encontrada no sistema SAP.");
            }

            // Definir parâmetros de entrada
            function.getImportParameterList().setValue("REQUTEXT", "Testando conexão SAP via Servlet Java");

            // Executar a função RFC
            function.execute(destination);

            // Obter resultados da função RFC
            String echoText = function.getExportParameterList().getString("ECHOTEXT");
            String responseText = function.getExportParameterList().getString("RESPTEXT");

            // Exibir resultados na resposta HTTP
            response.getWriter().append("<h1>Conexão com SAP bem-sucedida!</h1>")
                                .append("<p>Texto de Echo: ").append(echoText).append("</p>")
                                .append("<p>Texto de Resposta: ").append(responseText).append("</p>");
        } catch (JCoException e) {
            // Capturar erros de conexão e exibir no navegador
            response.getWriter().append("<h1>Erro ao se conectar ao SAP</h1>")
                                .append("<p>").append(e.getMessage()).append("</p>");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
*/