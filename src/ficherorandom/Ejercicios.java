package ficherorandom;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicios {
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
            System.out.println("La longitud del fichero que acabamos de crear es "+ randomAccessFile.length());
//vamos a escribir 4 datos enteros (un int ocupa 4 butes) y 4 longs (un long ocupa 8 bytes)
            randomAccessFile.write(int1);
            randomAccessFile.write(int2);
            randomAccessFile.write(int3);
            randomAccessFile.write(int4);
            randomAccessFile.writeLong(long1);
            randomAccessFile.writeLong(long2);
            randomAccessFile.writeLong(long3);
            randomAccessFile.writeLong(long4);
            System.out.println("La longitud del fichero ahora es "+ randomAccessFile.length());
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
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.read());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            randomAccessFile.seek(4);
            System.out.println("me posiciono en la posicion 4  y leo con tips readLong y pregunto por la " +
                    "posicion del puntero");
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());
            System.out.println("Qué nos dará la siguiente lectura? " + randomAccessFile.readLong());
            System.out.println("posicion "+ randomAccessFile.getFilePointer());



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
}

