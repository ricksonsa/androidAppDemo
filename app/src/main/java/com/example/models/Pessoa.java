package com.example.models;

import java.util.List;

public class Pessoa {
    private String nome;
    private String sobreNome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public Pessoa(String nome, String sobreNome) {
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public Pessoa CriarPessoa(String dados) {
        return new Pessoa(dados.split(" ")[0], dados.split(" ")[1]);
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobreNome;
    }

    public static String[] serializePeople(List<Pessoa> pessoas) {
        String[] pessoasSerialized = new String[pessoas.size()];

       for(int i=0;i<pessoas.size();i++) {
           pessoasSerialized[i] = pessoas.get(i).toString();
       }

       return pessoasSerialized;
    }
}
