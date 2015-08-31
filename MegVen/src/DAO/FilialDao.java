/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Filial;
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
public class FilialDao {
    
    public Boolean InsertFilial(Filial filial){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(filial);
            t.commit();
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public Boolean updateFilial(Filial filial){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(filial);
            t.commit();
            
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Filial> procuraPorCodigo(int cod){
        List<Filial> listaFilial = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Filial where codigo = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Filial filial = (Filial) o;
                listaFilial.add(filial);
            }
            
            return listaFilial;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaFilial;
        }
    }
    
    public List<Filial> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Filial> listaFilial = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Filial");
            resultado = q.list();

            for (Object o : resultado) {
                Filial filial = (Filial) o;
                listaFilial.add(filial);
            }
            
            return listaFilial;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaFilial;
        }
        
    }
    
    public Boolean existeNoBanco(int cod){
        boolean existe = false;
        List<Filial> listaFilial = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Filial where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
                Filial filial = (Filial) o;
                listaFilial.add(filial);
            }                
        
        if (listaFilial.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
            
    public List<Filial> pesquisaFilial(String nome){
        List<Filial> listaFilial = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createQuery("from Filial where nome like '" + nome + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Filial filial = (Filial) o;
                listaFilial.add(filial);
            }
            
            return listaFilial;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaFilial;
        }
    }
}
