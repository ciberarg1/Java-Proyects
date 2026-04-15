//import java.util.Scanner; comento esto porque es para import el swing, como gui
import javax.swing.JOptionPane;

public class Calculadora {
    public static void main(String[] args) {
        //Scanner teclado = new Scanner(System.in); fundamental comentar esto porque ya no usamos el import de scanner
        double num1, num2, resultado;
        //System.out.println("Introduci el primer numero");
        String texto1 = JOptionPane.showInputDialog("introduci el primer numero :");
        num1 = Double.parseDouble(texto1);
        //num1 = teclado.nextDouble(); comento esto para importar la herramienta gui de JOPtionpane

        //System.out.println("Introduci el segundo numero"); Todo por el gui, lo que tenga q ver con teclado, hay que comentar
        //num2 = teclado.nextDouble();
        String texto2 = JOptionPane.showInputDialog("introduci el segundo number :");
        num2 = Double.parseDouble(texto2);
        
        String menu = "Elija una operacion:\n" +
                        "1. Sumar\n" +
                        "2. Restar\n"+
                        "3. Multiplicar\n" +
                        "4. Dividir";
        
        String opcionTexto = JOptionPane.showInputDialog(menu);
        int operacion = Integer.parseInt(opcionTexto);
        //System.out.println("¿Que operacion queres hacer?"); <<< importante comentar esto porque ya no tenemos que escribirlo, por ende no nos deberia
        //System.out.println("1. Sumar"); preguntar a nosotros que queremos escribir.
        //System.out.println("2. Restar");
        //System.out.println("3. Multiplicar");
        //System.out.println("4. Dividir");
        //int operacion = teclado.nextInt();

        switch (operacion) {
            case 1:
                resultado = num1 + num2;
                // null es para que la ventanita aparezca libre y centrada en el monitor
                // showmessagedialog para mostara informacion al usuario en el cartel
                // break para tomar decisiones y evitar que el programa haga calculos imposibles
                JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + resultado);
                //System.out.println("El resultado de la suma es :" + resultado); Codigo original pero cambiado para hacer la gui
                break;

            case 2:
                resultado = num1 - num2;
                JOptionPane.showMessageDialog(null, "El resultado de la resta es:" + resultado);
                    //System.out.println("El resultado de la resta es : " + resultado);
                    break;

            case 3:
                resultado = num1 * num2;
                JOptionPane.showMessageDialog(null, "El resultado de la multiplicacion es: " + resultado);
                //System.out.println("El resultado de la multiplicacion es : " + resultado);
                break;

            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    JOptionPane.showMessageDialog(null,"El resultado de la division es : " + resultado);
                    //System.out.println("El resultado de la division es :" + resultado);
                    } else {
                    JOptionPane.showMessageDialog(null, "Esto no se puede dividir por cero. ");
                    }
                    break;
        }
    }   
}



