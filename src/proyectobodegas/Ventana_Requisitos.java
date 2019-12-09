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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proyectobodegas.Estructura.Constantes;
import proyectobodegas.Estructura.Requisitos;

/**
 *
 * @author Steven Jocol
 */
public class Ventana_Requisitos extends JInternalFrame implements ItemListener,ActionListener {
    private ProyectoBodegas Contexto;
    private Requisitos Lista_Requisitos;
    private JTextField nuevo_nombre;
    private JTextArea nueva_descripcion;
    private JComboBox Lista;
    private JTextArea descripcion_actual;
    
    
    public Ventana_Requisitos(ProyectoBodegas Contexto){
        this.Contexto = Contexto;
        this.Lista_Requisitos = Contexto.obtenerRequisitos();
        setTitle("Requisitos de Areas y Productos");
        setMaximumSize(new Dimension(1300, 700));
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        add(crearContenedorAgregar());
        pack();
        setMinimumSize(new Dimension(this.getWidth(),400));
        setVisible(true);
    }
    
    private JScrollPane crearContenedorAgregar() {

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 15, 5, 15);
        c.gridx = 0;
        c.gridy = 0;

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());

        JPanel agregar_restriccion = new JPanel();
        agregar_restriccion.setLayout(new GridBagLayout());
        agregar_restriccion.setOpaque(true);
        agregar_restriccion.setBackground(Color.WHITE);

        JLabel label_agregar = new JLabel("Nombre :");
        nuevo_nombre = new JTextField(15);
        Boton boton_agregar = new Boton("Agregar");
        boton_agregar.addActionListener(this);
        boton_agregar.setAction(Constantes.ACCION_AGREGAR);

        c.gridx = 0;
        agregar_restriccion.add(label_agregar, c);
        c.gridx = 1;
        agregar_restriccion.add(nuevo_nombre, c);
        c.ipadx = 0;
        c.gridx = 2;
        agregar_restriccion.add(boton_agregar, c);
        
        c.gridy = 1;
        c.gridx = 0;
        agregar_restriccion.add(new JLabel("Descripcion: "),c);
        
        c.gridx = 1;
        c.gridwidth = 3;
        nueva_descripcion = new JTextArea();
        nueva_descripcion.setLineWrap(true);
        nueva_descripcion.setRows(3);
        nueva_descripcion.setBorder(BorderFactory.createMatteBorder(1, 1,1,1, Color.BLACK));
        agregar_restriccion.add(nueva_descripcion,c);

        c.gridx = 0;
        contenedor.add(agregar_restriccion, c);
        c.gridy = 3;
        contenedor.add(crearContenedorLista(),c);

        contenedor.setVisible(true);
        JScrollPane scrollpane = new JScrollPane(contenedor);
        return scrollpane;
    }
    
    private JPanel crearContenedorLista() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 15, 5, 15);
        c.gridx = 0;
        c.gridy = 0;

        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());

        JPanel elemento_actual = new JPanel();
        elemento_actual.setLayout(new GridBagLayout());
        elemento_actual.setOpaque(true);
        elemento_actual.setBackground(Color.WHITE);

        JLabel label_lista = new JLabel("Listado: ");
        elemento_actual.add(label_lista, c);
        
        c.gridx = 1;
        elemento_actual.add(crearLista(), c);
        
        c.gridx = 2;
        Boton boton_actualizar = new Boton("Actualizar");
        boton_actualizar.addActionListener(this);
        boton_actualizar.setAction(Constantes.ACCION_AGREGAR);
        elemento_actual.add(boton_actualizar,c);
        
        c.gridy = 2;    
        c.gridx = 0;
        JLabel label_agregar = new JLabel("Nombre :");
        elemento_actual.add(label_agregar, c);
        
        c.gridx = 1;
        JTextField nuevo_elemento_textfield = new JTextField(15);
        elemento_actual.add(nuevo_elemento_textfield, c);
        
        c.ipadx = 0;
        c.gridx = 2;
        Boton boton_eliminar = new Boton("Eliminar");
        elemento_actual.add(boton_eliminar, c);
        
        c.gridy = 3;
        c.gridx = 0;
        elemento_actual.add(new JLabel("Descripcion: "),c);
        
        c.gridx = 1;
        c.gridwidth = 3;
        descripcion_actual = new JTextArea();
        descripcion_actual.setLineWrap(true);
        descripcion_actual.setRows(3);
        descripcion_actual.setBorder(BorderFactory.createMatteBorder(1, 1,1,1, Color.BLACK));
        elemento_actual.add(descripcion_actual,c);
        contenedor.add(elemento_actual, c);
        contenedor.setVisible(true);
        return contenedor;
    }
    
    public JComboBox crearLista(){
        Lista = new JComboBox();
        Lista.addItemListener(this);
        while(Lista_Requisitos.siguienteRequisito()){
            Lista.addItem(Lista_Requisitos.requisitoActual().obtenerIdentificador());
        }
        return Lista;
    }
    
    public void agregaraLista(String nombre, String descripcion){
        Lista.addItem(nombre);
        
    }

    public void itemStateChanged(ItemEvent e) {
        System.out.println("Seleccionaste: "+e.getItem().toString());
    }

    public void actionPerformed(ActionEvent e) {
        Boton boton = (Boton) e.getSource();
        switch(boton.getAccion()){
            case Constantes.ACCION_AGREGAR:
                System.out.println("Apachaste el boton");
                Lista_Requisitos.agregarRequisito(nuevo_nombre.getText(), nueva_descripcion.getText());
                agregaraLista(nuevo_nombre.getText(), nueva_descripcion.getText());
                break;
            default:
                System.out.println("Otra cosa.");
                break;
        }
        
    }
    
}
