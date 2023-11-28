import java.util.ArrayList;

public class BancoDados {
    
    ArrayList<Conta> ListaDeContas= new ArrayList<Conta>();

	public void salvarDadosCadastrais(Conta c){
        this.ListaDeContas.add(c);
	}

}
