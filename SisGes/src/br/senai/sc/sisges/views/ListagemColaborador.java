
package br.senai.sc.sisges.views;

import br.senai.sc.sisges.dao.ColaboradorDao;
import br.senai.sc.sisges.modelo.Colaborador;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListagemColaborador extends javax.swing.JPanel {

    private CardLayout cl;
    private int idCol;

    public ListagemColaborador() {
        initComponents();

        this.add(painelListagem, "painelListagem");
        this.add(painelEdicao, "painelEdicao");

        this.cl = (CardLayout) this.getLayout();
        this.cl.show(this, "painelListagem");
    }

    private void popularTabela() {
        ColaboradorDao cl = new ColaboradorDao();
        List<Colaborador> listaColaborador;

        try {
            listaColaborador = cl.listarColaboradores();

            DefaultTableModel model = (DefaultTableModel) tblColaborador.getModel();
            List<Object> lista = new ArrayList<Object>();

            for (int i = 0; i < listaColaborador.size(); i++) {
                Colaborador c = listaColaborador.get(i);
                lista.add(new Object[]{c.getIdCol(), c.getNomCol(),
                    c.getEndCol(),c.getNumCol(), c.getBaiCol(),
                    c.getCepCol(),c.getComCol(),c.getCepCol(), 
                    c.getCelCol(),c.getTipoCol(),c.getUsuCol(),
                    c.getSenCol(),c.getUltAcCol(),c.getEquCol(),
                    
                     });
            }

            for (int idx = 0; idx < lista.size(); idx++) {
                model.addRow((Object[]) lista.get(idx));
            }

        } catch (SQLException ex) {
            String msg = "Ocorreu um erro ao obter os clientes do banco de dados!";
            JOptionPane.showMessageDialog(null, msg);
            Logger.getLogger(ListagemColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparTabela() {
        ((DefaultTableModel) tblColaborador.getModel()).setNumRows(0);
        tblColaborador.updateUI();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblColaborador = new javax.swing.JTable();
        painelEdicao = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        labelCadastroCliente = new javax.swing.JLabel();
        lbNomCol = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cpNomCol = new javax.swing.JTextField();
        labelEnderecoLocalizacao = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelEndereco = new javax.swing.JLabel();
        cpEndCol = new javax.swing.JTextField();
        labelBairro = new javax.swing.JLabel();
        cpBaiCol = new javax.swing.JTextField();
        labelCep = new javax.swing.JLabel();
        cpCepCol = new javax.swing.JFormattedTextField();
        labelComplemento = new javax.swing.JLabel();
        cpComCol = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        labelTituloContato = new javax.swing.JLabel();
        lbCelularCol = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        cpCelCol = new javax.swing.JFormattedTextField();
        lbNumCol = new javax.swing.JLabel();
        cpNumCol = new javax.swing.JTextField();
        lbCpfCol = new javax.swing.JLabel();
        cpCpfCol = new javax.swing.JFormattedTextField();
        lbDddCol = new javax.swing.JLabel();
        cpDddCol = new javax.swing.JTextField();
        labelTituloContato1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lbEquCol = new javax.swing.JLabel();
        cpEquCol = new javax.swing.JTextField();
        comboLogin = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        painelListagem.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                painelListagemComponentShown(evt);
            }
        });

        tblColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Bairro", "Complemento", "CEP", "Celular"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblColaboradorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblColaborador);

        javax.swing.GroupLayout painelListagemLayout = new javax.swing.GroupLayout(painelListagem);
        painelListagem.setLayout(painelListagemLayout);
        painelListagemLayout.setHorizontalGroup(
            painelListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        painelListagemLayout.setVerticalGroup(
            painelListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        add(painelListagem, "card3");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar cadastro");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        labelCadastroCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelCadastroCliente.setText("Atualizar Dados");

        lbNomCol.setText("Nome:");

        cpNomCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpNomColActionPerformed(evt);
            }
        });

        labelEnderecoLocalizacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelEnderecoLocalizacao.setText("Endereço e localização");

        labelEndereco.setText("Endereço:");

        labelBairro.setText("Bairro:");

        labelCep.setText("CEP:");

        try {
            cpCepCol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelComplemento.setText("Complemento:");

        labelTituloContato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTituloContato.setText("Contato");

        lbCelularCol.setText("Celular:");

        try {
            cpCelCol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbNumCol.setText("Número:");

        lbCpfCol.setText("CPF:");

        try {
            cpCpfCol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbDddCol.setText("DDD:");

        labelTituloContato1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTituloContato1.setText("Login");

        lbEquCol.setText("Equipe:");

        comboLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Colaborador" }));
        comboLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEdicaoLayout = new javax.swing.GroupLayout(painelEdicao);
        painelEdicao.setLayout(painelEdicaoLayout);
        painelEdicaoLayout.setHorizontalGroup(
            painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEdicaoLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnApagar)
                .addGap(60, 60, 60))
            .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEdicaoLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(painelEdicaoLayout.createSequentialGroup()
                            .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelEdicaoLayout.createSequentialGroup()
                                    .addComponent(lbNomCol)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cpNomCol))
                                .addGroup(painelEdicaoLayout.createSequentialGroup()
                                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelCadastroCliente)
                                        .addGroup(painelEdicaoLayout.createSequentialGroup()
                                            .addComponent(lbCpfCol)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cpCpfCol, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(painelEdicaoLayout.createSequentialGroup()
                                            .addComponent(lbEquCol)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cpEquCol, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(10, 10, 10))
                        .addGroup(painelEdicaoLayout.createSequentialGroup()
                            .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelEdicaoLayout.createSequentialGroup()
                                    .addComponent(labelEndereco)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cpEndCol))
                                .addGroup(painelEdicaoLayout.createSequentialGroup()
                                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelEdicaoLayout.createSequentialGroup()
                                            .addComponent(lbNumCol)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cpNumCol, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                                .addComponent(labelComplemento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cpComCol, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelEnderecoLocalizacao)
                                                .addComponent(labelTituloContato)
                                                .addGroup(painelEdicaoLayout.createSequentialGroup()
                                                    .addComponent(lbDddCol)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cpDddCol, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lbCelularCol)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cpCelCol, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(painelEdicaoLayout.createSequentialGroup()
                                                    .addComponent(labelBairro)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cpBaiCol, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(labelCep)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cpCepCol, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(0, 10, Short.MAX_VALUE))
                                .addComponent(labelTituloContato1))
                            .addGap(40, 40, 40))
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator5)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(painelEdicaoLayout.createSequentialGroup()
                            .addComponent(comboLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(38, 38, 38)))
        );
        painelEdicaoLayout.setVerticalGroup(
            painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEdicaoLayout.createSequentialGroup()
                .addContainerGap(522, Short.MAX_VALUE)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagar)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelEdicaoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNomCol)
                        .addComponent(cpNomCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCpfCol)
                        .addComponent(cpCpfCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbEquCol)
                        .addComponent(cpEquCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)
                    .addComponent(labelEnderecoLocalizacao)
                    .addGap(18, 18, 18)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEndereco)
                        .addComponent(cpEndCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cpBaiCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelBairro)
                        .addComponent(labelCep)
                        .addComponent(cpCepCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNumCol)
                        .addComponent(cpNumCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelComplemento)
                        .addComponent(cpComCol, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelTituloContato)
                    .addGap(18, 18, 18)
                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCelularCol)
                        .addComponent(cpCelCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbDddCol)
                        .addComponent(cpDddCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelTituloContato1)
                    .addGap(9, 9, 9)
                    .addComponent(comboLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        add(painelEdicao, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         Colaborador col = new Colaborador();
         
        col.setNomCol(cpNomCol.getText());
         col.setEndCol(cpEndCol.getText());
        col.setBaiCol(cpBaiCol.getText());
        col.setComCol(cpComCol.getText());
       col.setEquCol(cpEquCol.getText());
       col.setTipoCol((String) comboLogin.getSelectedItem());

        String cep = cpCepCol.getText();
        cep = cep.replaceAll("[^0-9]", "");

        String celular = cpCelCol.getText();
        celular = celular.replaceAll("[^0-9]", "");
        
        String numero = cpNumCol.getText();
        numero = numero.replaceAll("[^0-9]", "");
        
        String cpf = cpCpfCol.getText();
        cpf = cpf.replaceAll("[^0-9]", "");
        
        String ddd = cpDddCol.getText();
        ddd = ddd.replaceAll("[^0-9]", "");

        col.setCepCol(Long.parseLong(cep));
        col.setCelCol(Long.parseLong(celular));
        col.setNumCol(Long.parseLong(numero));
        col.setCpfCol(Long.parseLong(cpf));
        col.setDddCol(Long.parseLong(ddd));
        
        col.setIdCol(this.idCol);

        //Inseri o cliente no banco de dados
        ColaboradorDao cliDao = new ColaboradorDao();
        try {
            cliDao.alterar(col);
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar cadastro !");
            Logger.getLogger(CadastroColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void painelListagemComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_painelListagemComponentShown
        this.popularTabela();
    }//GEN-LAST:event_painelListagemComponentShown

    private void preencherFormulario(int idCol){
        
        ColaboradorDao colab = new ColaboradorDao();
        try {
            Colaborador col = colab.getColaborador(idCol);
            cpNomCol.setText(col.getNomCol());
            cpEndCol.setText(col.getEndCol());
            cpBaiCol.setText(col.getBaiCol());
            cpComCol.setText(col.getComCol());
            cpCepCol.setText(""+col.getCepCol());
            cpCelCol.setText(""+col.getCelCol());
            
        } catch (SQLException ex) {
            Logger.getLogger(ListagemColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.idCol = idCol;
        
    }
    
    private void tblColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColaboradorMouseClicked
        int linha = tblColaborador.getSelectedRow();
        
        if (linha != -1){
            
            String codigo = tblColaborador.getValueAt(linha, 0).toString();
            int codigoCliente = Integer.parseInt(codigo);
            this.preencherFormulario(codigoCliente);
            this.cl.show(this,"painelEdicao");
        }
        
        
    }//GEN-LAST:event_tblColaboradorMouseClicked

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
   
        Object[] options = {"Sim", "Não"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Deseja realmente eliminar este funcionário?",
        "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if (opcaoSelecionada==0){
            
            ColaboradorDao cliDao = new ColaboradorDao();
            try {
                cliDao.eliminar(this.idCol);
                this.limparTabela();
                JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso!");
                
            } catch (SQLException ex) {
                Logger.getLogger(ListagemColaborador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao apagar cadastro!", "ATENÇÃO!", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnApagarActionPerformed

    private void cpNomColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpNomColActionPerformed

    }//GEN-LAST:event_cpNomColActionPerformed

    private void comboLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboLogin;
    private javax.swing.JTextField cpBaiCol;
    private javax.swing.JFormattedTextField cpCelCol;
    private javax.swing.JFormattedTextField cpCepCol;
    private javax.swing.JTextField cpComCol;
    private javax.swing.JFormattedTextField cpCpfCol;
    private javax.swing.JTextField cpDddCol;
    private javax.swing.JTextField cpEndCol;
    private javax.swing.JTextField cpEquCol;
    private javax.swing.JTextField cpNomCol;
    private javax.swing.JTextField cpNumCol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelBairro;
    private javax.swing.JLabel labelCadastroCliente;
    private javax.swing.JLabel labelCep;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelEnderecoLocalizacao;
    private javax.swing.JLabel labelTituloContato;
    private javax.swing.JLabel labelTituloContato1;
    private javax.swing.JLabel lbCelularCol;
    private javax.swing.JLabel lbCpfCol;
    private javax.swing.JLabel lbDddCol;
    private javax.swing.JLabel lbEquCol;
    private javax.swing.JLabel lbNomCol;
    private javax.swing.JLabel lbNumCol;
    private javax.swing.JPanel painelEdicao;
    private javax.swing.JPanel painelListagem;
    private javax.swing.JTable tblColaborador;
    // End of variables declaration//GEN-END:variables
}
