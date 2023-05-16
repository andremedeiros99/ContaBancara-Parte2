public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(){
        nome = null;
        cpf = null;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
