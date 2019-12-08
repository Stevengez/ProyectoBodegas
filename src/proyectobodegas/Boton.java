/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package proyectobodegas;

import javax.swing.JButton;
import proyectobodegas.Estructura.Nivel;

/**
 *
 * @author propietario
 */
public class Boton extends JButton{
    private int accion, id, origen;
    private Nivel Lista_Niveles;
    
    
    public Boton(String Texto){
        setText(Texto);
    }
    
    public void setOrigen(int origen){
        this.origen = origen;
    }
    
    public int getOrigen(){
        return origen;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setAction(int action){
        accion = action;
    }
    
    public int getAccion(){
        return accion;
    }
}
