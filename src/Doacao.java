public class Doacao {
    
    public static void visualizarMenuDoacao(String usuarioAtual,BancoDados bd, ProdutoDoacao pD){

        int opcao=0; 
        CentroDistribuicao cd = new CentroDistribuicao("", "", "", "", "");
        
        
        do{
            EntradaSaida.clearScreen();   
            EntradaSaida.inserirNomeSite();
            opcao=EntradaSaida.escolherOpcao("[1] - Visualizar Campanhas\n[2] - Criar Campanha\n[3] - Acessar Minha Campanha\n[4] - Sair da Página");
            opcao=Validacao.validarEscolhaMenu(1, 5, opcao);
            
            switch(opcao){
                case 1:
                    if(bd.listaCampanhas.isEmpty()){
                        EntradaSaida.escreverMensagem("Não há nenhuma campanha no momento"); 
                        EntradaSaida.pressionarEnterParaContinuar();
                    }else{
                        EntradaSaida.escreverMensagem(bd.visualizarCampanhas());
                        String escolhaUsuario=EntradaSaida.responderPerguntaSimNao("\n\nDeseja realizar uma doação?\n").toUpperCase();

                        if(escolhaUsuario.equals("NÃO")||escolhaUsuario.equals("NAO")){
                            break;
                        }else if (escolhaUsuario.equals("SIM")){
                            boolean campanhaValida = false;
                            do{
                                pD.setDestinoDoacao(EntradaSaida.inserirDadosCadastrais("Digite o nome da campanha que você deseja realizar a doação:"));
                                campanhaValida=bd.verificarExistenciaCampanha(pD.getDestinoDoacao());
                                if(campanhaValida==false){
                                    EntradaSaida.escreverMensagem("Campanha inserida inválida!");
                                }
                            }while(campanhaValida!=true);

                            pD.setNome(EntradaSaida.inserirDadosCadastrais("Insira o nome do produto que será doado:"));  
                            pD.setCategoria(EntradaSaida.escolherCategoriaDoacao());
                            pD.setDescricao(EntradaSaida.inserirDadosCadastrais("Descreva o estado do produto e sua quantidade:"));
                            bd.salvarProdutosDoados(pD);

                            bd.salvarProdutosArrecadadosNaCampanha(pD.getDestinoDoacao(), bd.concatenarProdutosArrecadados(pD.getDestinoDoacao()));
                        }else{
                            EntradaSaida.escreverMensagem("A opção digitada não corresponde as informadas!");
                        }
                    }
                    break;
                case 2:
                    EntradaSaida.clearScreen();
                    EntradaSaida.inserirNomeSite();
                    
                    if(bd.verificarExistenciaDeUmaCampanhaPorUsuario(usuarioAtual)==true){
                        EntradaSaida.escreverMensagem("Você já possui uma campanha!");
                    }else{
                        cd.setCategoria(EntradaSaida.escolherCategoriaDoacao());
                        
                        boolean verificaExistenciaCampanha=false;
                        do{
                            cd.setNomeCampanha(EntradaSaida.inserirDadosCadastrais("Insira o nome da campanha:")); 
                            verificaExistenciaCampanha=bd.verificarExistenciaCampanha(cd.getNomeCampanha());
                            if(verificaExistenciaCampanha == true){
                                EntradaSaida.escreverMensagem("Campanha já existente! Coloque outro nome.");
                            }
                        }while(verificaExistenciaCampanha==true);

                        cd.setDescricaoCampanha(EntradaSaida.inserirDadosCadastrais("Insira a descrição da campanha:"));
                        cd.setLocalDistribuicao(EntradaSaida.inserirDadosCadastrais("Informe o endereço onde os produtos serão distribuídos:"));
                        cd.setProdutosArrecadados(bd.concatenarProdutosArrecadados(cd.getProdutosArrecadados()));
                        cd.setAdminCampanha(usuarioAtual);
                        bd.salvarCampanha(cd);
                    }
                    break;

                case 3: 
                    EntradaSaida.clearScreen();
                    EntradaSaida.inserirNomeSite();
                    
                    EntradaSaida.escreverMensagem(bd.concatenarDadosCampanha(usuarioAtual));

                    int opcaoPerfilCampanha=EntradaSaida.escolherOpcao("[1] - Editar Campanha\n[2] - Excluir Campanha\n[3] - Voltar");
                    switch (opcaoPerfilCampanha) {
                        case 1:
                            EntradaSaida.escreverMensagem("Digite qual atributo você deseja alterar: (Descrição / Endereço)");
                            String retorno=EntradaSaida.retornarRespostaUsuario().toUpperCase();

                            if(retorno.equals("DESCRICAO")||retorno.equals("DESCRIÇÃO")){
                                bd.editarDescricaoCampanha(usuarioAtual);
                                EntradaSaida.escreverMensagem("Descrição alterada com sucesso!");
                                EntradaSaida.pressionarEnterParaContinuar();
                            }else if(retorno.equals("ENDEREÇO")||retorno.equals("ENDERECO")){
                                bd.editarLocalCampanha(usuarioAtual);
                                EntradaSaida.escreverMensagem("Endereço alterado com sucesso!");
                                EntradaSaida.pressionarEnterParaContinuar();
                            }else{
                                EntradaSaida.escreverMensagem("Opção informada inválida!");
                            }
                            break;
                    
                        case 2:
                            bd.deletarCampanha(usuarioAtual);
                            break;

                        case 3:
                            break;
                    }
                    break;

                case 4:
                    break;
            }
        }while(opcao!=4);
    }
}