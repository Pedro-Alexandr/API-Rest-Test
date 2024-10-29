package br.com.senac.herois.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "super_heroi")
public class Heroi {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String apelido;

    @Column
    private String superpoder;

    @Column
    private String fraqueza;

    @Column
    private String historiaOrigem;

    @Column
    private Date primeiraAparicao;

    @ManyToOne
    @JoinColumn(name="equipe_id", referencedColumnName = "id")
    private Equipe equipe;

    public String exibirDados() {
        return getId() + getNome() + getApelido() + getSuperpoder() + getFraqueza() + getHistoriaOrigem() + getPrimeiraAparicao() + getEquipe();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSuperpoder() {
        return this.superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public String getFraqueza() {
        return this.fraqueza;
    }

    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }

    public String getHistoriaOrigem() {
        return this.historiaOrigem;
    }

    public void setHistoriaOrigem(String historiaOrigem) {
        this.historiaOrigem = historiaOrigem;
    }

    public Date getPrimeiraAparicao() {
        return this.primeiraAparicao;
    }

    public void setPrimeiraAparicao(Date primeiraAparicao) {
        this.primeiraAparicao = primeiraAparicao;
    }

    public Equipe getEquipe() {
        if (equipe != null) {
            equipe.setHeroi(null);

        }
        return this.equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}