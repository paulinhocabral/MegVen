package Entidades;
// Generated 24/08/2015 21:06:40 by Hibernate Tools 4.3.1



/**
 * Filial generated by hbm2java
 */
public class Filial  implements java.io.Serializable {


     private int codigo;
     private Usuario usuario;
     private String nome;
     private String cidade;

    public Filial() {
    }

    public Filial(int codigo, Usuario usuario, String nome, String cidade) {
       this.codigo = codigo;
       this.usuario = usuario;
       this.nome = nome;
       this.cidade = cidade;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }




}


