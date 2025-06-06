package arqcomp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class lerDados {
    public static void main(String[] args) {

        String diretorio = "E:\\";

        for (int i = 1; i <= 10; i++) {
            String numero = String.format("%02d", i); 
            String nomeEntrada = "TESTE-" + numero + ".txt";
            String nomeSaida = "TESTE-" + numero + "-RESULTADO.txt";

            Path caminhoEntrada = Paths.get(diretorio, nomeEntrada);
            Path caminhoSaida = Paths.get(diretorio, nomeSaida);

            try {
            
                String conteudo = Files.readString(caminhoEntrada);
                String resultado = conteudo; 
                
                Files.writeString(caminhoSaida, resultado);
                System.out.println("Gerado: " + nomeSaida);

            } catch (IOException e) {
                System.err.println("Erro ao processar " + nomeEntrada + ": " + e.getMessage());
            }
        }

        System.out.println("Todos os arquivos foram processados.");
    }
}
