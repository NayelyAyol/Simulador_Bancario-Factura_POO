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
                new Registro();
                dispose();
            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Factura();
                dispose();
            }
        });
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerProductos();
                dispose();
            }
        });
    }
}
