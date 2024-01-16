import java.util.ArrayList;

public class BancoDados {
    
    //===================Dados Do Usuário===================//
    ArrayList<Conta> contas = new ArrayList<Conta>();

    public void admin(){//ADMIN
        Conta conta = new Conta("", "", "", "", "", "","", "", "");
        
        conta.setEmail("admin");
        conta.setCpf("admin");
        conta.setNomeUsuario("admin");
        conta.setSenha("admin");
        
        contas.add(conta);
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
        Conta conta = new Conta("", "", "", "", "", "", "", "", "");

        conta.setNomeCompleto(EntradaSaida.inserirDadosCadastrais("Nome completo"));
        
        boolean validacao=false;
        do{
            conta.setCpf(EntradaSaida.inserirDadosCadastrais("CPF"));
            validacao=validarNomeUsuario(conta.getCpf());
            Validacao.validarDadosUsuario(validacao, "CPF já cadastrado.");
        }while(validacao==true);
        
        do{
            conta.setEmail(EntradaSaida.inserirEmail());
            validacao=validarNomeUsuario(conta.getEmail());
            Validacao.validarDadosUsuario(validacao, "E-mail já cadastrado.");
        }while(validacao==true);

        do{
            conta.setNomeUsuario(EntradaSaida.inserirDadosCadastrais("Digite o nome de usuário"));
            validacao=validarNomeUsuario(conta.getNomeUsuario());
            Validacao.validarDadosUsuario(validacao, "Usuário já existente.");
        }while(validacao==true);
        usuarioAtual=conta.getNomeUsuario();

        conta.setDataNascimento(EntradaSaida.inserirDadosCadastrais("data de nascimento"));
        conta.setEndereco(EntradaSaida.inserirDadosCadastrais("Endereço"));
        conta.setCep(EntradaSaida.inserirDadosCadastrais("CEP"));
        conta.setNumeroTelefone(EntradaSaida.inserirDadosCadastrais("Telefone"));
        conta.setSenha(EntradaSaida.inserirDadosCadastrais("Senha")); // digitar senha duas vezes para a confirmação
        salvarDadosCadastrais(conta);

        return usuarioAtual;
    }

    public String retornarArraylist(){ //ver se precisa
        String retorno="";
        for (Conta c: this.contas) {
                retorno+="Nome de Usuário: "+c.getNomeUsuario()+"\nNome Completo: "+c.getNomeCompleto()+"\nCPF: "+c.getCpf()+"\nData de Nascimento: "+c.getDataNascimento()+
                "\nCEP: "+c.getCep()+"\nEndereço: "+c.getEndereco()+"\nE-mail: "+c.getEmail()+"\nTelefone: "+c.getNumeroTelefone()+"\n\n";
        }
        return retorno;
    }

    public boolean validarNomeUsuario(String dadoUsuario){  //troca nome - validarDadosCadastrais
        boolean verificador = false;
        for (Conta cTemp : this.contas) {
           if(cTemp.getNomeUsuario().equals(dadoUsuario) || (cTemp.getEmail().equals(dadoUsuario)) || (cTemp.getCpf().equals(dadoUsuario))){
                verificador = true;
            } 
        }
        return verificador;
    }
    
    public boolean validarSenhaUsuario(String senha, String nomeEmailCpf){

        boolean verificador = false;
        for (Conta cTemp : contas) {
            if(cTemp.getNomeUsuario().equals(nomeEmailCpf) || (cTemp.getEmail().equals(nomeEmailCpf)) || (cTemp.getCpf().equals(nomeEmailCpf))){
                if(cTemp.getSenha().equals(senha)){
                    verificador = true;
                    break;
                }
            }
        }
        return verificador;
    }

    public String visualizarPerfilUsusario(String usuarioAtual){
        String retorno="";
        String testeTela="";//temporário
        for (Conta c: this.contas) {
            if(c.getNomeUsuario().equals(usuarioAtual) || (c.getEmail().equals(usuarioAtual)) || (c.getCpf().equals(usuarioAtual))){
                retorno+="Nome de Usuário: "+c.getNomeUsuario()+"\nNome Completo: "+c.getNomeCompleto()+"\nCPF: "+c.getCpf()+"\nData de Nascimento: "+c.getDataNascimento()+
                "\nCEP: "+c.getCep()+"\nEndereço: "+c.getEndereco()+"\nE-mail: "+c.getEmail()+"\nTelefone: "+c.getNumeroTelefone()+"\n\n";

                testeTela=  " ____________________________________________________________________________\n"+
                            "|                             PERFIL DO USUÁRIO                              |\n"+
                            "|----------------------------------------------------------------------------|\n"+
                            "| Nome de Usuário: "+c.getNomeUsuario()+"\n"+
                            "| Nome Completo: "+c.getNomeCompleto()+"\n"+
                            "| CPF: "+"                                   Data de Nascimento:                |\n"+
                            "| CEP:                                                                       |\n"+
                            "| Endereço:                                                                  |\n"+
                            "| E-mail:                                                                    |\n"+
                            "| Telefone:                                                                  |\n"+
                            "|____________________________________________________________________________|\n"+
                            "|  [1] EDITAR DADOS CADASTRAIS                                               |\n"+
                            "|  [2] VOLTAR AO MENU                                                        |\n"+
                            "|____________________________________________________________________________|\n"+
                            "|SELECIONE UMA DAS OPÇÕES: "; //fazer o preenchimento com dos atributos de modo que não alterem o desenho.
            }
        }
        return retorno;
    }

    //====================Dados Doações====================//
    ArrayList<CentroDistribuicao> listaCampanhas=new ArrayList<CentroDistribuicao>();

    public void salvarCampanha(CentroDistribuicao cd){
        this.listaCampanhas.add(cd);
    }

    // public String visualizarCampanhas(){
    //     String lista="CAMPANHAS DISPONÍVEIS:\n\n";
    //     for (CentroDistribuicao cd:this.listaCampanhas) {
    //         lista+=cd.getNomeCampanha()+"\nAdministrador: "+cd.getLiderOrganizacao()+"\nCentro de Distribuição: "+cd.getLocalDistribuicao()+"\nDescrição: "+cd.getDescricaoCampanha()+"\n";
    //     }
    //     return lista;
    // } //arrumar 

	public boolean verificarExistenciaCampanha(String nomeCampanha) {
        boolean verificaExistenciaCampanha=false;
		for (CentroDistribuicao cd : this.listaCampanhas) {
            if(cd.getNomeCampanha().equals(nomeCampanha)){
                verificaExistenciaCampanha=true;
            }
        }
        return verificaExistenciaCampanha;
	}

    
}
