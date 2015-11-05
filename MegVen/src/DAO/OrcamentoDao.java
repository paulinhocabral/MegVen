/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Cliente;
import Entidades.Orcamento;
import Entidades.Secao;
import Entidades.Usuario;
import Util.HibernateUtil;
import Visoes.Login;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class OrcamentoDao {
    
    int us = Secao.getInstance().getUsuario();
    
    public Boolean InsertOrcamento(Orcamento orcamento){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(orcamento);
            t.commit();
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao inserir Orcamento: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Orcamento> pesqView() {
        List<Orcamento> listaOrcamento = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("Select * from PESQORCAMENTO");
            q.addEntity(Orcamento.class);
            List<Orcamento> resultado = q.list();
            for (Orcamento a : resultado) {
               Orcamento orcamento = (Orcamento) a;
               listaOrcamento.add(orcamento);
            }            
            sessao.getTransaction().commit();
            return listaOrcamento;            

        } catch (Exception e) {
            Login.log.info("Erro ao pesquisar Orcamento(pesqView): " + e);
            return null;
        }
    }
    
    public Boolean updateOrcamento(Orcamento orcamento){
        Auditoria auditoria = new Auditoria();
        AuditoriaDao auditoriaDao = new AuditoriaDao();
        Usuario usu = new Usuario();        
        List<Orcamento> listvelho = new ArrayList();
        List<Orcamento> listnovo = new ArrayList();
        Session sessao = null;
        try {
            listvelho  = procuraPorCodigo(orcamento.getCodigo());
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(orcamento);
            t.commit();
            listnovo = procuraPorCodigo(orcamento.getCodigo());
            for (int i = 0; i < listnovo.size(); i++) {
                if (listnovo.get(i).getData() != listvelho.get(i).getData()) {
                    auditoria.setValorAnterior("Campo data: " + listvelho.get(i).getData());
                    auditoria.setValorPosterior("Campo data: " + listnovo.get(i).getData());
                }
                if (listnovo.get(i).getCliente().getCodigo() != listvelho.get(i).getCliente().getCodigo()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo cliente: " + listvelho.get(i).getCliente().getCodigo());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo cliente " + listnovo.get(i).getCliente().getCodigo());
                }                  
            }    
                            
            auditoria.setAcao("Update orcamento: " + orcamento.getCodigo());            
            usu.setCodigo(us);
            auditoria.setUsuario(usu); 
            auditoriaDao.InsertAuditoria(auditoria);
               
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao atualizar Orcamento: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Orcamento> procuraPorCodigo(int cod){
        List<Orcamento> listaOrcamento = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Orcamento where codigo = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Orcamento orcamento = (Orcamento) o;
                listaOrcamento.add(orcamento);
            }
            
            return listaOrcamento;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar Orcamento(procuraPorCodigo): " + he);
            return listaOrcamento;
        }
    }
    
    public List<Orcamento> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Orcamento> listaOrcamento = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Orcamento ");            
            resultado = q.list();

            for (Object o : resultado) {
                Orcamento orcamento = (Orcamento) o;                
                listaOrcamento.add(orcamento);
            }
            
            return listaOrcamento;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar Orcamento(encontrarTudo): " + he);
            return listaOrcamento;
        }        
    }
    public Boolean existeNoBanco(int cod){
        boolean existe = false;
        List<Orcamento> listaOrcamento = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Orcamento where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
                Orcamento orcamento = (Orcamento) o;
                listaOrcamento.add(orcamento);
            }                
        
        if (listaOrcamento.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
    
    public List<Orcamento> pesquisaOrcamento(String data){
        List<Orcamento> listaOrcamento = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createQuery("from Orcamento where nome like '" + data + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Orcamento orcamento = (Orcamento) o;
                listaOrcamento.add(orcamento);
            }
            
            return listaOrcamento;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar Orcamento(pesquisaOrcamento): " + he);
            return listaOrcamento;
        }
    }
}
