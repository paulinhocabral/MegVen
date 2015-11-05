/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Cliente;
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
public class ClienteDao {
    
    AuditoriaDao auditoriaDao = new AuditoriaDao();
    Auditoria auditoria = new Auditoria();
    int usuario = Secao.getInstance().getUsuario();
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usu = new Usuario();
        
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
            Login.log.info("Erro ao inserir cliente: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public Boolean updateCliente(Cliente cliente){
        Session sessao = null;
        List<Cliente> listvelho = new ArrayList();
        List<Cliente> listnovo = new ArrayList();
        
        Usuario usu = new Usuario();
        try {           
            listvelho  = procuraPorCodigo(cliente.getCodigo());            
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(cliente);
            t.commit();
                                    
            listnovo = procuraPorCodigo(cliente.getCodigo());
            for (int i = 0; i < listnovo.size(); i++) {                
                if (listnovo.get(i).getNome() != listvelho.get(i).getNome()) {
                    auditoria.setValorAnterior("Campo nome: " + listvelho.get(i).getNome());
                    auditoria.setValorPosterior("Campo nome: " + listnovo.get(i).getNome());
                }  
                if (listnovo.get(i).getTelefone() != listvelho.get(i).getTelefone()) { 
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo telefone: " + listvelho.get(i).getTelefone());
                    auditoria.setValorPosterior(auditoria.getValorPosterior()+ " Campo telefone: " + listnovo.get(i).getTelefone());
                } 
                if (listnovo.get(i).getCeuluar()!= listvelho.get(i).getCeuluar()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo celular: " + listvelho.get(i).getCeuluar());
                    auditoria.setValorPosterior(auditoria.getValorAnterior() +" Campo celular: " + listnovo.get(i).getCeuluar());
                } 
                if (listnovo.get(i).getEmail()!= listvelho.get(i).getEmail()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo email: " + listvelho.get(i).getEmail());
                    auditoria.setValorPosterior(auditoria.getValorAnterior() + " Campo email: " + listnovo.get(i).getEmail());
                }                                        
            }
            
            auditoria.setAcao("Update cliente: " + cliente.getCodigo());            
            usu.setCodigo(usuario);
            auditoria.setUsuario(usu); 
            auditoriaDao.InsertAuditoria(auditoria);
                        
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao atualizar o cliente: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Cliente> pesqView() {
        List<Cliente> listaCli = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("Select * from PESQCLI");
            q.addEntity(Cliente.class);
            List<Cliente> resultado = q.list();
            for (Cliente a : resultado) {
               Cliente cliente = (Cliente) a;
               listaCli.add(cliente);
            }            
            sessao.getTransaction().commit();
            return listaCli;            

        } catch (Exception e) {            
            Login.log.info("Erro ao chamar view: " + e);
            return null;
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
            Login.log.info("Erro ao pesquisar(procuraPorCodigo) cliente: " + he);
            return listaCliente;
        }
    }
    
/*    public List<Cliente> encontraPorCodigo(int cod){
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
    } */
    
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
            Login.log.info("Erro ao pesquisar(encontrarTudo) cliente: " + he);
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
            Login.log.info("Erro ao pesquisar(pesquisaCliente) cliente: " + he);
            return listaCliente;
        }
    }       
                
    
}
