package Entidades;
// Generated 12/10/2015 12:43:43 by Hibernate Tools 4.3.1



/**
 * ProdutoestoqueId generated by hbm2java
 */
public class ProdutoestoqueId  implements java.io.Serializable {


     private int produtosCodigo;
     private int codigoEstoque;

    public ProdutoestoqueId() {
    }

    public ProdutoestoqueId(int produtosCodigo, int codigoEstoque) {
       this.produtosCodigo = produtosCodigo;
       this.codigoEstoque = codigoEstoque;
    }
   
    public int getProdutosCodigo() {
        return this.produtosCodigo;
    }
    
    public void setProdutosCodigo(int produtosCodigo) {
        this.produtosCodigo = produtosCodigo;
    }
    public int getCodigoEstoque() {
        return this.codigoEstoque;
    }
    
    public void setCodigoEstoque(int codigoEstoque) {
        this.codigoEstoque = codigoEstoque;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProdutoestoqueId) ) return false;
		 ProdutoestoqueId castOther = ( ProdutoestoqueId ) other; 
         
		 return (this.getProdutosCodigo()==castOther.getProdutosCodigo())
 && (this.getCodigoEstoque()==castOther.getCodigoEstoque());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getProdutosCodigo();
         result = 37 * result + this.getCodigoEstoque();
         return result;
   }   


}


