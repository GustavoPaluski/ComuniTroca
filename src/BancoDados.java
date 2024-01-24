import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.StringJoiner;

public class BancoDados {
    
    //===================Dados Do Usuário===================//
    ArrayList<Conta> listaContas = new ArrayList<Conta>();

    Calendar c = Calendar.getInstance();
    Date data = c.getTime();

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
        String nomeCompleto = "";
        int tamanhoNomeCompleto = 0;
        Conta conta = new Conta("", "", "", "", "", "", "", "", "");

        do{
            nomeCompleto = EntradaSaida.inserirDadosCadastrais("Nome completo");
            tamanhoNomeCompleto = nomeCompleto.length();
            if(tamanhoNomeCompleto < 2 || tamanhoNomeCompleto > 64){
                EntradaSaida.escreverMensagem("Número de letras insuficiente!");
            }else{conta.setNomeCompleto(nomeCompleto);}
        }while(tamanhoNomeCompleto < 2 || tamanhoNomeCompleto > 64);
        
        boolean validacao=false;
        boolean validaCaractere=false;
        int quantidadeNumerosDaString = 0;
        do{
            do{
                conta.setCpf(EntradaSaida.inserirDadosCadastrais("CPF"));
                quantidadeNumerosDaString = conta.getCpf().length();
                validaCaractere = conta.getCpf().matches("-?\\d+");
                if(quantidadeNumerosDaString != 11 || validaCaractere==false){EntradaSaida.escreverMensagem("\nCPF Inválido, tente novamente\n");}else {validacao=true;}
            }while(validacao==false);
            validacao=validarNomeUsuario(conta.getCpf());
            Validacao.validarDadosUsuario(validacao, "CPF já cadastrado.");
        }while(validacao==true);
        
        int emailValido = 0;
        int verificaEmail = 0;
        int tamanhoEmail = 0;
        int posicaoPontoCom = 0;
        String testeEmail = "";
        String novo_email = "";
        do{
            do{
                novo_email = EntradaSaida.inserirEmail();
                tamanhoEmail = novo_email.length();
                posicaoPontoCom = novo_email.indexOf(".com");

                if(tamanhoEmail - 1 > (posicaoPontoCom + 3) || posicaoPontoCom == -1){
                    EntradaSaida.escreverMensagem("Email inválido!");
                }else{conta.setEmail(novo_email);

                    String vetorEmails[]= {"@gmail.com", "@outlook.com", "@yahoo.com", "@icloud.com", "@hotmail.com"};

                    for(int i=0; i<5;i++){
                        
                        emailValido = conta.getEmail().indexOf(vetorEmails[i]);
                        if(emailValido!=-1){
                            testeEmail = conta.getEmail().replaceAll(" ","#@#ERRO#@#");
                            verificaEmail = testeEmail.indexOf("#@#ERRO#@#");
                            break;
                        }
                    }
                    if(emailValido == -1 || verificaEmail != -1 ){
                        EntradaSaida.escreverMensagem("\nEMAIL INVÁLIDO\n");
                    }
                }
            }while(emailValido == -1 || verificaEmail != -1);
            
            validacao=validarNomeUsuario(conta.getEmail());
            Validacao.validarDadosUsuario(validacao, "E-mail já cadastrado.");
        }while(validacao==true);

        do{
            conta.setNomeUsuario(EntradaSaida.inserirDadosCadastrais("Digite o nome de usuário"));

            int tamanhoNomeUsuario = conta.getNomeUsuario().length();
            if(tamanhoNomeUsuario < 2 || tamanhoNomeUsuario > 64){
                EntradaSaida.escreverMensagem("Número de letras insuficiente!");
                validacao = true;
            }else{
                validacao=validarNomeUsuario(conta.getNomeUsuario());
                Validacao.validarDadosUsuario(validacao, "Usuário já existente.");
            }
        }while(validacao==true); //ESTÁ REPETINDO MESMO NÃO PODENDO
        usuarioAtual=conta.getNomeUsuario();

        String dataNascimento = EntradaSaida.inserirDadosCadastrais("data de nascimento");
        if(Validacao.StringEhNumero(dataNascimento)){
            int diaNascimento = Integer.parseInt(dataNascimento.substring(0, 2));
            int mesNascimento = Integer.parseInt(dataNascimento.substring(2, 4));
            int anoNascimento = Integer.parseInt(dataNascimento.substring(4, 8));

            if(diaNascimento > c.get(Calendar.DAY_OF_MONTH) && anoNascimento > c.get(Calendar.YEAR)){EntradaSaida.escreverMensagem("Data inválida!");}
            conta.setDataNascimento(dataNascimento);

        }
        

        conta.setEndereco(EntradaSaida.inserirDadosCadastrais("Endereço"));
        
        validacao=false;
        quantidadeNumerosDaString=0;
        validaCaractere=false;
        do{
            conta.setCep(EntradaSaida.inserirDadosCadastrais("CEP"));
            quantidadeNumerosDaString=conta.getCep().length();
            validaCaractere=conta.getCep().matches("-?\\d+");
            if(quantidadeNumerosDaString != 8 || validaCaractere==false){EntradaSaida.escreverMensagem("CEP inválido, tente novamente:");}else{validacao=true;}
        }while(validacao==false);

        validacao=false;
        quantidadeNumerosDaString=0;
        validaCaractere=false;
        do{
            conta.setNumeroTelefone(EntradaSaida.inserirDadosCadastrais("Telefone"));
            quantidadeNumerosDaString=conta.getNumeroTelefone().length();
            validaCaractere=conta.getNumeroTelefone().matches("-?\\d+");
            if(quantidadeNumerosDaString != 11 || validaCaractere==false){
                EntradaSaida.escreverMensagem("Número de telefone inválido, tente novamente: ");}else{validacao=true;}
        }while(validacao==false); 

        conta.setSenha(EntradaSaida.inserirDadosCadastrais("Senha")); // digitar senha duas vezes para a confirmação
        salvarDadosCadastrais(conta);

        return usuarioAtual;
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

    public String retornarNomeUsuario(String nomeEmailCpf){
        String retorno="";
        for (Conta conta: this.listaContas) {
            if(conta.getNomeUsuario().equals(nomeEmailCpf) || (conta.getEmail().equals(nomeEmailCpf)) || (conta.getCpf().equals(nomeEmailCpf))){
                retorno=conta.getNomeUsuario();
            }
        }
        return retorno;
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

    public void deletarCampanha(String usuarioAtual){
        for (CentroDistribuicao centroDistribuicao : this.listaCampanhas) {
            if(usuarioAtual.equals(centroDistribuicao.getAdminCampanha())){
                this.listaCampanhas.remove(centroDistribuicao);
            }
        }
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

    public String concatenarDadosCampanha(String usuarioAtual){
        String retorno="";
        for (CentroDistribuicao centroDistribuicao: this.listaCampanhas) {
            if(usuarioAtual.equals(centroDistribuicao.getAdminCampanha())){
                retorno+="Nome da campanha: "+centroDistribuicao.getNomeCampanha()+"\nCategoria: "+centroDistribuicao.getCategoria()+"\nLocal: "+centroDistribuicao.getLocalDistribuicao()+
                "\nDescrição: "+centroDistribuicao.getDescricaoCampanha()+"\nProdutos arrecadados: "+centroDistribuicao.getProdutosArrecadados();
            }
        }
        return retorno;
    }

    public void salvarProdutosArrecadadosNaCampanha(String campanhaSelecionada, String produtosArrecadados){
        for (CentroDistribuicao cd:listaCampanhas){
            if(campanhaSelecionada.equals(cd.getNomeCampanha())){
                cd.setProdutosArrecadados(produtosArrecadados);
            }
        }
    }

    public String visualizarCampanhas(){
        String lista="CAMPANHAS DISPONÍVEIS:\n\n";
        int i=0;
        for (CentroDistribuicao cd:this.listaCampanhas) {
            lista+="Campanha "+(i++)+": "+cd.getNomeCampanha()+"\nCategoria: "+cd.getCategoria()+"\nDescrição: "+cd.getDescricaoCampanha()+"\n";
        }
        return lista;
    } 

    public boolean verificarExistenciaDeUmaCampanhaPorUsuario(String usuarioAtual){
        for (CentroDistribuicao centroDistribuicao : this.listaCampanhas) {
            if(usuarioAtual.equals(centroDistribuicao.getAdminCampanha())){
                return true;
            }
        }
        return false;
    }

    public void editarDescricaoCampanha(String usuarioAtual){
        for (CentroDistribuicao centroDistribuicao : this.listaCampanhas) {
            if(usuarioAtual.equals(centroDistribuicao.getAdminCampanha())){
                centroDistribuicao.setDescricaoCampanha(EntradaSaida.inserirDadosCadastrais("Digite a nova descrição: "));
            }
        }
    }

    public void editarLocalCampanha(String usuarioAtual){
        for (CentroDistribuicao centroDistribuicao : this.listaCampanhas) {
            if(usuarioAtual.equals(centroDistribuicao.getAdminCampanha())){
                centroDistribuicao.setLocalDistribuicao(EntradaSaida.inserirDadosCadastrais("Digite o novo endereço: "));
            }
        }
    }
    
    //====================Dados De Produtos Doados====================//
    ArrayList<ProdutoDoacao> listaDoacoes=new ArrayList<ProdutoDoacao>();

    public String concatenarProdutosArrecadados(String destinoDoacao){
        String retorno="";
        int tamanhoLista= listaDoacoes.size();
        int contador=0;

        for (ProdutoDoacao pd:this.listaDoacoes) {
            if(pd.getDestinoDoacao().equals(destinoDoacao)){
                retorno+="Produto "+(contador+1)+":\nNome produto: "+pd.getNome()+"\nCategoria: "+pd.getDescricao()+"\nDescrição: "+pd.getDescricao()+"\n\n";
            }else if(tamanhoLista==contador && !(pd.getDestinoDoacao().equals(destinoDoacao) && retorno=="")){
                retorno+="Nenhum produto foi arrecadado no momento.";
            }   
        }
        return retorno;
    }

    public void salvarProdutosDoados(ProdutoDoacao pD){
        this.listaDoacoes.add(pD);
    }
}