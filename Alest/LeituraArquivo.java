package Alest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class LeituraArquivo {

    public static void main(String[] args) {
        Scanner resposta = new Scanner(System.in);
        String linhas[] = new String[100000];
        int numLinhas = 0;
        int numero;

        Path filePath = Paths
                .get("C:/Users/eduar/Desktop/pucrs/Algoritmos e Estruturas/exercicio_avaliacao/Alest/acidentes.csv");

        // Ler o arquivo
        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;
                numLinhas++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

        // Aceita os seguintes formatos de data/horario
        // 20200101 (somente data)
        // 20200101 08:00 (data e horario)
        // 20200101 8 :00 (horario sem zero à esquerda da hora)
        Pattern datePattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})(?: (?:(\\d{2})|(\\d) ):(\\d{2}))?",
                Pattern.CASE_INSENSITIVE);

        // Mude numLinhas para algum numero pequeno para executar testes mais
        // rapidamente.
        // Ex:

        ListaDeAcidentes lista = new ListaDeAcidentes();

        for (int i = 0; i < numLinhas; i++) {
            // for (int i = 0; i < numLinhas; i++) {

            String[] campos = linhas[i].split(";"); // divide a string pelo espaco em branco

            // Ignorar esta linha caso o campo de endereco nao
            // puder ser separado em 2
            if (campos[0].split(" ").length < 2) {
                continue;
            }

            // Determinar data e horario.
            Matcher dateMatcher = datePattern.matcher(campos[2]);
            dateMatcher.matches();

            int ano = Integer.parseInt(dateMatcher.group(1));
            int mes = Integer.parseInt(dateMatcher.group(2));
            int dia = Integer.parseInt(dateMatcher.group(3));

            int hora;
            if (dateMatcher.group(4) != null) {
                hora = Integer.parseInt(dateMatcher.group(4));
            } else if (dateMatcher.group(5) != null) {
                hora = Integer.parseInt(dateMatcher.group(5));
            } else {
                hora = 0;
            }

            int minuto;
            if (dateMatcher.group(6) != null) {
                minuto = Integer.parseInt(dateMatcher.group(6));
            } else {
                minuto = 0;
            }

            String logradouro = campos[0].split(" ", 2)[0];
            String nomeLog = campos[0].split(" ", 2)[1];
            String tipoAcidente = campos[1];
            LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);
            String diaSemana = campos[3];
            int feridos = Integer.parseInt(campos[4]);
            int fatais = Integer.parseInt(campos[5]);
            int auto = Integer.parseInt(campos[6]);
            int taxis = Integer.parseInt(campos[7]);
            int lotacao = Integer.parseInt(campos[8]);
            int onibusUrb = Integer.parseInt(campos[9]);
            int onibusInt = Integer.parseInt(campos[10]);
            int caminhao = Integer.parseInt(campos[11]);
            int moto = Integer.parseInt(campos[12]);
            int carroca = Integer.parseInt(campos[13]);
            int bicicleta = Integer.parseInt(campos[14]);
            String tempo = campos[15];
            String turno = campos[16];
            String regiao = campos[17];

            Acidente acidente = new Acidente(logradouro, nomeLog, tipoAcidente, data, diaSemana, feridos, fatais, auto,
                    taxis, lotacao, onibusUrb, onibusInt, caminhao, moto, carroca, bicicleta, tempo, turno, regiao);

            lista.addLogradouroAcidente(acidente);
        }

        do {
            System.out.println("Digite um número de 1 a 4");
            System.out.println();
            System.out.println("Digite 1 para saber a Rua/av/trav na qual ocorreram mais acidentes.");
            System.out.println("Digite 2 para saber a rua na qual ocorreram mais acidentes naquela semana.");
            System.out.println("Digite 3 para saber o total de acidentes envolvendo motos.");
            System.out.println("Digite 4 para navegar entre os logradouros");
            System.out.println();

            numero = resposta.nextInt();
            String rua;

            switch (numero) {
                case 1: {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>> Resposta");
                    System.out.println(lista.getLogradouroComMaisAcidentes());
                    break;
                }
                case 2: {
                    Scanner resposta2 = new Scanner(System.in);
                    System.out.println("Escreva o nome da Rua/AV/Trav.");
                    rua = resposta2.nextLine();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>> Resposta");
                    System.out.println(lista.getDiaDaSemanaComMaisAcidentes(rua));
                    break;
                }
                case 3: {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>> Resposta");
                    System.out.println(lista.getAcidenteComMoto());
                    break;
                }
                case 4: {
                    String avancarRetroceder;
                    Scanner sc = new Scanner(System.in);
                    int index = 0;
                    System.out.println(lista.getListaPosicao(index));
                    do{
                        System.out.println("1 - Digite A para avancar entre as ruas");
                        System.out.println("2 - Digite V para retroceder entre as ruas");
                        System.out.println("3 - Digite SAIR para voltar ao menu");
                        
                        avancarRetroceder = sc.nextLine();

                        switch(avancarRetroceder) { 
                            case "A": {
                                index++;
                                if(index > lista.getQtdElem()) {
                                    System.out.println("Nao ha nenhum logradouro apos este favor voltar");
                                    index = lista.getQtdElem();
                                    break;
                                }
                                System.out.println(lista.getListaPosicao(index));
                                break;
                            }
                            case "V": {
                                index--;
                                if(index < 0) {
                                    System.out.println("Nao ha nenhum logradouro anterior favor avancar");
                                    index = 0;
                                    break;
                                }
                                System.out.println(lista.getListaPosicao(index));
                                break;
                            }
                            default : {
                                System.out.println("Letra Inválida!");      
                            }
                        }
                    } while(!avancarRetroceder.equalsIgnoreCase("SAIR"));
                    break;
                }
                default: {
                    System.out.println("Valor Inválido!");
                    break;
                }
            }
        } while (numero != 0);
    }
}
