import java.io.*;

public class Ej10_LeerFichAleatorio {
    public static void main(String[] args) {
        String fileName = "empleados.dat";
        final int RECORD_SIZE = 36; // tamaño fijo del registro

        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            long fileLength = file.length();
            long pos = 0;

            while (pos < fileLength) {
                file.seek(pos); // Posicionarse en el inicio del registro

                // Leer ID
                int id = file.readInt();

                // Leer apellido (10 caracteres = 20 bytes)
                StringBuilder apellidoBuilder = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    char c = file.readChar(); // 2 bytes por carácter
                    apellidoBuilder.append(c);
                }
                String apellido = apellidoBuilder.toString().trim();

                // Leer departamento
                int departamento = file.readInt();

                // Leer salario
                double salario = file.readDouble();

                // Mostrar datos
                System.out.printf("ID: %d | Apellido: %-10s | Departamento: %d | Salario: %.2f%n",
                        id, apellido, departamento, salario);

                pos += RECORD_SIZE; // Avanzar al siguiente registro
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
