package com.example.demo.controller;

import java.util.List;

public class Persona {
    private Corazon corazon;

    private List<Ropa> ropaList;

    public Persona() {
        this.corazon = new Corazon();
    } //Agregacion || Composicion

    public void addRopa(Ropa ropa) {
        ropaList.add(ropa);
    }

    public void algo() {
        Trabajo recursoConfiable = new Trabajo();
        //Arreglo el test
        recursoConfiable.trabajarMasDuro();
    }
}
