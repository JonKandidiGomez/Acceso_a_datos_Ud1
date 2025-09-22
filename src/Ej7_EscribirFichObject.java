import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ej7_EscribirFichObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Persona p1 = new Persona("Maria", 12);
        Persona p2 = new Persona("José", 13);
        Persona p3 = new Persona("Jesus", 21);
        Persona p4 = new Persona("Raul", 12);
        Persona p5 = new Persona("Carlos", 13);
        Persona p6 = new Persona("Ana", 21);
        Persona[] personas1 = new Persona[]{p1, p2, p3, p4, p5, p6};
        File pers = new File("FichPersona.dat");
        FileOutputStream fos = new FileOutputStream(pers);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Persona persona : personas1) {
            oos.writeObject(persona);
        }
        oos.close();
    }
}
