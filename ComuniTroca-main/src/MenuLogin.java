public class MenuLogin {
    public static void exibirMenuDeCadastro() {

        BancoDados bd=new BancoDados();
        Conta c=new Conta();
        int opcao=0;

        do{
            EntradaSaida.inserirNomeSite();
            opcao=EntradaSaida.escolherOpcao("[1] Cadastrar-se\n[2] Fazer login\n[3] Sair");
            opcao=Validacao.validarEscolhaMenu(1,3,opcao);

            switch (opcao) {
                case 1:
                    c.nomeUsuario=EntradaSaida.inserirDadosCadastrais("Digite seu nome completo");
                    c.dataNascimento=EntradaSaida.inserirDadosCadastrais("Digite sua data de nascimento");
                    c.cpf=EntradaSaida.inserirDadosCadastrais("Digite seu CPF");
                    c.pais=EntradaSaida.inserirDadosCadastrais("Digite seu País");
                    c.estado=EntradaSaida.inserirDadosCadastrais("Digite seu Estado");
                    c.cidade=EntradaSaida.inserirDadosCadastrais("Digite sua cidade");
                    c.endereco=EntradaSaida.inserirDadosCadastrais("Digite seu endereço");
                    c.cep=EntradaSaida.inserirDadosCadastrais("Digite seu CEP");
                    c.email=EntradaSaida.inserirDadosCadastrais("Digite seu email");
                    c.numeroTelefone=EntradaSaida.inserirDadosCadastrais("Digite seu número de telefone");
                    c.senha=EntradaSaida.inserirDadosCadastrais("Digite sua senha");
                    
                    bd.salvarDadosCadastrais(c);
                    //levar usuário para menu principal, depois de ralizar primeiro cadastro
                    break;
            
                case 2:
                    boolean repetirLogin=false;

                    do{
                        String nomeUsuario=EntradaSaida.inserirDadosCadastrais("Informe seu nome de usuário");
                        String senha=EntradaSaida.inserirDadosCadastrais("Informe sua senha");

                        boolean verificarUsuario=bd.verificarLogin(nomeUsuario, senha);
                        if(verificarUsuario==true){
                            //levar usuário ao menu principal
                        }else{
                            int escolha=0;
                            EntradaSaida.mensagemAviso("Usuário e senha incorretos.");
                            escolha=EntradaSaida.escolherOpcao("[1] Tentar novamente\n[2] Voltar ao menu de login\n[3] Sair");
                            escolha=Validacao.validarEscolhaMenu(1, 3, escolha);

                            switch (escolha) {
                                case 1:
                                    repetirLogin=true;
                                    break;
                            
                                case 2:
                                    MenuLogin.exibirMenuDeCadastro();
                                    repetirLogin=false;
                                    break;

                                case 3:
                                    System.exit(0);
                                    break;
                            }
                        }
                    }while(repetirLogin==true);
                    break;

                case 3:
                    System.exit(0);
                    break;
            }
        }while(!(opcao==1 || opcao ==2 || opcao==3));
    }
}