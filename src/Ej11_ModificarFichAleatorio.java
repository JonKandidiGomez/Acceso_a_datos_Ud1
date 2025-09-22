import java.io.*;

public class Ej11_ModificarFichAleatorio {
    static void main() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int TAM_REGISTRO = 36;
        final int TAM_ID = 4;
        long pos = 0;
        int nuevoID = 0;

        File empleados = new File("empleados.dat");
        try(RandomAccessFile rafEmple = new RandomAccessFile(empleados, "rw");) {

            System.out.println("Introduce el apellido del empleado:");
            String apellido = br.readLine();
            System.out.println("Introduce el dept. del empleado:");
            int dept = Integer.parseInt(br.readLine());
            System.out.println("Introduce el salario del empleado:");
            double salario = Double.parseDouble(br.readLine());

            while (pos < rafEmple.length()) {
                rafEmple.seek(pos);

                int id = rafEmple.readInt();
                nuevoID = id + 1;
                if (id == -1) {
                    pos = rafEmple.getFilePointer() - TAM_ID;
                    break;
                }
                pos += TAM_REGISTRO - TAM_ID;
            }

            rafEmple.seek(pos);
            rafEmple.write(nuevoID);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
