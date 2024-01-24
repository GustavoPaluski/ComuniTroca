import java.util.ArrayList;

public class Noticias {

    private String noticia;
    private String dataPublicacao;

    public String getNoticia() {
        return noticia;
    }
    public String getDataPublicacao() {
        return dataPublicacao;
    }
    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    ArrayList<Noticias> listaDeNoticias= new ArrayList<>();

    
    
    
}
