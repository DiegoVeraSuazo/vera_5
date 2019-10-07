import com.google.gson.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LecturaEscrituraTexto {

    public static Gestor gestor = new Gestor();

    public static void main(String[] args) {
        String ruta = "zapatillas.json";
        gestor.agregarZapatilla();
        menu(ruta);
    }

    /**
     * Metodo que llama a un menu clasico
     */
    public static void menu(String ruta){
        boolean ejec = true;
        System.out.println("Bienvenido al menu principal, ¿Que desea hacer?");
        do {
            System.out.println("Selecciona la operacion a realizar");
            System.out.println("1 - Leer Json");
            System.out.println("2 - Deserializar");
            System.out.println("3 - Agregar Zapatilla");
            System.out.println("9 - Terminar");
            int opcion = validarNumero();
            if (opcion >= 1 && opcion <= 3 ) {
                seleccion(opcion, ejec, ruta);

            } else if (opcion == 9) {
                ejec = false;
            } else {
                System.out.println("Opcion no valida");
            }

        } while (ejec);
    }

    /**
     * Extension del menu que usa un Switch para ir a cada metodo
     * @param opcion ingresado para saber a que caso ir
     * @param ejec usado para saber cuando esta activo
     */
    private static void seleccion(int opcion, boolean ejec, String ruta) {

        switch(opcion){
            case 1:
                mostrarTexto(ruta);
                break;
            case 2:
                gestor.deserializar(gestor.obtenerTextoArchivo(ruta));
                break;
            case 3:
                gestor.agregarZapatilla();
                break;
            default:
                break;
        }

    }

    public static void mostrarTexto(String ruta) {
        System.out.println("El contenido del archivo es: \n"+gestor.obtenerTextoArchivo(ruta));
    }

    /**
     * Metodo que valida los numeros ingresados de letra y/o caracteres
     * @return Retorna una Variable de tipo int.
     */
    public static int validarNumero() {
        Scanner teclado = new Scanner(System.in);
        int entrada = 0;
        Boolean valido;
        do {
            try {
                entrada = teclado.nextInt();
                if (entrada >= 0){
                    valido = false;
                } else {
                    System.out.println("Ingreso de negativo, Invalido");
                    valido = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("No ingrese letras u oraciones");
                teclado.next();
                valido = true;
            }
        } while (valido);
        return entrada;
    }

}
