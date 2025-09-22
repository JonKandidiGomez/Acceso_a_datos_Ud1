import java.io.File;
import java.io.IOException;

public class Ej2_CrearDir {
    public static void main(String[] args) {
        File dir= new File("NuevoDirectorio");
        if (dir.mkdir()){
            System.out.println("Directorio Creado");
            verFichero(dir);
        }
        File f1 = new File(dir,"fichero1");
        File f2 = new File(dir,"fichero2");
        try {
            if (f1.createNewFile()) {
                System.out.println("Fichero guardado correctamente");
                verFichero(f1);
            }
            if (f2.createNewFile()) {
                System.out.println("Fichero guardado correctamente");
                verFichero(f2);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero");
        }
        if (f1.delete()) {
            System.out.println(f1.getName() + " borrado correctamente");
        }

        if (f2.delete()) {
            System.out.println(f2.getName() + " borrado correctamente");
        }

        if (dir.delete()) {
            System.out.println(dir.getName() + " borrado correctamente");
        }
    }

    private static void verFichero(File fichero) {
        if (fichero.exists()) {
            System.out.println("Nombre: " + fichero.getName() +
                    "\nRuta: " + fichero.getPath() +
                    "\nRuta absoluta: " + fichero.getAbsolutePath() +
                    "\nTamaño: " + fichero.length() +
                    "\nPermiso de lectura: " + fichero.canRead() +
                    "\nPermiso de escritura: " + fichero.canWrite() +
                    "\nEs un directorio: " + fichero.isDirectory() +
                    "\nEs un fichero: " + fichero.isFile());
        } else {
            System.out.println("El fichero no existe");
        }
    }
    }

