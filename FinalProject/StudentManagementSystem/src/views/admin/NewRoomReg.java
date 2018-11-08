/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.admin;

import control.InitialStatelessStudentOrAdmin;
import edu.tdt.entity.Room;
import edu.tdt.service.SystemStudentManagementRemote;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class NewRoomReg extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegisterCourse
     */
    InitialStatelessStudentOrAdmin init;
    DefaultTableModel dftable1;
    DefaultTableModel dftable2;

    public NewRoomReg() {
        initComponents();
        init = new InitialStatelessStudentOrAdmin();
        dftable1 = (DefaultTableModel) jDataTable.getModel();
        dftable2 = (DefaultTableModel) jDataTable1.getModel();
    }

    private void loadCoursesOnJTable() {
        try {
            dftable1.setRowCount(0);

            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            List<Object[]> courses = session.getCourses();

            for (int i = 0; i < courses.size(); i++) {
                String id_course = courses.get(i)[0].toString();
                String name = courses.get(i)[1].toString();
                String duration = courses.get(i)[2].toString();
                String fee = courses.get(i)[3].toString();
                String type = courses.get(i)[4].toString();

                Object[] ojb = {id_course, name, duration, fee, type};
                dftable1.addRow(ojb);
            }
        } catch (NamingException ex) {
            Logger.getLogger(NewRoomReg.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTeachersOnJTable() {
        try {
            dftable2.setRowCount(0);
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            List<Object[]> teachers = session.getAllTeachers();

            for (int i = 0; i < teachers.size(); i++) {
                String id_student = teachers.get(i)[0].toString();
                String fullname = teachers.get(i)[2].toString() + " " + teachers.get(i)[1].toString();
                String student_birthday = formatter1.format(formatter2.parse(teachers.get(i)[3].toString()));
                String gender = ("true".equals(teachers.get(i)[4].toString())) ? "Male" : "Female";
                String email = teachers.get(i)[6].toString();

                Object[] ojb = {id_student, fullname, student_birthday, gender, email};
                dftable2.addRow(ojb);
            }
        } catch (NamingException | ParseException ex) {
            Logger.getLogger(NewRoomReg.class
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jDataTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDataTable1 = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        jLabelIDCourse = new javax.swing.JLabel();
        jTextFieldIDCourse = new javax.swing.JTextField();
        jLabelNameCourse = new javax.swing.JLabel();
        jTextFieldNameCourse = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        jTextFieldType = new javax.swing.JTextField();
        jLabelIDTeacher = new javax.swing.JLabel();
        jTextFieldIDTeacher = new javax.swing.JTextField();
        jLabelNameTeacher = new javax.swing.JLabel();
        jTextFieldNameTeacher = new javax.swing.JTextField();
        JLabelBirthday = new javax.swing.JLabel();
        jTextFieldBirthday = new javax.swing.JTextField();
        jLabelIDRoom = new javax.swing.JLabel();
        jTextFieldIDRoom = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        jComboBoxDay = new javax.swing.JComboBox<>();
        jComboBoxMonth = new javax.swing.JComboBox<>();
        jComboBoxYear = new javax.swing.JComboBox<>();
        jLabelSession = new javax.swing.JLabel();
        jTextFieldSession = new javax.swing.JTextField();
        jButtonCreate = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonLoadData1 = new javax.swing.JButton();
        jButtonLoadData2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Room Registration");

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
        jDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jDataTable);

        jDataTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jDataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Birthday", "Gender", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jDataTable1.setRowHeight(30);
        jDataTable1.setRowMargin(2);
        jDataTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDataTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jDataTable1);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 51, 204));
        jLabelTitle.setText("CREATE ROOM FOR COURSE");

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setPreferredSize(new java.awt.Dimension(1920, 402));
        jPanel.setLayout(null);

        jLabelIDCourse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelIDCourse.setText("ID Course");
        jPanel.add(jLabelIDCourse);
        jLabelIDCourse.setBounds(370, 30, 119, 29);

        jTextFieldIDCourse.setEditable(false);
        jTextFieldIDCourse.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIDCourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldIDCourse);
        jTextFieldIDCourse.setBounds(230, 70, 400, 40);

        jLabelNameCourse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNameCourse.setText("Name");
        jPanel.add(jLabelNameCourse);
        jLabelNameCourse.setBounds(390, 130, 70, 29);

        jTextFieldNameCourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldNameCourse);
        jTextFieldNameCourse.setBounds(230, 180, 400, 40);

        jLabelType.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelType.setText("Type");
        jPanel.add(jLabelType);
        jLabelType.setBounds(390, 260, 60, 29);

        jTextFieldType.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldType);
        jTextFieldType.setBounds(230, 310, 400, 40);

        jLabelIDTeacher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelIDTeacher.setText("ID Teacher");
        jPanel.add(jLabelIDTeacher);
        jLabelIDTeacher.setBounds(1460, 30, 140, 29);

        jTextFieldIDTeacher.setEditable(false);
        jTextFieldIDTeacher.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIDTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldIDTeacher);
        jTextFieldIDTeacher.setBounds(1310, 70, 400, 40);

        jLabelNameTeacher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNameTeacher.setText("Full Name");
        jPanel.add(jLabelNameTeacher);
        jLabelNameTeacher.setBounds(1462, 133, 120, 29);

        jTextFieldNameTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldNameTeacher);
        jTextFieldNameTeacher.setBounds(1310, 180, 400, 40);

        JLabelBirthday.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLabelBirthday.setText("Birthday");
        jPanel.add(JLabelBirthday);
        JLabelBirthday.setBounds(1473, 263, 101, 29);

        jTextFieldBirthday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldBirthday);
        jTextFieldBirthday.setBounds(1310, 310, 400, 40);

        jLabelIDRoom.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelIDRoom.setText("ID Room");
        jPanel.add(jLabelIDRoom);
        jLabelIDRoom.setBounds(910, 30, 110, 29);

        jTextFieldIDRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldIDRoom);
        jTextFieldIDRoom.setBounds(760, 70, 400, 40);

        jLabelDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelDate.setText("Start");
        jPanel.add(jLabelDate);
        jLabelDate.setBounds(930, 140, 70, 29);

        jComboBoxDay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel.add(jComboBoxDay);
        jComboBoxDay.setBounds(830, 190, 63, 28);

        jComboBoxMonth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jPanel.add(jComboBoxMonth);
        jComboBoxMonth.setBounds(920, 190, 83, 28);

        jComboBoxYear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970" }));
        jPanel.add(jComboBoxYear);
        jComboBoxYear.setBounds(1040, 190, 73, 28);

        jLabelSession.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelSession.setText("Session");
        jPanel.add(jLabelSession);
        jLabelSession.setBounds(920, 250, 100, 29);

        jTextFieldSession.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel.add(jTextFieldSession);
        jTextFieldSession.setBounds(760, 300, 400, 40);

        jButtonCreate.setBackground(new java.awt.Color(12, 91, 160));
        jButtonCreate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonCreate.setText("Create");
        jButtonCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCreateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCreateMouseExited(evt);
            }
        });
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

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

        jButtonLoadData1.setBackground(new java.awt.Color(12, 91, 160));
        jButtonLoadData1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonLoadData1.setText("Load");
        jButtonLoadData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoadData1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoadData1MouseExited(evt);
            }
        });
        jButtonLoadData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadData1ActionPerformed(evt);
            }
        });

        jButtonLoadData2.setBackground(new java.awt.Color(12, 91, 160));
        jButtonLoadData2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonLoadData2.setText("Load");
        jButtonLoadData2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoadData2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoadData2MouseExited(evt);
            }
        });
        jButtonLoadData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadData2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1877, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(849, 849, 849)
                        .addComponent(jButtonCreate)
                        .addGap(66, 66, 66)
                        .addComponent(jButtonReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(692, 692, 692)
                        .addComponent(jLabelTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jButtonLoadData1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoadData2)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButtonLoadData1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLoadData2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreate)
                    .addComponent(jButtonReset))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataTableMouseClicked
        int selectedIndexRow = jDataTable.getSelectedRow();

        jTextFieldIDCourse.setText(dftable1.getValueAt(selectedIndexRow, 0).toString());
        jTextFieldNameCourse.setText(dftable1.getValueAt(selectedIndexRow, 1).toString());
        jTextFieldType.setText(dftable1.getValueAt(selectedIndexRow, 2).toString());
    }//GEN-LAST:event_jDataTableMouseClicked

    private void jDataTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDataTable1MouseClicked
        int selectedIndexRow = jDataTable1.getSelectedRow();

        jTextFieldIDTeacher.setText(dftable2.getValueAt(selectedIndexRow, 0).toString());
        jTextFieldNameTeacher.setText(dftable2.getValueAt(selectedIndexRow, 1).toString());
        jTextFieldBirthday.setText(dftable2.getValueAt(selectedIndexRow, 2).toString());

    }//GEN-LAST:event_jDataTable1MouseClicked

    private void jButtonCreateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateMouseEntered
        setColor(jButtonCreate);
    }//GEN-LAST:event_jButtonCreateMouseEntered

    private void jButtonCreateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateMouseExited
        resetColor(jButtonCreate);
    }//GEN-LAST:event_jButtonCreateMouseExited

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        try {
            SystemStudentManagementRemote session = (SystemStudentManagementRemote) init.getCtx().lookup(init.getJNDI());
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            //Get start date of room from combobox
            Date date;

            String day = jComboBoxDay.getSelectedItem().toString();
            if (day.equals("Day")) {
                jComboBoxDay.requestFocus();
                return;
            }

            String month = jComboBoxMonth.getSelectedItem().toString();
            if (month.equals("Month")) {
                jComboBoxMonth.requestFocus();
                return;
            }
            
            String year = jComboBoxYear.getSelectedItem().toString();
            if (year.equals("Year")) {
                jComboBoxYear.requestFocus();
                return;
            }

            String start_date = day + "-" + month + "-" + year;
            
            //Check stringBirth is valid or not 
            if (checkValid(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year))) {
                date = formatter.parse(start_date);
                
            } else {
                JOptionPane.showMessageDialog(null, "Date is not valid!!!");
                return;
            }
            
            Room room = new Room();            
            room.setId(jTextFieldIDRoom.getText());
            room.setStartDate(date);
            room.setSession(Integer.parseInt(jTextFieldSession.getText()));
            
            session.insertRoom(room, jTextFieldIDCourse.getText(), jTextFieldIDTeacher.getText());
            
            JOptionPane.showMessageDialog(null, "Assign successfully!");
        } catch (NamingException | ParseException e) {
            Logger.getLogger(NewRoomReg.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jButtonResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetMouseEntered
        setColor(jButtonReset);
    }//GEN-LAST:event_jButtonResetMouseEntered

    private void jButtonResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetMouseExited
        resetColor(jButtonReset);
    }//GEN-LAST:event_jButtonResetMouseExited

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        jTextFieldIDTeacher.setText("");
        jTextFieldNameTeacher.setText("");
        jTextFieldNameCourse.setText("");
        jTextFieldIDCourse.setText("");
        jTextFieldType.setText("");
        jTextFieldBirthday.setText(""); 
        jTextFieldIDRoom.setText("");
        jTextFieldSession.setText("");
        jComboBoxDay.setSelectedIndex(0);
        jComboBoxMonth.setSelectedIndex(0);
        jComboBoxYear.setSelectedIndex(0);
        
        jTextFieldIDTeacher.requestFocus();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonLoadData1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoadData1MouseEntered
        setColor(jButtonLoadData1);
    }//GEN-LAST:event_jButtonLoadData1MouseEntered

    private void jButtonLoadData1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoadData1MouseExited
        resetColor(jButtonLoadData1);
    }//GEN-LAST:event_jButtonLoadData1MouseExited

    private void jButtonLoadData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadData1ActionPerformed
        loadCoursesOnJTable();
    }//GEN-LAST:event_jButtonLoadData1ActionPerformed

    private void jButtonLoadData2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoadData2MouseEntered
        setColor(jButtonLoadData2);
    }//GEN-LAST:event_jButtonLoadData2MouseEntered

    private void jButtonLoadData2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoadData2MouseExited
        resetColor(jButtonLoadData2);
    }//GEN-LAST:event_jButtonLoadData2MouseExited

    private void jButtonLoadData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadData2ActionPerformed
        loadTeachersOnJTable();
    }//GEN-LAST:event_jButtonLoadData2ActionPerformed

    public void setColor(javax.swing.JButton button) {
        button.setBackground(new java.awt.Color(115, 163, 239));
    }

    public void resetColor(javax.swing.JButton button) {
        button.setBackground(new java.awt.Color(12, 91, 160));
    }
    
    public boolean checkValid(int day, int month, int year) {
        if (isLeapYear(year)) {
            if (month == 2 && day > 29) {
                return false;
            }
        } else {
            if (month == 2 && day > 28) {
                return false;
            }
        }
        return true;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelBirthday;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonLoadData1;
    private javax.swing.JButton jButtonLoadData2;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JComboBox<String> jComboBoxDay;
    private javax.swing.JComboBox<String> jComboBoxMonth;
    private javax.swing.JComboBox<String> jComboBoxYear;
    private javax.swing.JTable jDataTable;
    private javax.swing.JTable jDataTable1;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelIDCourse;
    private javax.swing.JLabel jLabelIDRoom;
    private javax.swing.JLabel jLabelIDTeacher;
    private javax.swing.JLabel jLabelNameCourse;
    private javax.swing.JLabel jLabelNameTeacher;
    private javax.swing.JLabel jLabelSession;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldBirthday;
    private javax.swing.JTextField jTextFieldIDCourse;
    private javax.swing.JTextField jTextFieldIDRoom;
    private javax.swing.JTextField jTextFieldIDTeacher;
    private javax.swing.JTextField jTextFieldNameCourse;
    private javax.swing.JTextField jTextFieldNameTeacher;
    private javax.swing.JTextField jTextFieldSession;
    private javax.swing.JTextField jTextFieldType;
    // End of variables declaration//GEN-END:variables
}
