import javax.swing.*;
import java.io.*;

public class ArchivoTexto {

    File archivo;
    FileReader leer;
    FileWriter escribir;
    PrintWriter linea;

    String cadena;

    private String nombre = "";

    private int numeroControl;
    private int semestre;
    private double promedio;
    File acreditados;
    File noAcreditados;

    public void altas() {
        archivo = new File("archivo.txt");
        String cadenaCache = "";

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();

                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: "
                        , "Solicitando datos", 3);
                numeroControl = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingresa el numero de control: ", "Solicitando datos", 3));
                semestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: "
                        , "Solicitando datos", 3));

                promedio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                        , "Solicitando datos", 3));

                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);

                linea.println(nombre);
                linea.println(numeroControl);
                linea.println(semestre);
                linea.println(promedio);

                linea.close();
                escribir.close();

            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else {
            try {
                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: "
                        , "Solicitando datos", 3);
                numeroControl = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingresa el numero de control: ", "Solicitando datos", 3));
                semestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: "
                        , "Solicitando datos", 3));

                promedio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                        , "Solicitando datos", 3));

                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);

                linea.println(nombre);
                linea.println(numeroControl);
                linea.println(semestre);
                linea.println(promedio);

                linea.close();
                escribir.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*try {
            leer = new FileReader(archivo);
            BufferedReader br = new BufferedReader(leer);

            cadena = "";

            while (cadena != null) {
                try {
                    cadena = br.readLine();
                    if (cadena != null) {
                        System.out.println(cadena);
                        cadenaCache = cadenaCache + cadena + "\n";
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                br.close();
                leer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,
                cadenaCache,
                "Mostrando los datos del archivo",
                1);*/

    }//cierra el metodo

    public void eliminarArchivo() {
        if (archivo.delete()) {
            System.out.println("Eliminado con exito");
        } else {
            System.out.println("Error, no se elimino");
        }
    }//cierra el metodo

    //  ESCRITURA DEL ARCHIVO
    public void escribirArchivo() {
        try {
            FileWriter fw = new FileWriter(archivo);
            fw.write("Saludos");
            fw.close();
            System.out.println("Texto anadido con exito");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }//cierra el metodo

    //  LECTURA DEL ARCHIVO
    public void leerArchivo() {
        String contenido;

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            contenido = br.readLine();

            while (contenido != null) {
                System.out.println(contenido);
                contenido = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//cierra el metodo
}//cierra la clase
