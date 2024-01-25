public class Troca{

    public static void visualizarMenuTroca(){

        EntradaSaida.clearScreen();
        EntradaSaida.inserirNomeSite();
        Conta c = new Conta("", "", "", "", "", "", "", "", "");
        int escolhaMenu=0;

        do{
            try{
                escolhaMenu = EntradaSaida.escolherOpcao("[1] - Criar anúncio\n[2] - Visualizar Trocas\n[3] - Excluir Troca\n[0] - Sair");
                escolhaMenu=Validacao.validarEscolhaMenu(1, 4, escolhaMenu); 

                switch(escolhaMenu){
                    case 1:
                        c.criarAnuncioTroca();
                        break;

                    case 2:
                        EntradaSaida.escreverMensagem(c.visualizarTrocas());
                        break;
                    case 3:
                        c.excluirTroca();
                        break;
                    case 0:
                        break;
                    default:
                        EntradaSaida.escreverMensagem("Opção inválida");
                }
            }catch(NumberFormatException exception){EntradaSaida.escreverMensagem("Apenas números permitidos!");};
        }while(escolhaMenu!=0);
    }
}            
