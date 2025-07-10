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
        setSize(500,300); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Registro de Productos"); //titulo para la ventana

        //Accion para el boton guardar
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se obtiene el texto ingresado en los campos
                String codigo = codigotextField1.getText();
                String nombre = nombretextField2.getText();
                String detalle = detalletextField3.getText();
                String precio = preciotextField4.getText();
                String stock = stocktextField5.getText();

                //Se verifica que todos los campos esten llenos
                if (codigo.isEmpty() || nombre.isEmpty() || detalle.isEmpty() || precio.isEmpty() || stock.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados");
                    return;
                }

                try {
                    //Se convierte el precio a double
                    double precioU = Double.parseDouble(precio);
                    //Se convierte el stock en int
                    int stockC = Integer.parseInt(stock);
                    if (precioU<0 || stockC<0){
                        JOptionPane.showMessageDialog(null, "El precio y el stock no pueden ser negativo");
                        return;
                    }

                    //Validacion para que el precio no tenga mas de 4 cifras
                    if (precio.replace(".", "").length()>4){
                        JOptionPane.showMessageDialog(null, "El precio solo puede tener 4 cifras");
                        return;
                    }

                    //Validacion para que el stock no tenga mas de 3 cifras
                    if (stock.length() > 3){
                        JOptionPane.showMessageDialog(null, "El stock solo puede tener 3 cifras");
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Registro de producto exitoso");

                    //Se asignan los datos a las variables estaticas de las ventanas Factura y VerProductos
                    Factura.codigoR = codigo;
                    Factura.nombreR = nombre;
                    Factura.precioR = precioU;
                    Factura.stock = stockC;
                    VerProductos.detalleR = detalle;

                    //Se limpian los campos automaticamente
                    codigotextField1.setText("");
                    nombretextField2.setText("");
                    detalletextField3.setText("");
                    preciotextField4.setText("");
                    stocktextField5.setText("");

                }catch (NumberFormatException ex){ //Excepcion para valores no numericos
                    JOptionPane.showMessageDialog(null, "Precio no valido");
                }
            }
        });

        //Accion para el boton limpiar
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se limpian los campos
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
                //Se llama a la venta del menu y se cierra la actual
                new Menu();
                dispose();
            }
        });
    }
}
