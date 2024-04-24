import java.util.Objects;


//Classe "Usuario" é super classe de aluno, professor e coordenador
public class Usuario {
    private final String cpf;
    private String nome;
    private String senha;

    //Método construtor da super classe
    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    //Métodos de Usuario
    public String getCpf() {

        return cpf;
    }
    public String getSenha() {

        return senha;
    }
    public String getNome() {

        return nome;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    // Equals e HashCode baseados no CPF
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
