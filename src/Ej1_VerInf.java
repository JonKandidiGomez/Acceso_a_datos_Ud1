import java.io.File;

public class Ej1_VerInf {
    public static void main(String[] args) {
        if (args.length > 0) {
            File f = new File(args[0]);
            if (!f.exists()) {
                System.out.println("Nombre: " + f.getName() +
                        "\nRuta: " + f.getPath() +
                        "\nRuta absoluta: " + f.getAbsolutePath() +
                        "\nTamaño: " + f.length() +
                        "\nPermiso de lectura: " + f.canRead() +
                        "\nPermiso de escritura: " + f.canWrite() +
                        "\nEs un directorio: " + f.isDirectory() +
                        "\nEs un fichero: " + f.isFile());
            } else {
                System.out.println("El fichero no existe");
            }
        } else {
            System.out.println("No se han pasado parametros");
        }
    }
}
