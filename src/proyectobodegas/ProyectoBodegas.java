/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import proyectobodegas.Estructura.Bodega;
import proyectobodegas.Estructura.Constantes;
import proyectobodegas.Estructura.Productos;
import proyectobodegas.Estructura.Requisitos;

/**
 *
 * @author propietario
 */
public class ProyectoBodegas extends JFrame implements ActionListener {

    private JDesktopPane Sub_Ventanas;
    private Bodega Listado_Bodegas;
    private Ventana_Interna ventanaBodega;
    private Ventana_Editar ventanaEditar;
    private Ventana_Requisitos ventanaRequisitos;
    private DesktopManager_Modificado desktopManager;
    private Requisitos Lista_Requisitos;
    private Productos Lista_Productos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProyectoBodegas GUI = new ProyectoBodegas();
    }

    public ProyectoBodegas() {
        InicializarDatos();
        InicializarVentana();

    }

    private void InicializarVentana() {
        setTitle("Programa Bodegas");
        setSize(1300, 700);
        setJMenuBar(crearMenu());

        Sub_Ventanas = new JDesktopPane();
        desktopManager = new DesktopManager_Modificado();
        Sub_Ventanas.setDesktopManager(desktopManager);
        getContentPane().add(Sub_Ventanas);

        Sub_Ventanas.add(ventanaBodega);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void InicializarDatos() {
        Listado_Bodegas = new Bodega();
        Lista_Requisitos = new Requisitos();
        Lista_Productos = new Productos();
        //llenarDatosdePrueba();
        ventanaBodega = new Ventana_Interna(null, Listado_Bodegas, "Inicio", Constantes.ORIGEN_BODEGA, this);
    }

    /**
     * Crea un elemento del tipo JMenuBar con los componentes del Menu
     * @return Devuelve un objeto del tipo JMenuBar.
     */
    private JMenuBar crearMenu() {

        JMenuBar menu_superior = new JMenuBar();

        JMenu menu_opcion_Inicio = new JMenu("Inicio");
        JMenu menu_opcion_acciones = new JMenu("Acciones");
        JMenu menu_opcion_administrar = new JMenu("Administrar");

        JMenuItem menu_opcion_inicio_salir = new JMenuItem("Salir");
        JMenuItem menu_opcion_acciones_maximizar = new JMenuItem("Inicio");
        JMenuItem menu_opcion_acciones_minimizar = new JMenuItem("Minimizar Todo");
        JMenuItem menu_opcion_acciones_cerrar = new JMenuItem("Cerrar Todo");
        JMenuItem menu_opcion_administrar_productos = new JMenuItem("Productos");
        JMenuItem menu_opcion_administrar_requisitos = new JMenuItem("Requisitos");

        menu_opcion_acciones_cerrar.setActionCommand(Constantes.MENU_ACCIONES_CERRAR_TODO);
        menu_opcion_acciones_cerrar.addActionListener(this);

        menu_opcion_acciones_minimizar.setActionCommand(Constantes.MENU_ACCIONES_MINIMIZAR);
        menu_opcion_acciones_minimizar.addActionListener(this);
        
        menu_opcion_administrar_productos.setActionCommand(Constantes.MENU_ADMINISTRAR_PRODUCCTOS);
        menu_opcion_administrar_productos.addActionListener(this);
        
        menu_opcion_administrar_requisitos.setActionCommand(Constantes.MENU_ADMINISTRAR_REQUISITOS);
        menu_opcion_administrar_requisitos.addActionListener(this);

        menu_opcion_acciones.add(menu_opcion_acciones_minimizar);
        menu_opcion_acciones.add(menu_opcion_acciones_cerrar);
        menu_opcion_administrar.add(menu_opcion_administrar_productos);
        menu_opcion_administrar.add(menu_opcion_administrar_requisitos);
        
        menu_superior.add(menu_opcion_Inicio);
        menu_superior.add(menu_opcion_acciones);
        menu_superior.add(menu_opcion_administrar);

        return menu_superior;
    }

    /**
     * Activa un elemento del tipo Ventana_Interna para que se visualice sobre
     * las demas ventanas.
     *
     * @param ventana Objeto del tipo Ventana_Interna que extiende a
     * JInternalFrame.
     */
    public void activarVentana(JInternalFrame ventana) {
        try {
            ventana.setIcon(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ProyectoBodegas.class.getName()).log(Level.SEVERE, null, ex);
        }
        desktopManager.activateFrame(ventana);
    }

    /**
     * Activa un elemento del tipo Ventana_Interna para que se visualice sobre
     * las demas ventanas.
     *
     * @param ID Identificador (String) unico de cada ventana.
     */
    public void activarVentana(String ID) {
        Ventana_Interna V = obtenerVentana(ID);
        try {
            V.setIcon(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ProyectoBodegas.class.getName()).log(Level.SEVERE, null, ex);
        }
        desktopManager.activateFrame(V);
    }

    /**
     * Crea o activa la ventana de edicion con las condiciones adecuadas.
     * @param Lista Objeto del tipo Lista sin definir.
     * @param Tipo Integer, valor constante que referencia al tipo de objeto (Bodega,Nivel,Area,Seccion,Estante).
     * @param ID Identificador unico de cada elemento de la lista.
     */
    public void activarVentanaEditar(Object Lista, int Tipo, int ID) {
        if (ventanaEditar == null) {
            ventanaEditar = new Ventana_Editar();
            ventanaEditar.configurarEditor(Tipo, ID, Lista);
            agregarVentana(ventanaEditar);
            activarVentana(ventanaEditar);
        } else {
            if(ventanaEditar.isClosed()){
                //ventanaEditar.setLocation(100,100);
                agregarVentana(ventanaEditar);
                ventanaEditar.show();
                System.out.println("Estado: "+ventanaEditar.isShowing());
                activarVentana(ventanaEditar);
            }
        }
    }
    
    /**
     * Crea o activa la ventana de edicion con las condiciones adecuadas.
     * @param Lista Objeto del tipo Lista sin definir.
     * @param Tipo Integer, valor constante que referencia al tipo de objeto (Bodega,Nivel,Area,Seccion,Estante).
     * @param ID Identificador unico de cada elemento de la lista.
     */
    public void activarVentanaRequisitos() {
        if (ventanaRequisitos == null) {
            ventanaRequisitos = new Ventana_Requisitos(this);
            agregarVentana(ventanaRequisitos);
            activarVentana(ventanaRequisitos);
        } else {
            if(ventanaRequisitos.isClosed()){
                //ventanaEditar.setLocation(100,100);
                agregarVentana(ventanaRequisitos);
                ventanaRequisitos.show();
                System.out.println("Estado: "+ventanaRequisitos.isShowing());
                activarVentana(ventanaRequisitos);
            }
        }
    }

    /**
     * Minimiza todas las ventanas derivadas de bodega.
     */
    public void minimizarVentanas() {
        JInternalFrame[] ventanas = Sub_Ventanas.getAllFrames();
        for (JInternalFrame v : ventanas) {
            try{
            Ventana_Interna V = (Ventana_Interna) v;
            try {
                V.setIcon(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ProyectoBodegas.class.getName()).log(Level.SEVERE, null, ex);
            }
            }catch(Exception e){
                
            }
        }
    }

    /**
     * Cierra todas las ventanas derivadas de bodega.
     */
    public void cerrarVentanas() {
        JInternalFrame[] ventanas = Sub_Ventanas.getAllFrames();
        for (JInternalFrame v : ventanas) {
            try{
            Ventana_Interna V = (Ventana_Interna) v;
            if (!V.obtenerID().equals("")) {
                try {
                    V.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(ProyectoBodegas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }catch(Exception e){
                
            }
        }
    }

    /**
     * Agrega una nueva ventana al escritorio
     *
     * @param nueva_ventana Objetivo del tipo Ventana_Interna
     */
    public void agregarVentana(JInternalFrame nueva_ventana) {
        Sub_Ventanas.add(nueva_ventana);
    }

    /**
     * Recorre la lista de Ventanas del escritorio para buscar el ID
     *
     * @param ID Identificador unico de cada ventana.
     * @return Devuelve TRUE si encuentra la ventana o FALSE de lo contrario.
     */
    public boolean existeVentana(String ID) {
        JInternalFrame[] ventanas = Sub_Ventanas.getAllFrames();
        for (JInternalFrame v : ventanas) {
            try {
                Ventana_Interna V = (Ventana_Interna) v;
                if (V.obtenerID().equals(ID)) {
                    return true;
                }
            } catch (Exception e) {

            }
        }
        return false;
    }

    /**
     * Busca la ventana con ID y devuelve la referencia.
     *
     * @param ID Identificador unico de cada ventana.
     * @return Devuelve un elemento del tipo Ventana_Interna que hace referencia
     * al ID especificado.
     */
    public Ventana_Interna obtenerVentana(String ID) {
        JInternalFrame[] ventanas = Sub_Ventanas.getAllFrames();
        for (JInternalFrame v : ventanas) {
            try{
            Ventana_Interna V = (Ventana_Interna) v;
            if (V.obtenerID().equals(ID)) {
                return V;
            }
            }catch(Exception e){
                
            }
        }
        return null;
    }

    /**
     * Cierra todas las ventanas que tengan el identificador especificado
     *
     * @param ID Identificador unico de cada Ventana.
     */
    public void cerrarVentanas(String ID) {
        JInternalFrame[] ventanas = Sub_Ventanas.getAllFrames();
        for (JInternalFrame v : ventanas) {
            try{
            Ventana_Interna V = (Ventana_Interna) v;
            if (V.obtenerID().equals(ID)) {
                try {
                    V.setClosed(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(ProyectoBodegas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }catch(Exception e){
                
            }
        }
    }

    /**
     * Listado principal de bodegas
     *
     * @return Devuelve una lista del tipo Bodega que contiene todos los
     * subelementos de la lista (Niveles, areas, estantes,secciones,productos).
     */
    public Bodega obtenerDatosdeBodega() {
        return Listado_Bodegas;
    }
    
    public Requisitos obtenerRequisitos(){
        return Lista_Requisitos;
    }
    
    public Productos obtenerProductos(){
        return Lista_Productos;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constantes.MENU_ACCIONES_MINIMIZAR:
                minimizarVentanas();
                break;
            case Constantes.MENU_ACCIONES_CERRAR_TODO:
                cerrarVentanas();
                break;
            case Constantes.MENU_ADMINISTRAR_REQUISITOS:
                activarVentanaRequisitos();
                break;
        }
    }
}
