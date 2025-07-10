package Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel Principal;
    private JTextField usuariotextField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;

    public Login (){
        setVisible(true); //la ventana se hace visible
        setSize(300,300); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Login"); //titulo para la ventana


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se obtiene el texto de los campos
                String usuario = usuariotextField1.getText();
                String contrasenia = String.valueOf(passwordField1.getPassword());

                //Se verifica que los campos esten vacios
                if (usuario.isEmpty() || contrasenia.isEmpty()){
                    JOptionPane.showMessageDialog(null, "El usuario y contraseña deben ser completados");
                    return;
                }

                //Validacion de credenciales
                if (usuario.equals("123") && contrasenia.equals("123")){
                    JOptionPane.showMessageDialog(null, "Acceso Concedido");
                    new Menu();
                    dispose();

                }else {
                    JOptionPane.showMessageDialog(null, "Acceso Denegado");
                }
            }
        });
    }
}
