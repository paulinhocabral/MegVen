/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Produtoestoque;
import Entidades.Secao;
import Entidades.Usuario;
import Util.HibernateUtil;
import Visoes.Login;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class PEDao {
    
    AuditoriaDao auditoriaDao = new AuditoriaDao();
    Auditoria auditoria = new Auditoria();
    int usuario = Secao.getInstance().getUsuario();
    
    public Boolean InsertPE(Produtoestoque pe){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(pe);
            t.commit();
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao inserir produtoestoque: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }        
    
    public Boolean updatePE(Produtoestoque pe){
        List<Produtoestoque> listvelho = new ArrayList();
        List<Produtoestoque> listnovo = new ArrayList();
        Session sessao = null;
        Usuario usu = new Usuario();
        try {
            listvelho  = procuraPorCodigo(pe.getId().getProdutosCodigo(), pe.getId().getCodigoEstoque());
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(pe);
            t.commit();
            
            listnovo = procuraPorCodigo(pe.getId().getProdutosCodigo(), pe.getId().getCodigoEstoque());
            for (int i = 0; i < listnovo.size(); i++) {
                if (listnovo.get(i).getCusto() != listvelho.get(i).getCusto()) {
                    auditoria.setValorAnterior("Campo custo: " + listvelho.get(i).getCusto());
                    auditoria.setValorPosterior("Campo custo: " + listnovo.get(i).getCusto());
                }
                if (listnovo.get(i).getValorVenda()!= listvelho.get(i).getValorVenda()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " " +"Campo valorVenda: " + listvelho.get(i).getValorVenda());
                    auditoria.setValorPosterior(auditoria.getValorPosterior()+ " " +"Campo valorVenda: " + listnovo.get(i).getValorVenda());
                }
                if (listnovo.get(i).getQtd()!= listvelho.get(i).getQtd()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " " +"Campo qtd: " + listvelho.get(i).getQtd());
                    auditoria.setValorPosterior(auditoria.getValorPosterior()+ " " +"Campo qtd: " + listnovo.get(i).getQtd());
                }
                if (listnovo.get(i).getDtEntrada()!= listvelho.get(i).getDtEntrada()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " " + "Campo dtEntrada: " + listvelho.get(i).getDtEntrada());
                    auditoria.setValorPosterior(auditoria.getValorPosterior()+ " " + "Campo dtEntrada: " + listnovo.get(i).getDtEntrada());
                }
                auditoria.setAcao("Update produtoEstoque: " + pe.getId().getProdutosCodigo() + " " + pe.getId().getCodigoEstoque());            
                usu.setCodigo(usuario);
                auditoria.setUsuario(usu); 
                auditoriaDao.InsertAuditoria(auditoria);                
            }                        
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao atualizar produtoestoque: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Produtoestoque> procuraPorCodigo(int prod, int cod){
        List<Produtoestoque> listaPe = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Produtoestoque where Produtos_Codigo = " + prod + " and CodigoEstoque = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Produtoestoque pe = (Produtoestoque) o;
                listaPe.add(pe);
            }
            
            return listaPe;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar produtoestoque(procuraPorCodigo): " + he);
            return listaPe;
        }
    }
    
    public List<Produtoestoque> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Produtoestoque> listaPe = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from produtoestoque ");
            //org.hibernate.Query q = sessao.createSQLQuery("SELECT FILIAL.CODIGO,FILIAL.NOME,FILIAL.CIDADE,FILIAL.USUARIO_CODIGO,USUARIO.NOME " +
                                                          //"FROM FILIAL LEFT OUTER JOIN USUARIO ON USUARIO.CODIGO = FILIAL.USUARIO_CODIGO");
            resultado = q.list();

            for (Object o : resultado) {
                Produtoestoque pe = (Produtoestoque) o;
                //System.out.println(filial.getUsuario().getNome());
                listaPe.add(pe);
            }
            
            return listaPe;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar produtoestoque(encontrarTudo): " + he);
            return listaPe;
        }        
    }
    
    public List<Produtoestoque> pesqView() {
        List<Produtoestoque> listaPE = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("Select * from PESQPE");
            q.addEntity(Produtoestoque.class);
            List<Produtoestoque> resultado = q.list();
            for (Produtoestoque a : resultado) {
               Produtoestoque pe = (Produtoestoque) a;
               listaPE.add(pe);
            }            
            sessao.getTransaction().commit();
            return listaPE;            

        } catch (Exception e) {
            System.out.println("erro ao chamar view: " + e);
            Login.log.info("Erro ao pesquisar produtoestoque(pesqView): " + e);
            return null;
        }
    }
    
    public int pesqQtdProd(int cod) {
        int qtd  = 0;
        int qtd2 = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            /*SQLQuery q = sessao.createSQLQuery("SELECT (SUM(PE.QTD) - (SELECT SUM(QTD) FROM ESTOQUE WHERE PRODUTO = PRODUTOS.CODIGO)) AS QTD " + 
                                               "FROM PRODUTOESTOQUE PE " + 
                                               "LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = PE.PRODUTOS_CODIGO " + 
                                               "LEFT OUTER JOIN ESTOQUE ON ESTOQUE.PRODUTO = PRODUTOS.CODIGO " +
                                               "WHERE PRODUTOS.CODIGO = " + cod); */
            
            SQLQuery q = sessao.createSQLQuery("SELECT SUM(PE.QTD) AS QTD FROM PRODUTOESTOQUE PE " +
                                               "WHERE PE.PRODUTOS_CODIGO = " + cod);
            
            if (q.list().size() > 0) {                
                qtd = Integer.parseInt(q.list().get(qtd).toString());
            }
            
            SQLQuery q1 = sessao.createSQLQuery("SELECT SUM(QTD) FROM ESTOQUE WHERE PRODUTO = " + cod);
            if (q1.list().size() > 0) {                
                qtd2 = Integer.parseInt(q1.list().get(0).toString());
            }
            
            sessao.getTransaction().commit();
            return qtd - qtd2;

        } catch (Exception e) {
            System.out.println("erro ao chamar view: " + e);
            Login.log.info("Erro ao pesquisar quantidade de produtos(pesqQtdProd): " + e);
        }
        return qtd - qtd2;
    }
    
    public List<Produtoestoque> pesqDesc(String desc){
        List<Produtoestoque> listaPe = new ArrayList();
        //List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            SQLQuery q = sessao.createSQLQuery(
                    "SELECT PE.PRODUTOS_CODIGO, PRODUTOS.DESCRICAO, PE.CODIGOESTOQUE, PE.CUSTO, PE.VALORVENDA, PE.QTD, PE.DTENTRADA, PRODUTOS.MARCA " +
                    "FROM PRODUTOESTOQUE PE " +
                    "LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = PE.PRODUTOS_CODIGO " +
                    "WHERE PRODUTOS.DESCRICAO LIKE '%" + desc + "%' " +
                    "ORDER BY PE.CODIGOESTOQUE");
            q.addEntity(Produtoestoque.class);
            List<Produtoestoque> resultado = q.list();
            
            for (Object o : resultado) {           
                Produtoestoque pe = (Produtoestoque) o;
                listaPe.add(pe);
            }
            sessao.getTransaction().commit();
            return listaPe;                    

        } catch (Exception e) {
            System.out.println("erro ao chamar view: " + e);            
            Login.log.info("Erro ao pesquisar produtoestoque(pesqDesc): " + e);
        }        
        return listaPe;
    }
    
    public Boolean existeNoBanco(int prod, int cod){
        boolean existe = false;
        List<Produtoestoque> listaPE = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createSQLQuery("SELECT * from Produtoestoque" + 
                                " LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = PRODUTOESTOQUE.PRODUTOS_CODIGO" +
                                " where Produtos_Codigo = " + prod + " and CodigoEstoque = " + cod);                
        resultado = q.list();                                        
        
        if (resultado.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
    
    /*public List<PesqProdOrc> pesqPeOrc(){
        boolean existe = false;
        List<PesqProdOrc> listaPE = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createSQLQuery("SELECT PE.PRODUTOS_CODIGO,PE.CODIGOESTOQUE,PRODUTOS.DESCRICAO,PRODUTOS.MARCA " + 
                                "FROM PRODUTOESTOQUE PE " +
                                "LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = PE.PRODUTOS_CODIGO");                
        resultado = q.list();
        for (Object o : resultado) {
                PesqProdOrc pe = (PesqProdOrc) o;
                listaPE.add(pe);
            }
        
        return listaPE;       
    }*/
    
    public List<Produtoestoque> pesquisaPe(String marca){
        List<Produtoestoque> listaPe = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createSQLQuery(
                    "SELECT PE.PRODUTOS_CODIGO, PE.CODIGOESTOQUE, PRODUTOS.DESCRICAO, PRODUTOS.MARCA, PE.CUSTO, PE.VALORVENDA," +
                    " PE.QTD, PE.DTENTRADA " +
                    " FROM PRODUTOESTOQUE PE LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = PE.PRODUTOS_CODIGO " +
                    " WHERE PRODUTOS.MARCA LIKE '%" + marca + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Produtoestoque pe = (Produtoestoque) o;
                listaPe.add(pe);
            }
            
            return listaPe;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar produtoestoque(pesquisaPe): " + he);
            return listaPe;
        }
    }
    
    public int novo (int prod){
        int novo = 0;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            //List resultado = null;
            org.hibernate.Query q = sessao.createSQLQuery("SELECT COALESCE(MAX(CODIGOESTOQUE))" + 
                                    " FROM PRODUTOESTOQUE WHERE Produtos_Codigo = " + prod);
            if (q.uniqueResult() != null) {
                novo = Integer.parseInt(q.uniqueResult().toString()) + 1;
            } else{
                novo = 1;
            }            
                                    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro: " + e);
            Login.log.info("Erro btNovo produtoestoque " + e);
        }        
        return novo;                        
    }        
    
}
