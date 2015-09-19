/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
            
    public Boolean updateCliente(Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(usuario);
            t.commit();
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
    
/*    public Usuario pesqUsuario(int cod){
        List<Usuario> listaUsuario = new ArrayList();
        Usuario usu = new Usuario();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Usuario where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
            Usuario usuario = (Usuario) o;
            listaUsuario.add(usuario);
        }
        
        //listaUsuario.
    } */
}
