import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.MaskFormatter;

public class Validacao {
    
    BancoDados bd = new BancoDados();

    public static int validarEscolhaMenu(int valorMinimo, int valorMaximo, int opcao){
        while(opcao<valorMinimo && opcao>valorMaximo){
            EntradaSaida.escreverMensagem("Opção inválida, selecione outra.");
            opcao=Integer.parseInt(System.console().readLine());
        }
        return opcao;
    }

    public static void validarDadosUsuario(boolean validacao, String msg){
        if(validacao==true){
            EntradaSaida.escreverMensagem(msg);
        }
    }

    public boolean verificarDadoUsuario(String dadoUsuario){ 
        boolean verificar = bd.validarNomeUsuario(dadoUsuario);
        if(verificar == false){
            EntradaSaida.escreverMensagem("Dados inválidos!");
        }
        return verificar;
    }

    public boolean verificarSenhaUsuario(String senha, String nomeEmailCpf){ 
        boolean verificar = bd.validarSenhaUsuario(senha,nomeEmailCpf);
        if(verificar == true){
            EntradaSaida.escreverMensagem("Senha incorreta!");
        }
        return verificar;
    }

    public static boolean verificarAdmin(String nomeEmailCpf, String senhaUsuario){
        boolean verificar=false;
        if(nomeEmailCpf.equals("admin") && senhaUsuario.equals("admin")) verificar=true;
        return verificar;

    }


    public static boolean verificarExistenciaId(int id, ArrayList<ProdutoTroca> listaProdutos){
        boolean verificador = false;
        for(ProdutoTroca pt : listaProdutos){  
            if(pt.getId() == id){
                verificador = true;
            }
        }
        return verificador;
    }

    public static boolean validarSenha(String senha, String senhaReescrita) {
        boolean verificaSenha=false;
        if(senha.equals(senhaReescrita)){
            verificaSenha=true;
        }
        return verificaSenha;
    }

	public static boolean validarErroLogin(boolean verificaDadosUsuario, int contador) {
        boolean validarErroLogin=false;
        if(verificaDadosUsuario==false && contador==3){
            validarErroLogin=true;
        }
		return validarErroLogin;
	}

    public static String formatNumericString(String string, String mask) throws java.text.ParseException {
        javax.swing.text.MaskFormatter mf = new javax.swing.text.MaskFormatter(mask);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(string);
    }

    public static String formartCpf(String cpf) {
        try {
            return formatNumericString(cpf, "###.###.###-##");
        } catch (ParseException e) {
            return null;
        }
    }
}
