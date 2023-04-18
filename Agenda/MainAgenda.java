package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * 
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(R)emover Favorito\n" +
						"(S)air\n" + 
						"\nOpção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			favoritos(agenda, scanner);
			break;
		case "A":
			cadastraFavorito(agenda, scanner);
			break;
		case "R":
			desfavoritaContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!\n");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println(agenda.contatosListados());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicao = scanner.nextInt();
		if(posicao == agenda.getTamanhoAgenda()) {
			posicao -= 1;
		} if (agenda.getContato(posicao) != null) {
            Contato contato = agenda.getContato(posicao);
            if (contato != null && agenda.verificaSeContatoFavorito(contato)) {
                System.out.println("\n" + "❤️ " + agenda.getContato(posicao) + "\n");

			} else {
				System.out.println("\n" + contato + "\n");
			}
		} else {
			System.out.println("POSIÇÃO INVÁLIDA\n");
		}
	}
	
	/**
	 * Todos os contatos favoritados 
	 * 
	 * @param agenda A agenda
	 * @param scanner Scanner para capturar qual contato
	 */
	public static void favoritos(Agenda agenda, Scanner scanner) {
		System.out.println(agenda.toString());
	}
	
	/**
	 * Cadastra um contato na lista de favoritos
	 * 
	 * @param agenda A agenda
	 * @param scanner Scanner para pedir informações do contato.
	 */
	public static void cadastraFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = scanner.nextInt();
		System.out.print("Posição> ");
		int posicao = scanner.nextInt();
		if(agenda.favoritaContato(posicao, contato)) {
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicao + "\n");
	 	} else {
			System.out.println("CONTATO INVÁLIDO\n");
		}
	}
	
	/**
	 * Descadrastra um contato da lista de favoritos
	 * 
	 * @param agenda A agenda
	 * @param scanner Scanner para pedir informações do contato.
	 */
	public static void desfavoritaContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int contato = scanner.nextInt();
		System.out.print("Posição> ");
		int posicao = scanner.nextInt();
		agenda.setContatosFavoritados(posicao, contato);
		System.out.println("");
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		while (true) {
			
			System.out.print("\nPosição> ");
			int posicao = scanner.nextInt();
			scanner.skip("\n");
			
			if (agenda.checaPosicao(posicao)) {
				System.out.println("POSIÇÃO INVÁLIDA\n");
				break;
			} else if (posicao == agenda.getTamanhoAgenda()) {
				posicao = agenda.getTamanhoAgenda() - 1;
			}
			
			System.out.print("Nome> ");
			String nome = scanner.nextLine();
			
			if (nome.isEmpty()) {
				System.out.println("CONTATO INVÁLIDO\n");
				break;
			}
			System.out.print("Sobrenome> ");
			String sobrenome = scanner.nextLine();
			
			System.out.print("Telefone> ");
			String telefone = scanner.nextLine();
			
			if (telefone.isEmpty()) {
				System.out.println("CONTATO INVÁLIDO\n");
				break;
			}
			if (agenda.checaIdentificacao(nome, sobrenome)) {
				System.out.println("CONTATO JÁ CADASTRADO\n");
				break;
			}
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.println("CADASTRO REALIZADO\n");
			break;
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		leitor.carregaContatos(arquivoContatos, agenda);
	}
}
