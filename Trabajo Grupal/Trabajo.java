import java.util.Scanner;
import java.util.Scanner;
public class Trabajo {

    static class Estudiante {
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
            return "Estudiante{" + "nombreEst=" + nombreEst + ", edadEst=" + edadEst + '}';
        }
    }

    static class Materia {
        private String nombreMat;
        private double notaACD;
        private double notaAPE;
        private double notaAA;
        private double recuperacion;
        private double notaTotal;
        private String estado;

        public Materia(String nombreMat, double notaACD, double notaAPE, double notaAA) {
            this.nombreMat = nombreMat;
            this.notaACD = notaACD;
            this.notaAPE = notaAPE;
            this.notaAA = notaAA;
        }

        public void carcularNotaTotal() {
            this.notaTotal = this.notaACD + this.notaAPE + this.notaAA;
        }

        public String calcularEstado() {
            this.estado = this.notaTotal >= 7 ? "APROBADO" : "REPROBADO";
            return this.estado;
        }

        public void calcularRecuperacion() {
            this.notaTotal = this.recuperacion + this.notaTotal * 0.65;
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
            return "Materia{" + "nombreMat=" + nombreMat + ", notaACD=" + notaACD + ", notaAPE=" + notaAPE + ", notaAA=" + notaAA + ", recuperacion=" + recuperacion + ", notaTotal=" + notaTotal + ", estado=" + estado + '}';
        }
    }

    public static class SolucionParcial {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("CUANTAS MATERIAS TIENES: ");
            int num = sc.nextInt();

            Materia materias[] = new Materia[num];
            for (int i = 0; i < num; i++) {
                System.out.println("Ingrese el nombre de la materia " + (i + 1) + ": ");
                String nombre = sc.next();
                System.out.println("Ingrese la nota ACD para la materia " + (i + 1) + ": ");
                double notaACD = sc.nextDouble();
                System.out.println("Ingrese la nota APE para la materia " + (i + 1) + ": ");
                double notaAPE = sc.nextDouble();
                System.out.println("Ingrese la nota AA para la materia " + (i + 1) + ": ");
                double notaAA = sc.nextDouble();
                materias[i] = new Materia(nombre, notaACD, notaAPE, notaAA);
            }

            Estudiante est1 = new Estudiante("David", 20, materias);
            System.out.println(est1);

            for (Materia materiaAux : materias) {
                materiaAux.carcularNotaTotal();
                materiaAux.calcularEstado();
                materiaAux.setRecuperacion(materiaAux.getEstado().equals("REPROBADO") ? 3 : 0);
                if (materiaAux.getEstado().equals("REPROBADO")) {
                    materiaAux.calcularRecuperacion();
                    materiaAux.calcularEstado();
                }
                System.out.println(materiaAux);
            }
        }
    }
}
