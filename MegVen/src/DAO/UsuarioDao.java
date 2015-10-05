/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Secao;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import Visoes.Login;

/**
 *
 * @author Murilo
 */
public class UsuarioDao {
    int us = Secao.getInstance().getUsuario();
    
    public Boolean InsertUsuario(Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(usuario);
            t.commit();
            Login.log.info("Usuário: " + Secao.getInstance().getUsuario() + " inseriu o usuário: " + usuario.getCodigo() + "," + usuario.getNome()
                           + "," + usuario.getEmail()+ "," + usuario.getNivelAcesso()+ "," +usuario.isAtivo()+ "," +usuario.getTelefone());
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }       
    
    public List<Usuario> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Usuario> listaUsuario = new ArrayList();
                
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("FROM Usuario");
            resultado = q.list();

            for (Object o : resultado) {
                Usuario usuario = (Usuario) o;
                listaUsuario.add(usuario);
            }
            
            return listaUsuario;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaUsuario;
        }
        
    }
            
    public Boolean updateUsuario(Usuario usuario){
        Auditoria auditoria = new Auditoria();
        AuditoriaDao auditoriaDao = new AuditoriaDao();
        Usuario usu = new Usuario();
        List<Usuario> listvelho = new ArrayList();
        List<Usuario> listnovo = new ArrayList();
        Session sessao = null;
        try {
            listvelho  = pesquisaPorCodigo(usuario.getCodigo());
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(usuario);
            t.commit();
            listnovo = pesquisaPorCodigo(usuario.getCodigo());
            for (int i = 0; i < listnovo.size(); i++) {
                if (listnovo.get(i).getNome() != listvelho.get(i).getNome()) {
                    auditoria.setValorAnterior("Campo nome: " + listvelho.get(i).getNome());
                    auditoria.setValorPosterior("Campo nome: " + listnovo.get(i).getNome());
                } else
                if (listnovo.get(i).getEmail() != listvelho.get(i).getEmail()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo email: " + listvelho.get(i).getEmail());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo email: " + listnovo.get(i).getEmail());
                } else
                if (listnovo.get(i).getNivelAcesso() != listvelho.get(i).getNivelAcesso()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo nivelAcesso: " + listvelho.get(i).getNivelAcesso());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo nivelAcesso: " + listnovo.get(i).getNivelAcesso());
                } else 
                if (listnovo.get(i).isAtivo() != listvelho.get(i).isAtivo()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo ativo: " + listvelho.get(i).isAtivo());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo ativo: " + listnovo.get(i).isAtivo());
                } else
                if (listnovo.get(i).getTelefone() != listvelho.get(i).getTelefone()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo telefone: " + listvelho.get(i).getTelefone());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo telefone: " + listnovo.get(i).getTelefone());
                }
            }
            
            auditoria.setAcao("Update usuario");            
            usu.setCodigo(us);
            auditoria.setUsuario(usu); 
            auditoriaDao.InsertAuditoria(auditoria);
            
            Login.log.info("Usuário: " + Secao.getInstance().getUsuario() + " atualizou o usuário: " + usuario.getCodigo() + "," + usuario.getNome()
                           + "," + usuario.getEmail()+ "," + usuario.getNivelAcesso()+ "," +usuario.isAtivo()+ "," +usuario.getTelefone());
            
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public Boolean existeNoBanco(int cod){
        boolean existe = false;
        List<Usuario> listaUsuario = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Usuario where codigo = " + cod);
        resultado = q.list();        
        
        for (Object o : resultado) {
                Usuario usuario = (Usuario) o;
                listaUsuario.add(usuario);
            }                
        
        if (listaUsuario.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
    
    public Usuario pesqUsuario(int cod){
        Usuario usuario = new Usuario();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario where codigo = " + cod);
            resultado = q.list();                     
            usuario.setCodigo(Integer.parseInt(resultado.get(0).toString()));
            usuario.setNome(resultado.get(1).toString());
            usuario.setEmail(resultado.get(2).toString());
            usuario.setNivelAcesso(Integer.parseInt(resultado.get(3).toString()));
            usuario.setAtivo(Boolean.parseBoolean(resultado.get(4).toString()));
            usuario.setTelefone(resultado.get(5).toString());
            usuario.setSenha(resultado.get(6).toString());                                
            
            return usuario;

        } catch (HibernateException he) {
            he.printStackTrace();
            return usuario;
        }
        
    }
    
    public List<Usuario> pesquisaUsuario(String nome){
        List<Usuario> listaUsuario = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createQuery("from Usuario where nome like '" + nome + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Usuario usuario = (Usuario) o;
                listaUsuario.add(usuario);
            }
            
            return listaUsuario;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaUsuario;
        }
    }
    
    public List<Usuario> pesquisaPorCodigo(int cod){
        //boolean existe = false;
        List<Usuario> listaUsuario = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Usuario where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
            Usuario usuario = (Usuario) o;
            listaUsuario.add(usuario);
        }                        
        
        return listaUsuario;
    }
    
}
