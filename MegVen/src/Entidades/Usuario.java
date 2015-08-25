package Entidades;
// Generated 24/08/2015 22:08:45 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer codigo;
     private String nome;
     private String email;
     private int nivelAcesso;
     private boolean ativo;
     private String telefone;
     private Set filials = new HashSet(0);
     private Set auditorias = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nome, String email, int nivelAcesso, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
        this.ativo = ativo;
    }
    public Usuario(String nome, String email, int nivelAcesso, boolean ativo, String telefone, Set filials, Set auditorias) {
       this.nome = nome;
       this.email = email;
       this.nivelAcesso = nivelAcesso;
       this.ativo = ativo;
       this.telefone = telefone;
       this.filials = filials;
       this.auditorias = auditorias;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getNivelAcesso() {
        return this.nivelAcesso;
    }
    
    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    public boolean isAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Set getFilials() {
        return this.filials;
    }
    
    public void setFilials(Set filials) {
        this.filials = filials;
    }
    public Set getAuditorias() {
        return this.auditorias;
    }
    
    public void setAuditorias(Set auditorias) {
        this.auditorias = auditorias;
    }




}


