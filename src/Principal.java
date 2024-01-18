public class Principal {
    public static void main(String[] args) {

        BancoDados bd=new BancoDados();
        Conta c = new Conta("", "", "", "", "", "", "", "", "");
        bd.admin();
        do{
            int opcao=0, contador = 0;
            boolean verificarAdmin=false;
            String usuarioAtual="";
            boolean verificadorErroLogin = false;

            //TELA DE CADASTRO/LOGIN:
            do{
                contador=0;
                EntradaSaida.clearScreen();
                EntradaSaida.inserirNomeSite();
                try{
                    opcao = EntradaSaida.escolherOpcao("[1] - Cadastrar Usuário\n[2] - Fazer Login\n[3] - Sair");
                    opcao = Validacao.validarEscolhaMenu(1, 3, opcao);
                    switch (opcao){
                        case 1:
                            EntradaSaida.clearScreen();
                            EntradaSaida.inserirNomeSite();
                            usuarioAtual=bd.cadastrarUsuario();
                            break;
                        
                        case 2:
                            EntradaSaida.clearScreen();
                            EntradaSaida.inserirNomeSite();

                            boolean verificaDadosUsuario=false;
                            String nomeEmailCpf="";
                            String senhaUsuario="";

                            do{
                                nomeEmailCpf=EntradaSaida.inserirDadosCadastrais("Informe seu Nome de Usuário/CPf/E-mail");

                                senhaUsuario=EntradaSaida.inserirDadosCadastrais("Digite sua senha");
                                verificaDadosUsuario=bd.validarSenhaUsuario(senhaUsuario,nomeEmailCpf);
                                if(verificaDadosUsuario == false){
                                    contador++;
                                    if(contador != 3){
                                        EntradaSaida.escreverMensagem("Usuário ou senha incorretos, tente novamente!\n");
                                    }
                                }
                                
                                verificadorErroLogin=Validacao.validarErroLogin(verificaDadosUsuario, contador);
                                
                            }while(verificaDadosUsuario==false && contador < 3); 
                                    
                            verificarAdmin=Validacao.verificarAdmin(nomeEmailCpf, senhaUsuario); 

                            usuarioAtual=nomeEmailCpf;
                            break;
            
                        case 3:
                            System.exit(0);
                            break;
                        }
                }catch (NumberFormatException nfe) {EntradaSaida.escreverMensagem("Opção inválida!");}

            }while(opcao!=1 && opcao!=2);

            if(verificadorErroLogin == false){
                opcao=0;
                if(verificarAdmin==false){ //MENU PRINCIPAL:
                    do{
                        EntradaSaida.inserirNomeSite();
                        opcao = EntradaSaida.escolherOpcao("[1] - Doações\n[2] - Trocas\n[3] - Notícias\n[4] - Chat\n[5] - Perfil\n[6] - Deslogar-se\n[7] - Sair");
                        opcao = Validacao.validarEscolhaMenu(1, 7, opcao);
                        switch (opcao){
                            case 1:
                                Doacao.visualizarMenuDoacao(usuarioAtual); //finalizar
                                break;
                            
                            case 2:
                                Troca.visualizarMenuTroca();
                                break;
                
                            case 3: //adm att
                                EntradaSaida.mostrarNoticias();
                                break;
                
                            case 4: 
                                EntradaSaida.mostarRespostasChat();
                                break;
                
                            case 5: //possibilidade de alterar alguns dados
                                EntradaSaida.escreverMensagem(bd.visualizarPerfilUsusario(usuarioAtual));
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
                        opcao = EntradaSaida.escolherOpcao("[1] - Remover Usuário\n[2] - Remover Publicação\n[3] - Deslogar-se\n[4] - Sair"); //possibilidade de modificar as notícias
                        opcao = Validacao.validarEscolhaMenu(1, 4, opcao);
                        switch(opcao){
                            case 1: //remover ususarios e suas publicacoes - conferir se esta pronto
                                int tamanho = bd.listaContas.size();
                                EntradaSaida.escreverMensagem("TAMANHO DA LISTA DE CONTAS: "+tamanho);
                                String nomeUsuario = EntradaSaida.inserirDadosCadastrais("Digite o nome de usuário que deseja excluir");
                                c.removerUsuarioAdmin(nomeUsuario,bd);
                                break;

                            case 2: //remover publicacoes2
                                EntradaSaida.escreverMensagem(bd.retornarArraylist()); // visualizacao de array temporária
                                break;

                            case 3:
                                break;

                            case 4:
                                System.exit(0);
                                break;
                        }
                    }while(opcao!=3);
                }
            }
        }while(true);
    }
}