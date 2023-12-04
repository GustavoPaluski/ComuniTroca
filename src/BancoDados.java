import java.util.ArrayList;

public class BancoDados {
    
    ArrayList<Conta> contas = new ArrayList<Conta>();

	public void salvarDadosCadastrais(Conta c){
        this.contas.add(c);
	}

    public boolean verificarLogin(String nomeUsuario, String senha){
        boolean verificar=false;
        for(Conta c:this.contas){
            if(c.nomeUsuario.equals(nomeUsuario) && c.senha.equals(senha)){
                verificar=true;
            }
        }
        return verificar;
    }

    public void cadastrarUsuario(){
        Conta c = new Conta();
        
        c.nomeCompleto = EntradaSaida.inserirDadosCadastrais("Nome completo");
        c.cpf = EntradaSaida.inserirDadosCadastrais("CPF");
        c.email = EntradaSaida.inserirDadosCadastrais("E-mail");
        c.nomeUsuario = EntradaSaida.inserirDadosCadastrais("Digite o nome de usuário");
        //validar nomeDeUsuario
        c.endereco = EntradaSaida.inserirDadosCadastrais("Endereço");
        c.cep = EntradaSaida.inserirDadosCadastrais("CEP");
        c.numeroTelefone = EntradaSaida.inserirDadosCadastrais("Telefone");
        contas.add(c);
    }

    public void fazerLogin(){

        boolean verificar = false;
        do{
            String nomeEmailUsuario = EntradaSaida.inserirDadosCadastrais("Digite o email ou o nome de usauario");
            verificar = this.validarnomeUsuario(nomeEmailUsuario);
            if(verificar == true){
                String senha = EntradaSaida.inserirDadosCadastrais("Digite a senha");
                verificar = this.validarSenhaUsuario(senha);
                if(verificar == true){
                    EntradaSaida.escreverMensagem("Login efeituado");
                }else{EntradaSaida.escreverMensagem("Senha incorreta!");}
            }else{EntradaSaida.escreverMensagem("Email ou nome de usuário incorreto!");}
        }while(verificar == false);
    }

    public boolean validarnomeUsuario(String nomeUsuario){
        boolean verificador = false;
        for (Conta cTemp : contas) {
           if(cTemp.nomeUsuario.equals(nomeUsuario) || (cTemp.email.equals(nomeUsuario))){verificador = true;}
        }
        return verificador;
    }
    
    public boolean validarSenhaUsuario(String senha){
        boolean verificador = false;
        for (Conta cTemp : contas) {
           if(cTemp.senha.equals(senha)){
                verificador = true;
           }
        }
        return verificador;
    }

}
