import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    static int count = 0;

    public static String input() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static Path dir(String s) {
        return Paths.get(s);
    }

    public static boolean isValidDir(String s) {
        Path p = dir(s);
        return (Files.exists(p) && Files.isDirectory(p));
    }
    public static boolean isValidFileName(String s) {
        int pos = s.indexOf('/');
        return (pos==-1);
    }

    public static String getFileName(String s){
        int pos = s.lastIndexOf('/')+1;
        s = s.substring(pos);
        return s;
    }

    public static void compare(String entry, String nome){
        String e = getFileName(entry);
        if (e.equalsIgnoreCase(nome)) {
            System.out.println("Encontramos seu arquivo em: " + entry );
            count++;
        }
    }

    public static void runDirs(Path path, String nome) { //Percorre os diretórios
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) runDirs(entry,nome); //Chamada recursiva para entrar nas sub-pastas
                else compare(entry.toString(),nome); //É um arquivo, não uma pasta
            }
        } catch (IOException e) { //Tratando a possibilidade de erro de I/O
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Este programa realiza uma busca recursiva de arquivos, a partir de um diretório base.\n");
        System.out.println("Digite um caminho absoluto para ser base da pesquisa: ");

        String inp = input();
        boolean isvalid=isValidDir(inp);
        while(!isvalid){ //Loop enquanto o input não for um diretório válido
            System.out.println("Diretório inválido! Tente novamente...  ");
            inp = input();
            isvalid=isValidDir(inp);
        }

        System.out.println("Digite o nome do arquivo que você busca (com a extensão): "); //Extensão = tipo de arquivo. Ex: arquivo.txt
        String nome = input();
        while(!isValidFileName(nome)) {
            System.out.println(nome);
            System.out.println("Nome inválido! Arquivos não podem conter '/'");
            nome=input();
        }

        Path path = dir(inp);
        runDirs(path,nome);
        if (count==0) System.out.println("Não encontramos nenhum arquivo com o nome especificado, no diretório base especificado!");
    }
}
