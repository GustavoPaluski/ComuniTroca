import java.util.ArrayList;

public class CentroDistribuicao {
    
    private String localDistribuicao;
    private String nomeCampanha;
    private String descricaoCampanha;
    private String categoria;

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    ArrayList<ProdutoDoacao> listaDoacao=new ArrayList<ProdutoDoacao>();

    public String getDescricaoCampanha(){
        return descricaoCampanha;
    }
    public void setDescricaoCampanha(String descricaoCampanha){
        this.descricaoCampanha = descricaoCampanha;
    }
    public String getNomeCampanha(){
        return nomeCampanha;
    }
    public void setNomeCampanha(String nomeCampanha){
        this.nomeCampanha = nomeCampanha;
    }

    public String getLocalDistribuicao() {
        return localDistribuicao;
    }
    public void setLocalDistribuicao(String centroDistribuicao) {
        this.localDistribuicao = centroDistribuicao;
    }
}
