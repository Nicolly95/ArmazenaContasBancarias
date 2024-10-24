package POO;
import java.io.Serializable;

public class ContaBancaria {

//  DEFINE OS ATRIBUTOS DA CLASSE CONTABANCARIA:
    private String clienteNome;
    private double clienteSaldo;


//  CRIA OS MÉTODOS CONSTRUTORES DA CLASSE CONTABANCARIA:
    public ContaBancaria(){}
    public ContaBancaria(String clienteNome, double clienteSaldo){
        this.clienteNome = clienteNome;
        this.clienteSaldo = clienteSaldo;
    }

//  MÉTODOS GETTERS PARA RETORNAR VALORES:
    public String getClienteNome() {
        return clienteNome;
    }

    public double getSaldo() {
        return clienteSaldo;
    }



//  DEFINE OS MÉTODOS QUE A CLASSE CONTABANCARIA PODE EXECUTAR:

    //Método de boas vindas:
    void bemVindo(){
        System.out.println("Olá cliente " + clienteNome + "!");
    }

    //Método que exibe saldo:    
    void exibeSaldo() {
        System.out.println("Este é o seu saldo atual: " + clienteSaldo);
    }

    //Método que saca:  
    void saca(double valor) {
        clienteSaldo = (clienteSaldo - valor);
        System.out.println("Você está sacando: " + valor);        
    }
    
    //Método que deposita:  
    void deposita(double valor) {
        clienteSaldo = (clienteSaldo + valor);
        System.out.println("Você está depositando: " + valor);
    }

    //Método que transfere:  
    void transferePara(ContaBancaria destino, double valor) {
        this.saca(valor);       //"this" é usada para referenciar o objeto em questão (saca DESTE objeto)
        destino.deposita(valor);
    }


}
