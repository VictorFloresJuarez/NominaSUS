package domain;

public class Empleado {
    private String nombre;
    private double salario;
    private double numHorasTrabajadas;
    
    //Constructor
    public Empleado(String nombre, double numHorasTrabajadas){
        this.nombre = nombre;
        this.numHorasTrabajadas = numHorasTrabajadas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getNumHorasTrabajadas() {
        return this.numHorasTrabajadas;
    }

    public void setNumHorasTrabajadas(double numHorasTrabajadas) {
        this.numHorasTrabajadas = numHorasTrabajadas;
    }
    
    
    //Imprimir contenido de ESTA clase
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + this.nombre + ", salario=" + this.salario + '}';
    }
    
    public double calcularSalario(int numHorasTrabajadas, double tarifa){
        this.salario = numHorasTrabajadas*tarifa;
        return this.salario;
    }
    
    
}
