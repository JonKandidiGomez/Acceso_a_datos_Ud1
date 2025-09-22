import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej6_EscribirFichData {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FichData.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);
        String[] nombres = {"Ana","Luis, Miguel","Alicia","Pedro","Manuel","Andrés",
                "Julio","Antonio","María Jesús"};
        int[] edades = {14,15,13,15,16,12,16,14,13};
        for (int i=0;i<edades.length; i++){
            dataOS.writeUTF(nombres[i]); //inserta nombre
            dataOS.writeInt(edades[i]); //inserta edad
        }
        dataOS.close(); //cerrar stream
    }
}
