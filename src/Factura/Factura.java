package Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Factura extends JFrame{
    private JPanel Principal;
    private JLabel lblproducto;
    private JTextField codigotextField1;
    private JLabel lblprecio;
    private JTextField cantidadtextField1;
    private JLabel lblsubtotal;
    private JLabel lbliva;
    private JLabel lbltotal;
    private JButton menuButton;
    private JButton calcularButton;

    public static String codigoR = "";
    public static String nombreR = "";
    public static double precioR = 0.0;
    public static int stock = 0;


    public Factura(){
        setVisible(true); //la ventana se hace visible
        setSize(300,300); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Ventas (Factura)"); //titulo para la ventana

        lblproducto.setText("---");
        lblprecio.setText("0.00");
        lbliva.setText("0.00");
        lblsubtotal.setText("0.00");
        lbltotal.setText("0.00");

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cantidad = cantidadtextField1.getText();

                if (cantidad.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Los campos deben estar llenos");
                    return;
                }

                try {
                    int cantidadE = Integer.parseInt(cantidad);

                    if (cantidadE<0) {
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que 0");
                        return;
                    }

                    if (cantidadE > stock){
                        JOptionPane.showMessageDialog(null, "No hay suficiente stock");
                        return;
                    }

                        double subtotal = cantidadE * precioR;
                        double iva = subtotal*0.15;
                        double total = subtotal + iva;

                        lblsubtotal.setText(String.format("%.2f", subtotal));
                        lbliva.setText(String.format("%.2f", iva));
                        lbltotal.setText(String.format("%.2f", total));

                        stock -= cantidadE;

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cantidad no válida");
                }
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });
        codigotextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigotextField1.getText();
                if (codigo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Los campos deben estar llenos");
                    return;
                }

                if (codigo.equals(Factura.codigoR)){
                    lblproducto.setText(nombreR);
                    lblprecio.setText(String.format("%.2f", precioR));
                }else {
                    lblproducto.setText("");
                    lblprecio.setText("");
                    JOptionPane.showMessageDialog(null, "Código sin registrar");
                }
            }
        });
    }
}
