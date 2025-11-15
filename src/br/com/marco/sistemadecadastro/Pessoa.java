package br.com.marco.sistemadecadastro;

public class Pessoa {
    private int id;
    private String nome;
    private String email;

    public Pessoa(int id, String nome, String email) {
        this.id = id;
        setNome(nome);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
