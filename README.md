# java-rmi-chat

## ClientArgs

Classe que lida com o recebimento dos argumentos de linha de comando para o programa do Cliente.

## Client

Programa que roda um Cliente. Instancia e manipula uma instância do Cliente além de lidar com o input do usuário dessa instância e recebe parâmetros de entrada para configuração do nome do Cliente.

## ClientRemoteImpl

Implementação da Interface RMI do Cliente. Nela são definidos o único atributo do cliente que é o nome, as implementações da interface RMI e outros métodos facilitadores.

## ClientRemote

Interface RMI do Cliente do chat. Nela é definido os métodos que serão utilizados pelo Servidor para o recebimento das mensagens. 

## ConfigurationException

Exceção para especificar o erro de configuração.

## Configuration

Classe que lida com a obtenção das configurações do ambiente. Obtém as configurações do arquivo *config.properties*.

## Message

Classe responsável para encapsular a lógica da mensagem. Contendo os atributos de remetente, conteúdo e carimbo da hora do envio da mensagem. Além disso implementa o método toString para printar a mensagem no chat.

## MessageListenable

Interface para desacoplar o servidor multicast da implementação de recebedores de mensagem, permitindo que qualquer classe que a implemente possa ouvir as mensagens recebidas pelo servidor multicast.

## MulticastClient

Cliente multicast responsável pelo envio de mensagens pelo Servidor para o endereço multicast associado.

## MulticastServer

Servidor multicast que recebe datagramas para a transmissão de mensagens entre servidores. Implementa a interface Runnable para poder ser utilizado como uma thread. Recebe as mensagens enviadas pelo endereço multicast e envia para o recebedor de mensagens associados. 

## Server

Programa que roda o Servidor do chat. Instancia e manipula o Servidor, configurando-o com as informações obtidas pela classe de configuração.

## ServerRemoteImpl

Implementação da Interface RMI do Servidor. Nela são definidos o cliente multicast, o servidor multicast e a lista de clientes que devem receber as mensagens. Implementa a interface MessageListenable para poder ouvir as mensagens recebidas pelo seu servidor multicast. Ao ouvir uma mensagem ele a envia para cada um dos clientes da sua lista, caso ocorra algum erro no envio, ele adota uma postura agressiva e exclui o cliente da sua lista. Ao ser instanciado começa uma thread com o servidor multicast.

## ServerRemote

Interface RMI do Servidor do chat. Nela é definido os métodos que serão utilizados pelo Cliente para o login e envio de mensagens.

## Utils

Classe de métodos utilitários. Com apenas um método, o de timestamp, que serve para encapsular a obtenção do carimbo da hora atual.

## Classes de Teste

- Test0
- Test1
- Test2
