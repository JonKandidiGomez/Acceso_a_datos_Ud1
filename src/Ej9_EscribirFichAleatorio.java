import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej9_EscribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        // Arrays de ejemplo
        String[] apellidos = {"Garcia", "Lopez", "Martinez", "Sanchez", "Perez"};
        int[] departamentos = {10, 20, 10, 30, 20};
        double[] salarios = {1500.50, 2000.75, 1800.60, 2200.90, 1700.30};

        // Nombre del fichero
        String fileName = "empleados.dat";

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");

        for (int i = 0; i < apellidos.length; i++) {
            int id = i + 1; // ID empieza en 1

            // Escribir ID (4 bytes)
            file.writeInt(id);

            // Escribir apellido (10 caracteres = 20 bytes en UTF-16)
            String apellido = apellidos[i];
            if (apellido.length() > 10) {
                apellido = apellido.substring(0, 10);
            }
            // Rellenar con espacios si es menor de 10
            StringBuilder sb = new StringBuilder(apellido);
            while (sb.length() < 10) {
                sb.append(' ');
            }
            file.writeChars(sb.toString()); // 2 bytes por char

            // Escribir departamento (4 bytes)
            file.writeInt(departamentos[i]);

            // Escribir salario (8 bytes)
            file.writeDouble(salarios[i]);
        }

        System.out.println("Datos escritos correctamente en " + fileName);


    }
}
