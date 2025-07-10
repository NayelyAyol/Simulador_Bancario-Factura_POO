package Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

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

    //Variables estaticas
    public static String codigoR = "";
    public static String nombreR = "";
    public static double precioR = 0.0;
    public static int stock = 0;


    public Factura(){
        setVisible(true); //la ventana se hace visible
        setSize(350,300); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Ventas (Factura)"); //titulo para la ventana

        //Se inicializan las etiquetas
        lblproducto.setText("---");
        lblprecio.setText("0.00");
        lbliva.setText("0.00");
        lblsubtotal.setText("0.00");
        lbltotal.setText("0.00");

        lbltotal.setFont(lbltotal.getFont().deriveFont(Font.BOLD, 16f));

        //Accion para el boton calcular
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cantidad = cantidadtextField1.getText();

                //Se valida que el campo o este vacio
                if (cantidad.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Los campos deben estar llenos");
                    return;
                }

                try {
                    //Se convierte cantidad a entero
                    int cantidadE = Integer.parseInt(cantidad);

                    //Se valida que la cantidad no sea negativa
                    if (cantidadE<0) {
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que 0");
                        return;
                    }

                    //Se valida que la cantidad no sobrepase el stock
                    if (cantidadE > stock){
                        JOptionPane.showMessageDialog(null, "No hay suficiente stock");
                        return;
                    }

                        //Calculos para la factura
                        double subtotal = cantidadE * precioR;
                        double iva = subtotal*0.15;
                        double total = subtotal + iva;

                        //Se muestran los resultados
                        lblsubtotal.setText(String.format("%.2f", subtotal));
                        lbliva.setText(String.format("%.2f", iva));
                        lbltotal.setText(String.format("%.2f", total));

                    //Se actualiza el stock
                        stock -= cantidadE;

                } catch (NumberFormatException ex) { //Excepcion para valores no numericos
                    JOptionPane.showMessageDialog(null, "Cantidad no válida");
                }
            }
        });

        //Accion para el boton menu
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se muestra la ventana del menu y se cierra la actual
                new Menu();
                dispose();
            }
        });

        //Accion para buscar el codigo en el registro
        codigotextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se extrae el texto del campo
                String codigo = codigotextField1.getText();
                //Se valida que el campo no este vacio
                if (codigo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Los campos deben estar llenos");
                    return;
                }

                //Se valida que el codigo sea identico al registrado
                if (codigo.equals(Factura.codigoR)){
                    //Si el codigo es identico se muestran el nombre del producto y el precio
                    lblproducto.setText(nombreR);
                    lblprecio.setText(String.format("%.2f", precioR));
                }else {
                    //Si no es correcto no se muestra nada
                    lblproducto.setText("");
                    lblprecio.setText("");
                    JOptionPane.showMessageDialog(null, "Código sin registrar");
                }
            }
        });
    }
}
