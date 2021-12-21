package com.example.accessingdata;

//wendel
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String status;
    private String local;
    private String iniPrevisto;
    private String iniCirurgia;
    private String fimCirurgia;
    private String saidaPrev;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
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
    public String getIniPrevisto() {
        return iniPrevisto;
    }
    public void setIniPrevisto(String iniPrevisto) {
        this.iniPrevisto = iniPrevisto;
    }
    public String getIniCirurgia() {
        return iniCirurgia;
    }
    public void setIniCirurgia(String iniCirurgia) {
        this.iniCirurgia = iniCirurgia;
    }
    public String getFimCirurgia() {
        return fimCirurgia;
    }
    public void setFimCirurgia(String fimCirurgia) {
        this.fimCirurgia = fimCirurgia;
    }
    public String getSaidaPrev() {
        return saidaPrev;
    }
    public void setSaidaPrev(String saidaPrev) {
        this.saidaPrev = saidaPrev;
    }
    
}
   
  
