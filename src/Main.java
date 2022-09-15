import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ArchivoTexto archivoTexto = new ArchivoTexto();

        int eleccion;
        String salida = null;

        do {
            eleccion = Integer.parseInt(JOptionPane.showInputDialog("1.- Altas " +
                    "\n2.- Modificar " +
                    "\n3.- Mostrar " +
                    "\n4.- Salir"));

            switch (eleccion) {
                case 1:
                    archivoTexto.altas();
                    break;

                case 2:
                    int buscar = Integer.parseInt(JOptionPane.showInputDialog("Buscar por: " +
                            "\n1.- Nombre" +
                            "\n2.- Numero de control"));
                    switch (buscar){
                        case 1:
                            archivoTexto.buscar(buscar);
                            break;
                        case 2:
                            archivoTexto.buscar(buscar);
                            break;
                        default: JOptionPane.showMessageDialog(null, "Debe elegir una de las " +
                                "opciones disponibles.");
                    }
                    break;

                case 3:
                    archivoTexto.leerArchivo();
                    break;

                case 4:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debe elegir una opcion valida.");
            }
            salida = JOptionPane.showInputDialog("¿Hacer otro movimiento?");
        } while (salida.equalsIgnoreCase("Si"));
    }//cierra el metodo
}//cierra la clase
