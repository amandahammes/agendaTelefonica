import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AgendaTelefonica {

    public ArrayList<Contato> agendaTelefonica = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    String corVerde = "\u001B[32m";
    String reset = "\u001B[0m";

    public void adicionarContato() {
        Contato novoContato = new Contato();
        System.out.println("Digite o nome do contato a ser adicionado: ");
        novoContato.setNome(scan.nextLine());
        System.out.println("Digite o número de telefone do novo contato: ");
        novoContato.setNumeroTelefone(scan.nextLine());

        boolean contatoExistente = false;
        for (Contato contato : agendaTelefonica) {
            if (contato.getNome().equals(novoContato.getNome())) {
                contatoExistente = true;
                break;
            }
        }
        if (contatoExistente) {
            System.out.println(corVerde + "Esse contato já existe na lista!" + reset);
        } else {
            agendaTelefonica.add(novoContato);
            System.out.println(corVerde + "Contato adicionado com sucesso.\n\n"+ reset);
        }
    }

    public void removerContato(){
        System.out.println("Digite o nome do contato a ser excluído: ");
        String nome = scan.nextLine();
        Iterator<Contato> iterator = agendaTelefonica.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if (contato.getNome().equals(nome)) {
                iterator.remove();
                System.out.println(corVerde + "Contato removido com sucesso!"+ reset);
            }
        }
    }

    public void atualizarContato(){
        System.out.println("Digite o nome do contato a ser alterado: ");
        String nomeParaAlterar = scan.nextLine();
        System.out.println("Digite o nome do contato a ser adicionado: ");
        Contato contatoAlterado = new Contato();
        contatoAlterado.setNome(scan.nextLine());
        System.out.println("Digite o número de telefone do novo contato: ");
        contatoAlterado.setNumeroTelefone(scan.nextLine());
        System.out.println(corVerde + "Contato adicionado com sucesso.\n\n"+ reset);
        for (int i = 0; i < agendaTelefonica.size(); i++) {
            Contato contato = agendaTelefonica.get(i);
            if (contato.getNome().equals(nomeParaAlterar)) {
                agendaTelefonica.set(i, contatoAlterado);
                break;
            }
        }
    }
    public void buscarContato(){
        System.out.println("Nome do contato: ");
        String nomeParaEncontrar = scan.nextLine();
        boolean encontrado = false;

        for (Contato contato : agendaTelefonica) {
            if (contato.getNome().equalsIgnoreCase(nomeParaEncontrar)) {
                System.out.println(corVerde + "Contato: " + reset);
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getNumeroTelefone());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(corVerde + "Contato não encontrado." + reset);
        }

    }
    public void listarContatosAgenda(){
        if(agendaTelefonica.size() != 0){
            System.out.println(corVerde + "\n********* LISTA DE CONTATOS *********" + reset);
            for (Contato contato : agendaTelefonica) {
                System.out.println("Nome: " + contato.getNome() + " === Telefone: " + contato.getNumeroTelefone());
            }
            System.out.println("");
        } else {
            System.out.println(corVerde + "Lista de contatos vazia."+ reset);
        }
    }
}
