import java.util.ArrayList;

public class MenuLogin {
    // [0] - Sair
    // [1] - Cadastrar usuário
    // [2] - Fazer Login
    // [3] - Fazer LogOut
    
    ArrayList<Conta> conta = new ArrayList<Conta>();

    public static void cadastrarUsuario(){
        Conta c = new Conta();
        
        String nomeDeUsuario = EntradaSaida.inserirDadosCadastrais("Digite o nome de usuário");
        //validar nomeDeUsuario
        c. = EntradaSaida.inserirDadosCadastrais("CPF");
        String cep = EntradaSaida.inserirDadosCadastrais("CEP");
        String email = EntradaSaida.inserirDadosCadastrais("E-mail");
        String telefone = EntradaSaida.inserirDadosCadastrais("Telefone");
        String nomeCompleto = EntradaSaida.inserirDadosCadastrais("Nome completo");


    }
}