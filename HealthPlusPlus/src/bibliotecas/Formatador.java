package bibliotecas;

public class Formatador {
    public String formatarTelefone(String telefone){
        String mask = "(##) ####-###";
        
        if(telefone.length() > 8)
            mask = "(##) ####-####";
        
        return mask;
    }
}
