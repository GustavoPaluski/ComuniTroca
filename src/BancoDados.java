import java.util.ArrayList;

public class BancoDados {
    
    //===================Dados Do Usuário===================//
    ArrayList<Conta> listaContas = new ArrayList<Conta>();

    public void admin(){//ADMIN
        Conta conta = new Conta("", "", "", "", "", "","", "", "");
        
        conta.setEmail("admin");
        conta.setCpf("admin");
        conta.setNomeUsuario("admin");
        conta.setSenha("admin");
        
        listaContas.add(conta);
    }
    
	public void salvarDadosCadastrais(Conta c){
        this.listaContas.add(c);
	}

    public boolean verificarLogin(String nomeUsuario, String senha){
        boolean verificar=false;
        for(Conta c:this.listaContas){
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
        boolean validaCaractere=false;
        int quantidadeCPF = 0;
        do{
            do{
                conta.setCpf(EntradaSaida.inserirDadosCadastrais("CPF"));
                quantidadeCPF = conta.getCpf().length();
                    validaCaractere = conta.getCpf().matches("-?\\d+");
                if(quantidadeCPF != 11 || validaCaractere==false){EntradaSaida.escreverMensagem("\nCPF Inválido, tente novamente\n");}else {validacao=true;}
            }while(validacao==false);
            validacao=validarNomeUsuario(conta.getCpf());
            Validacao.validarDadosUsuario(validacao, "CPF já cadastrado.");
        }while(validacao==true);
        
        int emailValido = 0;
        do{
            do{
                conta.setEmail(EntradaSaida.inserirEmail());
                emailValido = conta.getEmail().indexOf("@gmail.com");
                // if(emailValido==-1){
                //     emailValido = conta.getEmail().indexOf("@outlook.com");
                //     if(emailValido==-1){
                //         emailValido = conta.getEmail().indexOf("@yahoo.com");
                //         if(emailValido==-1){
                //             emailValido = conta.getEmail().indexOf("@icloud.com");
                //         }
                //     }
                // }
                String vetorEmails[]= {"@gmail.com", "@outlook.com", "@yahoo.com", "@icloud.com"};
                for(int i=0; i<4;i++){
                    emailValido = conta.getEmail().indexOf(vetorEmails[i]);
                }//CONTINUAR BREAK DPS QUE -1

                    if(emailValido == -1){
                        EntradaSaida.escreverMensagem("\nEMAIL INVÁLIDO\n");
                    }
            }while(emailValido == -1);
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
        for (Conta c: this.listaContas) {
                retorno+="Nome de Usuário: "+c.getNomeUsuario()+"\nNome Completo: "+c.getNomeCompleto()+"\nCPF: "+Validacao.formartCpf(c.getCpf())+"\nData de Nascimento: "+c.getDataNascimento()+
                "\nCEP: "+c.getCep()+"\nEndereço: "+c.getEndereco()+"\nE-mail: "+c.getEmail()+"\nTelefone: "+c.getNumeroTelefone()+"\n\n";
        }
        return retorno;
    }

    public boolean validarNomeUsuario(String dadoUsuario){  //troca nome - validarDadosCadastrais
        boolean verificador = false;
        for (Conta cTemp : this.listaContas) {
           if(cTemp.getNomeUsuario().equals(dadoUsuario) || (cTemp.getEmail().equals(dadoUsuario)) || (cTemp.getCpf().equals(dadoUsuario))){
                verificador = true;
            } 
        }
        return verificador;
    }
    
    public boolean validarSenhaUsuario(String senha, String nomeEmailCpf){

        boolean verificador = false;
        for (Conta cTemp : listaContas) {
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
        for (Conta c: this.listaContas) {
            if(c.getNomeUsuario().equals(usuarioAtual) || (c.getEmail().equals(usuarioAtual)) || (c.getCpf().equals(usuarioAtual))){
                retorno+="\nNome de Usuário: "+c.getNomeUsuario()+"\nNome Completo: "+c.getNomeCompleto()+"\nCPF: "+Validacao.formartCpf(c.getCpf())+
                "\nData de Nascimento: "+c.getDataNascimento()+"\nCEP: "+c.getCep()+"\nEndereço: "+c.getEndereco()+"\nE-mail: "+c.getEmail()+
                "\nTelefone: "+c.getNumeroTelefone()+"\n\n";
            }
        }
        return retorno;
    }

    //====================Dados Da Campanha====================//
    ArrayList<CentroDistribuicao> listaCampanhas=new ArrayList<CentroDistribuicao>();

    public void salvarCampanha(CentroDistribuicao cd){
        this.listaCampanhas.add(cd);
    }

	public boolean verificarExistenciaCampanha(String nomeCampanha) {
        boolean verificaExistenciaCampanha=false;
		for (CentroDistribuicao cd : this.listaCampanhas) {
            if(cd.getNomeCampanha().equals(nomeCampanha)){
                verificaExistenciaCampanha=true;
            }
        }
        return verificaExistenciaCampanha;
	}

    public String concatenarDadosCampanha(){
        //concatenar dados da campanha e suas arrecadações
        return null;
    }

    // public String visualizarCampanhas(){
    //     String lista="CAMPANHAS DISPONÍVEIS:\n\n";
    //     for (CentroDistribuicao cd:this.listaCampanhas) {
    //         lista+=cd.getNomeCampanha()+"\nAdministrador: "+cd.getLiderOrganizacao()+"\nCentro de Distribuição: "+cd.getLocalDistribuicao()+"\nDescrição: "+cd.getDescricaoCampanha()+"\n";
    //     }
    //     return lista;
    // } //arrumar 
    
    //====================Dados De Produtos Doados====================//
    ArrayList<ProdutoDoacao> listaDoacoes=new ArrayList<ProdutoDoacao>();

    public String concatenarProdutosArrecadados(String destinoDoacao){
        String retorno="";
        int tamanhoLista= listaDoacoes.size();
        int contador=0;

        for (ProdutoDoacao pd:this.listaDoacoes) {
            if(pd.getDestinoDoacao().equals(destinoDoacao)){
                retorno+="Nome produto: "+pd.getNome()+"\nCategoria: "+pd.getDescricao()+"\nDescrição: "+pd.getDescricao()+"\n\n";
            }else if(tamanhoLista==contador && !(pd.getDestinoDoacao().equals(destinoDoacao) && retorno=="")){
                retorno+="Nenhum produto foi arrecadado no momento.";
            }   
            contador+=1;
        }
        return retorno;
    }
}