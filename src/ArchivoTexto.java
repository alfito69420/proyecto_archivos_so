import javax.swing.*;
import java.io.*;
import java.util.Formatter;

public class ArchivoTexto {

    FileReader leer;
    FileWriter escribir;
    PrintWriter linea;

    Formatter fmt = new Formatter();

    private String nombre = "", cadena;
    private int numeroControl, semestre;
    private double promedio;
    File acreditados, noAcreditados;

    public void altas() {

        acreditados = new File("acreditados.txt");
        noAcreditados = new File("noAcreditados.txt");

        if (!acreditados.exists() && !noAcreditados.exists()) { //  Si no existe...
            try {
                acreditados.createNewFile();
                noAcreditados.createNewFile();

                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: "
                        , "Solicitando datos", JOptionPane.QUESTION_MESSAGE);
                numeroControl = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingresa el numero de control: ", "Solicitando datos", 3));
                semestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: "
                        , "Solicitando datos", JOptionPane.QUESTION_MESSAGE));

                promedio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                        , "Solicitando datos", JOptionPane.QUESTION_MESSAGE));

                seleccionarArchivo();

            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else { // Si ya existe...
            try {
                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: "
                        , "Solicitando datos", JOptionPane.QUESTION_MESSAGE);
                numeroControl = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Ingresa el numero de control: ", "Solicitando datos", 3));
                semestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: "
                        , "Solicitando datos", JOptionPane.QUESTION_MESSAGE));

                promedio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                        , "Solicitando datos", JOptionPane.QUESTION_MESSAGE));

                seleccionarArchivo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//cierra el metodo

    public void seleccionarArchivo() {
        try {
            if (promedio >= 70 && promedio <= 100) {  //  acreditado
                escribir = new FileWriter(acreditados, true);
                linea = new PrintWriter(escribir);
                //linea.println("Nombre \tSemestre \tNumero de control \tPromedio");
                //linea.println(fmt.format("%20s %20s %20s %20s",nombre,numeroControl,semestre,promedio));

                /*linea.println(nombre);
                linea.println(numeroControl);
                linea.println(semestre);
                linea.println(promedio);*/

                linea.println(String.format("%20s %20s %20s %20s",nombre,numeroControl,semestre,promedio));

                linea.close();
                escribir.close();
            }

            if (promedio >= 0 && promedio <= 69) {  //  No acreditado
                escribir = new FileWriter(noAcreditados, true);
                linea = new PrintWriter(escribir);
                //linea.println("Nombre \tSemestre \tNumero de control \tPromedio");

                /*linea.println(nombre);
                linea.println(numeroControl);
                linea.println(semestre);
                linea.println(promedio);*/
                linea.println(String.format("%30s %20s %20s %20s",nombre,numeroControl,semestre,promedio));
                //linea.println(fmt.format("%20s %20s %20s %20s",nombre,numeroControl,semestre,promedio));
                //linea.println(String.format("%20s %20s %20s %20s",nombre,numeroControl,semestre,promedio));

                linea.close();
                escribir.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//cierra el metodo

    //  LECTURA DEL ARCHIVO
    public void leerArchivo() {
        String contenido;
        String cadenaCache = "";
        int mostrar;

        mostrar = Integer.parseInt(JOptionPane.showInputDialog("Que desea mostrar? " +
                "\n1.- Acreditados " +
                "\n2.- No acreditados " +
                "\n3 Todos"));

        switch (mostrar) {
            case 1: //  Solo acreditados
                //lectura(acreditados);
                try {
                    FileReader fr = new FileReader("acreditados.txt");
                    BufferedReader br = new BufferedReader(fr);

                    cadena = "";
                    while (cadena != null) {
                        try {
                            cadena = br.readLine();
                            if(cadena != null){
                                System.out.println(cadena);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    br.close();
                    fr.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2: //  Solo no acreditados
                //lectura(noAcreditados);
                try {
                    FileReader fr = new FileReader("noAcreditados.txt");
                    BufferedReader br = new BufferedReader(fr);

                    cadena = "";
                    while (cadena != null) {
                        try {
                            cadena = br.readLine();
                            if(cadena != null){
                                System.out.println(cadena);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    br.close();
                    fr.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Debe elegir una opción dentro del menu.");
                break;
        }
    }//cierra el metodo

    public void lectura(File file) {
        String contenido;
        String cadenaCache = "";
        try {
            FileReader fr = new FileReader(file);
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