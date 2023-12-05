public class Troca{

    public void menuTroca(){
        EntradaSaida.inserirNomeSite();
        int menu = EntradaSaida.escolherOpcao("[0] - Sair\n[1] - Inserir produto\n[2] - Excluir produto\n[3] - Visualizar produto");

        switch (menu) {
            case 1:
                this.criarAnuncio();
                break;
        
            default:
                break;
        }
    }

    public static void criarAnuncio(){
        Conta c = new Conta("", "", "", "", "", "","", "", "");
        Produtos p = new Produtos();
        p.nome = EntradaSaida.inserirDadosCadastrais("Digite o modelo");
        p.categoria = EntradaSaida.inserirDadosCadastrais("Digite a categoria");
        p.tempoDeUso = EntradaSaida.inserirDadosCadastrais("Digite o tempo de uso"); //TEM QUE ARMAZENAR NO ARRAYLIST EM CONTA
        p.situacao = EntradaSaida.inserirDadosCadastrais("Digite a situacao");
        c.armazenarProdutos(p);
    }
}            
