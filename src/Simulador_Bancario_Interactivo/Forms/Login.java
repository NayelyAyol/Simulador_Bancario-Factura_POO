package Simulador_Bancario_Interactivo.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel Principal;
    private JTextField usuariotextField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;

    public Login(){
        setVisible(true); //la ventana se hace visible
        setSize(300,200); //se establece el tamaño de la ventana
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setTitle("Login"); //titulo para la ventana

        //accion para el boton ingresar
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //se obtiene el texto de los campos usuario y contraseña
                String usuario = usuariotextField1.getText();
                String contrasenia = String.valueOf(passwordField1.getPassword());

                //se verifica que los campos no esten vacios
                if (usuario.isEmpty() || contrasenia.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "El campo de usuario y contraseña deber ser completados");
                    return;
                }

                //Se validan las credenciales del usuario
                if (usuario.equals("cliente123") && contrasenia.equals("clave456")) {
                    JOptionPane.showMessageDialog(null, "Acceso Concedido");
                    BancoForm banco = new BancoForm(); //si el acceso es concedido se muestra el formuolario BancoForm
                    banco.Usuario(usuario); //Se usa el metodo para pasar valores entre las ventanas
                    dispose(); //se cierra la ventana actual
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso Denegado");
                }

            }
        });
    }
}
