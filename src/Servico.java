import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Servico extends Remote{
    public Retorno add(Produto p, List<Produto> produto) throws RemoteException;
    public Retorno remove(Integer id, List<Produto> produto) throws RemoteException;
    public Retorno edita(Produto p, List<Produto> produto) throws RemoteException;
    public String listar(List<Produto> produto) throws RemoteException;
}
