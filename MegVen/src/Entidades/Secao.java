package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.UsuarioDao;
import Visoes.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class Secao {
    
    private static Secao instance;
    
    public synchronized static Secao getInstance(){
        if (instance == null){
            instance = new Secao();
        }
        return instance;
    }
    
    public void Logando(int usuario, String senha){
        boolean logado = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> listaUsuario = new ArrayList();        
        if (usuario > 0 )  {
            logado = usuarioDao.existeNoBanco(usuario);
            if (logado) {             
                listaUsuario = usuarioDao.pesquisaPorCodigo(usuario);
                for (Usuario usu : listaUsuario) {
                this.usuario     = usu.getCodigo();
                this.nivelAcesso = usu.getNivelAcesso();
                this.nome        = usu.getNome();                               
            }                
                new Menu().setVisible(true);                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha invalido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o usuário e a senha!");
        }
    }
    
    private int usuario;
    private int nivelAcesso;
    private String nome;

    public Secao() {
        
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
    
    
    
}
