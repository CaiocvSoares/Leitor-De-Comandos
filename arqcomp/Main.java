package arqcomp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        String nomeDoArquivo = "caio1.txt";

        File pendrive = new File("E:\\"); // Unidade do pendrive

        if (!pendrive.exists() || !pendrive.isDirectory()) {
            System.out.println("Unidade E:\\ não encontrada.");
            return;
        }

        File arquivoEncontrado = buscarArquivoRecursivo(pendrive, nomeDoArquivo);

        if (arquivoEncontrado != null) {
            System.out.println("Arquivo encontrado em: " + arquivoEncontrado.getAbsolutePath());

            try {
                String conteudo = Files.readString(arquivoEncontrado.toPath());
                System.out.println("Conteúdo do arquivo:\n" + conteudo);
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo não encontrado na unidade E:\\");
        }
    }

    public static File buscarArquivoRecursivo(File dir, String nomeDoArquivo) {
        if (!dir.canRead()) return null;

        File[] arquivos = dir.listFiles();
        if (arquivos == null) return null;

        for (File f : arquivos) {
            if (f.isDirectory()) {
                File resultado = buscarArquivoRecursivo(f, nomeDoArquivo);
                if (resultado != null) return resultado;
            } else if (f.getName().equalsIgnoreCase(nomeDoArquivo)) {
                return f;
            }
        }
        return null;
    }
}
