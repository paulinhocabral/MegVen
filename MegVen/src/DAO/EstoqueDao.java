/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Estoque;
import Util.HibernateUtil;
import Visoes.Login;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class EstoqueDao {
    
    public Boolean saidaEstoque(Estoque estoque){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();           
            
            sessao.save(estoque);
            t.commit();            
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao inserir saídaDeEstoque: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
}
