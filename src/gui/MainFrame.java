/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import resources.DefaultValues;

/**
 *
 * @author jefal
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialButton = new javax.swing.JButton();
        loanButton = new javax.swing.JButton();
        studentsButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        studentsModuleLabel = new javax.swing.JLabel();
        materialModuleLabel = new javax.swing.JLabel();
        loanModuleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BiblioTech");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 450));
        setResizable(false);

        materialButton.setBackground(new java.awt.Color(255, 102, 102));
        materialButton.setForeground(new java.awt.Color(255, 102, 102));
        materialButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/MATERIAL_ICON.png"))); // NOI18N
        materialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButtonActionPerformed(evt);
            }
        });

        loanButton.setBackground(new java.awt.Color(255, 204, 102));
        loanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/LOAN_ICON.png"))); // NOI18N
        loanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanButtonActionPerformed(evt);
            }
        });

        studentsButton.setBackground(new java.awt.Color(51, 153, 255));
        studentsButton.setForeground(new java.awt.Color(51, 153, 255));
        studentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/STUDENT_ICON.png"))); // NOI18N
        studentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("BiblioTech");

        studentsModuleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentsModuleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentsModuleLabel.setText("Registro de estudiantes");

        materialModuleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        materialModuleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        materialModuleLabel.setText("Manejo de materiales");

        loanModuleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loanModuleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loanModuleLabel.setText("Manejo de préstamos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentsModuleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(materialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(materialModuleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(loanModuleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentsModuleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(materialModuleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loanModuleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(studentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materialButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsButtonActionPerformed
        // TODO add your handling code here:
        EnterStudentFrame enterStudentFrame = new EnterStudentFrame();
        enterStudentFrame.setVisible(true);
    }//GEN-LAST:event_studentsButtonActionPerformed

    private void materialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButtonActionPerformed
        // TODO add your handling code here:
        Object selected = JOptionPane.showInputDialog(null, 
                "Elija un tipo de recurso a registrar:", 
                "Selection", JOptionPane.DEFAULT_OPTION, null, 
                DefaultValues.MATERIAL_TYPE, "0");
        if (selected != null){ // Es nulo si no se scepta
            String selectedString = selected.toString();
            switch (selectedString){
                case "Reproductor multimedia":
                    EnterMediaPlayerFrame enterMediaPlayerFrame = new EnterMediaPlayerFrame();
                    enterMediaPlayerFrame.setVisible(true);
                    break;
                case "Multimedia":
                    EnterMediaFrame enterMediaFrame = new EnterMediaFrame();
                    enterMediaFrame.setVisible(true);
                    break;
                case "Libro":
                    EnterBookFrame enterBookFrame = new EnterBookFrame();
                    enterBookFrame.setVisible(true);
                    break;
            }
        }
    }//GEN-LAST:event_materialButtonActionPerformed

    private void loanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanButtonActionPerformed
        // TODO add your handling code here:        
        Object actionSelection = JOptionPane.showInputDialog(null, 
                "Elija un que desea hacer:", 
                "Selection", JOptionPane.DEFAULT_OPTION, null, 
                DefaultValues.LOAN_ACTIONS, "0");
        if (actionSelection != null){ // Es nulo si no se scepta
            String actionSelectionString = actionSelection.toString();
            switch (actionSelectionString){
                case "Registrar nuevo préstamo":
                    Object loanTypeSelection = JOptionPane.showInputDialog(null, 
                            "Elija el tipo de préstamo:", 
                            "Selection", JOptionPane.DEFAULT_OPTION, null, 
                            DefaultValues.MATERIAL_TYPE, "0");
                    if (loanTypeSelection != null){ // Es nulo si no se scepta
                        String loanTypeString = loanTypeSelection.toString();
                        switch (loanTypeString){
                            case "Reproductor multimedia":
                                // MediaPlayer multimedia
                                MediaPlayerLoanFrame mediaPlayerLoanFrame = new MediaPlayerLoanFrame();
                                mediaPlayerLoanFrame.setVisible(true);
                                break;
                            case "Multimedia":
                                // Préstamo multimedia
                                MediaLoanFrame mediaLoanFrame = new MediaLoanFrame();
                                mediaLoanFrame.setVisible(true);
                                break;
                            case "Libro":
                                BookLoanFrame bookLoanFrame = new BookLoanFrame();
                                bookLoanFrame.setVisible(true);
                                break;
                        }
                    }
                    break;
                case "Terminar préstamo":
                    // Frame de terminar préstamo
                    EndLoan endLoan = new EndLoan();
                    endLoan.setVisible(true);
                    break;
            }
        }
        
    }//GEN-LAST:event_loanButtonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                else if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loanButton;
    private javax.swing.JLabel loanModuleLabel;
    private javax.swing.JButton materialButton;
    private javax.swing.JLabel materialModuleLabel;
    private javax.swing.JButton studentsButton;
    private javax.swing.JLabel studentsModuleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
