/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Book;
import domain.Loan;
import domain.Material;
import domain.Media;
import domain.MediaPlayer;
import domain.Student;
import file.BookFile;
import file.LoanFile;
import file.MediaFile;
import file.MediaPlayerFile;
import file.StudentFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import resources.DefaultValues;

/**
 *
 * @author jefal
 */
public class EndLoanFrame extends javax.swing.JFrame {

    /**
     * Creates new form EndLoanFrame
     */
    
    private DefaultTableModel tableModel;
    private LoanFile loanFile;
    private StudentFile studentFile;
    private BookFile bookFile;
    private MediaFile mediaFile;
    private MediaPlayerFile mediaPlayerFile;
    
    
    public EndLoanFrame() {
        initComponents();
        
        tableModel = new DefaultTableModel(DefaultValues.LOAN_TABLE_COLUMNS, 0);
        
        try{
            File fileLoan = new File(DefaultValues.LOAN_FILE_PATH);
            loanFile = new LoanFile(fileLoan);
            List<Loan> loans = loanFile.getAllRecords();
            for(Loan currentLoan : loans){
                Object row[] = { currentLoan.getStudent().getId(),
                                 currentLoan.getMaterial().getId(),
                                 getMaterialKind(currentLoan.getMaterial()),
                                 getLoanState(currentLoan.isFinished()),
                                 currentLoan.getEndDate().toString()
                               };
                tableModel.addRow(row);
            }
            loansTable.setModel(tableModel);
            loansTable.setAutoCreateRowSorter(true);
            
            studentFile = new StudentFile(new File(DefaultValues.STUDENT_FILE_PATH));
            bookFile = new BookFile(new File(DefaultValues.BOOK_FILE_PATH));
            mediaFile = new MediaFile(new File(DefaultValues.MEDIA_FILE_PATH));
            mediaPlayerFile = new MediaPlayerFile(new File(DefaultValues.MEDIA_PLAYER_FILE_PATH));
            
        }
        catch(Exception e){
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(this, DefaultValues.DEFAULT_QUERY_ERROR);
        }
    }
    
    private String getLoanState(boolean finished){
        if(finished){
            return DefaultValues.IS_FINISHED_STATE;
        }
        else{
            return DefaultValues.IS_NOT_FINISHED_STATE;
        }
    }
    
    private String getMaterialKind(Material material){
        if(material instanceof Book){
            return DefaultValues.MATERIAL_TYPE[0]; // Libros
        }
        else if(material instanceof Media){
            return DefaultValues.MATERIAL_TYPE[1]; // Multimedia
        }
        else{
            return DefaultValues.MATERIAL_TYPE[2]; // Reproductor multimedia
        }
    }
    
    private String getClassName(String materialKind){
        if( materialKind.equals(DefaultValues.MATERIAL_TYPE[0]) ){
            return DefaultValues.BOOK_CLASS_NAME;
        }
        else if (materialKind.equals(DefaultValues.MATERIAL_TYPE[1])) {
            return DefaultValues.MEDIA_CLASS_NAME;
        }
        else{
            return DefaultValues.MEDIA_PLAYER_CLASS_NAME;
        }
    }
    
    private int getMaterialIndex(String id, String materialKind) throws IOException{
        if( materialKind.equals(DefaultValues.MATERIAL_TYPE[0]) ){
            return bookFile.searchRecord(id);
        }
        else if (materialKind.equals(DefaultValues.MATERIAL_TYPE[1])) {
            return mediaFile.searchRecord(id);
        }
        else{
            return mediaPlayerFile.searchRecord(id);
        }
    }
    
    private Material getMaterial(int index, String kind) throws IOException{
        if( kind.equals(DefaultValues.BOOK_CLASS_NAME) ){
            return bookFile.getRecord(index);
        }
        else if (kind.equals(DefaultValues.MEDIA_CLASS_NAME)) {
            return mediaFile.getRecord(index);
        }
        else{
            return mediaPlayerFile.getRecord(index);
        }
    }
    
    private void putMaterial(Material material, int index, String kind) throws IOException{
        if( kind.equals(DefaultValues.BOOK_CLASS_NAME) ){
            bookFile.putValue(index, (Book) material);
        }
        else if (kind.equals(DefaultValues.MEDIA_CLASS_NAME)) {
            mediaFile.putValue(index, (Media) material);
        }
        else{
            mediaPlayerFile.putValue(index, (MediaPlayer) material);
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

        bookTitleLabel = new javax.swing.JLabel();
        bookSearchTextField = new javax.swing.JTextField();
        searchLoanButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        loansTable = new javax.swing.JTable();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        frameTitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        bookTitleLabel.setText("Búsqueda");

        searchLoanButton.setText("Buscar");
        searchLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLoanButtonActionPerformed(evt);
            }
        });

        loansTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(loansTable);

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

        frameTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        frameTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameTitleLabel.setText("Terminar préstamo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frameTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bookSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchLoanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitleLabel)
                    .addComponent(bookSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLoanButton))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchLoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLoanButtonActionPerformed
        // TODO add your handling code here:

        //Texto a buscar
        String query = bookSearchTextField.getText().toLowerCase();

        //Filtrador de la tabla
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
        loansTable.setRowSorter(tableRowSorter);

        //Filtra la tabla segun el texto a buscar
        //usa una expresion regular para omitir las mayusculas
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));

    }//GEN-LAST:event_searchLoanButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        
        //Guarda los ids de la tabla
        String studentId = loansTable.getValueAt(loansTable.getSelectedRow(), 0).toString();
        String materialId = loansTable.getValueAt(loansTable.getSelectedRow(), 1).toString();
        //Guarda el tipo de material (Media, MediaPlayer, Book)
        String materialKind = loansTable.getValueAt(loansTable.getSelectedRow(), 2).toString();
        //Guarda el estado del prestamo
        String state = loansTable.getValueAt(loansTable.getSelectedRow(), 3).toString();
        //Guarda la fecha de finalizacion
        Date endDate = new Date (loansTable.getValueAt(loansTable.getSelectedRow(), 4).toString());
        //Calcula los dias entre la fecha de finalizacion y la actual
        int days = DefaultValues.daysBetween(endDate, new Date());
        //Multa a cobrar
        int fee = 0;
        //Si la cantidad de dias entre fechas es mayor a 0
        if(days > 0){
            //Calcula la multa multiplicando los dias con el monto asignado
            fee = days * Integer.parseInt(
            DefaultValues.loadSetting(DefaultValues.FEE_PER_DAY_SETTINGS_KEY)
                                         );
        }
        
        //Si el estado del prestamo es activo
        if(state.equals(DefaultValues.IS_NOT_FINISHED_STATE)){
            //Crea un dialogo para preguntar si se termina o no el prestamo
            //Muestra un mensaje con la multa a pagar
            int dialogResult = JOptionPane.showConfirmDialog (null, 
                DefaultValues.FEE_PAYMENT_WARNING +
                String.valueOf(fee) +
                DefaultValues.FEE_PAYMENT_CONFIRMATION,
                DefaultValues.DEFAULT_YES_NO_DIALOG_TITLE,
                JOptionPane.YES_NO_OPTION);
            
            //Si se acepta terminar el prestamo
            if(dialogResult == JOptionPane.YES_OPTION){
                try{
                    //Busca las posiciones del prestamo, estudiante y material
                    int loanIndex = loanFile.searchRecord(studentId, materialId, endDate);
                    int studentIndex = studentFile.searchRecord(studentId);
                    int materialIndex = getMaterialIndex(materialId, materialKind);
                    //Obtiene el nombre de la clase que corresponde al prestamo
                    //(Media, MediaPlayer, Book)
                    String materialClass = getClassName(materialKind);
                    //Obtiene el objeto Loan
                    Loan loan = loanFile.getRecord(loanIndex);
                    //Lo marca como acabado, guarda la multa y lo actualiza en el RAF
                    loan.setFinished(true);
                    loan.setFee(fee);
                    loanFile.putValue(loanIndex, loan, studentIndex, materialIndex, materialClass);
                    
                    //Obtiene el material
                    Material material = getMaterial(materialIndex, materialClass);
                    //Aumenta la cantidad disponible
                    material.setAvailable(material.getAvailable() + 1);
                    //Actualiza el material en el RAF
                    putMaterial(material, materialIndex, materialClass);
                    
                    this.dispose();
                }
                catch(Exception e){
                    System.err.println(e.toString());
                    JOptionPane.showMessageDialog(this, DefaultValues.DEFAULT_QUERY_ERROR);
                }
                
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, DefaultValues.END_FINISHED_LOAN);
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EndLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndLoanFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndLoanFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookSearchTextField;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel frameTitleLabel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable loansTable;
    private javax.swing.JButton searchLoanButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
