/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visoes;

import Controle.MiscTools;
import DAO.ClienteDao;
import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

/**
 *
 * @author Murilo
 */
public class CadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCliente
     */
    
    //Cliente cliente;
    
    public CadastroCliente() {
        initComponents();
    }
                    
    private void carregaCliente (Cliente cliente) {
        edCodigo.setText(cliente.getCodigo().toString());
        edNome.setText(cliente.getNome());
        edTelefone.setText(cliente.getTelefone());
        edCelular.setText(cliente.getCeuluar());
        edEmail.setText(cliente.getEmail());                               
    }
    
    private void limpaTable() {
        DefaultTableModel model = (DefaultTableModel) gdClientes.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    private void limpaTela() {        
        edCodigo.setText("");
        edNome.setText("");
        edTelefone.setText("");
        edCelular.setText("");
        edEmail.setText("");        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PesquisaCliente = new javax.swing.JDialog();
        label_descConta = new javax.swing.JLabel();
        edNome1 = new javax.swing.JTextField();
        btPesquisa1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gdClientes = new javax.swing.JTable();
        btCarregar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edCodigo = new javax.swing.JTextField();
        edNome = new javax.swing.JTextField();
        edEmail = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        edTelefone = new javax.swing.JFormattedTextField();
        edCelular = new javax.swing.JFormattedTextField();

        label_descConta.setText("Nome");

        edNome1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edNome1FocusLost(evt);
            }
        });
        edNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edNome1ActionPerformed(evt);
            }
        });
        edNome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edNome1KeyReleased(evt);
            }
        });

        btPesquisa1.setText("Pesquisar");
        btPesquisa1.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisa1ActionPerformed(evt);
            }
        });

        gdClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gdClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gdClientesMouseClicked(evt);
            }
        });
        gdClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gdClientesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gdClientesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(gdClientes);

        btCarregar.setText("Carregar");
        btCarregar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PesquisaClienteLayout = new javax.swing.GroupLayout(PesquisaCliente.getContentPane());
        PesquisaCliente.getContentPane().setLayout(PesquisaClienteLayout);
        PesquisaClienteLayout.setHorizontalGroup(
            PesquisaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PesquisaClienteLayout.createSequentialGroup()
                .addGroup(PesquisaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PesquisaClienteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PesquisaClienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(PesquisaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PesquisaClienteLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                            .addGroup(PesquisaClienteLayout.createSequentialGroup()
                                .addComponent(label_descConta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PesquisaClienteLayout.setVerticalGroup(
            PesquisaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PesquisaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PesquisaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_descConta)
                    .addComponent(edNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(PesquisaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCarregar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(380, 260));

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton2.setText(">");

        jToggleButton1.setText("<");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("2/10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jToggleButton1)
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jToggleButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton1)
                    .addComponent(jLabel1)))
        );

        jLabel2.setText("Código:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Celular:");

        jLabel6.setText("Email:");

        edCodigo.setName("edCodigo"); // NOI18N
        edCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                edCodigoFocusLost(evt);
            }
        });
        edCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edCodigoActionPerformed(evt);
            }
        });
        edCodigo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                edCodigoPropertyChange(evt);
            }
        });
        edCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edCodigoKeyTyped(evt);
            }
        });
        edCodigo.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                edCodigoVetoableChange(evt);
            }
        });

        edNome.setFocusTraversalPolicyProvider(true);
        edNome.setName(""); // NOI18N

        edEmail.setName("edEmail"); // NOI18N

        btPesquisa.setIcon(new javax.swing.ImageIcon("C:\\Users\\Murilo\\Documents\\NetBeansProjects\\ProjetosPAA\\images.png")); // NOI18N
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        try {
            edTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            edCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edNome, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(edTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edEmail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(edCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(edNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(edTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(edEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(jButton2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        boolean retorno = false;
        if (edCodigo.getText().equals("")) {
            cliente.setNome(edNome.getText());
            cliente.setTelefone(edTelefone.getText());
            cliente.setCeuluar(edCelular.getText());
            cliente.setEmail(edEmail.getText());
        
            retorno = clienteDao.InsertCliente(cliente);
                    
        } else {
            boolean existe = clienteDao.existeNoBanco(Integer.parseInt(edCodigo.getText()));
            if (existe){
                cliente.setCodigo(Integer.parseInt(edCodigo.getText()));
                cliente.setNome(edNome.getText());
                cliente.setTelefone(edTelefone.getText());
                cliente.setCeuluar(edCelular.getText());
                cliente.setEmail(edEmail.getText());
                
                retorno = clienteDao.updateCliente(cliente);                                
            }                
        }
        if (retorno == true) {
            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
            carregaCliente(cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }            
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void edCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edCodigoActionPerformed

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
//        ConsultaCliente pesqCli = new ConsultaCliente();
//        Cliente cliente = new Cliente();
//        pesqCli.setCliente(cliente);
//        pesqCli.setVisible(true);
//        carregaCliente(cliente);
        PesquisaCliente.setSize(600, 450);
        PesquisaCliente.setModal(true);
        PesquisaCliente.setLocation(200, 100);
        PesquisaCliente.setVisible(true);
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void edNome1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edNome1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_edNome1FocusLost

    private void edNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edNome1ActionPerformed

    private void edNome1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edNome1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_edNome1KeyReleased

    private void btPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisa1ActionPerformed
        limpaTable();
        DefaultTableModel model = (DefaultTableModel) gdClientes.getModel();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> list = new ArrayList();

        if (edNome.getText().equals("")) {
            try {
                list = clienteDao.encontrarTudo();
            } catch (Exception ex) {
                Logger.getLogger(PesquisaCliente.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                list = clienteDao.pesquisaCliente(edNome.getText());
            } catch (Exception ex) {
                Logger.getLogger(PesquisaCliente.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cliente não localizado.", "Erro",
                JOptionPane.ERROR_MESSAGE);
            btCarregar.setEnabled(false);
        } else {
            String tabela[] = new String[]{"", "", "", "", ""};
            for (Cliente cliente : list) {
                tabela[0] = String.valueOf(cliente.getCodigo());
                tabela[1] = cliente.getNome();
                tabela[2] = cliente.getTelefone();
                tabela[3] = cliente.getCeuluar();
                tabela[4] = cliente.getEmail();

                model.addRow(tabela);
            }
            btCarregar.setEnabled(true);
            gdClientes.setVisible(true);
        }

    }//GEN-LAST:event_btPesquisa1ActionPerformed

    private void gdClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gdClientesMouseClicked
        if (evt.getClickCount() == 2) {
            if (gdClientes.getSelectedRow() > -1) {
                edCodigo.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 0).toString());
                edNome.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 1).toString());
                edTelefone.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 2).toString());
                edCelular.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 3).toString());
                edEmail.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 4).toString());
                PesquisaCliente.setVisible(false);
            }
        }
    }//GEN-LAST:event_gdClientesMouseClicked

    private void gdClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gdClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_gdClientesKeyReleased

    private void gdClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gdClientesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_gdClientesKeyTyped

    private void btCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarActionPerformed
        //DefaultTableModel model = (DefaultTableModel) gdClientes.getModel();
        if (gdClientes.getSelectedRow() > -1) {
            edCodigo.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 0).toString());
            edNome.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 1).toString());
            edTelefone.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 2).toString());
            edCelular.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 3).toString());
            edEmail.setText(gdClientes.getValueAt(gdClientes.getSelectedRow(), 4).toString());
            PesquisaCliente.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione algum cliente da lista.", "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btCarregarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        PesquisaCliente.setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void edCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edCodigoKeyReleased
                
    }//GEN-LAST:event_edCodigoKeyReleased

    private void edCodigoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_edCodigoPropertyChange
        
    }//GEN-LAST:event_edCodigoPropertyChange

    private void edCodigoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_edCodigoVetoableChange
         
    }//GEN-LAST:event_edCodigoVetoableChange

    private void edCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edCodigoKeyTyped
        
    }//GEN-LAST:event_edCodigoKeyTyped

    private void edCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edCodigoFocusLost
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> list = new ArrayList();
        if (edCodigo.equals("")) {
            limpaTela();
        } else {

            Cliente cliente = new Cliente();
            try {
//                list = clienteDao.procuraPorCodigo(Integer.parseInt(edCodigo.getText()));
                //for (Cliente cliente : list) {
//                    edCodigo.setText(cliente.getCodigo().toString());
                    
//                }
                
            } catch (Exception ex) {
                Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (cliente == null) {
                limpaTela();
            } else {
                //carregaPaci(paciente);
            }
        }
    }//GEN-LAST:event_edCodigoFocusLost

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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog PesquisaCliente;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCarregar;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btPesquisa1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField edCelular;
    private javax.swing.JTextField edCodigo;
    private javax.swing.JTextField edEmail;
    private javax.swing.JTextField edNome;
    private javax.swing.JTextField edNome1;
    private javax.swing.JFormattedTextField edTelefone;
    private javax.swing.JTable gdClientes;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel label_descConta;
    // End of variables declaration//GEN-END:variables
}
