package Simulador_Bancario_Interactivo.Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoForm extends JFrame{
    private double saldo = 1000.00;
    private JPanel Principal;
    private JTextArea historialtextArea1;
    private JButton depositoButton;
    private JButton transferenciaButton;
    private JButton retiroButton;
    private JButton salirButton;
    private JLabel lblusuario;
    private JLabel lblsaldo;
    private JTextField destinatariotextField1;
    private JTextField montotextField2;

    //metodo para pasar valores entre ventanas
    public void Usuario(String nombre){
        lblusuario.setText("Bienvenido "+nombre);
    }

    //metodo para actualizar el saldo
    public void actualizarSaldo(){
        lblsaldo.setText(String.format("%.2f", saldo));
    }

    public BancoForm(){
        setTitle("BancoForm"); //titulo para la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sirve para que se cierra la aplicacion al salir
        setLocationRelativeTo(null); //sirve para centrar la ventana en la pantalla
        setContentPane(Principal); //se establece el panel principal
        setVisible(true); //la ventana se hace visible
        setSize(500,400); //se establece el tamaño de la ventana

        lblsaldo.setText(String.format("%.2f", saldo)); //se inicializa a saldo
        historialtextArea1.setEditable(false); //se configura al area del historial para que no sea editable

        depositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ventana de dialogo para ingresar el monto del deposito
                String valor = JOptionPane.showInputDialog(BancoForm.this, "Ingrese el monto que desea depositar: ");

                //Se verifica que el campo no este vacio
                if (valor.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un monto para el deposito");
                    return;
                }

                try {
                    //Se convierte el monto ingresado a tipo double
                    double monto= Double.parseDouble(valor);
                    //se valida que el monto sea mayor que 0
                    if (monto>0){
                        saldo+=monto; //se suma el monto al saldo de la cuenta
                        historialtextArea1.append("Depósito de $"+monto+"\n"); //el deposito es agregado al historial
                        actualizarSaldo(); //se llama al metodo para actualizar el saldo
                        JOptionPane.showMessageDialog(BancoForm.this, "El depósito fue exitoso");
                    }else{
                        JOptionPane.showMessageDialog(BancoForm.this, "El monto del depósito no puede ser negativo");
                    }
                }catch (NumberFormatException ex){ //Excepcion para valores no numericos
                    JOptionPane.showMessageDialog(BancoForm.this, "Monto no válido");
                }
            }
        });
        retiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ventana de dialogo para ingresar el monto del retiro
                String retiro= JOptionPane.showInputDialog(BancoForm.this, "Ingrese el monto que desea retirar: ");

                //Se verifica que el campo no este vacio
                if (retiro.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un monto para el retiro");
                    return;
                }

                try {
                    //Se transforma el monto del retiro a double
                    double monto = Double.parseDouble(retiro);
                    //se valida que el monto no sea mayor al saldo y que sea mayor que 0
                    if (monto <= saldo && monto > 0) {
                        saldo-=monto; //se resta el monto del saldo de la cuenta
                        historialtextArea1.append("Retiro de $"+monto+"\n"); //el retiro es agregado al historial
                        actualizarSaldo(); //se llama al metodo para actualizar el saldo
                        JOptionPane.showMessageDialog(BancoForm.this, "Retiro exitoso");
                    }else{
                        JOptionPane.showMessageDialog(BancoForm.this, "El monto que desea retirar debe ser menor que el saldo de su cuenta y mayor que 0");
                    }
                } catch (NumberFormatException ex) { //Excepcion para valores no numericos
                    JOptionPane.showMessageDialog(BancoForm.this,"Monto no válido");
                }
            }
        });
        transferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //se obtienen los valores de los campos del formulario
                String detinatario = destinatariotextField1.getText();
                String valor = montotextField2.getText();

                //se verifica que los campos esten llenos
                if (detinatario.isEmpty() || valor.isEmpty()){
                    JOptionPane.showMessageDialog(BancoForm.this, "LLene el destinatario y el monto");
                    return;
                }
                try{
                    double monto = Double.parseDouble(valor);
                    //se valida que el monto no sea mayor al saldo y que sea mayor que 0
                    if (monto <= saldo && monto > 0){
                        saldo-=monto; //se resta el monto del retiro al saldo de la cuenta
                        historialtextArea1.append("Transferencia exitosa a "+detinatario+" por $"+monto+"\n"); //se agrega la transferencia al historial
                        actualizarSaldo(); //se llama al metodo para actualizar el saldo
                        JOptionPane.showMessageDialog(BancoForm.this, "Transferencia exitosa");
                        //se limpian los campos de detinatario y monto
                        destinatariotextField1.setText("");
                        montotextField2.setText("");
                    }else{
                        JOptionPane.showMessageDialog(BancoForm.this, "El monto que desea transferir debe ser menor que el saldo de su cuenta y mayor que 0");
                    }

                } catch (NumberFormatException ex) { //Excepcion para valores no numericos
                    JOptionPane.showMessageDialog(BancoForm.this, "Monto no válido");
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(); //Se vuelve a mostrar el formulario de Login
                dispose(); //Se cierra la ventana actual
            }
        });
    }
}
