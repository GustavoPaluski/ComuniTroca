import java.util.ArrayList;

public class BancoDados {
    
    ArrayList<Conta> contas = new ArrayList<Conta>();

	public void salvarDadosCadastrais(Conta c){
        this.contas.add(c);
	}

}
