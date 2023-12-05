import java.util.ArrayList;

public class BancoDados {
    
    ArrayList<Conta> contas = new ArrayList<Conta>();

    //ADMIN
    public void admin(){
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

    // public void fazerLogin(){

    //     boolean verificar = false;
    //     do{
    //         String nomeEmailUsuario = EntradaSaida.inserirDadosCadastrais("Digite o email, nome de usauario ou o CPF");
    //         verificar = this.validarNomeUsuario(nomeEmailUsuario);
    //         if(verificar == true){
    //             String senha = EntradaSaida.inserirDadosCadastrais("Digite a senha: ");
    //             verificar = this.validarSenhaUsuario(senha);
    //             if(verificar == true){
    //                 EntradaSaida.escreverMensagem("Login efeituado");
    //             }else{EntradaSaida.escreverMensagem("Senha incorreta!");}
    //         }else{EntradaSaida.clearScreen(); EntradaSaida.escreverMensagem("Email ou nome de usuário incorreto!");}
    //     }while(verificar == false);
    // }

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
}
