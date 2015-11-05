/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.Produtos;
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
public class ProdutoDao {
    
    int usuario = Secao.getInstance().getUsuario();
    
    public Boolean InsertProdutos(Produtos produto){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();            
            sessao.save(produto);
            t.commit();
            Login.log.info("Usuário: " + usuario + " inseriu o cliente: " + produto.getCodigo() + "," + produto.getDescricao()+ "," + produto.getMarca());                                                         
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao inserir produto: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Produtos> pesqView() {
        List<Produtos> listaProdutos = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("Select * from PESQPROD");
            q.addEntity(Produtos.class);
            List<Produtos> resultado = q.list();
            for (Produtos a : resultado) {
               Produtos produtos = (Produtos) a;
               listaProdutos.add(produtos);
            }            
            sessao.getTransaction().commit();
            return listaProdutos;            

        } catch (Exception e) {
            System.out.println("erro ao chamar view: " + e);
            Login.log.info("Erro ao pesquisar produto(pesqView): " + e);
            return null;
        }
    }
    
    public Boolean updateProdutos(Produtos produto){
        Auditoria auditoria = new Auditoria();
        AuditoriaDao auditoriaDao = new AuditoriaDao();
        Usuario usu = new Usuario();
        List<Produtos> listvelho = new ArrayList();
        List<Produtos> listnovo = new ArrayList();
        Session sessao = null;
        try {
            listvelho  = procuraPorCodigo(produto.getCodigo());
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(produto);
            t.commit();
            listnovo = procuraPorCodigo(produto.getCodigo());
            
            for (int i = 0; i < listnovo.size(); i++) {
                if (listnovo.get(i).getDescricao()!= listvelho.get(i).getDescricao()) {
                    auditoria.setValorAnterior("Campo descricao: " + listvelho.get(i).getDescricao());
                    auditoria.setValorPosterior("Campo descricao: " + listnovo.get(i).getDescricao());
                }
                if (listnovo.get(i).getMarca()!= listvelho.get(i).getMarca()) {
                    auditoria.setValorAnterior(auditoria.getValorAnterior() + " Campo marca: " + listvelho.get(i).getMarca());
                    auditoria.setValorPosterior(auditoria.getValorPosterior() + " Campo marca: " + listnovo.get(i).getMarca());
                }                 
            }
            
            auditoria.setAcao("Update produtos: " + produto.getCodigo());            
            usu.setCodigo(usuario);
            auditoria.setUsuario(usu); 
            auditoriaDao.InsertAuditoria(auditoria);
                        
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            Login.log.info("Erro ao atualizar produto: " + he);
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<Produtos> procuraPorCodigo(int cod){
        List<Produtos> listaProduto = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Produtos where codigo = " + cod);
            resultado = q.list();

            for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProduto.add(produtos);
            }
            
            return listaProduto;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar produto(procuraPorCodigo): " + he);
            return listaProduto;
        }
    }
    
    public List<Produtos> encontrarTudo(){
        //Cliente cliente = new Cliente();
        List<Produtos> listaProdutos = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("FROM Produtos");
            resultado = q.list();

            for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProdutos.add(produtos);
            }
            
            return listaProdutos;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar produto(encontrarTudo): " + he);
            return listaProdutos;
        }        
    }
    
    public Boolean existeNoBanco(int cod){
        boolean existe = false;
        List<Produtos> listaProdutos = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from Produtos where codigo = " + cod);                
        resultado = q.list();        
        
        for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProdutos.add(produtos);
            }                
        
        if (listaProdutos.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
    
    public List<Produtos> pesquisaProdutos(String nome){
        List<Produtos> listaProdutos = new ArrayList();
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            org.hibernate.Query q = sessao.createQuery("from Produtos where Marca like '" + nome + "%'");
            resultado = q.list();

            for (Object o : resultado) {
                Produtos produtos = (Produtos) o;
                listaProdutos.add(produtos);
            }
            
            return listaProdutos;

        } catch (HibernateException he) {
            he.printStackTrace();
            Login.log.info("Erro ao pesquisar produto(pesquisaProdutos): " + he);
            return listaProdutos;
        }
    }
}
