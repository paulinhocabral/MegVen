/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Auditoria;
import Entidades.OrcamentoProdutoestoque;
import Entidades.Secao;
import Entidades.Usuario;
import Util.HibernateUtil;
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
public class OrcamentoPEDao {

    int usu = Secao.getInstance().getUsuario();
    
    public Boolean InsertOrcPe(OrcamentoProdutoestoque orcProdEst){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            sessao.save(orcProdEst);
            t.commit();
            
            return true;

        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<OrcamentoProdutoestoque> pesqOrcPE(int cod) {
        List<OrcamentoProdutoestoque> listaOPE = new ArrayList();
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            SQLQuery q = sessao.createSQLQuery("SELECT OPE.PRODUTOESTOQUE_PRODUTOS_CODIGO, OPE.PRODUTOESTOQUE_CODIGOESTOQUE,PRODUTOS.DESCRICAO,OPE.ORCAMENTO_CODIGO " + 
                                               "FROM ORCAMENTO_PRODUTOESTOQUE OPE " +
                                               "LEFT OUTER JOIN PRODUTOS ON PRODUTOS.CODIGO = OPE.PRODUTOESTOQUE_PRODUTOS_CODIGO " +
                                               "WHERE OPE.ORCAMENTO_CODIGO = " + cod);
            
            q.addEntity(OrcamentoProdutoestoque.class);
            
            List<OrcamentoProdutoestoque> resultado = q.list();
            
            for (OrcamentoProdutoestoque a : resultado) {
               OrcamentoProdutoestoque orcpe = (OrcamentoProdutoestoque) a;
               listaOPE.add(orcpe);
            }            
            sessao.getTransaction().commit();
            return listaOPE;            

        } catch (Exception e) {
            System.out.println("erro ao chamar consulta: " + e);
            return null;
        }
    }
    
    public Boolean updateOrcPe(OrcamentoProdutoestoque OrcProdESt){
        Auditoria auditoria = new Auditoria();
        AuditoriaDao auditoriaDao = new AuditoriaDao();
        Usuario usu = new Usuario();
        List<OrcamentoProdutoestoque> listvelho = new ArrayList();
        List<OrcamentoProdutoestoque> listnovo = new ArrayList();
        Session sessao = null;
        try {
            //listvelho  = procuraPorCodigo(OrcProdESt.getId().getProdutoEstoqueCodigoEstoque(), OrcProdESt.getId().getProdutoEstoqueProdutosCodigo(), OrcProdESt.getId().getOrcamentoCodigo());
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            sessao.update(OrcProdESt);
            t.commit();
            //listnovo = procuraPorCodigo(OrcProdESt.getId().getProdutoEstoqueCodigoEstoque(), OrcProdESt.getId().getProdutoEstoqueProdutosCodigo(), OrcProdESt.getId().getOrcamentoCodigo());
            /*for (int i = 0; i < listnovo.size(); i++) {
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
            } */   
                            
            //auditoria.setAcao("Update filial: " + filial.getCodigo());            
            //usu.setCodigo(us);
            //auditoria.setUsuario(usu); 
            //auditoriaDao.InsertAuditoria(auditoria);
               
            return true;
            
        } catch (HibernateException he) {
            he.printStackTrace(); 
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public List<OrcamentoProdutoestoque> procuraPorCodigo(int prod,int codest, int orc){
        List<OrcamentoProdutoestoque> listaOrcProd = new ArrayList();
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from OrcamentoProdutoestoque OPE " +
                                    "LEFT OUTER JOIN PRODUTOESTOQUE ON PRODUTOESTOQUE.PRODUTOS_CODIGO = OPE.PRODUTOESTOQUE_PRODUTOS_CODIGO AND " +
                                    "PRODUTOESTOQUE.CODIGOESTOQUE = OPE.ORCAMENTO_CODIGO "+
                                    "WHERE OPE.PRODUTOESTOQUE_PRODUTOS_CODIGO = " + prod +
                                    " AND OPE.PRODUTOESTOQUE_CODIGOESTOQUE = " + codest +
                                    " AND OPE.ORCAMENTO_CODIGO = " + orc);
            
            resultado = q.list();

            for (Object o : resultado) {
                OrcamentoProdutoestoque orcpe = (OrcamentoProdutoestoque) o;
                listaOrcProd.add(orcpe);
            }
            
            return listaOrcProd;

        } catch (HibernateException he) {
            he.printStackTrace();
            return listaOrcProd;
        }
    }
    
    public Boolean existeNoBanco(int prod,int codest, int orc){
        boolean existe = false;
        List<OrcamentoProdutoestoque> listaOPE = new ArrayList();
        List resultado = null;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        org.hibernate.Query q = sessao.createQuery("from OrcamentoProdutoestoque OPE " +
                                    "LEFT OUTER JOIN PRODUTOESTOQUE ON PRODUTOESTOQUE.PRODUTOS_CODIGO = OPE.PRODUTOESTOQUE_PRODUTOS_CODIGO AND " +
                                    "PRODUTOESTOQUE.CODIGOESTOQUE = OPE.ORCAMENTO_CODIGO "+
                                    "WHERE OPE.PRODUTOESTOQUE_PRODUTOS_CODIGO = " + prod +
                                    " AND OPE.PRODUTOESTOQUE_CODIGOESTOQUE = " + codest +
                                    " AND OPE.ORCAMENTO_CODIGO = " + orc);                
        resultado = q.list();                                        
        
        if (resultado.size() > 0){
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }
}
