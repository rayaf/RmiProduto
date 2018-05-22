import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;


public class Cliente {
    private static boolean possuiId(Integer id, List<Produto> lista) {
        return lista.stream().anyMatch((i) -> (i.getId().equals(id)));
    }
    private static Retorno adicionarUsuario(Servico servico, List<Produto> lista)
            throws RemoteException {
        Scanner sc = new Scanner(System.in);
        Integer id;
    	String titulo;
        Double valor;

        System.out.println("\n\n************************");
        System.out.println("*****  Adicionar  ******");
        System.out.println("************************");

        System.out.print("Nome: ");
        titulo = sc.next();

        System.out.print("valor: ");
        valor = sc.nextDouble();

        System.out.print("Id: ");
        id = sc.nextInt();

        Produto p = new Produto(titulo, id, valor);
        return servico.add(p, lista);
    }

    private static Retorno editarUsuario(Servico servico, List<Produto> lista)
            throws RemoteException {
        Scanner sc = new Scanner(System.in);
        Integer id;
    	String titulo;
        Double valor;

        System.out.println("\n\n************************");
        System.out.println("*******  Editar  *******");
        System.out.println("************************");
        
        System.out.print("Id: ");
        id = sc.nextInt();

        while (!possuiId(id, lista)) {
            System.out.println("Id Nao encontrado ! Tente Novamente");
            System.out.print("Id: ");
            id = sc.nextInt();
        }

        System.out.print("Nome: ");
        titulo = sc.next();

        System.out.print("Valor: ");
        valor = sc.nextDouble();

        Produto p = new Produto(titulo, id, valor);
        return servico.edita(p, lista);
    }

    private static Retorno removerUsuario(Servico servico, List<Produto> lista) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n\n************************");
        System.out.println("******  Remover  *******");
        System.out.println("************************");

        System.out.print("Id: ");
        Integer id = sc.nextInt();

        while (!possuiId(id, lista)) {
            System.out.println("Id Nao encontrado ! Tente Novamente");
            System.out.print("Id: ");
            id = sc.nextInt();
        }
        
        return servico.remove(id, lista);
    }
    
    private static void mostraMenu() {
        System.out.println("\n\n\n************************");
        System.out.println("********  MENU  ********");
        System.out.println("************************");
        System.out.println("**  1) Adicionar      **");
        System.out.println("**  2) Editar         **");
        System.out.println("**  3) Remover        **");
        System.out.println("**  4) Listar         **");
        System.out.println("**  0) Sair           **");
        System.out.println("************************");
        System.out.print("** Resp:");
    }

    public static void main(String[] args)
            throws NotBoundException, MalformedURLException, RemoteException {
    	Servico servico = (Servico) Naming.lookup("//localhost/servico");
        Scanner sc = new Scanner(System.in);
        List<Produto> listaProduto = new LinkedList<>();

        int resp = 1;
        while (resp >= 1 && resp <= 4) {
            mostraMenu();
            resp = sc.nextInt();
            switch (resp) {
                case 1:
                    Retorno ret1 = adicionarUsuario(servico, listaProduto);
                    listaProduto = ret1.getProduto();
                    System.out.println(ret1.getMensagem());
                    break;
                case 2:
                    Retorno ret2 = editarUsuario(servico, listaProduto);
                    listaProduto = ret2.getProduto();
                    System.out.println(ret2.getMensagem());
                    break;
                case 3:
                    Retorno ret3 = removerUsuario(servico, listaProduto);
                    listaProduto = ret3.getProduto();
                    System.out.println(ret3.getMensagem());
                    break;
                case 4:
                    System.out.println(servico.listar(listaProduto));
                    break;
            }
        }
    }
}
