public class Principal {
    public static void main(String[] args) {

        do{
            BancoDados bd=new BancoDados();
            Conta c = new Conta("", "", "", "", "", "","", "", "");
            int opcao=0;
            boolean verificarAdmin=false;
            Troca t = new Troca();

            //TELA DE CADASTRO/LOGIN:
            do{
                EntradaSaida.clearScreen();
                EntradaSaida.inserirNomeSite();
                opcao = EntradaSaida.escolherOpcao("[1] - Cadastras Usuário\n[2] - Fazer Login\n[3] - Sair");
                opcao = Validacao.validarEscolhaMenu(1, 3, opcao);
                bd.admin();
                switch (opcao){
                    case 1:
                        EntradaSaida.clearScreen();
                        EntradaSaida.inserirNomeSite();
                        bd.cadastrarUsuario();
                        break;
                    
                    case 2:
                        EntradaSaida.clearScreen();
                        EntradaSaida.inserirNomeSite();
                        String nomeEmailCpf=EntradaSaida.inserirDadosCadastrais("Informe seu Nome de Usuário/CPf/E-mail");
                        String senhaUsuario=EntradaSaida.inserirDadosCadastrais("Digite sua senha");
                        //fazer login só 3 vezes
                        break;
        
                    case 3:
                        System.exit(0);
                        break;
                }
            }while(opcao!=1 && opcao!=2);

            opcao=0;
            if(verificarAdmin==false){ //MENU PRINCIPAL:
                do{
                    EntradaSaida.inserirNomeSite();
                    opcao = EntradaSaida.escolherOpcao("[1] - Doações\n[2] - Trocas\n[3] - Notícias\n[4] - Grupos\n[5] - Perfil\n[6] - Deslogar-se\n[7] - Sair");
                    opcao = Validacao.validarEscolhaMenu(1, 7, opcao);
                    switch (opcao){
                        case 1:
                            Doacao.visualizarMenuDoacao();
                            break;
                        
                        case 2:
                            EntradaSaida.inserirNomeSite();
                            int menu = EntradaSaida.escolherOpcao("[0] - Sair\n[1] - Inserir produto\n[2] - Excluir produto\n[3] - Visualizar produto");
                            Conta cTeste = new Conta("", "", "", "", "", "", "", "", "");
                            String visualizacaoTroca = ""; 

                            if(menu == 1){
                                cTeste.criarAnuncioTroca();
                            }
                            if(menu == 2){
                                EntradaSaida.escreverMensagem(cTeste.visualizarTrocas());
                            }else{
                                EntradaSaida.escreverMensagem("Opção inválida");
                            }
                            break;
            
                        case 3:
                            break;
            
                        case 4:
                            break;
            
                        case 5:
                            break;

                        case 6:
                            break;
            
                        case 7:
                            System.exit(0);
                            break;
                    }
                }while(opcao!=6);
            }else{ //MENU PRINCIPAL ADMINISTRADOR:
                do{
                    EntradaSaida.inserirNomeSite();
                    opcao = EntradaSaida.escolherOpcao("[1] - Remover Usuário\n[2] - Remover Publicação\n[3] - Deslogar-se\n[4] - Sair");
                    opcao = Validacao.validarEscolhaMenu(1, 4, opcao);
                    switch(opcao){
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            break;

                        case 4:
                            System.exit(0);
                            break;
                    }
                }while(opcao!=3);
            }
        }while(true);
    }
}