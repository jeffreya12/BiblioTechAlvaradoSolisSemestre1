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
 * Archivo de manejo de RAF de la clase Loan
 * 
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
    
    //Inserta un registro en una posicion especifica
    public boolean putValue(int position, Loan loan, 
            int studentIndex, int materialIndex,
            String loanType) throws IOException{
        //validacion antes de insertar
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
                //Posicion del objeto Student en su archivo
                randomAccessFile.writeInt(studentIndex);
                //Tipo de prestamo (Media, MediaPlayer, Book)
                randomAccessFile.writeUTF(loanType);
                //Posicion del objeto Material en su archivo
                randomAccessFile.writeInt(materialIndex);
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }
    
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
            
            //Manejador del RAF de Studente para consultar el Student de la
            //clase Loan
            StudentFile studentFile = new StudentFile(new File (DefaultValues.STUDENT_FILE_PATH));
            
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de Loan
            Loan myLoan = new Loan();
            //Variable temporal para almacenar la fecha
            Date endDateTemp = new Date();
            
            //llevamos a cabo las lecturas
            endDateTemp.setTime(randomAccessFile.readLong());
            myLoan.setFinished(randomAccessFile.readBoolean());
            myLoan.setFee(randomAccessFile.readInt());
            //El Student se asigna directamente del RAF de Student
            myLoan.setStudent(studentFile.getRecord(randomAccessFile.readInt()));
            //Tipo de prestamo (Media, MediaPlayer, Book)
            String loanType = randomAccessFile.readUTF();
            //Indice de Material en su RAF
            int materialIndex = randomAccessFile.readInt();
            //Asigna la fecha al objeto Loan
            myLoan.setEndDate(endDateTemp);
            
            //Se evalua el tipo de prestamo
            //Para cada tipo, se crea una instancia de su respectivo manejador
            //y se asigna al atributo Material en cada caso
            switch(loanType){
                case "Book":
                    BookFile bookFile = new BookFile(
                            new File(DefaultValues.BOOK_FILE_PATH));
                    myLoan.setMaterial(bookFile.getRecord(materialIndex));
                    bookFile.close();
                    break;
                    
                case "Media":
                    MediaFile mediaFile = new MediaFile(
                            new File(DefaultValues.MEDIA_FILE_PATH));
                    myLoan.setMaterial(mediaFile.getRecord(materialIndex));
                    mediaFile.close();
                    break;
                    
                case "MediaPlayer":
                    MediaPlayerFile mediaPlayerFile = new MediaPlayerFile(
                            new File(DefaultValues.MEDIA_PLAYER_FILE_PATH));
                    myLoan.setMaterial(mediaPlayerFile.getRecord(materialIndex));
                    mediaPlayerFile.close();
                    break;
            }
            
            studentFile.close();
            
            //Devuelve el objeto Loan completo
            return myLoan;            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }
    
    //Consulta todos los objetos Loan en el RAF
    public List<Loan> getAllRecords() throws IOException{
        
        //variable a retornar
        List<Loan> loans = new ArrayList<Loan>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Loan loanTemp = this.getRecord(i);
            
            if(loanTemp != null){
                loans.add(loanTemp);
            }
        }
        
        return loans;
    }
    
    //Busca un objeto basado en el id de Student, id de Material y su fecha
    public int searchRecord(String studentId, String materialId, Date endDate) 
            throws IOException{
        Loan myLoan = null;
        
        //Recorre el RAF de Loan
        for(int i = 0; i < regsQuantity; i++){
            //Obtiene el record
            myLoan = this.getRecord(i);
            if(myLoan.getStudent().getId().equalsIgnoreCase(studentId) &&
               myLoan.getMaterial().getId().equalsIgnoreCase(materialId) &&
               myLoan.getEndDate().equals(endDate)){
                //En caso de que cumpla con el criterio, lo retorna
                return i;
            }
        }
        //Si no existe, retorna una posicion invalida
        return -1;
    }    
}
