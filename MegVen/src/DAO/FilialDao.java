/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Filial;
import Entidades.Secao;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import Visoes.Login;
import org.hibernate.SQLQuery;

/**
 *
 * @author Murilo
 */
public class FilialDao {
    int us = Secao.getInstance().getUsuario();
    
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
            Login.log.info("Erro ao inserir filial: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Filial> pesqView() {
        List<Filial> listaFilial = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("Select * from PESQFILIAL");
            q.addEntity(Filial.class);
            List<Filial> resultado = q.list();
            for (Filial a : resultado) {
               Filial filial = (Filial) a;
               listaFilial.add(filial);
            }            
            sessao.getTransaction().commit();
            return listaFilial;            

        } catch (Exception e) {
            Login.log.info("Erro ao pesquisar filial(pesqView): " + e);
            return null;
        }
    }
    
    public Boolean updateFilial(Filial filial){
        Auditoria auditoria = new Auditoria();
        AuditoriaDao auditoriaDao = new AuditoriaDao();
        Usuario usu = new Usuario();
        List<Filial> listvelho = new ArrayList();
        List<Filial> listnovo = new ArrayList();
        Session sessao = null;
        try {
            listvelho  = procuraPorCodigo(filial.getCodigo());
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(filial);
            t.commit();
            listnovo = procuraPorCodigo(filial.getCodigo());
            for (int i = 0; i < listnovo.size(); i++) {
                if (listnovo.get(i).getNome() != listvelho.get(i).getNome()) {
                    auditoria.setValorAnterior("Campo nome: " + listvelho.get(i).getNome());
                    auditoria.setValorPosterior("Campo nome: " + listnovo.get(i).getNome());
                }
                if (listnovo.get(i).getCidade()!= listvelho.get(i).getCidade()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo cidade: " + listvelho.get(i).getCidade());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo cidade " + listnovo.get(i).getCidade());
                } 
                if (listnovo.get(i).getUsuario().getCodigo() != listvelho.get(i).getUsuario().getCodigo()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo usuario: " + listvelho.get(i).getUsuario().getCodigo());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo usuario: " + listnovo.get(i).getUsuario().getCodigo());
                }  
            }    
                            
            auditoria.setAcao("Update filial: " + filial.getCodigo());            
            usu.setCodigo(us);
            auditoria.setUsuario(usu); 
            auditoriaDao.InsertAuditoria(auditoria);
               
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao atualizar filial: " + he);
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
            Login.log.info("Erro ao pesquisar filial(procuraPorCodigo): " + he);
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

            org.hibernate.Query q = sessao.createQuery("from Filial ");
            //org.hibernate.Query q = sessao.createSQLQuery("SELECT FILIAL.CODIGO,FILIAL.NOME,FILIAL.CIDADE,FILIAL.USUARIO_CODIGO,USUARIO.NOME " +
                                                          //"FROM FILIAL LEFT OUTER JOIN USUARIO ON USUARIO.CODIGO = FILIAL.USUARIO_CODIGO");
            resultado = q.list();

            for (Object o : resultado) {
                Filial filial = (Filial) o;
                //System.out.println(filial.getUsuario().getNome());
                listaFilial.add(filial);
            }
            
            return listaFilial;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar filial(encontrarTudo): " + he);
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
            Login.log.info("Erro ao pesquisar filial(pesquisaFilial): " + he);
            return listaFilial;
        }
    }
}
