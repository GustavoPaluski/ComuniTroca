import java.util.ArrayList;

public class BancoDados {
    
    ArrayList<Conta> contas = new ArrayList<Conta>();

	public void salvarDadosCadastrais(Conta c){
        this.contas.add(c);
	}

    public boolean verificarLogin(String nomeUsuario, String senha){
        boolean verificar=false;
        for(Conta c:this.contas){
            if(c.nomeUsuario.equals(nomeUsuario) && c.senha.equals(senha)){
                verificar=true;
            }
        }
        return verificar;
    }

}
