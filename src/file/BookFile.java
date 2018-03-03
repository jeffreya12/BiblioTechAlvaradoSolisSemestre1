/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Book;
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
public class BookFile {
    
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;
    
    public BookFile(File file) throws IOException{
        start(file);
    }
    
    
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = DefaultValues.BOOK_REG_SIZE;
        
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
    
    public boolean putValue(int position, Book book) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(book.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                
                randomAccessFile.writeUTF(book.getAuthor());
                randomAccessFile.writeUTF(book.getLanguage());
                randomAccessFile.writeUTF(book.getFormat());
                randomAccessFile.writeUTF(book.getTitle());
                randomAccessFile.writeUTF(book.getGenre());
                randomAccessFile.writeLong(book.getPublished().getTime());
                randomAccessFile.writeUTF(book.getDescription());
                randomAccessFile.writeUTF(book.getId());
                randomAccessFile.writeInt(book.getQuantity());
                randomAccessFile.writeInt(book.getAvailable());
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }//fin metodo
    
    public boolean addEndRecord(Book book) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, book);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    public Book getRecord(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Book myBook = new Book();
            
            Date publishedTemp = new Date();
            
            //llevamos a cabo las lecturas            
            myBook.setAuthor(randomAccessFile.readUTF());
            myBook.setLanguage(randomAccessFile.readUTF());
            myBook.setFormat(randomAccessFile.readUTF());
            myBook.setTitle(randomAccessFile.readUTF());
            myBook.setGenre(randomAccessFile.readUTF());
            
            publishedTemp.setTime(randomAccessFile.readLong());
            
            myBook.setPublished(publishedTemp);
            myBook.setDescription(randomAccessFile.readUTF());
            myBook.setId(randomAccessFile.readUTF());
            myBook.setQuantity(randomAccessFile.readInt());
            myBook.setAvailable(randomAccessFile.readInt());
            
            //si es delete no retorno
            if(myBook.getId().equalsIgnoreCase(DefaultValues.DELETE_NAME_ON_RECORD)){
                return null;
            }
            else{
                return myBook;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo
    
    public List<Book> getAllRecords() throws IOException{
        
        //variables a retornar
        List<Book> books = new ArrayList<Book>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Book bookTemp = this.getRecord(i);
            
            if(bookTemp != null){
                books.add(bookTemp);
            }
        }
        
        return books;
    }//fin metodo
    
    public int searchRecord(String id) throws IOException{
        Book myBook = null;
        
        for(int i = 0; i < regsQuantity; i++){
            myBook = this.getRecord(i);
            if(myBook.getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean deleteRecord(String id) throws IOException{
        Book myBook;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la persona de esa posicion
            myBook = this.getRecord(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myBook.getId().equalsIgnoreCase(id)){

                //marcar esta persona como eliminada
                myBook.setId(DefaultValues.DELETE_NAME_ON_RECORD);

                return this.putValue(i, myBook);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }
    
}
