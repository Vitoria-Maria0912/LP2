package lab4;

import java.util.Scanner;

/**
 * Classe responsável pelo contato com o usuário.
 * 
 * @author Vitória Maria do Nascimento
 *
 */
public class MainSistema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, sistema, scanner);
        }
    }

    /**
     * Exibe o menu e captura a escolha do usuário.
     * 
     * @param scanner Para captura da opção do usuário.
     * 
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println("(C)adastrar aluno\n" + 
                           "(E)xibir aluno\n" + 
                           "(N)ovo grupo\n" + 
                           "(A)locar aluno no grupo ou verificar pertinência a grupos\n" + 
                           "(O)lhar quais grupos o aluno está.\n" +
                           "(R)egistrar aluno que respondeu\n" +
                           "(I)mprimir alunos que responderam\n" +
                           "(S)im, quero fechar o programa!\n" + 
                           "\n" + 
                           "Opção> ");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida pelo usuário.
     * 
     * @param opcao   É a opção digitada.
     * @param sistema É o sistema de alunos.
     * @param scanner Objeto scanner para o caso do comando precisar que o usuário
     *                digite algo mais.
     */
    private static void comando(String opcao, Sistema sistema, Scanner scanner) {

        switch (opcao) {

        case "C":
            cadastraAluno(sistema, scanner);
            break;
        case "E":
            consultaAluno(sistema, scanner);
            break;
        case "N":
            cadastraGrupo(sistema, scanner);
            break;
        case "A":

            System.out.println("(A)locar Aluno ou (P)ertinência a Grupo? ");
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
            case "A":
                alocaAlunosEmGrupos(sistema, scanner);
                break;
            case "P":
                pertinenciaGrupos(sistema, scanner);
                break;
            default:
                System.out.println("ENTRADA INVÁLIDA!\n");
                break;
            }
            break;

        case "O":
            verGrupos(sistema, scanner);
            break;
        case "R":
            registrarAlunoQueRespondeu(sistema, scanner);
            break;
        case "I":
            mostrarAlunosQueResponderam(sistema, scanner);
            break;
        case "S":
            sair();
            break;
        default:
            System.out.println("ENTRADA INVÁLIDA!\n");
            break;
        }
    }

    /**
     * Cadastra um aluno no sistema.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner Objeto scanner para o usuário digitar a matrícula, o nome e o
     *                curso de um estudante.
     */
    private static void cadastraAluno(Sistema sistema, Scanner scanner) {

        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.println("Nome: ");
        String aluno = scanner.nextLine();
        System.out.println("Curso: ");
        String curso = scanner.nextLine();

        System.out.println(sistema.cadastraAlunoSistema(aluno, matricula, curso));
    }

    /**
     * Mostra um aluno do sistema, através de sua matrícula.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner Objeto scanner para que o usuário digite a matrícula do aluno.
     */
    private static void consultaAluno(Sistema sistema, Scanner scanner) {

        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.println(sistema.exibeAlunoCadastrado(matricula));
    }

    /**
     * Cadastra um grupo no sistema.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner Objeto scanner para que o usuário digite um nome para o grupo
     *                e um tamanho (caso o grupo seja limitado).
     */
    private static void cadastraGrupo(Sistema sistema, Scanner scanner) {

        System.out.println("Grupo: ");
        String nomeDoGrupo = scanner.nextLine();

        System.out.println("Deseja limitar o grupo? [S/N]");
        String comando = scanner.nextLine().toUpperCase();

        switch (comando) {

        case "S":

            System.out.println("Tamanho: ");
            int tamanhoDoGrupo = Integer.parseInt(scanner.nextLine());

            System.out.println(sistema.cadastraGrupoLimitadoSistema(nomeDoGrupo, tamanhoDoGrupo));

            break;

        case "N":

            System.out.println(sistema.cadastraGrupoNoSistema(nomeDoGrupo));
            break;

        default:
            System.out.println("ENTRADA INVÁLIDA!\n");
            break;
        }
    }

    /**
     * Aloca um aluno em um grupo.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner Objeto scanner para que o usuário digite a matrícula e o
     *                grupo.
     */
    private static void alocaAlunosEmGrupos(Sistema sistema, Scanner scanner) {

        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();

        if (!(sistema.getAlunos().containsKey(matricula))) {
            System.out.println("ALUNO NÃO CADASTRADO.\n");
        } else {
            System.out.println("Grupo: ");
            String nomeDoGrupo = scanner.nextLine();

            if (!(sistema.checaSeGrupoFoiCadastrado(nomeDoGrupo))) {
                System.out.println("GRUPO NÃO CADASTRADO.\n");
            } else {
                System.out.println(sistema.alocaAlunoEmGrupoSistema(matricula, nomeDoGrupo));
            }
        }
    }

    /**
     * Checa a pertinência de um aluno em um grupo.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner Objeto scanner para que o usuário digite a matrícula e o grupo.
     */
    private static void pertinenciaGrupos(Sistema sistema, Scanner scanner) {

        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();

        if (!(sistema.getAlunos().containsKey(matricula))) {
            System.out.println("ALUNO NÃO CADASTRADO.\n");
        } else {
            System.out.println("Grupo: ");
            String nomeDoGrupo = scanner.nextLine();

            if (!(sistema.checaSeGrupoFoiCadastrado(nomeDoGrupo))) {
                System.out.println("GRUPO NÃO CADASTRADO.\n");
            } else {
                System.out.println(sistema.checaSeAlunoEstaEmGrupo(nomeDoGrupo, matricula));
            }
        }
    }

    /**
     * Mostra os grupos que um determinado aluno participa.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner É Objeto scanner para que o usuário digite a matrícula do aluno.
     */
    private static void verGrupos(Sistema sistema, Scanner scanner) {

        System.out.println("Matrícula: ");
        String aluno = scanner.nextLine();

        System.out.println("\nAluno: " + aluno + "\nGrupos: \n" + sistema.gruposQueAlunoParticipa(aluno));
    }

    /**
     * Registra um aluno que respondeu.
     * 
     * @param sistema É o sistema de alunos.
     * @param scanner É Objeto scanner para que o usuário digite a matrícula do aluno.
     */
    private static void registrarAlunoQueRespondeu(Sistema sistema, Scanner scanner) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        
        System.out.println(sistema.registraAlunoQueRespondeu(matricula));
    }
    
    /**
     * Mostra os alunos que responderam.
     * 
     * @param sistema É o sistema de alunos.
     */
    private static void mostrarAlunosQueResponderam(Sistema sistema, Scanner scanner) {
        System.out.println(sistema.getAlunosQueResponderam());
    }
    
    /**
     * Sai do sistema.
     */
    private static void sair() {
        System.out.println("Você saiu do sistema!");
        System.exit(0);
    }
}
