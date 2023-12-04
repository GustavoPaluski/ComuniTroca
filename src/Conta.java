import java.util.ArrayList;

public class Conta {
    
    public String nomeUsuario;
    public String dataNascimento;
    public String cpf;
    public String pais;
    public String estado;
    public String cidade;
    public String endereco;
    public String cep;
    public String email;
    public String numeroTelefone;
    public String senha;
    ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();

    // public Conta(String nu, String dataNasc, String cpf, String pais, String estado, String cid, String end, String cep, String email, String numTel, String senha){
    //     this.nomeUsuario = nu;
        
    // }

    public void armazenarProdutos(Produtos p){
        this.listaProdutos.add(p);
    }

    public String imprimir(){
        String s="";
        for (Produtos p : this.listaProdutos) {
            s += p.nome+p.categoria+p.situacao+p.tempoDeUso;
        }
         return s;
    }
}
