package classes;
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

    //Retorna o cpf do usuario
    public String getCpf() {

        return cpf;
    }
    //Retorna a senha do usuario
    public String getSenha() {

        return senha;
    }
    //Retorna o nome do usuario
    public String getNome() {

        return nome;
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
