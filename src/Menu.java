import java.util.Scanner;

public class Menu {
    protected AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
    public String menu = """
        ***** AGENDA TELEFÔNICA *****
    
               ---- MENU ----
            
        1 - Adicionar um novo contato;
        2 - Remover contato;
        3 - Atualizar contato;
        4 - Buscar contato;
        5 - Listar contatos;
        6 - Sair do programa; 
    """;
    Scanner scan = new Scanner(System.in);
    public void mostrarMenu(){
        System.out.println("\n" + menu);
        System.out.println("       Digite a opção escolhida: ");
        int opcao = scan.nextInt();
        scan.nextLine();

        switch (opcao){
            case 1:
                agendaTelefonica.adicionarContato();
                mostrarMenu();
                break;
            case 2:
                agendaTelefonica.removerContato();
                mostrarMenu();
                break;
            case 3:
                agendaTelefonica.atualizarContato();
                mostrarMenu();
                break;
            case 4:
                agendaTelefonica.buscarContato();
                mostrarMenu();
                break;
            case 5:
                agendaTelefonica.listarContatosAgenda();
                mostrarMenu();
                break;
            case 6:
                if (sairMenu() == 1){
                    break;
                } else {
                    mostrarMenu();
                }
        }
    }
    public int sairMenu(){
        System.out.println("Deseja sair da agenda? 1-Sim / 2-Não");
        int resposta = scan.nextInt();
        return resposta;
    }
}
