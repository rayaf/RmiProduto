import java.io.Serializable;


public class Produto implements Serializable{
	private Integer id;
	private String titulo;
    private Double valor;
    
    public Produto() {
        valor = 0.0;
    }
    
    public Produto(String titulo, Integer id, Double valor) {
        this.titulo = titulo;
        this.id = id;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}