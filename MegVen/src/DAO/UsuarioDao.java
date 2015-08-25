/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

/**
 *
 * @author Murilo
 */
public class UsuarioDao {
    public Boolean InsertUsuario(Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(usuario);
            t.commit();
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
}
