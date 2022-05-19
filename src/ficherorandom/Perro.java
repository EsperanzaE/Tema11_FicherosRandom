package ficherorandom;

import java.io.Serializable;

public class Perro implements Serializable {


    private int id;
    private String nombre;
    private int raza;
    private boolean conChapa;
    private String color;
    private int edad;
    static int longReg=53;

    /**
     * la longitud del constructor es de 97 más los dos saltos de página que meteremos a los string
     *
     * @param id:       ocupa 4
     * @param nombre:   ocupa 20
     * @param raza:     ocupa 4
     * @param conChapa: ocupa 4
     * @param color:    ocupa 20
     * @param edad:     ocupa 1
     *                  Total:53+2(de los saltos de línea)
     */
    public Perro(int id, String nombre, int raza, boolean conChapa, String color, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.conChapa = conChapa;
        this.color = color;
        this.edad = edad;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean isConChapa() {
        return conChapa;
    }

    public void setConChapa(boolean conChapa) {
        this.conChapa = conChapa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", raza=" + RAZA.values()[raza] +
                ", conChapa=" + conChapa +
                ", color='" + color + '\'' +
                ", edad=" + edad +
                '}'+"\n";
    }
}


