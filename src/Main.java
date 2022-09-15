import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ArchivoTexto archivoTexto = new ArchivoTexto();

        //archivoTexto.crearArchivo();
        //archivoTexto.eliminarArchivo();
        //archivoTexto.escribirArchivo();
        //archivoTexto.leerArchivo();

        int eleccion;
        String salida = null;

        //archivoTexto.altas();

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
                    break;

                case 3:
                    break;

                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debe elegir una opcion valida.");
            }
            salida = JOptionPane.showInputDialog("Esta seguro que desea salir?");
        } while (salida.equalsIgnoreCase("No"));
    }//cierra el metodo
}//cierra la clase
