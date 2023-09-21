import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AgendaTelefonica {

    public ArrayList<Contato> agendaTelefonica = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

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
            System.out.println("Esse contato já existe na lista!");
        } else {
            agendaTelefonica.add(novoContato);
            System.out.println("Contato adicionado com sucesso.\n\n");
        }
    }

    public void removerContato(String nome){
        Iterator<Contato> iterator = agendaTelefonica.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if (contato.getNome().equals(nome)) {
                iterator.remove();
                System.out.println("Contato removido com sucesso!");
            }
        }
    }

    public void atualizarContato(String nome, Contato novoContato){
        for (int i = 0; i < agendaTelefonica.size(); i++) {
            Contato contato = agendaTelefonica.get(i);
            if (contato.getNome().equals(nome)) {
                agendaTelefonica.set(i, novoContato);
                break;
            }
        }
    }

    public void listarContatosAgenda(){
        System.out.println("********* LISTA DE CONTATOS *********\n\n");
        for (Contato contato : agendaTelefonica) {
            System.out.println("Nome: " + contato.getNome() + " === Telefone: " + contato.getNumeroTelefone());
        }
    }
}
