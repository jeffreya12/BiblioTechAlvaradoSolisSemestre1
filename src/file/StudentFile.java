/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import resources.DefaultValues;

/**
 *
 * Manejador del RAF de la clase Student
 * 
 */
public class StudentFile {
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;

    public StudentFile(File file) throws IOException{
        start(file);
    }
    
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = DefaultValues.STUDENT_REG_SIZE;
        
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
    
    //Inserta un valor en la posicion especifica    
    public boolean putValue(int position, Student student) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(student.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                
                randomAccessFile.writeUTF(student.getName());
                randomAccessFile.writeUTF(student.getLastNames());
                randomAccessFile.writeUTF(student.getId());
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }
    
    //Inserta un objeto al finl del RAF
    public boolean addEndRecord(Student student) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, student);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    //Obtiene un objtedo a partir de su posicion en el RAF
    public Student getRecord(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Student myStudent = new Student();
            
            //llevamos a cabo las lecturas
            myStudent.setName(randomAccessFile.readUTF());
            myStudent.setLastNames(randomAccessFile.readUTF());
            myStudent.setId(randomAccessFile.readUTF());
            
            //si es delete no retorno
            if(myStudent.getId().equalsIgnoreCase(DefaultValues.DELETE_NAME_ON_RECORD)){
                return null;
            }
            else{
                return myStudent;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }
    
    //Retorna todos los objetos del RAF
    public List<Student> getAllRecords() throws IOException{
        
        //variables a retornar
        List<Student> students = new ArrayList<Student>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Student studentTemp = this.getRecord(i);
            
            if(studentTemp != null){
                students.add(studentTemp);
            }
        }
        
        return students;
    }
    
    //Busca un objeto basado en su ID
    public int searchRecord(String id) throws IOException{
        Student myStudent = null;
        
        //Recorro el RAF
        for(int i = 0; i < regsQuantity; i++){
            //Obtendo el objeto
            myStudent = this.getRecord(i);
            if(myStudent.getId().equalsIgnoreCase(id)){
                //Si el objeto existe, retorno su posicion
                return i;
            }
        }
        //Si no existe, retorno una posicion invalida
        return -1;
    }
    
    //Busca y borra un objeto del RAF
    public boolean deleteRecord(String id) throws IOException{
        Student myStudent;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la persona de esa posicion
            myStudent = this.getRecord(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myStudent.getId().equalsIgnoreCase(id)){

                //marcar esta persona como eliminada
                myStudent.setId(DefaultValues.DELETE_NAME_ON_RECORD);

                return this.putValue(i, myStudent);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }
    
}
