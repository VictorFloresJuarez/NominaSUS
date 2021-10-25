package domain;

public class Administrador extends Empleado {
    private double aux;

    //Constructor de objetos de tipo Administrador
    public Administrador(String nombreAdmin, double numHorasTrabajadas) {
        super(nombreAdmin, numHorasTrabajadas);
    }

    //Se sobreescribe el método para que se adapte a las condiciones de los administradores
    @Override
    public double calcularSalario(int numHorasTrabajadas, double tarifa) {
        if (numHorasTrabajadas >= 80) {
            aux = (numHorasTrabajadas * tarifa) * .30 + numHorasTrabajadas * tarifa;
            setSalario(aux);
            return getSalario();
        } else {
            aux = (numHorasTrabajadas * tarifa) * .20 + numHorasTrabajadas * tarifa;
            setSalario(aux);
            return getSalario();
        }
    }

    @Override
    public String toString() {
        return "Administrador{" + "nombre=" + getNombre() + ", salario=" + getSalario() + '}';
    }

}
