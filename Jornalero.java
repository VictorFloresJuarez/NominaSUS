package domain;

public class Jornalero extends Empleado {
    private double aux;

    //Constructor de objetos de tipo Jornalero
    public Jornalero(String nombre, double numHorasTrabajadas) {
        super(nombre, numHorasTrabajadas);
    }

    //Para la clase Jornalero no se sobreescribe, se crea otro método
    public double calcularSalario(int numHorasTrabajadas, double tarifa, int numHorasExtra) {
        aux = ((numHorasTrabajadas - numHorasExtra) * tarifa) + numHorasExtra * (2 * tarifa);
        setSalario(aux);
        return getSalario();
    }

    @Override
    public String toString() {
        return "Jornalero{" + "nombre=" + getNombre() + ", salario=" + getSalario() + '}';
    }
}
