import javax.swing.*;
import java.io.*;

public class ArchivoTexto {

    FileWriter escribir;
    PrintWriter linea;

    FileReader fr;
    BufferedReader br;

    private String nombre = "", cadena;
    private int numeroControl, semestre;
    private String promedio;
    File acreditados, noAcreditados;

    public void altas() {

        acreditados = new File("acreditados.txt");
        noAcreditados = new File("noAcreditados.txt");

        if (!acreditados.exists() && !noAcreditados.exists()) { //  Si no existe...
            if(!acreditados.exists() || !noAcreditados.exists()) {
                try {
                    acreditados.createNewFile();
                    noAcreditados.createNewFile();

                    formulario();
                    seleccionarArchivo();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            } else {
                try {
                    formulario();
                    seleccionarArchivo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                acreditados.createNewFile();
                noAcreditados.createNewFile();

                formulario();
                seleccionarArchivo();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else { // Si ya existe...
            try {
                formulario();
                seleccionarArchivo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//cierra el metodo

    public void formulario() {
        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: "
                , "Solicitando datos", JOptionPane.QUESTION_MESSAGE);
        numeroControl = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingresa el numero de control: ", "Solicitando datos", 3));
        semestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el semestre: "
                , "Solicitando datos", JOptionPane.QUESTION_MESSAGE));
       /* promedio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                , "Solicitando datos", JOptionPane.QUESTION_MESSAGE));*/

        promedio = JOptionPane.showInputDialog(null, "Ingresa el promedio: "
                , "Solicitando datos", JOptionPane.QUESTION_MESSAGE);
    }//cierra el metodo

    public void seleccionarArchivo() {
        try {
            if (Integer.parseInt(promedio) >= 70 && Integer.parseInt(promedio) <= 100) {  //  acreditado
                escribir = new FileWriter(acreditados, true);
                linea = new PrintWriter(escribir);

                linea.println(String.format("%20s %20s %20s %20s", nombre+" |", numeroControl+" |", semestre+" |", promedio+" |"));

                linea.close();
                escribir.close();
            }

            if (Integer.parseInt(promedio) >= 0 && Integer.parseInt(promedio) <= 69) {  //  No acreditado
                escribir = new FileWriter(noAcreditados, true);
                linea = new PrintWriter(escribir);
                linea.println(String.format("%20s %20s %20s %20s", nombre+" |", numeroControl+" |", semestre+" |", promedio+" |"));

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
                "\n3.- Todos"));

        switch (mostrar) {
            case 1: //  Solo acreditados
                System.out.println("\nALUMNOS ACREDITADOS");
                System.out.println("***********************************************************************************");
                System.out.println(String.format("%20s %20s %20s %20s", "Nombre |", "Numero de control |", "Semestre |", "Promedio |"));
                System.out.println("***********************************************************************************");
                lectura("acreditados.txt");
                break;
            case 2: //  Solo no acreditados
                System.out.println("\nALUMNOS NO ACREDITADOS");
                System.out.println("***********************************************************************************");
                System.out.println(String.format("%20s %20s %20s %20s", "Nombre |", "Numero de control |", "Semestre |", "Promedio |"));
                System.out.println("***********************************************************************************");
                lectura("noAcreditados.txt");
                break;
            case 3: //  Todos
                lecturaTodo("acreditados.txt", "noAcreditados.txt");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Debe elegir una opci??n dentro del menu.");
                break;
        }
    }//cierra el metodo

    public void lectura(String file) {
        String contenido;
        String cadenaCache = "";

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            cadena = "";
            while (cadena != null) {
                try {
                    cadena = br.readLine();
                    if (cadena != null) {
                        System.out.println(cadena);
                        System.out.println("-----------------------------------------------------------------------------------");
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
    }//cierra el metodo

    public void lecturaTodo(String fileAcreditados, String fileNoAcreditados){
        //  Acreditados
        System.out.println("\nALUMNOS ACREDITADOS");
        System.out.println("***********************************************************************************");
        System.out.println(String.format("%20s %20s %20s %20s", "Nombre |", "Numero de control |", "Semestre |", "Promedio |"));
        System.out.println("***********************************************************************************");
        try {
            fr = new FileReader(fileAcreditados);
            br = new BufferedReader(fr);

            cadena = "";
            while (cadena != null) {
                try {
                    cadena = br.readLine();
                    if (cadena != null) {
                        System.out.println(cadena);
                        System.out.println("-----------------------------------------------------------------------------------");
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

        System.out.println("\nALUMNOS NO ACREDITADOS");
        System.out.println("***********************************************************************************");
        System.out.println(String.format("%20s %20s %20s %20s", "Nombre |", "Numero de control |", "Semestre |", "Promedio |"));
        System.out.println("***********************************************************************************");
        try {
            fr = new FileReader(fileNoAcreditados);
            br = new BufferedReader(fr);

            cadena = "";
            while (cadena != null) {
                try {
                    cadena = br.readLine();
                    if (cadena != null) {
                        System.out.println(cadena);
                        System.out.println("-----------------------------------------------------------------------------------");
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
    }//cierra el metodo

    public void buscar(int buscar){
        String nombre_buscar;
        String numCtrl_buscar;
        boolean encontrado = false;

        if(buscar == 1){
            nombre_buscar = JOptionPane.showInputDialog("Ingrese el nombre: ");
            //  ACREDITADOS
            try {
                fr = new FileReader("acreditados.txt");
                br = new BufferedReader(fr);

                cadena = "";
                while ((cadena = br.readLine()) != null) {
                    if(cadena.indexOf(nombre_buscar) != -1){
                        System.out.println("Se encontro el registro en el archivo de Acreditados: "+cadena);
                        encontrado = true;
                        //double nuevo = Double.parseDouble(JOptionPane.showInputDialog("Dijite el nuevo promedio: "));
                        String nuevo = JOptionPane.showInputDialog("Dijite el nuevo promedio: ");
                        //String nuevoString = String.valueOf(nuevo);

                        modificar(nuevo);
                        //modificar(nuevo);
                    }
                }
                if(encontrado == false){
                    System.out.println("El registro no existe en el archivo de Acreditados.");
                }
                br.close();
                fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            //  NO ACREDITADOS
            try {
                fr = new FileReader("noAcreditados.txt");
                br = new BufferedReader(fr);

                cadena = "";
                while ((cadena = br.readLine()) != null) {
                    if(cadena.indexOf(nombre_buscar) != -1){
                        System.out.println("Se encontro el registro en el archivo de No acreditados: "+cadena);
                        encontrado = true;
                    }
                }
                if(encontrado == false){
                    System.out.println("El registro no existe en el archivo de No acreditados.");
                }
                br.close();
                fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(buscar == 2){
            numCtrl_buscar = JOptionPane.showInputDialog("Ingrese el numero de control: ");
            //  ACREDITADOS
            try {
                fr = new FileReader("acreditados.txt");
                br = new BufferedReader(fr);

                cadena = "";
                while ((cadena = br.readLine()) != null) {
                    if(cadena.indexOf(numCtrl_buscar) != -1){
                        System.out.println("Se encontro el registro en el archivo de Acreditados: "+cadena);
                        encontrado = true;
                    }
                }
                if(encontrado == false){
                    System.out.println("El registro no existe en el archivo de Acreditados.");
                }
                br.close();
                fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            //  NO ACREDITADOS
            try {
                fr = new FileReader("noAcreditados.txt");
                br = new BufferedReader(fr);

                cadena = "";
                while ((cadena = br.readLine()) != null) {
                    if(cadena.indexOf(numCtrl_buscar) != -1){
                        System.out.println("Se encontro el registro en el archivo de No acreditados: "+cadena);
                        encontrado = true;
                    }
                }
                if(encontrado == false){
                    System.out.println("El registro no existe en el archivo de No acreditados.");
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valor no encontrado.");
        }
    }//cierra el metodo

    public void modificar(String nuevo) {
        //String line;
        //String vieja = promedio;
        String input = "";

        try {
            // input the (modified) file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("acreditados.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                System.out.println(line.replace(promedio, nuevo));// replace the line here

                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("acreditados.txt");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
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


/*try {
                    fr = new FileReader(acreditados);
                    br = new BufferedReader(fr);

                    cadena = "";
                    while (cadena != null) {
                        try {
                            cadena = br.readLine();
                            if (cadena != null) {
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
                }*/