import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class LeituraArquivo {

    private static String path = "C:/Users/eduar/Desktop/pucrs/Algoritmos e Estruturas/exercicio_avaliacao/Alest/acidentes.csv";

    public static void main(String[] args) {
        String linhas[] = new String[100000];
        int numLinhas = 0;

        Path path1 = Paths.get(path);

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;
                numLinhas++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

        for (int i = 0; i < 5; i++) {
            String[] campos = linhas[i].split(";"); // divide a string pelo espaco em branco
            String logradouro = campos[0].substring(0,campos[0].indexOf(" ")); // AV, R, TV Logradouro
            String nomeLog = campos[0].substring(campos[0].indexOf(" ")+1,campos[0].length()); // Nome do logradoura Borges, ipiranga etc
            String tipoAcidente = campos[1]; // Abalroamento
            LocalDateTime data = LocalDateTime.of(
                    Integer.parseInt(campos[2].substring(0,4)), Integer.parseInt(campos[2].substring(4,6)), Integer.parseInt(campos[2].substring(6,8)), 
                    Integer.parseInt(campos[2].substring(9,11)), Integer.parseInt(campos[2].substring(12,14)));
            String diaSemana = campos[3]; // dia da semana Segunda, Terca, Quarta etc
            int feridos = Integer.parseInt(campos[4]); // numero de feridos
            int fatais = Integer.parseInt(campos[5]); // numero de feridos fatais
            int auto = Integer.parseInt(campos[6]); // numero de veiculos
            int taxi = Integer.parseInt(campos[7]); // numero de veiculos
            int lotacao = Integer.parseInt(campos[8]); // numero de veiculos 
            int onibusUrb = Integer.parseInt(campos[9]); // numero de veiculos
            int onibusInt = Integer.parseInt(campos[10]); // numero de veiculos
            int caminhao = Integer.parseInt(campos[11]); // numero de veiculos
            int moto = Integer.parseInt(campos[12]); // numero de veiculos
            int carroca = Integer.parseInt(campos[13]); // numero de veiculos
            int bicicleta = Integer.parseInt(campos[14]);  // numero de veiculos
            String tempo = campos[15]; // Bom, chuvoso
            String turno = campos[16]; // DIA ou noite
            String regiao = campos[17]; // Norte, Sul, Centro, Leste, Oeste
            System.out.println(logradouro+" "+nomeLog+"; "+tipoAcidente+"; "+data.toString()+"; "+tempo+"; "+turno+"; "+regiao); 
                    
        }
    }
}
