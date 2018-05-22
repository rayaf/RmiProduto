import java.io.Serializable;
import java.util.List;


public class Retorno implements Serializable{
    private List<Produto> produto;
    private String mensagem;
    
    public Retorno() {
        produto = null;
        mensagem = "";
    }
    
    public Retorno(List<Produto> produto, String mensagem) {
        this.produto = produto;
        this.mensagem = mensagem;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setproduto(List<Produto> produto) {
        this.produto = produto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
