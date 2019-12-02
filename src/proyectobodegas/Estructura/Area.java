/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas.Estructura;

/**
 *
 * @author propietario
 */
public class Area {
    Nodo_Area Nodo_area_inicial, Nodo_area_final, Nodo_area_actual;
    int Size;
    
    public Area(){
        Nodo_area_inicial = null;
        Nodo_area_final = null;
        Nodo_area_actual = null;
        Size = 0;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    public Nodo_Area areaActual(){
        return Nodo_area_actual;
    }
    
}
