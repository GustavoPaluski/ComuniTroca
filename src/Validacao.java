public class Validacao {
    
    public static int validarEscolhaMenu(int valorMinimo, int valorMaximo, int opcao){
        while(opcao<valorMinimo || opcao>valorMaximo){
            EntradaSaida.mensagemAviso("Opção inválida, selecione outra.");
            opcao=Integer.parseInt(System.console().readLine());
        }
        return opcao;
    }
}
