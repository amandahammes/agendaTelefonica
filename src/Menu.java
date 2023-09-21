import java.util.Scanner;

public class Menu {

    protected AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
    public String menu = """
    ***** AGENDA TELEFÔNICA *****
    
               ---- MENU ----
            
        1 - Adicionar um novo contato;
        2 - Remover contato;
        3 - Atualizar contato;
        4 - Listar contatos;
        5 - Sair do programa;    
    """;
    Scanner scan = new Scanner(System.in);
    public void mostrarMenu(){
        System.out.println(menu);
        System.out.println("\nDigite a opção escolhida: ");
        int opcao = scan.nextInt();
        scan.nextLine();

        switch (opcao){
            case 1:
                adicionarContatoMenu();
                break;
            case 2:
                excluirContatoMenu();
                break;
            case 3:
                atualizarContatoMenu();
                break;
            case 4:
                listarContatoMenu();
                break;
            case 5:
                if (sairMenu() == 1){
                    break;
                } else {
                    mostrarMenu();
                }
        }
    }
    public void adicionarContatoMenu(){
        agendaTelefonica.adicionarContato();
        mostrarMenu();
    }

    public void excluirContatoMenu(){
        agendaTelefonica.removerContato();
        mostrarMenu();
    }

    public void atualizarContatoMenu(){
        agendaTelefonica.atualizarContato();
        mostrarMenu();
    }
    public void listarContatoMenu(){
        agendaTelefonica.listarContatosAgenda();
        mostrarMenu();
    }
    public int sairMenu(){
        System.out.println("Deseja sair da agenda? 1-Sim / 2-Não");
        int resposta = scan.nextInt();
        return resposta;
    }
}
