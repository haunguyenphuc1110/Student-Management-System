/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.admin;

import control.InitialStatelessStudentOrAdmin;
import edu.tdt.entity.Course;
import edu.tdt.service.SystemStudentManagementRemote;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAU
 */
public class ViewFee extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditStdReg
     */
    
    InitialStatelessStudentOrAdmin init;
    DefaultTableModel dftable;
    public ViewFee() {
        initComponents();
        init = new InitialStatelessStudentOrAdmin();
        dftable = (DefaultTableModel) jDataTable.getModel();
    }
    
    private void loadDataOnJTable() {
        try {            
            dftable.setRowCount(0);

            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            if(!session.findStudentByID(jTextFieldID.getText().toUpperCase())){
                JOptionPane.showMessageDialog(null, "Student is not found!!!");
                return;
            }
            ArrayList<String> courses = session.getListCoursesRegistered(jTextFieldID.getText().toUpperCase());
            int total_fee = 0; 
            
            for(int i = 0 ; i < courses.size() ; i++){
                String[] obj = courses.get(i).split(";");
                String id_course = obj[0];
                String name = obj[1];
                String duration = obj[2];
                String fee = obj[3];
                String type = obj[4];
                
                total_fee += Integer.parseInt(fee);

                Object[] ojb = {id_course, name, duration, fee, type};
                dftable.addRow(ojb);
            }
            
            jTextFieldTotalFee.setText(String.valueOf(total_fee));
        } catch (NamingException ex) {
            Logger.getLogger(ViewFee.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldTotalFee = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDataTable = new javax.swing.JTable();
        jButtonFind = new javax.swing.JButton();
        jTextFieldID = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Fee Management");

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 51, 204));
        jLabelTitle.setText("INFORMATION ABOUT STUDENT FEE");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 402));
        jPanel1.setLayout(null);

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTotal.setText("Total");
        jPanel1.add(jLabelTotal);
        jLabelTotal.setBounds(1090, 0, 61, 29);

        jTextFieldTotalFee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(jTextFieldTotalFee);
        jTextFieldTotalFee.setBounds(1040, 40, 160, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("VND");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1210, 50, 41, 16);

        jDataTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Duration", "Fee", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jDataTable.setRowHeight(30);
        jDataTable.setRowMargin(2);
        jScrollPane1.setViewportView(jDataTable);

        jButtonFind.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonFind.setText("Find");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        jTextFieldID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFind)
                        .addGap(453, 453, 453))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFind)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed
        loadDataOnJTable();
        jTextFieldID.setText("");
        jTextFieldID.requestFocus();
    }//GEN-LAST:event_jButtonFindActionPerformed

    
    public void setColor(javax.swing.JButton button) {
        button.setBackground(new java.awt.Color(115, 163, 239));
    }

    public void resetColor(javax.swing.JButton button) {
        button.setBackground(new java.awt.Color(12, 91, 160));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFind;
    private javax.swing.JTable jDataTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldTotalFee;
    // End of variables declaration//GEN-END:variables
}