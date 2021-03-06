/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.admin;

import control.InitialStatelessStudentOrAdmin;
import edu.tdt.service.SystemStudentManagementRemote;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.student.ClassView;

/**
 *
 * @author HAU
 */
public class EditMark extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditMark
     */
    InitialStatelessStudentOrAdmin init;
    DefaultTableModel dftable;
    public EditMark() {
        initComponents();
        init = new InitialStatelessStudentOrAdmin();
        dftable = (DefaultTableModel) jDataTable.getModel();
        loadDataOnJComboBox();
    }

    private void loadDataOnJTable(String idRoom) {
        try {
            dftable.setRowCount(0);
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            List<Object[]> listStudentScore = session.searchScoreByIDClass(idRoom);
            jTextFieldCourse.setText(session.getNameCourse(idRoom));
            jTextFieldTeacher.setText(session.getNameTeacher(idRoom));
            for(int i = 0 ; i < listStudentScore.size() ; i++){
                String id_student = listStudentScore.get(i)[0].toString();
                String student_name = listStudentScore.get(i)[1].toString() + " " + listStudentScore.get(i)[2].toString();
                String student_birthday = formatter1.format(formatter2.parse(listStudentScore.get(i)[3].toString()));
                String gender = ("true".equals(listStudentScore.get(i)[4].toString()))?"Male":"Female";
                String result1 = listStudentScore.get(i)[5].toString();
                String result2 = listStudentScore.get(i)[6].toString();
                String result3 = listStudentScore.get(i)[7].toString();
                String test1 = listStudentScore.get(i)[8].toString();
                String test2 = listStudentScore.get(i)[9].toString();

                Object[] ojb = {id_student, student_name, student_birthday, gender, result1, result2, result3, test1, test2};
                dftable.addRow(ojb);
            }
        } catch (NamingException | ParseException ex) {
            Logger.getLogger(EditMark.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataOnJComboBox() {
        try {
            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            List<Object[]> roomList = session.getIDRooms();
            for (int i = 0; i < roomList.size(); i++) {
                String room = (String) roomList.get(i)[0];
                jComboBoxClass.addItem(room);
            }
        } catch (NamingException ex) {
            Logger.getLogger(ClassView.class
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

        jLabel1 = new javax.swing.JLabel();
        jComboBoxClass = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();
        jLabelCourse = new javax.swing.JLabel();
        jTextFieldCourse = new javax.swing.JTextField();
        jLabelTeacher = new javax.swing.JLabel();
        jTextFieldTeacher = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDataTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelIDStudent = new javax.swing.JLabel();
        jTextFieldIDStudent = new javax.swing.JTextField();
        jLabelFullName = new javax.swing.JLabel();
        jTextFieldFullName = new javax.swing.JTextField();
        jLabelIDRoom = new javax.swing.JLabel();
        jTextFieldIDRoom = new javax.swing.JTextField();
        jLabelResult1 = new javax.swing.JLabel();
        jTextFieldResult1 = new javax.swing.JTextField();
        jLabelResult2 = new javax.swing.JLabel();
        jTextFieldResult2 = new javax.swing.JTextField();
        jLabelResult3 = new javax.swing.JLabel();
        jTextFieldResult3 = new javax.swing.JTextField();
        jLabelTest1 = new javax.swing.JLabel();
        jTextFieldTest1 = new javax.swing.JTextField();
        jLabelTest2 = new javax.swing.JLabel();
        jTextFieldTest2 = new javax.swing.JTextField();
        jButtonReset = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Edit Mark");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("EDIT MARK");

        jComboBoxClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.setBorder(null);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelCourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCourse.setText("Course");

        jTextFieldCourse.setEditable(false);
        jTextFieldCourse.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldCourse.setDisabledTextColor(new java.awt.Color(204, 204, 204));

        jLabelTeacher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTeacher.setText("Teacher");

        jTextFieldTeacher.setEditable(false);
        jTextFieldTeacher.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldTeacher.setDisabledTextColor(new java.awt.Color(204, 204, 204));

        jDataTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDataTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student", "Birthday", "Gender", "Result1", "Result2", "Result3", "Test1", "Test2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jDataTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDataTable.setRowHeight(30);
        jDataTable.setRowMargin(2);
        jDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jDataTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelIDStudent.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelIDStudent.setText("ID Student");

        jTextFieldIDStudent.setEditable(false);
        jTextFieldIDStudent.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIDStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelFullName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFullName.setText("Full Name");

        jTextFieldFullName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelIDRoom.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelIDRoom.setText("ID Room");

        jTextFieldIDRoom.setEditable(false);
        jTextFieldIDRoom.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIDRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelResult1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelResult1.setText("Result 1");

        jTextFieldResult1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelResult2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelResult2.setText("Result 2");

        jTextFieldResult2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelResult3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelResult3.setText("Result 3");

        jTextFieldResult3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelTest1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTest1.setText("Test 1");

        jTextFieldTest1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabelTest2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTest2.setText("Test 2");

        jTextFieldTest2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(jLabelIDStudent))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIDRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelFullName)
                                .addGap(256, 256, 256))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelIDRoom)
                                .addGap(264, 264, 264)))))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResult2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldResult3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelResult2)
                                    .addComponent(jLabelResult3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTest2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabelTest1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabelTest2)))
                        .addGap(153, 153, 153))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabelResult1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelIDStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelFullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelIDRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIDRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelResult1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelResult2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldResult2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelResult3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldResult3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabelTest1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTest2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTest2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jButtonReset.setBackground(new java.awt.Color(12, 91, 160));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonResetMouseExited(evt);
            }
        });
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(12, 91, 160));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseExited(evt);
            }
        });
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonClose.setBackground(new java.awt.Color(12, 91, 160));
        jButtonClose.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonClose.setText("Close");
        jButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseExited(evt);
            }
        });
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTeacher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1452, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClose)
                .addGap(609, 609, 609))
            .addGroup(layout.createSequentialGroup()
                .addGap(634, 634, 634)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxClass, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxClass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCourse)
                    .addComponent(jTextFieldCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTeacher)
                    .addComponent(jTextFieldTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        loadDataOnJTable(jComboBoxClass.getSelectedItem().toString());
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataTableMouseClicked
        int selectedIndexRow = jDataTable.getSelectedRow();
        
        jTextFieldIDStudent.setText(dftable.getValueAt(selectedIndexRow, 0).toString());
        jTextFieldFullName.setText(dftable.getValueAt(selectedIndexRow, 1).toString());
        jTextFieldIDRoom.setText(jComboBoxClass.getSelectedItem().toString());
        jTextFieldResult1.setText(dftable.getValueAt(selectedIndexRow, 4).toString());
        jTextFieldResult2.setText(dftable.getValueAt(selectedIndexRow, 5).toString());
        jTextFieldResult3.setText(dftable.getValueAt(selectedIndexRow, 6).toString());
        jTextFieldTest1.setText(dftable.getValueAt(selectedIndexRow, 7).toString());
        jTextFieldTest2.setText(dftable.getValueAt(selectedIndexRow, 8).toString());
        
    }//GEN-LAST:event_jDataTableMouseClicked

    private void jButtonResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetMouseEntered
        setColor(jButtonReset);
    }//GEN-LAST:event_jButtonResetMouseEntered

    private void jButtonResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetMouseExited
        resetColor(jButtonReset);
    }//GEN-LAST:event_jButtonResetMouseExited

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        jTextFieldIDStudent.setText("");
        jTextFieldFullName.setText("");
        jTextFieldIDRoom.setText("");
        jTextFieldCourse.setText("");
        jTextFieldTeacher.setText("");
        jTextFieldResult1.setText("");
        jTextFieldResult2.setText("");
        jTextFieldResult3.setText("");
        jTextFieldTest1.setText("");
        jTextFieldTest2.setText("");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseEntered
        setColor(jButtonUpdate);
    }//GEN-LAST:event_jButtonUpdateMouseEntered

    private void jButtonUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseExited
        resetColor(jButtonUpdate);
    }//GEN-LAST:event_jButtonUpdateMouseExited

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try {
            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            String id_student = jTextFieldIDStudent.getText();
            String id_room = jTextFieldIDRoom.getText();
            String result1 = jTextFieldResult1.getText();
            String result2 = jTextFieldResult2.getText();
            String result3 = jTextFieldResult3.getText();
            String test1 = jTextFieldTest1.getText();
            String test2 = jTextFieldTest2.getText();
            
            session.updateScore(id_student, id_room, result1, result2, result3, test1, test2);
            JOptionPane.showMessageDialog(null, "Update successfully!");
        } catch (NamingException e) {
            Logger.getLogger(EditMark.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCloseMouseEntered
        setColor(jButtonClose);
    }//GEN-LAST:event_jButtonCloseMouseEntered

    private void jButtonCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCloseMouseExited
        resetColor(jButtonClose);
    }//GEN-LAST:event_jButtonCloseMouseExited

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    
    public void setColor(javax.swing.JButton button) {
        button.setBackground(new java.awt.Color(115, 163, 239));
    }

    public void resetColor(javax.swing.JButton button) {
        button.setBackground(new java.awt.Color(12, 91, 160));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxClass;
    private javax.swing.JTable jDataTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCourse;
    private javax.swing.JLabel jLabelFullName;
    private javax.swing.JLabel jLabelIDRoom;
    private javax.swing.JLabel jLabelIDStudent;
    private javax.swing.JLabel jLabelResult1;
    private javax.swing.JLabel jLabelResult2;
    private javax.swing.JLabel jLabelResult3;
    private javax.swing.JLabel jLabelTeacher;
    private javax.swing.JLabel jLabelTest1;
    private javax.swing.JLabel jLabelTest2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldCourse;
    private javax.swing.JTextField jTextFieldFullName;
    private javax.swing.JTextField jTextFieldIDRoom;
    private javax.swing.JTextField jTextFieldIDStudent;
    private javax.swing.JTextField jTextFieldResult1;
    private javax.swing.JTextField jTextFieldResult2;
    private javax.swing.JTextField jTextFieldResult3;
    private javax.swing.JTextField jTextFieldTeacher;
    private javax.swing.JTextField jTextFieldTest1;
    private javax.swing.JTextField jTextFieldTest2;
    // End of variables declaration//GEN-END:variables
}
