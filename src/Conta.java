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
    
    public Conta(String nomeUsuario, String dataNascimento, String cpf, String endereco, String cep, String email,
            String numeroTelefone, String senha, String nomeCompleto) {
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
    }
    
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

    
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>(); //verificar
    ArrayList<ProdutoTroca> listaTroca = new ArrayList<ProdutoTroca>();

    public void armazenarProdutos(Produto p){//verificar
        this.listaProdutos.add(p);
    }

    // public String imprimir(){//verificar
    //     String s="";
    //     for (Produto p : this.listaProdutos) {
    //         s += p.nome+p.categoria+p.situacao+p.tempoDeUso;
    //     }
    //      return s;
    // }

    public void criarAnuncioTroca(){
        ProdutoTroca pt = new ProdutoTroca();
        pt.setNome(EntradaSaida.inserirDadosCadastrais("Nome"));
        pt.setCategoria(EntradaSaida.inserirDadosCadastrais("Categoria"));
        pt.setDescricao(EntradaSaida.inserirDadosCadastrais("Descrição"));
        pt.setEstado(EntradaSaida.inserirDadosCadastrais("Estado"));
        pt.setGarantia(EntradaSaida.inserirDadosCadastrais("Garantia"));
        pt.setTempoUso(EntradaSaida.inserirDadosCadastrais("Tempo de uso")); 
        this.listaTroca.add(pt); //NÃO ESTÁ CADASTRANDO (EU ACHO)
    }

    public String visualizarTrocas(){
        String print = "AAAAA";
        int i = 0;
        if(listaTroca.isEmpty()){
            EntradaSaida.escreverMensagem("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        }
        for (ProdutoTroca t : this.listaTroca) { //NÃO ESTÁ ENTRANDO NO FOR
            i++;
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            print += "Troca "+i+"\n";
            print += t.getNome()+"\n";
            print += t.getCategoria()+"\n";
            print += t.getDescricao()+"\n";
        }
        return print;
    }

}
