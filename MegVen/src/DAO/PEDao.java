/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Produtoestoque;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class PEDao {
    
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
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public Boolean updatePE(Produtoestoque pe){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(pe);
            t.commit();
            
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
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

            org.hibernate.Query q = sessao.createQuery("from produtoestoque where Produtos_Codigo = " + prod + " and CodigoEstoque = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Produtoestoque pe = (Produtoestoque) o;
                listaPe.add(pe);
            }
            
            return listaPe;

        } catch (HibernateException he) {
            he.printStackTrace();
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
            return listaPe;
        }        
    }
    
    public Boolean existeNoBanco(int prod, int cod){
        boolean existe = false;
        List<Produtoestoque> listaPE = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createSQLQuery("from produtoestoque where Produtos_Codigo = " + prod + " and CodigoEstoque = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
                Produtoestoque pe = (Produtoestoque) o;
                listaPE.add(pe);
            }                
        
        if (listaPE.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
    
    public List<Produtoestoque> pesquisaPe(String marca){
        List<Produtoestoque> listaPe = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createSQLQuery("SELECT PE.PRODUTOS_CODIGO, PE.CODIGOESTOQUE, PRODUTOS.DESCRICAO, PRODUTOS.MARCA, PE.CUSTO, PE.VALORVENDA," +
                                                          "PE.QTD, PE.DTENTRADA " +
                                                          "FROM PRODUTOESTOQUE PE LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = PE.PRODUTOS_CODIGO " +
                                                          "WHERE PRODUTOS.MARCA LIKE '%" + marca + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Produtoestoque pe = (Produtoestoque) o;
                listaPe.add(pe);
            }
            
            return listaPe;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaPe;
        }
    }
    
}
