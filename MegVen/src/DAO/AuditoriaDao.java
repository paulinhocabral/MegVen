/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
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
public class AuditoriaDao {
    
    public Boolean InsertAuditoria(Auditoria auditoria){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            //sessao.save(auditoria);            
            //t.
            sessao.createQuery("CALL InsAuditoria(" + auditoria.getAcao() + "," + auditoria.getValorAnterior() + "," + 
                                auditoria.getValorPosterior() + "," + auditoria.getUsuario() +")");            
            
            return true;                 

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Auditoria> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Auditoria> listaAuditoria = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("FROM Auditoria");
            resultado = q.list();

            for (Object o : resultado) {
                Auditoria auditoria = (Auditoria) o;
                listaAuditoria.add(auditoria);
            }
            
            return listaAuditoria;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaAuditoria;
        }
        
    }
}
