package modelador;

import java.security.SecureRandom;


public class GeradorSenha {
    
    public static String gerarSenha(int len){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom sr = new SecureRandom(chars.getBytes());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            int randomIndex = sr.nextInt(chars.length());
            
            sb.append(chars.charAt(randomIndex));
        }
        
        return sb.toString();
    }
    
}
