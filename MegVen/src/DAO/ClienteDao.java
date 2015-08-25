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
    
    public List<Cliente> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Cliente> listaCliente = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            //int id = 3;
            org.hibernate.Query q = sessao.createQuery("SELECT CODIGO,NOME,TELEFONE,CEULUAR,EMAIL FROM CLIENTE");
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
