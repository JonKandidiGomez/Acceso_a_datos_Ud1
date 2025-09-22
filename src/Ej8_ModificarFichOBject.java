import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej8_ModificarFichOBject {
    public static void main(String[] args) throws IOException {

        File pers = new File("FichModPersona.dat");
        FileInputStream fis = new FileInputStream(pers);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Persona> lista = new ArrayList<>();
        while (true) {
            try {
                Persona p = (Persona) ois.readObject();
                lista.add(p);
            } catch (EOFException e) {
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        ois.close();

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero del persona: ");
        int n = sc.nextInt() -1;

        String sl = sc.nextLine();
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce la edad: ");
        int edad = sc.nextInt();

        FileOutputStream fos = new FileOutputStream(pers);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            lista.get(n).setNombre(nombre);
            lista.get(n).setEdad(edad);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe la persona");
        }

        for (Persona persona : lista) {
            oos.writeObject(persona);
        }
        oos.close();
    }
}
