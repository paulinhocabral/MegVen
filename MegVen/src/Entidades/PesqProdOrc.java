/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Murilo
 */
public class PesqProdOrc {

    private int produto;
    private int codEstoque;
    private String descProd;
    private String marcaProd;

    public PesqProdOrc(int produto, int codEstoque, String descProd, String marcaProd) {
        this.produto = produto;
        this.codEstoque = codEstoque;
        this.descProd = descProd;
        this.marcaProd = marcaProd;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCodEstoque() {
        return codEstoque;
    }

    public void setCodEstoque(int codEstoque) {
        this.codEstoque = codEstoque;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public String getMarcaProd() {
        return marcaProd;
    }

    public void setMarcaProd(String marcaProd) {
        this.marcaProd = marcaProd;
    }
    
    
    
    
}
