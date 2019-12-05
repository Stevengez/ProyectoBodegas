/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package proyectobodegas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import proyectobodegas.Estructura.Bodega;

/**
 *
 * @author propietario
 */
public class Ventana_Interna_Bodegas extends JInternalFrame {
    private DefaultTableModel modelo_tabla_bodegas;
    private JTable tabla_bodegas;
    private JPanel contenedor;
    private int y;
    
    public Ventana_Interna_Bodegas(Bodega lista_bodegas){
        setTitle("Listado de Bodegas");
        y = 0;
        
        add(crearContenedor(lista_bodegas));
        pack();
        setMinimumSize(this.getSize());
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setVisible(true);
    }
    
    public JPanel crearContenedor(Bodega lista_bodegas){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = y;
        
        contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());
        
        
        JPanel agregar_bodega = new JPanel(null);
        agregar_bodega.setVisible(true);
        JLabel label_agregar = new JLabel("Agregar Bodega");
        label_agregar.setBounds(10,10,100,30);
        JTextField nueva_bodega_textfield = new JTextField();
        nueva_bodega_textfield.setBounds(10,140,100,30);
        JButton boton_agregar = new JButton("Agregar");
        boton_agregar.setBounds(10,270,100,30);
        
        agregar_bodega.add(label_agregar);
        agregar_bodega.add(nueva_bodega_textfield);
        agregar_bodega.add(boton_agregar);
        
        
        contenedor.add(agregar_bodega,c);
        y++;
        llenarDatos(lista_bodegas);
        contenedor.setVisible(true);
        return contenedor;
    }
    
    public JTable crearTabla(){
        String[] nombre = new String[]{"ID","Nombre"};
        modelo_tabla_bodegas = new DefaultTableModel();
        modelo_tabla_bodegas.addColumn("ID");
        modelo_tabla_bodegas.addColumn("Nombre");
        
        tabla_bodegas = new JTable(modelo_tabla_bodegas);
        return tabla_bodegas;
    }
    
    public void llenarDatos(Bodega lista_bodegas){
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = y;
        c.gridwidth = 3;
        while(lista_bodegas.SiguienteBodega()){
            c.gridx = 0;
            c.gridy = y;
            
            JPanel nueva_fila = new JPanel(new GridBagLayout());
            nueva_fila.setOpaque(true);
            nueva_fila.setBackground(Color.WHITE);
            
            JLabel ID = new JLabel();
            ID.setBackground(Color.WHITE);
            ID.setOpaque(true);
            ID.setText(""+lista_bodegas.bodegaActual().obtenerIndice());
            
            JLabel Nombre = new JLabel();
            Nombre.setBackground(Color.WHITE);
            Nombre.setOpaque(true);
            Nombre.setText(lista_bodegas.bodegaActual().obtenerIdentificador());
            
            JButton Editar = new JButton("Editar");
            Editar.setBounds(0, 0, 80, 10);
            
            nueva_fila.add(ID);
            nueva_fila.add(Nombre);
            nueva_fila.add(Editar);
            
            contenedor.add(nueva_fila,c);
            y++;
        }
    }
}
