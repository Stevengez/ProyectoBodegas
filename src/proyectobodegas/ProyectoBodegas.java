/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas;

import javax.swing.JFrame;
import proyectobodegas.Estructura.Bodega;

/**
 *
 * @author propietario
 */
public class ProyectoBodegas extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bodega Lista_Bodegas = new Bodega();
        //Pruebas iniciales de la estructura.
        Lista_Bodegas.agregarBodega("Primera");
        Lista_Bodegas.SiguienteBodega();
        Lista_Bodegas.bodegaActual().Niveles().agregarNivel("Primer Nivel");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.bodegaActual().Niveles().agregarNivel("Primer Nivel");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.bodegaActual().Niveles().agregarNivel("Primer Nivel");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.bodegaActual().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");       
    }
    
    public void IniciarVentana(){
        
    }
    
}
