package Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel Principal;
    private JButton registroButton;
    private JButton ventasButton;
    private JButton verProductosButton;

    public Menu(){
        setVisible(true); //la ventana se hace visible
        setSize(300,200); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Menú"); //titulo para la ventana


        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se muestra la ventana del Registro y se cierra la actual
                new Registro();
                dispose();
            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se muestra la ventana de la Factura y se cierra la actual
                new Factura();
                dispose();
            }
        });
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se muestra la ventana de VerProductos y se cierra la actual
                new VerProductos();
                dispose();
            }
        });
    }
}
