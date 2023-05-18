package com.utpl.sistemas.solucionparcialpoo.b;

import java.util.Scanner;

public class TestEstudiante {

    public static void main(String[] args) {

        Materia materia1= new Materia(3.5,0,0);
        Materia materia2= new Materia(3.5,3,3.5);
        Materia materia3= new Materia(3.5,3,0);
        Materia materias[]= {materia1,materia2,materia3};

        Estudiante estudiante= new Estudiante("Iam",20,materias);

        System.out.println(estudiante);
        for (Materia materiaAux: materias) {
            materiaAux.calcularNotaTotal();
            materiaAux.calcularEstado();
            materiaAux.setRecuperacion(materiaAux.getEstado().equals("REPROBADO")  ?  3  :  0);
            if (materiaAux.getEstado().equals("REPROBADO")){
                materiaAux.calcularRecuperacion();
            }
            materiaAux.calcularEstado();
            System.out.println(materiaAux);
        }

        for (Materia ma:materias ) {
            System.out.println(ma);
        }
    }
}
class Estudiante{
    private String nombreEst;
    private int edadEst;
    private Materia materia[];


    public Estudiante(String nombreEst, int edadEst, Materia materia[]) {
        this.nombreEst = nombreEst;
        this.edadEst = edadEst;
        this.materia = materia;
    }



    public Materia[] getMateria() {
        return materia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombreEst='" + nombreEst + '\'' +
                ", edadEst=" + edadEst +
                '}';
    }
}

class Materia {
    private double notaACD;
    private double notaAPE;
    private double notaAA;
    private double recuperacion;
    private double notaTotal;
    private String estado;

    public Materia(double notaACD, double notaAPE, double notaAA) {
        this.notaACD = notaACD;
        this.notaAPE = notaAPE;
        this.notaAA = notaAA;
    }

    public void calcularNotaTotal() {
        this.notaTotal = this.notaACD + this.notaAPE + this.notaAA;
    }

    public String calcularEstado() {
        this.estado = this.notaTotal >= 7 ? "APROBADO" : "REPROBADO";
        return this.estado;
    }

    public void calcularRecuperacion() {
        this.notaTotal = (this.recuperacion + (this.notaTotal * 0.65));
    }

    public double getNotaTotal() {
        return notaTotal;
    }

    public double getRecuperacion() {
        return recuperacion;
    }

    public void setNotaTotal(double notaTotal) {
        this.notaTotal = notaTotal;
    }

    public void setRecuperacion(double recuperacion) {
        this.recuperacion = recuperacion;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "notaACD=" + notaACD +
                ", notaAPE=" + notaAPE +
                ", notaAA=" + notaAA +
                ", recuperacion=" + recuperacion +
                ", notaTotal=" + notaTotal +
                ", estado='" + estado + '\'' +
                '}';
    }
}