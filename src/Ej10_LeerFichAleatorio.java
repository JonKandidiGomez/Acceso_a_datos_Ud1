import java.io.*;

public class Ej10_LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        final int TAM_REGISTRO = 36;
        File emp = new File("empleados.dat");
        RandomAccessFile file = new RandomAccessFile(emp, "r");
        long pos = 0;

        while (pos < file.length()) {
            file.seek(pos);

            int id = file.readInt();

            StringBuilder apellidoBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                char c = file.readChar();
                apellidoBuilder.append(c);
            }
            String apellido = apellidoBuilder.toString().trim();
            int departamento = file.readInt();
            double salario = file.readDouble();
            System.out.printf("ID: %d | Apellido: %-10s | Departamento: %d | Salario: %.2f%n",
                    id, apellido, departamento, salario);

            pos += TAM_REGISTRO;
        }
        file.close();
    }
}
