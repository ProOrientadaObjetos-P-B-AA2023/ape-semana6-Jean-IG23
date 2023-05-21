package Problema2;

import java.util.Random;
import java.util.Scanner;

public class Problema2 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Random random= new Random();

        Materia materia[]= new Materia[100];
        Estudiante estudiante= new Estudiante();

        boolean in=true;
        int i=0;
        while (in){
            System.out.println("Ingrese 1 para agregar una materia");
            System.out.println("Ingrese 2 para mostrar la informacion");
            System.out.println("Ingrese 3 para salir");
            int opc= entrada.nextInt();

            if(opc==1){
                double num1=random.nextDouble(0,3.5);
                double num2=random.nextDouble(0,3.5);
                double num3=random.nextDouble(0,3);
                System.out.println("INGRESE: MATERIA");
                materia[i]=new Materia(entrada.next(),num1,num2,num3);
                estudiante= new Estudiante("Iam",20,materia[i]);
                i++;
            }else if (opc==2){
                for (int j = 0; j < i; j++) {
                    System.out.println(estudiante);
                    materia[j].calcularNotaTotal();
                    materia[j].calcularEstado();
                    double recuperacion= random.nextDouble(0,3.5);
                    materia[j].setRecuperacion(materia[j].getEstado().equals("REPROBADO")  ?  recuperacion  :  0);
                    if (materia[j].getEstado().equals("REPROBADO")){
                        materia[j].calcularRecuperacion();
                    }
                    materia[j].calcularEstado();
                    System.out.println(materia[j]);

                }
                System.out.println("\n");
            }else if(opc==3){
                in=false;
            }
        }
    }
}
class Estudiante{
    private String nombreEst;
    private int edadEst;
    private Materia materia;
    public Estudiante(){}
    public Estudiante(String nombreEst, int edadEst, Materia materia) {
        this.nombreEst = nombreEst;
        this.edadEst = edadEst;
        this.materia = materia;
    }
    public Materia getMateria() {
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

class Materia{
    private double notaACD;
    private double notaAPE;
    private double notaAA;
    private double recuperacion;
    private double notaTotal;
    private String estado;
    private String nombreMateria;

    public Materia(String nombreMateria, double notaACD, double notaAPE, double notaAA) {
        this.notaACD = notaACD;
        this.notaAPE = notaAPE;
        this.notaAA = notaAA;
        this.nombreMateria=nombreMateria;
    }
    public void calcularNotaTotal(){
        this.notaTotal=this.notaACD+this.notaAPE+this.notaAA;
    }

    public String calcularEstado(){
        this.estado = this.notaTotal >=7 ? "APROBADO": "REPROBADO";
        return this.estado;
    }
    public void calcularRecuperacion(){
        this.notaTotal=(this.recuperacion+(this.notaTotal*0.65));
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
                ", nombreMateria='" + nombreMateria + '\'' +
                '}';
    }
}
