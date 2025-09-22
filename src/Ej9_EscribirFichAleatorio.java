import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej9_EscribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        String[] apellidos = {"Garcia", "Lopez", "Martinez", "Sanchez", "Perez"};
        int[] departamentos = {10, 20, 10, 30, 20};
        double[] salarios = {1500.50, 2000.75, 1800.60, 2200.90, 1700.30};

        RandomAccessFile file = new RandomAccessFile("empleados.dat", "rw");

        for (int i = 0; i < 5; i++) {
            int id = i + 1;
            file.writeInt(id);

            String apellido = apellidos[i];
            if (apellido.length() > 10) {
                apellido = apellido.substring(0, 10);
            }
            StringBuilder sb = new StringBuilder(apellido);
            while (sb.length() < 10) {
                sb.append(' ');
            }
            file.writeChars(sb.toString()); // 2 bytes por char
            file.writeInt(departamentos[i]);
            file.writeDouble(salarios[i]);
        }
        file.close();
    }
}