import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ej6_LeerFichData {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FichData.dat");
        FileInputStream fis = new FileInputStream(fichero);
        DataInputStream entrada = new DataInputStream(fis);

        while(entrada.available() > 0) {
            String nombre = entrada.readUTF();
            int edad = entrada.readInt();
            System.out.println("Nombre: " + nombre +  " Edad: " + edad);
        }
        entrada.close();
    }
}
