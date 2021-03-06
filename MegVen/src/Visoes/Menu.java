/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visoes;

import DAO.AuditoriaDao;
import Entidades.Auditoria;
import Entidades.Cliente;
import Entidades.Secao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controle.Conexao;
import Entidades.Usuario;
import java.util.Iterator;
import org.hibernate.Query;

/**
 *
 * @author Murilo
 */
public class Menu extends javax.swing.JFrame {

    CadastroCliente CadastroCliente;
    CadastroUsuario CadastroUsuario;
    CadastroFilial CadastroFilial;
    CadastroProduto CadastroProdutos;
    CadastroProdEst CadastroPe;
    CadastroOrcamento CadastroOrcamento;
    
    /**
     * Creates new form Menu
     */
    public Menu() {                       
        //JOptionPane.showMessageDialog(null, Secao.getInstance().getNome());
        initComponents();
        if (Secao.getInstance().getNivelAcesso() == 1){
            //MenuUsuario.setEnabled(true);
            MenuFiliais.setEnabled(true);
        } else {            
            //MenuUsuario.setEnabled(false);
            MenuFiliais.setEnabled(false);
        }
    }
    
    private void limpaTable() {
        DefaultTableModel model = (DefaultTableModel) gdAuditoria.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Feorm Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Auditoria = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        gdAuditoria = new javax.swing.JTable();
        jDialog1 = new javax.swing.JDialog();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        MenuUsuario = new javax.swing.JMenuItem();
        MenuProdutos = new javax.swing.JMenuItem();
        MenuFiliais = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        Auditoria.setTitle("Auditoria");

        gdAuditoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq", "Data/Hora", "Ação", "Valor anterior", "Valor posterior", "Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gdAuditoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gdAuditoriaMouseClicked(evt);
            }
        });
        gdAuditoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gdAuditoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gdAuditoriaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(gdAuditoria);
        if (gdAuditoria.getColumnModel().getColumnCount() > 0) {
            gdAuditoria.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout AuditoriaLayout = new javax.swing.GroupLayout(Auditoria.getContentPane());
        Auditoria.getContentPane().setLayout(AuditoriaLayout);
        AuditoriaLayout.setHorizontalGroup(
            AuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuditoriaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        AuditoriaLayout.setVerticalGroup(
            AuditoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuditoriaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu2.setText("Cadastros");

        MenuClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        MenuClientes.setText("Manutenção de clientes");
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        jMenu2.add(MenuClientes);

        MenuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        MenuUsuario.setText("Manutenção de usuário");
        MenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(MenuUsuario);

        MenuProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        MenuProdutos.setText("Manutenção de produtos");
        MenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(MenuProdutos);

        MenuFiliais.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        MenuFiliais.setText("Manutenção de filiais");
        MenuFiliais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFiliaisActionPerformed(evt);
            }
        });
        jMenu2.add(MenuFiliais);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Manutenção de produtos do estoque");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Orçamentos");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Orçamento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Configurações");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Auditoria");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Chat");

        jMenuItem3.setText("Chat");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        if (CadastroCliente == null) {
            CadastroCliente = new CadastroCliente();
            CadastroCliente.setVisible(true);
            CadastroCliente.setLocationRelativeTo(null);
        } else {
            CadastroCliente.setVisible(true);
            CadastroCliente.setLocationRelativeTo(null);
        }                
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioActionPerformed
        if (CadastroUsuario == null){
            CadastroUsuario = new CadastroUsuario();            
            CadastroUsuario.setVisible(true);
            CadastroUsuario.setLocationRelativeTo(null);
        } else {
            CadastroUsuario.setVisible(true);
            CadastroUsuario.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_MenuUsuarioActionPerformed

    private void MenuFiliaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFiliaisActionPerformed
        if (CadastroFilial == null){
            CadastroFilial = new CadastroFilial();            
            CadastroFilial.setVisible(true);
            CadastroFilial.setLocationRelativeTo(null);
        } else {
            CadastroFilial.setVisible(true);
            CadastroFilial.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_MenuFiliaisActionPerformed

    private void MenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProdutosActionPerformed
        if (CadastroProdutos == null){
            CadastroProdutos = new CadastroProduto();            
            CadastroProdutos.setVisible(true);
            CadastroProdutos.setLocationRelativeTo(null);
        } else {
            CadastroProdutos.setVisible(true);
            CadastroProdutos.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_MenuProdutosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        limpaTable();
        DefaultTableModel model = (DefaultTableModel) gdAuditoria.getModel();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        AuditoriaDao auditoriaDao = new AuditoriaDao();
        List<Auditoria> list = new ArrayList<Auditoria>();
        try {
            list = auditoriaDao.pesqView();                        
            } catch (Exception ex) {
                Logger.getLogger(Auditoria.getName()).log(Level.SEVERE, null, ex);
                Login.log.info("Erro ao pesquisar auditoria(Menu): " + ex);
            
            }
        String tabela[] = new String[]{"", "", "", "", "",""};                             
                
        for (Auditoria auditoria : list) {                        
            tabela[0] = auditoria.getCodigo().toString();            
            tabela[1] = auditoria.getDataHora().toString();            
            tabela[2] = auditoria.getAcao();            
            tabela[3] = auditoria.getValorAnterior();            
            tabela[4] = auditoria.getValorPosterior();            
            tabela[5] = auditoria.getUsuario().getCodigo().toString();            
            model.addRow(tabela);         
        }
        Auditoria.setSize(600, 450);
        Auditoria.setModal(true);
        Auditoria.setLocation(200, 100);
        Auditoria.setVisible(true);                
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (CadastroPe == null){
            CadastroPe = new CadastroProdEst();            
            CadastroPe.setVisible(true);
            CadastroPe.setLocationRelativeTo(null);
        } else {
            CadastroPe.setVisible(true);
            CadastroPe.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (CadastroOrcamento == null){
            CadastroOrcamento = new CadastroOrcamento();            
            CadastroOrcamento.setVisible(true);
            CadastroOrcamento.setLocationRelativeTo(null);
        } else {
            CadastroOrcamento.setVisible(true);
            CadastroOrcamento.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String ip = JOptionPane.showInputDialog("Informe o IP", "192.168.0.");
        int porta = Integer.parseInt(JOptionPane.showInputDialog("Informe a Porta", "5000"));

        Conexao c = new Conexao(ip, porta);

        JChat j = new JChat(c);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void gdAuditoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gdAuditoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_gdAuditoriaKeyTyped

    private void gdAuditoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gdAuditoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_gdAuditoriaKeyReleased

    private void gdAuditoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gdAuditoriaMouseClicked

    }//GEN-LAST:event_gdAuditoriaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Auditoria;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuFiliais;
    private javax.swing.JMenuItem MenuProdutos;
    private javax.swing.JMenuItem MenuUsuario;
    private javax.swing.JTable gdAuditoria;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
