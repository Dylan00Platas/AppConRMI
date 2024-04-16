import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;


public class Cliente {
    
public static void main(String[] args) {
    int puerto = 8080;
    String servidor = "localhost";

    try{
        Calculadora calc = (Calculadora) Naming.lookup("rmi://" + servidor + ":" + puerto + "/Calculadora");

        while (true){
            String opt = JOptionPane.showInputDialog(
                "Calcular\n" + "suma...... (1)\n"+ 
                "resta.......(2)\n" + "multip......(3)\n" + "division......... (4)\n");

        if (opt == null)
         break;

            int a = Integer.parseInt(JOptionPane.showInputDialog("ingrese a"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("ingrese b"));


            switch (opt) {
                case "1": {
                JOptionPane.showMessageDialog(null, a + "+" + b + "=" + calc.sum(a, b));
                    break;
            }
            case "2": {
                JOptionPane.showMessageDialog(null, a + "-" + b + "=" + calc.res(a, b));
                break;
                

            }
            case "3" : {
                JOptionPane.showMessageDialog(null, a + "*" + b + "=" + calc.mul(a, b));

            }
            case "4" : {
                JOptionPane.showMessageDialog(null, a + "/" + b + "=" + calc.div(a, b));

            }
            }

            }

    }catch (RemoteException | NotBoundException ex){
        JOptionPane.showMessageDialog(null, "no se pudo conectar" + puerto);
    }catch (MalformedURLException ex){
        JOptionPane.showMessageDialog(null, "URL MAL", servidor, puerto);
    }


}


}
