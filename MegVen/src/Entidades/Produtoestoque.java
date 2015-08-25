package Entidades;
// Generated 25/08/2015 19:25:23 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Produtoestoque generated by hbm2java
 */
public class Produtoestoque  implements java.io.Serializable {


     private ProdutoestoqueId id;
     private Produtos produtos;
     private double custo;
     private double valorVenda;
     private int qtd;
     private Date dtEntrada;
     private Set orcamentoProdutoestoques = new HashSet(0);

    public Produtoestoque() {
    }

	
    public Produtoestoque(ProdutoestoqueId id, Produtos produtos, double custo, double valorVenda, int qtd, Date dtEntrada) {
        this.id = id;
        this.produtos = produtos;
        this.custo = custo;
        this.valorVenda = valorVenda;
        this.qtd = qtd;
        this.dtEntrada = dtEntrada;
    }
    public Produtoestoque(ProdutoestoqueId id, Produtos produtos, double custo, double valorVenda, int qtd, Date dtEntrada, Set orcamentoProdutoestoques) {
       this.id = id;
       this.produtos = produtos;
       this.custo = custo;
       this.valorVenda = valorVenda;
       this.qtd = qtd;
       this.dtEntrada = dtEntrada;
       this.orcamentoProdutoestoques = orcamentoProdutoestoques;
    }
   
    public ProdutoestoqueId getId() {
        return this.id;
    }
    
    public void setId(ProdutoestoqueId id) {
        this.id = id;
    }
    public Produtos getProdutos() {
        return this.produtos;
    }
    
    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }
    public double getCusto() {
        return this.custo;
    }
    
    public void setCusto(double custo) {
        this.custo = custo;
    }
    public double getValorVenda() {
        return this.valorVenda;
    }
    
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    public int getQtd() {
        return this.qtd;
    }
    
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public Date getDtEntrada() {
        return this.dtEntrada;
    }
    
    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }
    public Set getOrcamentoProdutoestoques() {
        return this.orcamentoProdutoestoques;
    }
    
    public void setOrcamentoProdutoestoques(Set orcamentoProdutoestoques) {
        this.orcamentoProdutoestoques = orcamentoProdutoestoques;
    }




}


