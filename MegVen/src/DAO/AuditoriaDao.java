/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Usuario;
import Util.HibernateUtil;
import Visoes.Login;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author Murilo
 */
public class AuditoriaDao {

    static Session sessao;

    public void InsertAuditoria(Auditoria auditoria) {
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    CallableStatement call = connection.prepareCall("{ call InsAuditoria(?,?,?,?) }");
                    call.setString(1, auditoria.getAcao());
                    call.setString(2, auditoria.getValorAnterior());
                    call.setString(3, auditoria.getValorPosterior());
                    call.setInt(4, auditoria.getUsuario().getCodigo());
                    call.execute();
                }
            });

            sessao.getTransaction().commit();
        } catch (Exception e) {            
            Login.log.info("Erro ao inserir auditoria: " + e);
        }
    }

    public List<Auditoria> encontrarTudo() {
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
            Login.log.info("Erro ao pesquisar auditoria(encontrarTudo): " + he);
            return listaAuditoria;
        }
    }

    public List<Auditoria> pesqView() {
        List<Auditoria> listaAuditoria = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("Select * from ConsAuditoria");
            q.addEntity(Auditoria.class);
            List<Auditoria> resultado = q.list();
            for (Auditoria a : resultado) {
               Auditoria auditoria = (Auditoria) a;
               listaAuditoria.add(auditoria);
            }            
            sessao.getTransaction().commit();
            return listaAuditoria;            

        } catch (Exception e) {
            System.out.println("erro ao chamar view: " + e);
            Login.log.info("Erro ao pesquisar auditoria(pesqView): " + e);
            return null;
        }
    }         

    public List findAll() throws Exception {
        List objects = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Query query = sessao.createQuery("from auditoria");
            objects = query.list();
        } catch (HibernateException he) {
            System.out.println("erro ao chamar view: " + he);
            Login.log.info("Erro ao pesquisar auditoria(findAll): " + he);
        } finally {
            sessao.close();
        }
        return objects;
    }

}
