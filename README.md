Sapdestination é um middleware desenvolvido em Node.js, projetado para facilitar a comunicação entre sistemas externos e o SAP via OData. Ele utiliza o SAP Cloud SDK e integra-se ao SAP Business Technology Platform (BTP) para fazer chamadas seguras e autenticadas a serviços OData no SAP.

Funcionalidades
Integração com SAP via OData: Permite a comunicação com endpoints OData do SAP, facilitando o consumo e a criação de dados SAP.
Uso de Destinations do BTP: A conexão com o SAP é feita usando destinations do BTP, garantindo configurações de autenticação e roteamento centralizadas.
CSRF Token Management: Implementação do gerenciamento automático de tokens CSRF para autenticação de requisições.
Desenvolvido com SAP Cloud SDK: Aproveita o SAP Cloud SDK para simplificar as integrações, gerenciar requisições HTTP, e lidar com configurações de autenticação e destination.
Pré-requisitos
SAP Business Technology Platform (BTP): Com destinations configuradas corretamente para conectar ao sistema SAP.
Node.js: Para executar o middleware (recomendado: v14 ou superior).
Conta e Autenticação SAP: Credenciais e permissões para acessar o sistema SAP via SAP Cloud SDK e destination.
Estrutura do Projeto
/src: Contém o código principal do middleware.
/src/service: Módulo principal para gerenciamento das requisições OData.
/src/utils: Utilitários, como a configuração de headers e gerenciamento de tokens CSRF.
/src/config: Configurações para conectar o middleware ao SAP BTP, incluindo o uso de destination e outras variáveis de ambiente.
Configuração
Configurar a Destination no SAP BTP
Acesse sua conta do SAP BTP.
Crie uma nova destination chamada dev120 (ou o nome configurado no código).
Defina os seguintes parâmetros para a destination:
URL: A URL base do seu sistema SAP.
Authentication: Escolha o método de autenticação (usuário/senha, OAuth, etc.).
Proxy Type: Internet (ou conforme necessário).
Salve a destination.
Variáveis de Ambiente
Para rodar localmente, você precisa de variáveis de ambiente configuradas para fornecer informações de autenticação e de destination. No arquivo .env (ou nas configurações de ambiente no BTP), configure as seguintes variáveis:
