package Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame{
    private JPanel Principal;
    private JTextField codigotextField1;
    private JTextField nombretextField2;
    private JTextField detalletextField3;
    private JTextField preciotextField4;
    private JTextField stocktextField5;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton menuButton;

    public Registro(){
        setVisible(true); //la ventana se hace visible
        setSize(500,500); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Registro de Productos"); //titulo para la ventana

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigotextField1.getText();
                String nombre = nombretextField2.getText();
                String detalle = detalletextField3.getText();
                String precio = preciotextField4.getText();
                String stock = stocktextField5.getText();

                if (codigo.isEmpty() || nombre.isEmpty() || detalle.isEmpty() || precio.isEmpty() || stock.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
                    return;
                }

                try {
                    double precioU = Double.parseDouble(precio);
                    int stockC = Integer.parseInt(stock);
                    if (precioU<0 || stockC<0){
                        JOptionPane.showMessageDialog(null, "El precio y el stock no pueden ser negativo");
                        return;
                    }

                    if (precio.replace(".", "").length()>4){
                        JOptionPane.showMessageDialog(null, "El precio solo puede tener 4 cifras");
                        return;
                    }

                    if (stock.length() > 3){
                        JOptionPane.showMessageDialog(null, "El stock solo puede tener 3 cifras");
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Registro de producto exitoso");
                    Factura.codigoR = codigo;
                    Factura.nombreR = nombre;
                    Factura.precioR = precioU;
                    Factura.stock = stockC;
                    VerProductos.detalleR = detalle;

                    codigotextField1.setText("");
                    nombretextField2.setText("");
                    detalletextField3.setText("");
                    preciotextField4.setText("");
                    stocktextField5.setText("");

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Precio no valido");
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigotextField1.setText("");
                nombretextField2.setText("");
                detalletextField3.setText("");
                preciotextField4.setText("");
                stocktextField5.setText("");
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });
    }
}
