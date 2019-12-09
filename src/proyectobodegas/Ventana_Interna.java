/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package proyectobodegas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import proyectobodegas.Estructura.Area;
import proyectobodegas.Estructura.Bodega;
import proyectobodegas.Estructura.Constantes;
import proyectobodegas.Estructura.Estante;
import proyectobodegas.Estructura.Nivel;
import proyectobodegas.Estructura.Seccion;

/**
 *
 * @author propietario
 */
public class Ventana_Interna extends JInternalFrame implements ActionListener {

    private String nombre_superior, Identificador;
    private JPanel contenedor, Contenedor_Lista;
    private JTextField nuevo_elemento_textfield;
    private int Tipo;
    private Dimension ventanaSize;
    private ProyectoBodegas Contexto;
    private Object lista_bodegas;
    private JInternalFrame frame_padre;
    private int y;

    /**
     *
     * @param frame_padre Elemento del Tipo Ventana_Interna de la cual proviene
     * la nueva ventana.
     * @param lista_bodegas Lista de elementos, es parte de la estructura.
     * @param nombre_superior Nombre de la lista que contiene a este nuevo
     * elemento
     * @param Tipo Tipo de Lista (Bodega, Nivel, Seccion, Estante, Area)
     * @param Contexto Referencia a la Frame Principal del programa.
     */
    public Ventana_Interna(JInternalFrame frame_padre, Object lista_bodegas, String nombre_superior, int Tipo, ProyectoBodegas Contexto) {
        this.Contexto = Contexto;
        this.Tipo = Tipo;
        this.nombre_superior = nombre_superior;
        this.lista_bodegas = lista_bodegas;
        this.frame_padre = frame_padre;
        this.y = 1;
        this.Identificador = "";

        setMaximumSize(new Dimension(1300, 700));
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        add(crearContenedor());
        pack();
        setMinimumSize(new Dimension(getWidth(), 100));
        setVisible(true);
    }

    private JScrollPane crearContenedor() {

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;

        contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());

        JPanel agregar_bodega = new JPanel();
        agregar_bodega.setLayout(new GridBagLayout());
        agregar_bodega.setOpaque(true);
        agregar_bodega.setBackground(Color.WHITE);

        JLabel label_agregar = new JLabel("Nombre :");
        nuevo_elemento_textfield = new JTextField(15);
        Boton boton_agregar = new Boton("Agregar");
        boton_agregar.addActionListener(this);
        boton_agregar.setOrigen(Tipo);
        boton_agregar.setAction(Constantes.ACCION_AGREGAR);

        Boton boton_buscar = new Boton("Buscar");
        boton_buscar.addActionListener(this);
        boton_buscar.setOrigen(Tipo);
        boton_buscar.setAction(Constantes.ACCION_BUSCAR);

        c.gridx = 0;
        agregar_bodega.add(label_agregar, c);
        c.gridx = 1;
        agregar_bodega.add(nuevo_elemento_textfield, c);
        c.ipadx = 0;
        c.gridx = 2;
        agregar_bodega.add(boton_buscar, c);
        c.gridx = 3;
        agregar_bodega.add(boton_agregar, c);

        c.gridx = 0;
        c.gridwidth = 3;
        c.insets = new Insets(10, 20, 10, 20);

        contenedor.add(agregar_bodega, c);

        llenarDatos();
        contenedor.setVisible(true);
        JScrollPane scrollpane = new JScrollPane(contenedor);
        return scrollpane;
    }

    public void definirIdentificador(String ID) {
        Identificador = ID;
    }

    public String obtenerID() {
        return Identificador;
    }

    private void llenarDatos() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = y;
        //c.gridwidth = 3;

        Contenedor_Lista = new JPanel(new GridBagLayout());
        Contenedor_Lista.setOpaque(true);
        Contenedor_Lista.setBackground(Color.WHITE);

        switch (Tipo) {
            case Constantes.ORIGEN_BODEGA:
                Bodega Lista = (Bodega) lista_bodegas;
                Lista.reiniciarLista();
                super.setTitle("Listado de Bodegas");
                while (Lista.SiguienteBodega()) {
                    agregarFila(Tipo, c, y, Lista.bodegaActual().obtenerIdentificador(), Lista.bodegaActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }

                break;
            case Constantes.ORIGEN_NIVEL:
                super.setTitle(nombre_superior + " - Listado de Niveles");
                Nivel Lista_Niveles = (Nivel) lista_bodegas;
                Lista_Niveles.reiniciarLista();
                while (Lista_Niveles.SiguienteNivel()) {
                    agregarFila(Tipo, c, y, Lista_Niveles.nivelActual().obtenerIdentificador(), Lista_Niveles.nivelActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }
                break;
            case Constantes.ORIGEN_AREA:
                super.setTitle(nombre_superior + " - Listado de Areas");
                Area Lista_Areas = (Area) lista_bodegas;
                Lista_Areas.reiniciarLista();
                while (Lista_Areas.SiguienteArea()) {
                    agregarFila(Tipo, c, y, Lista_Areas.areaActual().obtenerIdentificador(), Lista_Areas.areaActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }
                break;
            case Constantes.ORIGEN_ESTANTE:
                super.setTitle(nombre_superior + " - Listado de Estantes");
                Estante Lista_Estantes = (Estante) lista_bodegas;
                Lista_Estantes.reiniciarLista();
                while (Lista_Estantes.SiguienteEstante()) {
                    agregarFila(Tipo, c, y, Lista_Estantes.estanteActual().obtenerIdentificador(), Lista_Estantes.estanteActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }
                break;
            case Constantes.ORIGEN_SECCION:
                super.setTitle(nombre_superior + " - Listado de Secciones");
                Seccion Lista_Secciones = (Seccion) lista_bodegas;
                Lista_Secciones.reiniciarLista();
                while (Lista_Secciones.SiguienteSeccion()) {
                    agregarFila(Tipo, c, y, Lista_Secciones.seccionActual().obtenerIdentificador(), Lista_Secciones.seccionActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }
                break;
            default:

                break;
        }

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        contenedor.add(Contenedor_Lista, c);

    }

    private void agregarFila(int Tipo, GridBagConstraints c, int y, String nombre, int ID, JPanel Contenedor_Lista) {
        c.gridx = 0;
        c.gridy = y;
        c.insets = new Insets(5, 5, 5, 5);

        JLabel Nombre = new JLabel();

        Nombre.setText(nombre);
        Nombre.setHorizontalAlignment(SwingConstants.CENTER);

        Boton Ver = new Boton("Abrir");
        Ver.setID(ID);
        Ver.setOrigen(Tipo);
        Ver.setAction(Constantes.ACCION_ABRIR);
        Ver.addActionListener(this);

        Boton Editar = new Boton("Editar");
        Editar.setAction(Constantes.ACCION_EDITAR);
        Editar.setOrigen(Tipo);
        Editar.setID(ID);
        Editar.addActionListener(this);

        Boton Eliminar = new Boton("Eliminar");

        Contenedor_Lista.add(Nombre, c);
        c.gridx = 1;
        Contenedor_Lista.add(Ver, c);
        c.gridx = 2;
        Contenedor_Lista.add(Editar, c);
        c.gridx = 3;
        Contenedor_Lista.add(Eliminar, c);
    }

    public void actionPerformed(ActionEvent e) {
        Boton boton = (Boton) e.getSource();
        switch (boton.getOrigen()) {
            case Constantes.ORIGEN_BODEGA:
                Bodega Lista_Bodegas = (Bodega) lista_bodegas;
                switch (boton.getAccion()) {
                    case Constantes.ACCION_AGREGAR:
                        if (!Lista_Bodegas.buscarPorIdentificador(nuevo_elemento_textfield.getText()) && !nuevo_elemento_textfield.getText().equals("") && !nuevo_elemento_textfield.getText().equals(" ")) {
                            Lista_Bodegas.agregarBodega(nuevo_elemento_textfield.getText());
                            GridBagConstraints c = new GridBagConstraints();
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.gridy = y;
                            this.agregarFila(Constantes.ORIGEN_BODEGA, c, y, nuevo_elemento_textfield.getText(), Lista_Bodegas.obtenerSize(), Contenedor_Lista);
                            y++;
                            this.pack();
                            if (this.getHeight() >= Contexto.getHeight() - 65) {
                                this.setSize(this.getWidth(), Contexto.getHeight() - 65);
                            }
                            Contenedor_Lista.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "EL nombre de bodega no es valido o ya existe.");
                        }
                        break;
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir la bodega: " + boton.getID());

                        Lista_Bodegas.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!Contexto.existeVentana(this.obtenerID() + "" + boton.getID())) {
                            Ventana_Interna niveles = new Ventana_Interna(this, Lista_Bodegas.bodegaActual().Niveles(), Lista_Bodegas.bodegaActual().obtenerIdentificador(), Constantes.ORIGEN_NIVEL, Contexto);
                            niveles.definirIdentificador(this.obtenerID() + "" + boton.getID());
                            System.out.println("El ID de la nueva ventana es: " + niveles.obtenerID());
                            Contexto.agregarVentana(niveles);
                            Contexto.activarVentana(niveles);
                        } else {
                            Contexto.activarVentana(this.obtenerID() + "" + boton.getID());
                        }
                        break;
                    case Constantes.ACCION_EDITAR:
                        Contexto.activarVentanaEditar(lista_bodegas, Tipo, boton.getID());
                        break;
                }
                break;
            case Constantes.ORIGEN_NIVEL:
                Nivel Lista_Niveles = (Nivel) lista_bodegas;
                switch (boton.getAccion()) {
                    case Constantes.ACCION_AGREGAR:
                        if (!Lista_Niveles.buscarPorIdentificador(nuevo_elemento_textfield.getText()) && !nuevo_elemento_textfield.getText().equals("") && !nuevo_elemento_textfield.getText().equals(" ")) {
                            Lista_Niveles.agregarNivel(nuevo_elemento_textfield.getText());
                            GridBagConstraints c = new GridBagConstraints();
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.gridy = y;
                            this.agregarFila(Constantes.ORIGEN_NIVEL, c, y, nuevo_elemento_textfield.getText(), Lista_Niveles.obtenerSize(), Contenedor_Lista);
                            y++;
                            this.pack();
                            if (this.getHeight() >= Contexto.getHeight() - 65) {
                                this.setSize(this.getWidth(), Contexto.getHeight() - 65);
                            }
                            Contenedor_Lista.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "EL nombre de bodega no es valido o ya existe.");
                        }
                        break;
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir el nivel: " + boton.getID());

                        Lista_Niveles.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!Contexto.existeVentana(this.obtenerID() + "" + boton.getID())) {
                            Ventana_Interna areas = new Ventana_Interna(this, Lista_Niveles.nivelActual().Areas(), nombre_superior + " \\ " + Lista_Niveles.nivelActual().obtenerIdentificador(), Constantes.ORIGEN_AREA, Contexto);
                            areas.definirIdentificador(this.obtenerID() + "" + boton.getID());
                            System.out.println("El ID de la nueva ventana es: " + areas.obtenerID());
                            //areas.setLocation(this.getLocation().x + this.getWidth(), 0);
                            Contexto.agregarVentana(areas);
                            Contexto.activarVentana(areas);
                        } else {
                            Contexto.activarVentana(this.obtenerID() + "" + boton.getID());
                        }
                        break;
                    case Constantes.ACCION_EDITAR:
                        Contexto.activarVentanaEditar(lista_bodegas, Tipo, boton.getID());
                        break;
                }
                break;
            case Constantes.ORIGEN_AREA:
                Area Lista_Areas = (Area) lista_bodegas;
                switch (boton.getAccion()) {
                    case Constantes.ACCION_AGREGAR:
                        if (!Lista_Areas.buscarPorIdentificador(nuevo_elemento_textfield.getText()) && !nuevo_elemento_textfield.getText().equals("") && !nuevo_elemento_textfield.getText().equals(" ")) {
                            Lista_Areas.agregarArea(nuevo_elemento_textfield.getText());
                            GridBagConstraints c = new GridBagConstraints();
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.gridy = y;
                            this.agregarFila(Constantes.ORIGEN_AREA, c, y, nuevo_elemento_textfield.getText(), Lista_Areas.obtenerSize(), Contenedor_Lista);
                            y++;
                            this.pack();
                            if (this.getHeight() >= Contexto.getHeight() - 65) {
                                this.setSize(this.getWidth(), Contexto.getHeight() - 65);
                            }
                            Contenedor_Lista.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "EL nombre del area no es valido o ya existe.");
                        }
                        break;
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir el Area: " + boton.getID());
                        Lista_Areas.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!Contexto.existeVentana(this.obtenerID() + "" + boton.getID())) {
                            Ventana_Interna estantes = new Ventana_Interna(this, Lista_Areas.areaActual().Estantes(), nombre_superior + " \\ " + Lista_Areas.areaActual().obtenerIdentificador(), Constantes.ORIGEN_ESTANTE, Contexto);
                            estantes.definirIdentificador(this.obtenerID() + "" + boton.getID());
                            System.out.println("El ID de la nueva ventana es: " + estantes.obtenerID());
                            //areas.setLocation(this.getLocation().x + this.getWidth(), 0);
                            Contexto.agregarVentana(estantes);
                            Contexto.activarVentana(estantes);
                        } else {
                            Contexto.activarVentana(this.obtenerID() + "" + boton.getID());
                        }
                        break;
                    case Constantes.ACCION_EDITAR:
                        Contexto.activarVentanaEditar(lista_bodegas, Tipo, boton.getID());
                        break;
                }
                break;

            case Constantes.ORIGEN_ESTANTE:
                Estante Lista_Estantes = (Estante) lista_bodegas;
                switch (boton.getAccion()) {
                    case Constantes.ACCION_AGREGAR:
                        if (!Lista_Estantes.buscarPorIdentificador(nuevo_elemento_textfield.getText()) && !nuevo_elemento_textfield.getText().equals("") && !nuevo_elemento_textfield.getText().equals(" ")) {
                            Lista_Estantes.agregarEstante(nuevo_elemento_textfield.getText());
                            GridBagConstraints c = new GridBagConstraints();
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.gridy = y;
                            this.agregarFila(Constantes.ORIGEN_ESTANTE, c, y, nuevo_elemento_textfield.getText(), Lista_Estantes.obtenerSize(), Contenedor_Lista);
                            y++;
                            this.pack();
                            if (this.getHeight() >= Contexto.getHeight() - 65) {
                                this.setSize(this.getWidth(), Contexto.getHeight() - 65);
                            }
                            Contenedor_Lista.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "EL nombre del area no es valido o ya existe.");
                        }
                        break;
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir el Area: " + boton.getID());

                        Lista_Estantes.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!Contexto.existeVentana(this.obtenerID() + "" + boton.getID())) {
                            Ventana_Interna secciones = new Ventana_Interna(this, Lista_Estantes.estanteActual().Secciones(), nombre_superior + " \\ " + Lista_Estantes.estanteActual().obtenerIdentificador(), Constantes.ORIGEN_SECCION, Contexto);
                            secciones.definirIdentificador(this.obtenerID() + "" + boton.getID());
                            System.out.println("El ID de la nueva ventana es: " + secciones.obtenerID());
                            //areas.setLocation(this.getLocation().x + this.getWidth(), 0);
                            Contexto.agregarVentana(secciones);
                            Contexto.activarVentana(secciones);
                        } else {
                            Contexto.activarVentana(this.obtenerID() + "" + boton.getID());
                        }
                        break;
                    case Constantes.ACCION_EDITAR:
                        Contexto.activarVentanaEditar(lista_bodegas, Tipo, boton.getID());
                        break;
                }
                break;
            case Constantes.ORIGEN_SECCION:
                Seccion Lista_Secciones = (Seccion) lista_bodegas;
                switch (boton.getAccion()) {
                    case Constantes.ACCION_AGREGAR:
                        if (!Lista_Secciones.buscarPorIdentificador(nuevo_elemento_textfield.getText()) && !nuevo_elemento_textfield.getText().equals("") && !nuevo_elemento_textfield.getText().equals(" ")) {
                            Lista_Secciones.agregarSeccion(nuevo_elemento_textfield.getText());
                            GridBagConstraints c = new GridBagConstraints();
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.gridy = y;
                            this.agregarFila(Constantes.ORIGEN_SECCION, c, y, nuevo_elemento_textfield.getText(), Lista_Secciones.obtenerSize(), Contenedor_Lista);
                            y++;
                            this.pack();
                            if (this.getHeight() >= Contexto.getHeight() - 65) {
                                this.setSize(this.getWidth(), Contexto.getHeight() - 65);
                            }
                            Contenedor_Lista.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "EL nombre del area no es valido o ya existe.");
                        }
                        break;
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir el Area: " + boton.getID());

                        Lista_Secciones.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (!Contexto.existeVentana(this.obtenerID() + "" + boton.getID())) {
                            Ventana_Interna productos = new Ventana_Interna(this, Lista_Secciones.seccionActual().Productos(), nombre_superior + " \\ " + Lista_Secciones.seccionActual().obtenerIdentificador(), Constantes.ORIGEN_PRODUCTO, Contexto);
                            productos.definirIdentificador(this.obtenerID() + "" + boton.getID());
                            Contexto.agregarVentana(productos);
                            Contexto.activarVentana(productos);
                            System.out.println("El ID de la nueva ventana es: " + productos.obtenerID());
                        } else {
                            Contexto.activarVentana(this.obtenerID() + "" + boton.getID());
                        }
                        break;
                    case Constantes.ACCION_EDITAR:
                        Contexto.activarVentanaEditar(lista_bodegas, Tipo, boton.getID());
                        break;
                }
                break;
        }
    }

    @Override
    public void doDefaultCloseAction() {
        try {
            frame_padre.setIcon(false);
            Contexto.cerrarVentanas(this.obtenerID());
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.doDefaultCloseAction();
    }

}
