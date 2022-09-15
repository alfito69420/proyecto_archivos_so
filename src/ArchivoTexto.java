import javax.swing.*;
import java.io.*;

public class ArchivoTexto {

    FileReader leer;
    FileWriter escribir;
    PrintWriter linea;

    private String nombre = "", cadena;
    private int numeroControl, semestre;
    private double promedio;
    File acreditados, noAcreditados;

    public void altas() {
        acreditados = new File("acreditados.txt");
        noAcreditados = new File("noAcreditados.txt");
        String cadenaCache = "";

        if (/*!archivo.exists()*/!acreditados.exists() && !noAcreditados.exists()) {
            try {
                //archivo.createNewFile();
                acreditados.createNewFile();
                noAcreditados.createNewFile();

                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: "
                        , "Solicitando datos", 3);
                numeroControl = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingresa el numero de control: ", "Solicitando datos", 3));
                semestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: "
                        , "Solicitando datos", 3));

                promedio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                        , "Solicitando datos", 3));

                seleccionarArchivo();

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

                seleccionarArchivo();
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

    public void seleccionarArchivo() {

        try {
            if (promedio >= 70 && promedio <= 100) {  //  acreditado
                escribir = new FileWriter(acreditados, true);
                linea = new PrintWriter(escribir);

                linea.println(nombre);
                linea.println(numeroControl);
                linea.println(semestre);
                linea.println(promedio);

                linea.close();
                escribir.close();
            }

            if (promedio >= 0 && promedio <= 69) {  //  No acreditado
                escribir = new FileWriter(noAcreditados, true);
                linea = new PrintWriter(escribir);

                linea.println(nombre);
                linea.println(numeroControl);
                linea.println(semestre);
                linea.println(promedio);

                linea.close();
                escribir.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//cierra el metodo

    /*public void eliminarArchivo() {
        if (archivo.delete()) {
            System.out.println("Eliminado con exito");
        } else {
            System.out.println("Error, no se elimino");
        }
    }//cierra el metodo*/

    //  ESCRITURA DEL ARCHIVO
    /*public void escribirArchivo() {
        try {
            FileWriter fw = new FileWriter(archivo);
            fw.write("Saludos");
            fw.close();
            System.out.println("Texto anadido con exito");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }//cierra el metodo*/

    //  LECTURA DEL ARCHIVO
    /*public void leerArchivo() {
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
    }//cierra el metodo*/
}//cierra la clase
