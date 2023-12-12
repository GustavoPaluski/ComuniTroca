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

    public String cadastrarUsuario(){
        String usuarioAtual="";
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
        usuarioAtual=c.getNomeUsuario();

        c.setEndereco(EntradaSaida.inserirDadosCadastrais("Endereço"));
        c.setCep(EntradaSaida.inserirDadosCadastrais("CEP"));
        c.setNumeroTelefone(EntradaSaida.inserirDadosCadastrais("Telefone"));
        c.setSenha(EntradaSaida.inserirDadosCadastrais("Senha"));
        contas.add(c);

        return usuarioAtual;
    }

    public boolean validarNomeUsuario(String dadoUsuario){ //TA DANDO ERRO(Só ta retornando Falso) entra no if apenas quando opcao esta correta- talvez não esteja cadastrando usuario
        boolean verificador = false;
        for (Conta cTemp : this.contas) {
            EntradaSaida.escreverMensagem(cTemp.getNomeUsuario());
           if(cTemp.getNomeUsuario().equals(dadoUsuario) || (cTemp.getEmail().equals(dadoUsuario)) || (cTemp.getCpf().equals(dadoUsuario))){
                EntradaSaida.escreverMensagem("BATATA QUENTE");
                verificador = true;
            } 
           break;
        }
        return verificador;
    }
    
    public boolean validarSenhaUsuario(String senha){

        boolean verificador = false;
        for (Conta cTemp : contas) {
           if(cTemp.getSenha().equals(senha)){
                verificador = true;
                break;
           }
        }
        return verificador;
    }

    public String visualizarPerfilUsusario(String usuarioAtual){
        String retorno="";
        String testeTela="";//temporário
        for (Conta c: this.contas) {
            if(c.getNomeUsuario().equals(usuarioAtual) || (c.getEmail().equals(usuarioAtual)) || (c.getCpf().equals(usuarioAtual))){
                retorno+="Nome de Usuário: "+c.getNomeUsuario()+"\nNome Completo: "+c.getNomeCompleto()+"\nCPF: "+c.getDataNascimento()+"\nData de Nascimento: "+c.getDataNascimento()+
                "\nCEP: "+c.getCep()+"\nEndereço: "+c.getEndereco()+"\nE-mail: "+c.getEmail()+"\nTelefone: "+c.getNumeroTelefone();

                testeTela=  " ____________________________________________________________________________\n"+
                            "|                                                [1] EDITAR DADOS CADASTRAIS |\n"+
                            "|                                                [2] VOLTAR AO MENU          |\n"+
                            "|----------------------------------------------------------------------------|\n"+
                            "|                               PERFIL DO USUÁRIO                            |\n"+
                            "| Nome de Usuário:                                                           |\n"+
                            "| Nome Completo:                                                             |\n"+
                            "| CPF:                                    Data de Nascimento:                |\n"+
                            "| CEP:                                                                       |\n"+
                            "| Endereço:                                                                  |\n"+
                            "| E-mail:                                                                    |\n"+
                            "| Telefone:                                                                  |\n"+
                            "|____________________________________________________________________________|\n"+
                            "|SELECIONE UMA DAS OPÇÕES: "; //fazer o preenchimento com dos atributos de modo que não alterem o desenho.
            }
        }
        return retorno;
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
