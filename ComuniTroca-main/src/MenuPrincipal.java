public class MenuPrincipal {
    public static void main(String[] args){

        int opcao=0;

        MenuLogin.exibirMenuDeCadastro();

        do{
            EntradaSaida.inserirNomeSite();
            opcao = EntradaSaida.escolherOpcao("[1] - Doacoes\n[2] - Trocas\n[3] - Notícias\n[4] - Grupos\n[5] - Perfil\n[6] - Sair");
            switch (opcao){
                case 1:
                    
                    break;
                
                case 2:
                    Troca.criarAnuncio();
                    String batata="";
                    batata = Conta.imprimir();
                    System.out.println(batata);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
        }while(!(opcao==6));
    }
}