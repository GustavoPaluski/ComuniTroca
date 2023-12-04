import java.util.ArrayList;

public class Conta {
    
    private String nomeUsuario;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String cep;
    private String email;
    private String numeroTelefone;
    private String senha;
    private String nomeCompleto;
    ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumeroTelefone() {
        return numeroTelefone;
    }
    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

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
