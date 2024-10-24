package Java;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;     
import java.nio.file.Paths;    
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.nio.file.Files;
import POO.ContaBancaria;

public class Arquivo3 {

    private static final Path PATH = Paths.get("/file/contas.txt");     //caminho relativo do arquivo
    private static final Charset UTF8 = StandardCharsets.UTF_8;  
    //Padroniza o Charset importando a classe Charset (o tipo de dado é Charset)

    public static void main(String[] args) throws IOException {
        
        ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
        contas.add(new ContaBancaria("Nicolly", 250000.00));
        contas.add(new ContaBancaria("Cristopher", 530000.00));
        contas.add(new ContaBancaria("Paula", 180000.00));
        contas.add(new ContaBancaria("Andre", 2500000.00));

        armazena(contas);
        retorna();        
     
    }

//  /*BLOCO PARA ESCRITA NO ARQUIVO */ 
    public static void armazena(ArrayList<ContaBancaria> contas) {

        BufferedWriter writer = null;
        try {   
            writer = Files.newBufferedWriter(PATH, UTF8);
            //Localiza o arquivo do sistema que queremos manipular, com o parâmetro "path" e padroniza seu Charset "utf8" 

            for(ContaBancaria conta : contas) {
                writer.write(conta.getClienteNome() + ", " + conta.getSaldo()); 
                writer.newLine();
                writer.flush();
            }

        }
        catch (IOException erro1) {
            erro1.printStackTrace();
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                } 
                catch (IOException erro3) {
                    erro3.printStackTrace();
                }
            }
        }

    }

//  /*BLOCO PARA LEITURA DO ARQUIVO*/
    public static void retorna() {

        BufferedReader reader = null;
        try {   
            reader = Files.newBufferedReader(PATH, UTF8);
            //Localiza o arquivo do sistema que queremos ler, com o parâmetro "path" e padroniza seu Charset "utf8" 

            String line;
            while((line = reader.readLine()) != null) {   //Enquanto line for diferente de nulo, adiciona valores
                System.out.println(line);
            }
            
            }
        catch (IOException erro2) {
            erro2.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
