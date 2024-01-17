import java.util.Random;

public class EntradaSaida {
    
    Conta c;

    public static void inserirNomeSite(){
        System.out.println("==============================================");
        System.out.println("                 COMUNITROCA                  ");
        System.out.println("==============================================");
    }

    public static int escolherOpcao(String msg){
        System.out.println(" -Selecione uma das opções abaixo\n"+msg);
        return Integer.parseInt(System.console().readLine());
    }    

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static String inserirDadosCadastrais(String msg){
        System.out.println(msg);
        return System.console().readLine();
    }
    
    public static void escreverMensagem(String msg){
        System.out.println(msg);
    }

    public static String responderPerguntaSimNao(String msg){
        System.out.println(msg+" Digite SIM ou NÃO.");
        return System.console().readLine();
    } 

    public static int inserirInt(String txt){
        System.out.println(txt);
        return Integer.parseInt(System.console().readLine());
    }

    public static String inserirEmail(){
        System.out.println("Insira seu e-mail:");
        return System.console().readLine().toLowerCase();
    }

    public static String escolherCategoriaDoacao() {
        String retorno="";
        int opcaoCategoria=0;
        do{
            System.out.println("Selecione uma das categorias abaixo:\n[1] - Roupas\n[2] - Móveis\n[3] - Alimentos\n[4] - Brinquedos");
            opcaoCategoria=Integer.parseInt(System.console().readLine());
            switch (opcaoCategoria) {
                case 1:
                    retorno="Roupas";
            
                case 2:
                    retorno="Móveis";

                case 3:
                    retorno="Alimentos";

                case 4:
                    retorno="Brinquedos";

                default:
                    System.err.println("Opção inválida, selecione outra.");
            }
        }while(opcaoCategoria<1 && opcaoCategoria>4);
        return retorno;
    }

    public static void mostarRespostasChat(){
        boolean sair=false;
        Random aleatorio=new Random();
        System.out.println("Chat Local\nDigite SAIR para voltar ao menu.\n\n     Bommmm diaaaa grupo");

        do{
            
            String mensagemDigitada=System.console().readLine();
            
            if (mensagemDigitada.equals("SAIR")||mensagemDigitada.equals("sair")){
                sair=true;
            }else{
                String[] mensagem= new String[15];
                mensagem[0]="     Já fizeram suas doações hoje???";
                mensagem[1]="     Troco uma galinha em um ps5. Alguém interessado?";
                mensagem[2]="     Passando aqui para lembrar você de beber água";
                mensagem[3]="     Genteeeeeeeeee, tenho uma caixa térmica que não uso mais, alguém tem interesse?";
                mensagem[4]="     Preciso de um microondas, dou em troca um boi";
                mensagem[5]="     troco um kit copo por um kit talher.";
                mensagem[6]="     Eae fml, alguém tem ferramentas para trocar??";
                mensagem[7]="     Troco nike Air Force por um Jordan";
                mensagem[8]="     Bom dia!!";
                mensagem[9]="     Boa tarde.";
                mensagem[10]="    Boa noite";
                mensagem[11]="    Troco uma tv 32 polegadas por uma tatuagem";
                mensagem[12]="    como está?";
                mensagem[13]="    Meu nome é paluski mafra gustavo";
                mensagem[14]="    E o pix? Nada ainda?";

                System.out.println(mensagem[aleatorio.nextInt(14)]);
            }
        }while(sair==false);
    }

    
    public static void mostrarNoticias(){
        String[] noticia = new String[5];
        Random rand = new Random();
        int i=0;

        noticia[0] = "Nova campanha do agasalho foi lanaçada, faça uma doação para ajudar os necessitados!";
        noticia[1] = "Curitiba registra 15 casos de morte por hipotermia nesse imverno, ajude a não aumentar os casos, doe roupas quentes!";
        noticia[2] = "JEC elabora jogo beneficiente para arrecadação de alimentos, para assistir a pertida é preciso doar apenas 1 Kg de alimento"+ 
        "não perecessível!";
        noticia[3] = "20 solicitações de trocas envolvendo PS5 na região de Joinville hoje";
        noticia[4] = "30 trocas de peças de carro foram trocadas ontem no Comasa";

        for(i=0; i<5; i++){
            EntradaSaida.escreverMensagem("=====================================================================");
            System.out.println(noticia[rand.nextInt(4)]);
            EntradaSaida.escreverMensagem("=====================================================================");
            System.out.println("Aperte 'ENTER' para ver a próxima notícia: ");
            System.console().readLine();
            EntradaSaida.clearScreen();
        }
    }
}