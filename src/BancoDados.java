import java.util.ArrayList;

public class BancoDados {
    
    //===================Dados Do Usuário===================//
    ArrayList<Conta> contas = new ArrayList<Conta>();

    public void admin(){//ADMIN
        Conta admin = new Conta("", "", "", "", "", "","", "", "");
        
        admin.setEmail("admin");
        admin.setSenha("admin");
        salvarDadosCadastrais(admin);
    }
    
	public void salvarDadosCadastrais(Conta c){
        this.contas.add(c);
	}

    public boolean verificarLogin(String nomeUsuario, String senha){
        boolean verificar=false;
        for(Conta c:this.contas){
            if(c.getNomeCompleto().equals(nomeUsuario) && c.getSenha().equals(senha)){
                verificar=true;
            }
        }
        return verificar;
    }

    public void cadastrarUsuario(){
        Conta c = new Conta("", "", "", "", "", "","", "", "");

        c.setNomeCompleto(EntradaSaida.inserirDadosCadastrais("Nome completo"));
        
        boolean validacao=false;
        do{
            c.setCpf(EntradaSaida.inserirDadosCadastrais("CPF"));
            validacao=validarNomeUsuario(c.getCpf());
            Validacao.validarDadosUsuario(validacao, "CPF já cadastrado.");
        }while(validacao==true);
        
        do{
            c.setEmail(EntradaSaida.inserirDadosCadastrais("E-mail"));
            validacao=validarNomeUsuario(c.getEmail());
            Validacao.validarDadosUsuario(validacao, "E-mail já cadastrado.");
        }while(validacao==true);

        do{
            c.setNomeUsuario(EntradaSaida.inserirDadosCadastrais("Digite o nome de usuário"));
            validacao=validarNomeUsuario(c.getNomeUsuario());
            Validacao.validarDadosUsuario(validacao, "Usuário já existente.");
        }while(validacao==true);

        c.setEndereco(EntradaSaida.inserirDadosCadastrais("Endereço"));
        c.setCep(EntradaSaida.inserirDadosCadastrais("CEP"));
        c.setNumeroTelefone(EntradaSaida.inserirDadosCadastrais("Telefone"));
        contas.add(c);
    }

    public boolean validarNomeUsuario(String dadoUsuario){
        boolean verificador = false;
        for (Conta cTemp : this.contas) {
           if(cTemp.getNomeUsuario().equals(dadoUsuario) || (cTemp.getEmail().equals(dadoUsuario)) || (cTemp.getCpf().equals(dadoUsuario))){verificador = true;}
        }
        return verificador;
    }
    
    public boolean validarSenhaUsuario(String senha){

        boolean verificador = false;
        for (Conta cTemp : contas) {
           if(cTemp.getSenha().equals(senha)){
                verificador = true;
           }
        }
        return verificador;
    }

    //====================Dados Doações====================//
    ArrayList<CentroDistribuicao> doacao=new ArrayList<CentroDistribuicao>();

    public void salvarCampanha(CentroDistribuicao cd){
        this.doacao.add(cd);
    }

    public String visualizarCampanhas(){
        String lista="CAMPANHAS DISPONÍVEIS:\n\n";
        for (CentroDistribuicao cd:this.doacao) {
            lista+=cd.getNomeCampanha()+"\nAdministrador: "+cd.getLiderOrganizacao()+"\nCentro de Distribuição: "+cd.getLocalDistribuicao()+"\nDescrição: "+cd.getDescricaoCampanha()+"\n";
        }
        return lista;
    }

    public String visualizarCampanhaDoUsuario(String nomeCampanha, String nomeLiderCampanha, String cpfLiderCampanha, String senhaLiderCampanha){
        String retorno="";
        for (CentroDistribuicao cd: this.doacao) {
            if(nomeCampanha.equals(cd.getNomeCampanha())||nomeLiderCampanha.equals(cd.getLiderOrganizacao())||cpfLiderCampanha.equals(cd.getCpfLider())||senhaLiderCampanha.equals(cd.getSenha())){
                retorno="Nome da Campanha: "+cd.getNomeCampanha()+"\nAdministrador: "+cd.getLiderOrganizacao()+"\nCPF Administrador: "+cd.getCpfLider()+"\nCentro de Distribuição: "+cd.getLocalDistribuicao()
                +"\nSenha: "+cd.getSenha()+"\nDescrição: "+cd.getLocalDistribuicao();
            }
        }
        return retorno;
    }

    
}
