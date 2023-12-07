public class Doacao {
    
    public static void visualizarMenuDoacao(){

        int opcao=0;
        BancoDados bd=new BancoDados();

        do{
            EntradaSaida.clearScreen();   
            EntradaSaida.inserirNomeSite();
            opcao=EntradaSaida.escolherOpcao("[1] - Fazer Doação\n[2] - Visualizar Campanhas\n[3] - Criar Campanha\n[4] - Acessar Minha Campanha\n[5] - Sair da Página");
            opcao=Validacao.validarEscolhaMenu(1, 5, opcao);
            
            CentroDistribuicao cd=new CentroDistribuicao();
            switch(opcao){
                case 1:
                    

                    break;

                case 2:
                    if(bd.doacao.isEmpty()){
                        EntradaSaida.escreverMensagem("Não há nenhuma campanha no momento");
                    }else{
                        EntradaSaida.escreverMensagem(bd.visualizarCampanhas());
                    }
                    break;
                    // está apagando a visualização das campanhas
                case 3:
                    EntradaSaida.clearScreen();
                    EntradaSaida.inserirNomeSite();
                    
                    cd.setLocalDistribuicao(EntradaSaida.inserirDadosCadastrais("Informe o endereço onde os produtos serão distribuídos:"));
                    cd.setLiderOrganizacao(EntradaSaida.inserirDadosCadastrais("Digite o nome do administrador da ONG:"));
                    cd.setCpfLider(EntradaSaida.inserirDadosCadastrais("Insira o CPF do administrador da organização:"));
                    cd.setSenha(EntradaSaida.inserirDadosCadastrais("Crie uma senha para acessar a função admin de sua organização:"));
                    // cadastrar senha duas vezes para validá-la
                    cd.setNomeCampanha(EntradaSaida.inserirDadosCadastrais("Insira o nome da campanha:"));
                    cd.setDescricaoCampanha(EntradaSaida.inserirDadosCadastrais("Insira a descrição da campanha:"));

                    bd.salvarCampanha(cd);
                    break;

                case 4:
                    break;

                case 5:
                    break;
            }
        }while(opcao!=5);
    }
}