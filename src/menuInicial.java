public class menuInicial {

    public static void exibirMenuDeCadastro(){

        BancoDados bd=new BancoDados();
        Conta c=new Conta();
        int opcao=0;

        //menu de login/cadastro
        do{
            EntradaSaida.inserirNomeSite();
            opcao=EntradaSaida.escolherOpcao(" -Selecione uma das opções abaixo\n[1] Cadastrar-se\n[2] Fazer login\n[3] Sair");
            switch (opcao) {
                case 1:
                    c.nomeUsuario=EntradaSaida.inserirDadosCadastrais("Digite seu nome completo");
                    c.dataNascimento=EntradaSaida.inserirDadosCadastrais("Digite sua data de nascimento");
                    c.cpf=EntradaSaida.inserirDadosCadastrais("Digite seu CPF");
                    c.cep=EntradaSaida.inserirDadosCadastrais("Digite seu CEP");
                    c.email=EntradaSaida.inserirDadosCadastrais("Digite seu email");
                    c.numeroTelefone=EntradaSaida.inserirDadosCadastrais("Digite seu número de telefone");
                    c.senha=EntradaSaida.inserirDadosCadastrais("Digite sua senha");
                    
                    bd.salvarDadosCadastrais(c);
                    //levar usuário para menu principal - fechar ao cadastrar
                    break;
            
                case 2:
                    //Verificar se existe uma conta cadastrada, se não houver realizar pergunta novamente de login/cadastro usando o do while
                    break;

                case 3:
                    System.exit(0);
                    break;
            }
        }while(opcao!=3); //equals 1,2,3
    }
}