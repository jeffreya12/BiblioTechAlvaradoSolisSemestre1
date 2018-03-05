/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import resources.DefaultValues;

/**
 *
 * Manejador de RAF de la clase MediaPlayer
 * 
 */
public class MediaPlayerFile {
    
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;
    
    public MediaPlayerFile(File file) throws IOException{
        start(file);
    }
    
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = DefaultValues.MEDIA_PLAYER_REG_SIZE;
        
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
    }
    
    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    public int fileSize(){
        return regsQuantity;
    }
    
    //Inserta un objeto en la posicion especifica
    public boolean putValue(int position, MediaPlayer mediaPlayer) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(mediaPlayer.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                
                randomAccessFile.writeUTF(mediaPlayer.getBrand());
                randomAccessFile.writeUTF(mediaPlayer.getModel());
                randomAccessFile.writeUTF(mediaPlayer.getKind());
                randomAccessFile.writeUTF(mediaPlayer.getDescription());
                randomAccessFile.writeUTF(mediaPlayer.getId());
                randomAccessFile.writeInt(mediaPlayer.getQuantity());
                randomAccessFile.writeInt(mediaPlayer.getAvailable());
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }
    
    //Inserta objeto al final del RAF
    public boolean addEndRecord(MediaPlayer mediaPlayer) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, mediaPlayer);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    //Obtiene objeto a partir de su posicion en el RAF
    public MediaPlayer getRecord(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            MediaPlayer myMediaPlayer = new MediaPlayer();
            
            //llevamos a cabo las lecturas
            myMediaPlayer.setBrand(randomAccessFile.readUTF());
            myMediaPlayer.setModel(randomAccessFile.readUTF());
            myMediaPlayer.setKind(randomAccessFile.readUTF());
            myMediaPlayer.setDescription(randomAccessFile.readUTF());
            myMediaPlayer.setId(randomAccessFile.readUTF());
            myMediaPlayer.setQuantity(randomAccessFile.readInt());
            myMediaPlayer.setAvailable(randomAccessFile.readInt());
            
            //si es delete no retorno
            if(myMediaPlayer.getId().equalsIgnoreCase(DefaultValues.DELETE_NAME_ON_RECORD)){
                return null;
            }
            else{
                return myMediaPlayer;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }
    
    //Obtiene todos los objetos del RAF
    public List<MediaPlayer> getAllRecords() throws IOException{
        
        //variables a retornar
        List<MediaPlayer> mediaPlayers = new ArrayList<MediaPlayer>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            MediaPlayer mediaPlayerTemp = this.getRecord(i);
            
            if(mediaPlayerTemp != null){
                mediaPlayers.add(mediaPlayerTemp);
            }
        }
        
        return mediaPlayers;
    }
    
    //Busca un objeto en el RAF basado en su ID
    public int searchRecord(String id) throws IOException{
        MediaPlayer myMediaPlayer = null;
        
        //Recorro el RAF
        for(int i = 0; i < regsQuantity; i++){
            //Obtengo el objeto
            myMediaPlayer = this.getRecord(i);
            if(myMediaPlayer.getId().equalsIgnoreCase(id)){
                //Si el objeto existe, retorna la posicion
                return i;
            }
        }
        //Si no existe, retorna una posicion invalida
        return -1;
    }
    
    //Borra un objeto del RAF
    public boolean deleteRecord(String id) throws IOException{
        MediaPlayer myMediaPlayer;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la persona de esa posicion
            myMediaPlayer = this.getRecord(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myMediaPlayer.getId().equalsIgnoreCase(id)){

                //marcar esta persona como eliminada
                myMediaPlayer.setId(DefaultValues.DELETE_NAME_ON_RECORD);

                return this.putValue(i, myMediaPlayer);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }
    
}
