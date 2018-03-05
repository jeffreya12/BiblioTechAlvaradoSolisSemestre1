/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.MediaPlayer;
import domain.Loan;
import domain.Student;
import file.MediaPlayerFile;
import file.LoanFile;
import file.StudentFile;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import resources.DefaultValues;

/**
 *
 * @author jefal
 */
public class MediaPlayerLoanFrame extends javax.swing.JFrame {

    
    private boolean studentExist;
    private int studentIndex;
    private DefaultTableModel tableModel;
    private MediaPlayerFile mediaPlayerFile;
    private StudentFile studentFile;
    
    /**
     * Creates new form LoanFrame
     */
    public MediaPlayerLoanFrame() {
        initComponents();
        
        studentExist = false;
        
        tableModel = new DefaultTableModel(DefaultValues.MEDIA_PLAYER_TABLE_COLUMNS, 0);
        
        try{
            File fileMediaPlayer = new File(DefaultValues.MEDIA_PLAYER_FILE_PATH);
            mediaPlayerFile = new MediaPlayerFile(fileMediaPlayer);
            List<MediaPlayer> mediaPlayers = mediaPlayerFile.getAllRecords();
            for(MediaPlayer currentMediaPlayer : mediaPlayers){
                Object row[] = { currentMediaPlayer.getBrand(), currentMediaPlayer.getModel(),
                                 currentMediaPlayer.getKind(), currentMediaPlayer.getId(),
                                 currentMediaPlayer.getAvailable()
                               };
                tableModel.addRow(row);
            }
            mediaPlayersTable.setModel(tableModel);
        }
        catch(Exception e){
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(this, DefaultValues.DEFAULT_QUERY_ERROR);
        }
        
        endDatePicker.setDate(new Date());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameTitleLabel = new javax.swing.JLabel();
        idStudentLabel = new javax.swing.JLabel();
        idStudentTextField = new javax.swing.JTextField();
        idStudentComboBox = new javax.swing.JComboBox<>();
        mediaPlayerTitleLabel = new javax.swing.JLabel();
        mediaPlayerSearchTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        verifyStudentButton = new javax.swing.JButton();
        searchMediaPlayerButton = new javax.swing.JButton();
        verificationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        endDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane = new javax.swing.JScrollPane();
        mediaPlayersTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        frameTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        frameTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameTitleLabel.setText("Nuevo préstamo");

        idStudentLabel.setText("Identificador del estudiante");

        idStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IC", "IM", "IE" }));

        mediaPlayerTitleLabel.setText("Búsqueda");

        submitButton.setText("Aceptar");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        verifyStudentButton.setText("Verificar");
        verifyStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyStudentButtonActionPerformed(evt);
            }
        });

        searchMediaPlayerButton.setText("Buscar");
        searchMediaPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMediaPlayerButtonActionPerformed(evt);
            }
        });

        verificationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/WRONG_ICON.png"))); // NOI18N

        dateLabel.setText("Fecha de finalización");

        mediaPlayersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(mediaPlayersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(frameTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mediaPlayerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(idStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(idStudentTextField)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(verificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(mediaPlayerSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(verifyStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchMediaPlayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idStudentLabel)
                                    .addComponent(idStudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(verificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mediaPlayerTitleLabel)
                            .addComponent(mediaPlayerSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verifyStudentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchMediaPlayerButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void verifyStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyStudentButtonActionPerformed
        // TODO add your handling code here:
        
        String id = idStudentComboBox.getSelectedItem().toString() +
                    idStudentTextField.getText();
        
        ImageIcon verificationIcon;
        
        try {
            File fileStudent = new File(DefaultValues.STUDENT_FILE_PATH);
            studentFile = new StudentFile(fileStudent);
            studentIndex = studentFile.searchRecord(id);
            
            if (studentIndex != -1 ){
                verificationIcon = new ImageIcon(DefaultValues.CHECK_ICON_PATH);
                verificationLabel.setIcon(verificationIcon);
                studentExist = true;
            }
            
            else{
                verificationIcon = new ImageIcon(DefaultValues.WRONG_ICON_PATH);
                verificationLabel.setIcon(verificationIcon);
                studentExist = false;
                JOptionPane.showMessageDialog(this, DefaultValues.STUDENT_NOT_FOUND_ERROR);
            }
        }
        catch (Exception e){
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(this, DefaultValues.FAILED_SEARCH);
        }    
        
        
    }//GEN-LAST:event_verifyStudentButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchMediaPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMediaPlayerButtonActionPerformed
        // TODO add your handling code here:
        
        String query = mediaPlayerSearchTextField.getText().toLowerCase();
        
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
        mediaPlayersTable.setRowSorter(tableRowSorter);
        
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        
    }//GEN-LAST:event_searchMediaPlayerButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        
        String mediaPlayerId = mediaPlayersTable.getValueAt(mediaPlayersTable.getSelectedRow(), 3).toString();
        int available = Integer.parseInt(mediaPlayersTable.getValueAt(mediaPlayersTable.getSelectedRow(), 4).toString());
        Date endLoanDate = endDatePicker.getDate();
        
        if (available > 0 && studentExist){
            try{
                int mediaPlayerIndex = mediaPlayerFile.searchRecord(mediaPlayerId);
                MediaPlayer mediaPlayer = mediaPlayerFile.getRecord(mediaPlayerIndex);
                Student student = studentFile.getRecord(studentIndex);
                
                Loan newLoan = new Loan(student, mediaPlayer, endLoanDate);
                
                
                try{
                    File fileLoan = new File(DefaultValues.LOAN_FILE_PATH);
                    LoanFile loanFile = new LoanFile(fileLoan);
                    loanFile.addEndRecord(newLoan, studentIndex, mediaPlayerIndex,
                            DefaultValues.MEDIA_PLAYER_CLASS_NAME);
                    
                    loanFile.close();
                    
                    mediaPlayer.setAvailable(available - 1);
                    mediaPlayerFile.putValue(mediaPlayerIndex, mediaPlayer);

                    this.dispose();
                }
                catch(Exception e){
                    System.err.println(e.toString());
                    JOptionPane.showMessageDialog(this, DefaultValues.DEFAULT_QUERY_ERROR);
                }
                
                studentFile.close();
                mediaPlayerFile.close();
                
                this.dispose();
                
            }
            catch(Exception e){
                System.err.println(e.toString());
                JOptionPane.showMessageDialog(this, DefaultValues.DEFAULT_QUERY_ERROR);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, DefaultValues.INVALID_OPTIONS);
        }
        
        
    }//GEN-LAST:event_submitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MediaPlayerLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MediaPlayerLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MediaPlayerLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MediaPlayerLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MediaPlayerLoanFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private org.jdesktop.swingx.JXDatePicker endDatePicker;
    private javax.swing.JLabel frameTitleLabel;
    private javax.swing.JComboBox<String> idStudentComboBox;
    private javax.swing.JLabel idStudentLabel;
    private javax.swing.JTextField idStudentTextField;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField mediaPlayerSearchTextField;
    private javax.swing.JLabel mediaPlayerTitleLabel;
    private javax.swing.JTable mediaPlayersTable;
    private javax.swing.JButton searchMediaPlayerButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel verificationLabel;
    private javax.swing.JButton verifyStudentButton;
    // End of variables declaration//GEN-END:variables
}
