import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Servidor {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Gestor gestor = new Gestor();
        Naming.rebind("//localhost/servico", gestor);
    }
}