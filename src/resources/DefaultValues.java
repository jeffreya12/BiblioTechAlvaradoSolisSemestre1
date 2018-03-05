/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.Date;

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
                                           };
    public static String[] LOAN_ACTIONS = {"Registrar nuevo préstamo",
                                            "Terminar préstamo"
                                          };
    public static String[] BOOK_TABLE_COLUMNS = {"Título",
                                                 "Autor",
                                                 "Formato",
                                                 "ISBN",
                                                 "Disponibles"
                                                };
    public static String[] MEDIA_TABLE_COLUMNS = {"Título",
                                                 "Género",
                                                 "Identificador",
                                                 "Disponibles"
                                                 };
    public static String[] MEDIA_PLAYER_TABLE_COLUMNS = {"Marca",
                                                        "Modelo",
                                                        "Tipo",
                                                        "Identificador",
                                                        "Disponibles"
                                                        };
    public static String[] LOAN_TABLE_COLUMNS = {"Estudiante",
                                                "Material",
                                                "Tipo",
                                                "Estado del préstamo",
                                                "Fecha de finalización"
                                                };
    
    public static final String BOOK_CLASS_NAME = "Book";
    public static final String MEDIA_PLAYER_CLASS_NAME = "MediaPlayer";
    public static final String MEDIA_CLASS_NAME = "Media";
    
    public static String IS_FINISHED_STATE = "Finalizado";
    public static String IS_NOT_FINISHED_STATE = "Activo";
    
    // Paths
    public static String STUDENT_FILE_PATH = "./Student.dat";
    public static String MEDIA_PLAYER_FILE_PATH = "./MediaPlayer.dat";
    public static String MEDIA_FILE_PATH = "./Media.dat";
    public static String BOOK_FILE_PATH = "./Book.dat";
    public static String LOAN_FILE_PATH = "./Loan.dat";
    public static String CHECK_ICON_PATH = "./src/resources/images/CHECK_ICON.png";
    public static String WRONG_ICON_PATH = "./src/resources/images/WRONG_ICON.png";
    
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
    
    // Funciones
    public static boolean checkId(String id){
        boolean isCorrect;
        if(id.length() >= 5){
            try{
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
    public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
