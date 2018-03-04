/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Loan;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import resources.DefaultValues;

/**
 *
 * @author jefal
 */
public class LoanFile {
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;

    public LoanFile(File file) throws IOException{
        start(file);
    }
    
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = DefaultValues.LOAN_REG_SIZE;
        
        //una validacion basica
        if(file.exists() && !file.isFile()){
            throw new IOException(file.getName() 
                    + " is an invalid file");
        }
        else{
            //crear la nueva instancia de randomAccessFile
            randomAccessFile = new RandomAccessFile(file, "rw");
            
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)regSize);
        }
    }//fin start
    
    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    public int fileSize(){
        return regsQuantity;
    }
    
    public boolean putValue(int position, Loan loan, 
            int studentIndex, int materialIndex,
            String loanType) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(loan.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                                
                randomAccessFile.writeLong(loan.getEndDate().getTime());
                randomAccessFile.writeBoolean(loan.isFinished());
                randomAccessFile.writeInt(loan.getFee());
                randomAccessFile.writeInt(studentIndex);
                randomAccessFile.writeUTF(loanType);
                randomAccessFile.writeInt(materialIndex);
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }//fin metodo
    
    public boolean addEndRecord(Loan loan, int studentIndex, int materialIndex, 
            String loanType) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, loan, studentIndex, 
                materialIndex, loanType);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    public Loan getRecord(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            
            StudentFile studentFile = new StudentFile(new File (DefaultValues.STUDENT_FILE_PATH));
            
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Loan myLoan = new Loan();
            
            Date endDateTemp = new Date();
            
            //llevamos a cabo las lecturas
            endDateTemp.setTime(randomAccessFile.readLong());
            myLoan.setFinished(randomAccessFile.readBoolean());
            myLoan.setFee(randomAccessFile.readInt());
            myLoan.setStudent(studentFile.getRecord(randomAccessFile.readInt()));
            String loanType = randomAccessFile.readUTF();
            int materialIndex = randomAccessFile.readInt();
                    
            myLoan.setEndDate(endDateTemp);
            
            switch(loanType){
                case "Book":
                    BookFile bookFile = new BookFile(new File(DefaultValues.BOOK_FILE_PATH));
                    myLoan.setMaterial(bookFile.getRecord(materialIndex));
                    bookFile.close();
                    break;
                    
                case "Media":
                    MediaFile mediaFile = new MediaFile(new File(DefaultValues.MEDIA_FILE_PATH));
                    myLoan.setMaterial(mediaFile.getRecord(materialIndex));
                    mediaFile.close();
                    break;
                    
                case "MediaPlayer":
                    MediaPlayerFile mediaPlayerFile = new MediaPlayerFile(new File(DefaultValues.MEDIA_PLAYER_FILE_PATH));
                    myLoan.setMaterial(mediaPlayerFile.getRecord(materialIndex));
                    mediaPlayerFile.close();
                    break;
            }
            
            studentFile.close();
            
            return myLoan;            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo
    
    public List<Loan> getAllRecords() throws IOException{
        
        //variables a retornar
        List<Loan> loans = new ArrayList<Loan>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Loan loanTemp = this.getRecord(i);
            
            if(loanTemp != null){
                loans.add(loanTemp);
            }
        }
        
        return loans;
    }//fin metodo
    
    public int searchRecord(String studentId, String materialId, Date endDate) throws IOException{
        Loan myLoan = null;
        
        for(int i = 0; i < regsQuantity; i++){
            myLoan = this.getRecord(i);
            if(myLoan.getStudent().getId().equalsIgnoreCase(studentId) &&
               myLoan.getMaterial().getId().equalsIgnoreCase(materialId) &&
               myLoan.getEndDate().equals(endDate)){
                return i;
            }
        }
        
        return -1;
    }    
}
