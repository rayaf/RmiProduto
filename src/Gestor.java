import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


public class Gestor extends UnicastRemoteObject implements Servico{
    protected Gestor() throws RemoteException {
        super();
    }
    
    private static final long serialVersionUID = 1L;

    @Override
    public Retorno add(Produto p, List<Produto> produto) throws RemoteException {
        String mensagem = "Produto cadastrado com sucesso ! \nDados:\n\tNome: "+
                p.getTitulo()+"\n\tId: "+p.getId()+"\n\tValor: "+p.getValor();
        produto.add(p);
        
        Retorno ret = new Retorno(produto, mensagem);
        return ret;
    }

    @Override
    public Retorno remove(Integer id, List<Produto> produto) throws RemoteException {
    	String mensagem = "Produto nao encontrado!";
    	int index = -1;
    	for (int i = 0; i < produto.size(); i++) {
    		if (produto.get(i).getId().equals(id)) {
    			index = i;
    			break;
    		}
    	}

    	if (index != -1){
    		produto.remove(index);
    		mensagem = "Produto removido com sucesso!";
    	}

        return new Retorno(produto,mensagem);
    }

    @Override
    public Retorno edita(Produto p, List<Produto> produto) throws RemoteException {
        String mensagem = "";
        for(Produto i : produto) {
            if (i.getId().equals(p.getId())) {
                if (!(i.getTitulo().equals(p.getTitulo()))){
                    mensagem += "Nome alterado de "+i.getTitulo()+" para "+p.getTitulo()+"\n";
                    i.setTitulo(p.getTitulo());;
                }
                if (i.getValor()!= p.getValor()) {
                    mensagem += "Valor alterada de "+i.getValor()+" para "+p.getValor()+"\n";
                    i.setValor(p.getValor());
                }
                break;
            }
        }
        Retorno ret = new Retorno(produto, mensagem);
        return ret;
    }

    public String listar(List<Produto> produto) throws RemoteException {
        String produtoNome = "produto: ";
        for(Produto nome : produto) {
        	produtoNome += nome.getTitulo()+" ";
        	produtoNome += nome.getValor()+" ";
            produtoNome += " -> ";
        }
        produtoNome += "null";
        return produtoNome;
    }


}