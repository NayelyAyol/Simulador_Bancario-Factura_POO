package Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerProductos extends JFrame{
    private JPanel Principal;
    private JTextArea mostrartextArea1;
    private JButton menuButton;

    public static String detalleR = "";

    public VerProductos(){
        setVisible(true); //la ventana se hace visible
        setSize(300,300); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Ventas (Factura)"); //titulo para la ventana

        //Se agrega al area de texto los productos
        mostrartextArea1.append("Código: "+ Factura.codigoR + "\nNombre: "+ Factura.nombreR + "\nDetalle: "+ detalleR + "\nStock Actuario: "+Factura.stock);

        //Accion para el boton menu
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se muestra la ventana del menu y se cierra la actual
                new Menu();
                dispose();
            }
        });
    }
}
