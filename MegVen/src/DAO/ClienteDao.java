/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

/**
 *
 * @author Murilo
 */
public class ClienteDao {
    
    public Boolean InsertCliente(Cliente cliente){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(cliente);
            t.commit();
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public Boolean updateCliente(Cliente cliente){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(cliente);
            t.commit();
            
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Cliente> procuraPorCodigo(int cod){
        List<Cliente> listaCliente = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Cliente where codigo = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Cliente cliente = (Cliente) o;
                listaCliente.add(cliente);
            }
            
            return listaCliente;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaCliente;
        }
    }
    
    public List<Cliente> encontraPorCodigo(int cod){
        List<Cliente> listaCliente = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Cliente where codigo = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Cliente cliente = (Cliente) o;
                listaCliente.add(cliente);
            }
            
            return listaCliente;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaCliente;
        }
    }
    
    public List<Cliente> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Cliente> listaCliente = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("FROM Cliente");
            resultado = q.list();

            for (Object o : resultado) {
                Cliente cliente = (Cliente) o;
                listaCliente.add(cliente);
            }
            
            return listaCliente;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaCliente;
        }
        
    }
    
    public Boolean existeNoBanco(int cod){
        boolean existe = false;
        List<Cliente> listaCliente = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Cliente where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
                Cliente cliente = (Cliente) o;
                listaCliente.add(cliente);
            }                
        
        if (listaCliente.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
            
    public List<Cliente> pesquisaCliente(String nome){
        List<Cliente> listaCliente = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createQuery("from Cliente where nome like '" + nome + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Cliente cliente = (Cliente) o;
                listaCliente.add(cliente);
            }
            
            return listaCliente;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaCliente;
        }
    }       
                
    
}
