import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej3_1_LeerFichTexto2 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("lectura.txt");

        if (f1.exists() && f1.isFile()) {
            FileReader fr = new FileReader(f1);
            char[] buffer = new char[20];
            int i;
            while((i = fr.read(buffer)) != -1) {
                if (i == 20){
                    System.out.print(buffer);
                } else {
                    for (int j = 0; j < i; j++) {
                        System.out.print(buffer[j]);
                    }
                }
            }
            fr.close();
        } else {
            System.out.println("El fichero no se puede leer");
        }
    }
}
