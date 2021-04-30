package ffinder;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

	static int count = 0;
	
	public static void msg(int i) {
		switch (i) {
		
		case 1: 
			System.out.println("Este programa realiza uma busca recursiva de arquivos, a partir de um diretório base.\n");
			break;
			
		case 2:
			System.out.println("Digite um caminho absoluto para ser base da pesquisa: ");
			break;
			
		case 3:
			System.out.println("Diretório inválido! Tente novamente...  ");
			break;
			
		case 4:
			System.out.println("Digite o nome do arquivo que você busca (com a extensão): "); //Extensão = tipo de arquivo. Ex: arquivo.txt
			break;
		
		case 5:
			System.out.println("Nome inválido! Arquivos não podem conter '/'");
			break;
		
		case 6:
			if (count==0) System.out.println("Não encontramos nenhum arquivo com o nome especificado, no diretório base especificado!");
		}
	}
	
	public static String input() {
		Scanner scan = new Scanner(System.in); 
	    String s = scan.nextLine();
	    return s;
	}

	public static Path dir(String s) {
		Path p = Paths.get(s);
		return p;
	}
	
	public static boolean isValidDir(String s) {
		Path p = dir(s);
		if (Files.exists(p) && Files.isDirectory(p))	return true;
		return false;
	}
	public static boolean isValidFileName(String s) {
		int pos = s.indexOf('/');
		if (pos==-1) return true;
		return false;
	}
	
	public static String getFileName(String s){
		int pos = s.lastIndexOf('/')+1;
		s = s.substring(pos, s.length());
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
		msg(1);
		msg(2);
		
		String inp = input();
		boolean isvalid=isValidDir(inp);
		while(!isvalid){ //Loop enquanto o input não for um diretório válido
			msg(3);
			inp = input();
			isvalid=isValidDir(inp);
		}
		
		msg(4);
		String nome = input();
		while(!isValidFileName(nome)) {
			System.out.println(nome);
			msg(5);
			nome=input();
		}
		
		Path path = dir(inp);
		runDirs(path,nome);
		msg(6);
	}
}
