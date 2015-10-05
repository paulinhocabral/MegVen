/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Produtos;
import Entidades.Secao;
import Util.HibernateUtil;
import Visoes.Login;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class ProdutoDao {
    
    int usuario = Secao.getInstance().getUsuario();
    
    public Boolean InsertProdutos(Produtos produto){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();            
            sessao.save(produto);
            t.commit();
            Login.log.info("Usuário: " + usuario + " inseriu o cliente: " + produto.getCodigo() + "," + produto.getDescricao()+ "," + produto.getMarca());                                                         
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public Boolean updateProdutos(Produtos produto){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(produto);
            t.commit();
            Login.log.info("Usuário: " + usuario + " fez o update do cliente: " + produto.getCodigo() + "," + produto.getDescricao()+ "," + produto.getMarca());
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Produtos> procuraPorCodigo(int cod){
        List<Produtos> listaProduto = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Produtos where codigo = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProduto.add(produtos);
            }
            
            return listaProduto;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaProduto;
        }
    }
    
    public List<Produtos> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Produtos> listaProdutos = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("FROM Produtos");
            resultado = q.list();

            for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProdutos.add(produtos);
            }
            
            return listaProdutos;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaProdutos;
        }        
    }
    
    public Boolean existeNoBanco(int cod){
        boolean existe = false;
        List<Produtos> listaProdutos = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Produtos where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProdutos.add(produtos);
            }                
        
        if (listaProdutos.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
    
    public List<Produtos> pesquisaProdutos(String nome){
        List<Produtos> listaProdutos = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createQuery("from Produtos where Marca like '" + nome + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProdutos.add(produtos);
            }
            
            return listaProdutos;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaProdutos;
        }
    }
}
