package ficherorandom;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicios {
    static final int MAXIMO = 20;
    static File file = null;
    static RandomAccessFile randomAccessFile = null;

    //Ejemplo básico de uso de la clase RandomAccessFile en el que se escriben contenidos en un fichero binario
// para posteriormente sobrescribir algunos accediendo directamente a su posición
    public static void basico1() {
        int int1 = 1;
        int int2 = 2;
        int int3 = 3;
        int int4 = 4;
        long long1 = 1;
        long long2 = 2;
        long long3 = 3;
        long long4 = 4;

        try {
            file = new File("C:\\ficheros\\Prueba.bin");
            randomAccessFile = new RandomAccessFile(file, "rw");
            System.out.println("La longitud del fichero que acabamos de crear es " + randomAccessFile.length());
//vamos a escribir 4 datos enteros (un int ocupa 4 butes) y 4 longs (un long ocupa 8 bytes)
            randomAccessFile.write(int1);
            randomAccessFile.write(int2);
            randomAccessFile.write(int3);
            randomAccessFile.write(int4);
            randomAccessFile.writeLong(long1);
            randomAccessFile.writeLong(long2);
            randomAccessFile.writeLong(long3);
            randomAccessFile.writeLong(long4);
            System.out.println("La longitud del fichero ahora es " + randomAccessFile.length());
//vamos a leer el primer elemento del fichero
            System.out.println(randomAccessFile.read());//!! no es realmente el primer elemento!!
            // ¿cuál es y qué daría?
            //vamos a ver en qué posición está realmente el puntero
            System.out.println("el puntero del fichero está actualmente en " + randomAccessFile.getFilePointer());
            //vamos a posicionarnos al principio
            randomAccessFile.seek(1);
            System.out.println("el puntero del fichero está actualmente en " + randomAccessFile.getFilePointer());
            //vamos ahora a leer el primer dato
            System.out.println("el dato de la posición 1 del fichero es " + randomAccessFile.read());
            //vemos que el principio no es 1 sino 0
            randomAccessFile.seek(0);
            System.out.println("el dato de la posición 0 del fichero es " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            randomAccessFile.seek(4);
            System.out.println("me posiciono en la posicion 4  y leo con tips readLong y pregunto por la " +
                    "posicion del puntero");
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion " + randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion " + randomAccessFile.getFilePointer());


        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero");
        } catch (IOException ioException) {
            System.out.println("error general de entrada salida");
        } catch (Exception Exception) {
            System.out.println("otros errores");
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Exception exception) {
                System.out.println("error en el cierre del fichero");
            }

        }
    }

    /**
     * Crear y gestionar un fichero de acceso aleatorio cuyos registros son objetos de la clase Perro.
     * Esta clase está formada por los siguientes atributos:
     * int id;
     * String nombre;
     * String raza; (usar ENUM)
     * boolean conChapa;
     * String color;
     * int edad;
     * Montar los datos de entrada mediante un Array list
     * Escibir en el fichero el array list, crear un método para acceder a un registro concreto que
     * le digamos por parámetro y por último recorreros de nuevo el fichero para que montar otro arraylist
     * que tiene que ser idéntico al primero
     */
    public static void clasePerro() {

        //Montamos la lista de perros con datos inventados
        List<Perro> listaPerros = new ArrayList<>();

        listaPerros = montarListadoPerros();
        System.out.println(listaPerros);//visualizamos por consola la lista de perros

        //escribimos en el fichero de salida la lista de perros
        RandomAccessFile fichero = grabarFichero(listaPerros);

        //mostramos el registro cuyo orden se lo pasamos por parámetro
        //para probar el método inicializo registro a 2, por ejemplo
        if (fichero != null) {
            int registro = 2;
            Perro perro = leerRegistro(fichero, registro);
            //mostramos el registro leido
            System.out.println(perro);
        }

        //creamos nuevamente la lista de entrada recorriendo el fichero randon recién creado
        //y usando el método anterior
        List<Perro> listaPerros2=new ArrayList<>();
        for (int i = 0; i < listaPerros.size(); i++) {
            listaPerros2.add(leerRegistro(fichero,i));
        }
        System.out.println(listaPerros2);//mostramos la nueva lista que tiene que coincidir con la primera

    }

    /**método para leer del fichero random "fichero" el registro de la posición que se indica.
     * la longitud del registro se encuentra en la variable de clase longred
     * @param fichero
     */
    private static Perro leerRegistro(RandomAccessFile fichero, int registro) {
        Perro perro = null;

        try {
            fichero.seek(registro * (Perro.longReg+2));
            perro = new Perro(fichero.readInt(), fichero.readLine().trim(), fichero.readInt(), fichero.readBoolean(),
                  fichero.readLine().trim(), fichero.readInt());



        } catch (EOFException eofException) {
            System.out.println("se ha llegado al final del fichero");
        } catch (IOException ioException) {
            System.out.println("error de lectura escritura leyendo el fichero perros.bin");
        }
        catch (Exception Exception) {
            System.out.println("error general en perros.bin");
        }

        return perro;
    }

    /**
     * Método por el que volcaremos la lista de perros en un fichero random
     * aseguraremos que cada registro de perro tiene la misma longitud para poder acceder sin problemas
     * posteriormente, para ello haremos uso de la clase StringBuffer
     *
     * @param listaPerros
     * @return los atributos de la clase perro son los siguientes
     * int id;
     * String nombre; fijamos la longitud a 20
     * entero raza;
     * boolean conChapa;
     * String color;fijamos la longitud a 20
     * int edad;
     * la longitud del objeto perro es de 53 más 2 porque tanto al nombre como al color vamos a meterle
     * un salto de página para poder leerlo luego con un readLine().
     */
    private static RandomAccessFile grabarFichero(List<Perro> listaPerros) {
        RandomAccessFile fichero = null;
        String cadena="";

        try {
            fichero = new RandomAccessFile("perros.bin", "rw");
            fichero.seek(0);
            for (int i = 0; i < listaPerros.size(); i++) {
                fichero.writeInt(listaPerros.get(i).getId());
                cadena=setea (listaPerros.get(i).getNombre());//fijamos la longitud a 20 con el método setea
                fichero.writeBytes(cadena + '\n');
                fichero.writeInt(listaPerros.get(i).getRaza());
                fichero.writeBoolean(listaPerros.get(i).isConChapa());
                cadena=setea (listaPerros.get(i).getColor());//fijamos la longitud a 20 con el método setea
                fichero.writeBytes(cadena + '\n');
                fichero.writeInt(listaPerros.get(i).getEdad());
            }
        } catch (IOException ioException) {
            fichero = null;
            System.out.println("Error de entrada salida en el fichero perros bin");
        } catch (Exception exception) {
            fichero = null;
            System.out.println("Error de entrada salida en el fichero perros bin");
        }

        return fichero;
    }

    /**
     * Método para fijar la longitud de los string a una longitud máxima de 20
     * @param cadena con una longitud de 20=MAXIMO
     * @return
     */
    private static String setea(String cadena) {
        StringBuffer stringBuffer=new StringBuffer(cadena);
        stringBuffer.setLength(MAXIMO);
        return stringBuffer.toString();
    }

    /**
     * nos inventamos los atribitos para el constructor perro
     * para el enum de la raza, grabamos el ordinal que es un entero para así poder acotar el tamaño del
     * registro, puesto que el ordinal() devuelve un entero
     * @return un ArrayList de perros
     */
    private static List<Perro> montarListadoPerros() {
        ArrayList<Perro> lista = new ArrayList<>();
        lista.add(new Perro(24, "Piqua", RAZA.PEKINÉS.ordinal(), true, "blanco", 12));
        lista.add(new Perro(25, "Piqui", RAZA.BOXER.ordinal(), false, "negro", 1));
        lista.add(new Perro(26, "Pique", RAZA.CHIGUAGUA.ordinal(), true, "gris", 2));
        lista.add(new Perro(27, "Piquo", RAZA.MARILÍ.ordinal(), false, "canela", 10));
        lista.add(new Perro(28, "Piquu", RAZA.PASTOR_ALEMÁN.ordinal(), true, "rojo", 8));
        lista.add(new Perro(29, "Pisqui", RAZA.PEKINÉS.ordinal(), false, "azul", 4));
        return lista;

    }
}

