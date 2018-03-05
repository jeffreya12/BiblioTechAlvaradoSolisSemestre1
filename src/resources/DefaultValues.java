/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author jefal
 */
public class DefaultValues {
    private DefaultValues(){}
    
    // Valores
    public static String PASSWORD = "1234";
    public static int FEE_PER_DAY = 100; // Colones
    public static int LOAN_TIME = 5; // Dias
    public static int STUDENT_REG_SIZE = 140; // Tamanno de registro Student
    public static int MEDIA_PLAYER_REG_SIZE = 500; // Tamanno de registro MediaPlayer
    public static int MEDIA_REG_SIZE = 500; // Tamanno de registro Media
    public static int BOOK_REG_SIZE = 1000; // Tamanno de registro Media
    public static int LOAN_REG_SIZE = 500; // Tamanno de registro de prestamos
    public static String[] MATERIAL_TYPE = {"Libro",
                                            "Multimedia",
                                            "Reproductor multimedia"
                                           }; //Tipos de material
    public static String[] LOAN_ACTIONS = {"Registrar nuevo préstamo",
                                            "Terminar préstamo"
                                          }; //Acciones de la ventana de prestamo
    public static String[] BOOK_TABLE_COLUMNS = {"Título",
                                                 "Autor",
                                                 "Formato",
                                                 "ISBN",
                                                 "Disponibles"
                                                };//Columnas de la tabla de libros
    public static String[] MEDIA_TABLE_COLUMNS = {"Título",
                                                 "Género",
                                                 "Identificador",
                                                 "Disponibles"
                                                 };//Columnas de la tabla de medios
    public static String[] MEDIA_PLAYER_TABLE_COLUMNS = {"Marca",
                                                        "Modelo",
                                                        "Tipo",
                                                        "Identificador",
                                                        "Disponibles"
                                                        };//Columnas de la tabla de reproductores
    public static String[] LOAN_TABLE_COLUMNS = {"Estudiante",
                                                "Material",
                                                "Tipo",
                                                "Estado del préstamo",
                                                "Fecha de finalización"
                                                };//Columnas de la tabla de prestamos
    
    public static final String BOOK_CLASS_NAME = "Book";
    public static final String MEDIA_PLAYER_CLASS_NAME = "MediaPlayer";
    public static final String MEDIA_CLASS_NAME = "Media";
    
    public static String IS_FINISHED_STATE = "Finalizado";
    public static String IS_NOT_FINISHED_STATE = "Activo";
    public static String PASSWORD_SETTINGS_KEY = "password";
    public static String FEE_PER_DAY_SETTINGS_KEY = "fee_per_day";
    
    // Paths
    public static String STUDENT_FILE_PATH = "./Student.dat";
    public static String MEDIA_PLAYER_FILE_PATH = "./MediaPlayer.dat";
    public static String MEDIA_FILE_PATH = "./Media.dat";
    public static String BOOK_FILE_PATH = "./Book.dat";
    public static String LOAN_FILE_PATH = "./Loan.dat";
    public static String CHECK_ICON_PATH = "./src/resources/images/CHECK_ICON.png";
    public static String WRONG_ICON_PATH = "./src/resources/images/WRONG_ICON.png";
    public static String SETTINGS_PATH = "./src/resources/xml/settings.xml";
    
    // Identificador de elemento borrado
    public static String DELETE_NAME_ON_RECORD = "delete";
    
    // Mensajes
    public static String LOGIN_ERROR = "La contraseña es incorrecta";
    public static String STUDENT_ID_ERROR = "El número de carné es inválido";
    public static String BOOK_ID_ERROR = "El número de ISBN es inválido";
    public static String MEDIA_PLAYER_ID_ERROR = "El número de identificación es inválido";
    public static String MEDIA_ID_ERROR = "El número de identificación es inválido";
    public static String FAILED_INSERT = "Error guardando sus datos";
    public static String STUDENT_NOT_FOUND_ERROR = "El estudiante no se encuentra registrado en el sistema";
    public static String FAILED_SEARCH = "No se puede realizar la búsqueda";
    public static String DEFAULT_QUERY_ERROR = "No se puede realizar la acción en este momento";
    public static String INVALID_OPTIONS = "Verifique el estudiante y elija un material que esté disponible";
    public static String FEE_PAYMENT_WARNING = "Debe cancelar el siguiente monto para terminar el préstamo\n\n₡";
    public static String FEE_PAYMENT_CONFIRMATION = "\n\n¿Desea terminar el préstamo?";
    public static String END_FINISHED_LOAN = "El préstamo ya se devolvió";
    public static String SAVE_SETTINGS_SUCCESSFUL = "Sus cambios se guardaron correctamente";
    
    // Funciones
    
    //Verifica que el id contenga numeros y sea mayor a 5
    public static boolean checkId(String id){
        boolean isCorrect;
        //Si es mayor a 5
        if(id.length() >= 5){
            try{
                //Si es numero
                Integer.parseInt(id);
                isCorrect = true;
            }
            catch(Exception e){
                isCorrect = false;
            }
        }
        else{
            isCorrect = false;
        }
        return isCorrect;
    }
    
    //Calcula los dias entre dos fechas
    public static int daysBetween(Date initialDate, Date endDate){
        //Toma los Long del tipo fecha y los resta
        return (int)( (endDate.getTime() - initialDate.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    //Guarda los valores en el xml
    public static boolean saveSetting(String password, String fee){
        // Propiedades a guardar
        Properties saveProps = new Properties();
        saveProps.setProperty(DefaultValues.PASSWORD_SETTINGS_KEY, password);
        saveProps.setProperty(DefaultValues.FEE_PER_DAY_SETTINGS_KEY, fee);
        try {
            //Guarda la contrasenna y la multa
            saveProps.storeToXML(new FileOutputStream(SETTINGS_PATH), "");
            return true;
        }
        catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }
    
    //Consulta el setting deseado con base en su identificador
    public static String loadSetting(String key){
        // Propiedades a consultar
        Properties loadProps = new Properties();
        try{
            //Consulta el setting y lo devuelve
            loadProps.loadFromXML(new FileInputStream(SETTINGS_PATH));
            return loadProps.getProperty(key);
        }
        catch(Exception e){
            System.err.println(e.toString());
            return "";
        }
        
    }
}
