package com.example.accessingdata;

import java.sql.Time;

//wendel
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String email;
    private String status;
    private String local;
    private String inicioPrevisto;
    private String inicioCirurgia;
    private String fimdaCirurgia;
    private String saidaPrevista;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getInicioPrevisto() {
        return inicioPrevisto;
    }

    public void setInicioPrevisto(String inicioPrevisto) {
        this.inicioPrevisto = inicioPrevisto;
    }

    public String getInicioCirurgia() {
        return inicioCirurgia;
    }

    public void setInicioCirurgia(String inicioCirurgia) {
        this.inicioCirurgia = inicioCirurgia;
    }

    public String getFimdaCirurgia() {
        return fimdaCirurgia;
    }

    public void setFimdaCirurgia(String fimdaCirurgia) {
        this.fimdaCirurgia = fimdaCirurgia;
    }

    public String getSaidaPrevista() {
        return saidaPrevista;
    }

    public void setSaidaPrevista(String saidaPrevista) {
        this.saidaPrevista = saidaPrevista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.equals("")) {
            throw new IllegalArgumentException("Erro no preenchimento do nome.");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        if (email.equals("")) {
            throw new IllegalArgumentException("Erro no preenchimento do email.");
        }

        this.email = email;
    }

}