package Problema1;

import java.util.Arrays;
import java.util.Scanner;

public class Problema1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el nombre del hospital");
        String nombreH= sc.next();
        System.out.println("INGRESE: NombreCiudad, Provincia");
        Ciudad ciudad= new Ciudad(sc.next(),sc.next());
        System.out.println("Ingrese la direccion del hospital");
        String direccion= sc.next();
        System.out.println("Ingrese numero de especialidades");
        int nEsp= sc.nextInt();
        double sueldoTotal=0;
        System.out.println("Ingrese el numero de medicos");
        int nMedicos=sc.nextInt();
        Medico medico[]= new Medico[nMedicos];
        int c1=1;
        for (int i = 0; i < nMedicos; i++) {
            System.out.println("INGRESE: Nombre, Especialidad, Sueldo "+c1);
            medico[i]= new Medico(sc.next(),sc.next(),sc.nextDouble());
            sueldoTotal+=medico[i].getSueldoMensual();
            c1++;
        }
        System.out.println("Ingrese numero enfermer@s");
        int nEnf= sc.nextInt();
        Enfemero enfemero[]= new Enfemero[nEnf];
        int c=1;
        for (int i = 0; i < nEnf; i++) {
            System.out.println("INGRESE: Nombre, Nombramiento(nombramiento / contrato), Sueldo "+c);
            enfemero[i]=new Enfemero(sc.next(),sc.next(),sc.nextDouble());
            System.out.println();
            sueldoTotal+=enfemero[i].getSueldoMensual();
            c++;
        }
        Hospital hospital= new Hospital(ciudad,enfemero,medico,direccion,nEsp,sueldoTotal,nombreH);
        System.out.println(hospital);
    }
}
class Ciudad{
    private String nombreCiudad;
    private String provincia;

    public Ciudad(String nombreCiudad, String provincia) {
        this.nombreCiudad = nombreCiudad;
        this.provincia = provincia;
    }
    public String getNombreCiudad() {
        return nombreCiudad;
    }
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString(){
        return String.format("Ciudad: %s\n"+
                "Provincia: %s\n",this.getNombreCiudad(),this.getProvincia());
    }
}
class Medico{
    private String nombreDoctor;
    private String especialidad;
    private double sueldoMensual;
    public Medico(String nombreDoctor, String especialidad, double sueldoMensual) {
        this.nombreDoctor = nombreDoctor;
        this.especialidad = especialidad;
        this.sueldoMensual = sueldoMensual;
    }
    public String getNombreDoctor() {
        return nombreDoctor;
    }
    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public double getSueldoMensual() {
        return sueldoMensual;
    }
    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
    @Override
    public String toString() {
        return String.format("Nombre Medico: %s\n"+
                "Especialidad: %s\n"+
                "Sueldo: %.2f\n",this.getNombreDoctor(),this.getEspecialidad(),this.getSueldoMensual());
    }
}
class Enfemero{
    public Enfemero(String nombre, String tipoNC, double sueldoMensual) {
        this.nombre = nombre;
        this.tipoNC = tipoNC;
        this.sueldoMensual = sueldoMensual;
    }
    private String nombre;
    private String tipoNC;
    private double sueldoMensual;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoNC() {
        return tipoNC;
    }
    public void setTipoNC(String tipoNC) {
        this.tipoNC = tipoNC;
    }
    public double getSueldoMensual() {
        return sueldoMensual;
    }
    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
    @Override
    public String toString() {
        return String.format("Nombre Enfermero: %s\n"+
                "Especialidad: %s\n"+
                "Sueldo: %.2f\n",this.getNombre(),this.getTipoNC(),this.getSueldoMensual());
    }
}
class Hospital{
    private Ciudad ciudad;
    private Enfemero[] enfemero;
    private Medico[] medico;
    private String direccion;
    private int nEspecialidad;
    private double sueldoTotal;
    private String nombreHospital;

    public Hospital(Ciudad ciudad, Enfemero[] enfemero, Medico[] medico, String direccion, int nEspecialidad,double sueldoTotal,String nombreHopsital) {
        this.ciudad = ciudad;
        this.enfemero = enfemero;
        this.medico = medico;
        this.direccion = direccion;
        this.nEspecialidad = nEspecialidad;
        this.sueldoTotal= sueldoTotal;
        this.nombreHospital= nombreHopsital;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Enfemero[] getEnfemero() {
        return enfemero;
    }

    public void setEnfemero(Enfemero[] enfemero) {
        this.enfemero = enfemero;
    }

    public Medico[] getMedico() {
        return medico;
    }

    public void setMedico(Medico[] medico) {
        this.medico = medico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getnEspecialidad() {
        return nEspecialidad;
    }

    public void setnEspecialidad(int nEspecialidad) {
        this.nEspecialidad = nEspecialidad;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    @Override
    public String toString() {
        return String.format("Hospital: %s\n"+
                "Ciudad: %s\n"+
                "Direccion: %s\n"+
                "Numero Especialidades: %d\n"+
                "Lista Medic@s: %s\n"+
                "Lista Enfermer@s: %s\n"+
                "Sueldo Total: %.2f\n",getNombreHospital(),getCiudad(),getDireccion(),getnEspecialidad(),Arrays.toString(medico),Arrays.toString(enfemero),getSueldoTotal());
    }
}
