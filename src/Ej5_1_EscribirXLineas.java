import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ej5_1_EscribirXLineas {
    public static void main(String[] args) {

        int i = Integer.parseInt(args[0]);
        File f = new File("EscribirLineas.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for(int j = 1; j < i + 1; j++){
                bw.write("Fila número " + j);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
