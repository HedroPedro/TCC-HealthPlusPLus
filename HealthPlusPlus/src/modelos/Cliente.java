package modelos;

public class Cliente {
    private int codigo;
    private String nome;
    private String telefone;
    private String endereco;
    private String CPF;
    
    public Cliente(){}

    public Cliente(int codigo, String nome, String telefone, String endereco, String CPF) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", CPF=" + CPF + '}';
    }
    
    public Cliente(String nome, String telefone, String endereco, String CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.CPF = CPF;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public boolean estaCertoCPF(){
            String[] cpfTemp = CPF.replace('.', ' ').replace('-', ' ').split(" ");
            char[] cpfTeste = (cpfTemp[0] + cpfTemp[1]+ cpfTemp[2] + cpfTemp[3]).toCharArray();
            int[] resultados = {0, 0};
            System.out.println(cpfTeste.length);
            if(cpfTeste[0] == cpfTeste[1] && cpfTeste[1] == cpfTeste[2] && cpfTeste[2] == cpfTeste[3] 
                    && cpfTeste[3] == cpfTeste[4] && cpfTeste[4] == cpfTeste[5] && cpfTeste[5] == cpfTeste[6]
                    && cpfTeste[6] == cpfTeste[7] && cpfTeste[7] == cpfTeste[8] && cpfTeste[8] == cpfTeste[9]
                    && cpfTeste[9] == cpfTeste[10])
                return false;
                        else{
                        int soma = 0;
                    for(int i = 10; i > 1; i--){
                        soma += (Integer.parseInt(String.valueOf(cpfTeste[10-i])) * i);
                    }
                    int resto1 = (soma * 10) % 11;
                    if(resto1 == 10)
                        resultados[0] = 0;
                    else
                        resultados[0] = resto1;
                    int soma1 = 0;
                    for(int i = 11; i > 1; i--){
                        soma1 += (Integer.parseInt(String.valueOf(cpfTeste[11-i])) * i);
                    }
                    int resto2 = (soma1 * 10) % 11;
                    if(resto2 == 10)
                        resultados[1] = 0;
                    else
                        resultados[1] = resto2;
            }
            boolean confirmaCPF = (String.valueOf(resultados[0]).equals(String.valueOf(cpfTeste[9]))) && (String.valueOf(resultados[1]).equals(String.valueOf(cpfTeste[10])));
        return confirmaCPF;
    }
}
