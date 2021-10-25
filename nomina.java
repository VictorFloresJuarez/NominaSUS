package test;

import domain.Administrador;
import domain.Empleado;
import domain.Jornalero;
import java.util.Scanner;

public class nomina {

    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);
        boolean salidaDelDoWhile;
        int respuesta2;
        int maximo = 10;
        int auxParaNumTipos;

        Empleado empleado[] = new Empleado[maximo];
        Administrador administrador[] = new Administrador[maximo];
        Jornalero jornalero[] = new Jornalero[maximo];

        inicializar(empleado, administrador, jornalero, maximo);

        //Primera elección
        menu2();
        respuesta2 = Integer.parseInt(entradaUsuario.nextLine());
        do {
            switch (respuesta2) {
                case 1:
                    do {
                        registro(empleado, administrador, jornalero);
                        System.out.println("Desea realizar otro registro: ");
                        salidaDelDoWhile = entradaUsuario.nextLine().equals("No");
                    } while (!salidaDelDoWhile);
                    break;
                case 2:
                    calcularSalario(empleado, administrador, jornalero, maximo);
                    break;
                case 3:
                    consultarNomina(empleado, administrador, jornalero, maximo);
                    break;
                case 4:
                    calcularHoras(empleado, administrador, jornalero, maximo);
                    break;
                case 5:
                    auxParaNumTipos = calcularNumEmpleados(empleado, administrador, jornalero, maximo);
                    System.out.println("Hay " + auxParaNumTipos);
                    break;
                case 6:
                    calcularNominaTotal(empleado, administrador, jornalero, maximo);
                    break;
            }
            menu2();
            respuesta2 = Integer.parseInt(entradaUsuario.nextLine());
        } while (respuesta2 != 7);

        System.out.println("Es todo. El programa terminó");

    }

    public static void registro(Empleado empleado[], Administrador administrador[], Jornalero jornalero[]) {
        int conteo = 0;
        boolean sacaDelRegistro = false;
        boolean comparaCadena;

        Scanner entrada = new Scanner(System.in);
        int entradaAux;

        String nombre;
        double horasTrabajadas;

        menu();
        entradaAux = Integer.parseInt(entrada.nextLine());

        switch (entradaAux) {
            case 1:
                System.out.println("Bienvenido, empleado. Por favor introduce tu nombre: ");
                nombre = entrada.nextLine();
                System.out.println("Introduce las horas que trabajaste esta quincena: ");
                horasTrabajadas = Integer.parseInt(entrada.nextLine());
                comparaCadena = empleado[conteo].getNombre().equals("Espacio libre");
                if (comparaCadena) {
                    empleado[conteo].setNombre(nombre);
                    empleado[conteo].setNumHorasTrabajadas(horasTrabajadas);
                } else {

                    do {
                        conteo++;
                        comparaCadena = empleado[conteo].getNombre().equals("Espacio libre");
                        if (comparaCadena) {
                            empleado[conteo].setNombre(nombre);
                            empleado[conteo].setNumHorasTrabajadas(horasTrabajadas);
                            sacaDelRegistro = true;
                        }
                    } while (sacaDelRegistro == false);
                }

                break;
            case 2:
                System.out.println("Bienvenido, administrador. Por favor introduce tu nombre: ");
                nombre = entrada.nextLine();
                System.out.println("Introduce las horas que trabajaste esta quincena: ");
                horasTrabajadas = Integer.parseInt(entrada.nextLine());
                comparaCadena = administrador[conteo].getNombre().equals("Espacio libre");
                if (comparaCadena) {
                    administrador[conteo].setNombre(nombre);
                    administrador[conteo].setNumHorasTrabajadas(horasTrabajadas);
                } else {

                    do {
                        conteo++;
                        comparaCadena = administrador[conteo].getNombre().equals("Espacio libre");
                        if (comparaCadena) {
                            administrador[conteo].setNombre(nombre);
                            administrador[conteo].setNumHorasTrabajadas(horasTrabajadas);
                            sacaDelRegistro = true;
                        }
                    } while (sacaDelRegistro == false);
                }
                break;
            case 3:
                System.out.println("Bienvenido, jornalero. Por favor introduce tu nombre: ");
                nombre = entrada.nextLine();
                System.out.println("Introduce las horas que trabajaste esta quincena: ");
                horasTrabajadas = Integer.parseInt(entrada.nextLine());
                comparaCadena = jornalero[conteo].getNombre().equals("Espacio libre");
                if (comparaCadena) {
                    jornalero[conteo].setNombre(nombre);
                    jornalero[conteo].setNumHorasTrabajadas(horasTrabajadas);
                } else {

                    do {
                        conteo++;
                        comparaCadena = jornalero[conteo].getNombre().equals("Espacio libre");
                        if (comparaCadena) {
                            jornalero[conteo].setNombre(nombre);
                            jornalero[conteo].setNumHorasTrabajadas(horasTrabajadas);
                            sacaDelRegistro = true;
                        }
                    } while (sacaDelRegistro == false);
                }
                break;
        }
    }

    public static void inicializar(Empleado empleado[], Administrador administrador[], Jornalero jornalero[], int maximo) {
        int i = 0;
        while (i != maximo) {
            empleado[i] = new Empleado("Espacio libre", 0);
            administrador[i] = new Administrador("Espacio libre", 0);
            jornalero[i] = new Jornalero("Espacio libre", 0);
            i++;
        }
    }

    public static void menu() {
        System.out.println("Seleccione su opción:");
        System.out.println("1. Empleado");
        System.out.println("2. Administrador");
        System.out.println("3. Jornalero");
    }

    public static void menu2() {
        System.out.println("Qué deseas hacer: ");
        System.out.println("1. Registrar ");
        System.out.println("2. Calcular salario");
        System.out.println("3. Consultar nómina por empleado");
        System.out.println("4. Número de horas trabajadas");
        System.out.println("5. Número de empleados por tipo de rol");
        System.out.println("6. Consultar nómina total");
        System.out.println("7. Salir");
    }

    public static void menu3() {
        System.out.println("Seleccione su opción:");
        System.out.println("1. Empleado");
        System.out.println("2. Administrador");
        System.out.println("3. Jornalero");
        System.out.println("4. Nómina total de la quincena");
    }

    public static void calcularSalario(Empleado empleado[], Administrador administrador[], Jornalero jornalero[], int maximo) {
        Scanner entrada = new Scanner(System.in);
        boolean comparadorCadenas;
        boolean mensajeNoEncontro;
        int i;
        int numHorasTrabajadas;
        double tarifa;
        String nombreIngresado;
        menu();
        int opcion = Integer.parseInt(entrada.nextLine());
        switch (opcion) {
            case 1:
                System.out.println("Ingrese su nombre: ");
                nombreIngresado = entrada.nextLine();
                for (i = 0; i < maximo; i++) {
                    comparadorCadenas = nombreIngresado.equals(empleado[i].getNombre());
                    if (comparadorCadenas) {
                        System.out.println("Ingrese las horas trabajadas: ");
                        numHorasTrabajadas = Integer.parseInt(entrada.nextLine());
                        System.out.println("Ingrese su tarifa: ");
                        tarifa = Double.parseDouble(entrada.nextLine());
                        empleado[i].calcularSalario(numHorasTrabajadas, tarifa);
                        break;
                    } else {
                        mensajeNoEncontro = true;
                    }
                    if (mensajeNoEncontro) {
                        System.out.println("Lo siento, no encontré a ese empleado");
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese su nombre: ");
                nombreIngresado = entrada.nextLine();
                for (i = 0; i < maximo; i++) {
                    comparadorCadenas = nombreIngresado.equals(administrador[i].getNombre());
                    if (comparadorCadenas) {
                        System.out.println("Ingrese las horas trabajadas: ");
                        numHorasTrabajadas = Integer.parseInt(entrada.nextLine());
                        System.out.println("Ingrese su tarifa: ");
                        tarifa = Double.parseDouble(entrada.nextLine());
                        administrador[i].calcularSalario(numHorasTrabajadas, tarifa);
                        break;
                    } else {
                        mensajeNoEncontro = true;
                    }
                    if (mensajeNoEncontro) {
                        System.out.println("Lo siento, no encontré a ese administrador");
                    }
                }
                break;

            case 3:
                int horasExtra;
                System.out.println("Ingrese su nombre: ");
                nombreIngresado = entrada.nextLine();
                for (i = 0; i < maximo; i++) {
                    comparadorCadenas = nombreIngresado.equals(jornalero[i].getNombre());
                    if (comparadorCadenas) {
                        System.out.println("Ingrese las horas trabajadas: ");
                        numHorasTrabajadas = Integer.parseInt(entrada.nextLine());
                        System.out.println("Ingrese las horas extra (las horas extra además tenían que incluirse en las horas trabajadas)");
                        horasExtra = Integer.parseInt(entrada.nextLine());
                        System.out.println("Ingrese su tarifa: ");
                        tarifa = Double.parseDouble(entrada.nextLine());
                        jornalero[i].calcularSalario(numHorasTrabajadas, tarifa, horasExtra);
                        break;
                    } else {
                        mensajeNoEncontro = true;
                    }
                    if (mensajeNoEncontro) {
                        System.out.println("Lo siento, no encontré a ese jornalero");
                    }
                }
                break;

        }
    }

    public static void consultarNomina(Empleado empleado[], Administrador administrador[], Jornalero jornalero[], int maximo) {
        Scanner entrada = new Scanner(System.in);
        boolean comparadorCadenas;
        int i;
        int numHorasTrabajadas;
        double tarifa;
        String nombreIngresado;
        menu();
        int opcion = Integer.parseInt(entrada.nextLine());
        switch (opcion) {
            case 1:
                System.out.println("Ingrese su nombre: ");
                nombreIngresado = entrada.nextLine();
                for (i = 0; i < maximo; i++) {
                    comparadorCadenas = nombreIngresado.equals(empleado[i].getNombre());
                    if (comparadorCadenas) {
                        System.out.println("Tu sueldo es : " + empleado[i].getSalario());
                        break;
                    } else {
                        System.out.println("No se ha encontrado a ese empleado");
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese su nombre: ");
                nombreIngresado = entrada.nextLine();
                for (i = 0; i < maximo; i++) {
                    comparadorCadenas = nombreIngresado.equals(administrador[i].getNombre());
                    if (comparadorCadenas) {
                        System.out.println("Tu sueldo es : " + administrador[i].getSalario());
                        break;
                    } else {
                        System.out.println("No se ha encontrado a ese admin");
                        break;
                    }
                }
                break;

            case 3:
                System.out.println("Ingrese su nombre: ");
                nombreIngresado = entrada.nextLine();
                for (i = 0; i < maximo; i++) {
                    comparadorCadenas = nombreIngresado.equals(jornalero[i].getNombre());
                    if (comparadorCadenas) {
                        System.out.println("Tu sueldo es : " + jornalero[i].getSalario());
                        break;
                    } else {
                        System.out.println("No se ha encontrado a ese jornalero");
                        break;
                    }
                }
                break;

        }
    }

    public static void calcularHoras(Empleado empleado[], Administrador administrador[], Jornalero jornalero[], int maximo) {
        int i;
        Scanner entrada = new Scanner(System.in);
        int eleccion;
        boolean comparador;
        double horasTotales = 0;

        System.out.println("Ingrese el tipo de trabajador para saber las horas totales");
        menu();
        eleccion = Integer.parseInt(entrada.nextLine());

        switch (eleccion) {
            case 1:
                for (i = 0; i < maximo; i++) {
                    comparador = empleado[i].getNombre().equals("Espacio libre");
                    if (!comparador) {
                        horasTotales = horasTotales + empleado[i].getNumHorasTrabajadas();
                    }
                }
                System.out.println("El total de horas trabajadas por los empleados es de: " + horasTotales);
                break;
            case 2:
                for (i = 0; i < maximo; i++) {
                    comparador = administrador[i].getNombre().equals("Espacio libre");
                    if (!comparador) {
                        horasTotales = horasTotales + administrador[i].getNumHorasTrabajadas();
                    }
                }
                System.out.println("El total de horas trabajadas por los administradores es de: " + horasTotales);
                break;
            case 3:
                for (i = 0; i < maximo; i++) {
                    comparador = jornalero[i].getNombre().equals("Espacio libre");
                    if (!comparador) {
                        horasTotales = horasTotales + jornalero[i].getNumHorasTrabajadas();
                    }
                }
                System.out.println("El total de horas trabajadas por los jornaleros es de: " + horasTotales);
                break;
        }

    }

    public static int calcularNumEmpleados(Empleado empleado[], Administrador administrador[], Jornalero jornalero[], int maximo) {
        Scanner entrada = new Scanner(System.in);
        int eleccion;
        int numDeTipo = 0;
        String cadenaAux = "Espacio libre";
        boolean comparador;
        int i;
        menu();
        eleccion = Integer.parseInt(entrada.nextLine());
        switch (eleccion) {
            case 1:
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(empleado[i].getNombre());
                    if (!comparador) {
                        numDeTipo = numDeTipo + 1;
                    }
                }
                break;
            case 2:
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(administrador[i].getNombre());
                    if (!comparador) {
                        numDeTipo = numDeTipo + 1;
                    }
                }
                break;
            case 3:
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(jornalero[i].getNombre());
                    if (!comparador) {
                        numDeTipo = numDeTipo + 1;
                    }
                }
                break;
        }

        return numDeTipo;
    }

    public static void calcularNominaTotal(Empleado empleado[], Administrador administrador[], Jornalero jornalero[], int maximo) {
        Scanner entrada = new Scanner(System.in);
        int eleccion;
        double nominatotal = 0;
        String cadenaAux = "Espacio libre";
        boolean comparador;
        int i;
        menu3();
        eleccion = Integer.parseInt(entrada.nextLine());
        switch (eleccion) {
            case 1:
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(empleado[i].getNombre());
                    if (!comparador) {
                        nominatotal = nominatotal + empleado[i].getSalario();
                    }
                }
                System.out.println("La nómina total para los empleados es: " + nominatotal);
                break;
            case 2:
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(administrador[i].getNombre());
                    if (!comparador) {
                        nominatotal = nominatotal + administrador[i].getSalario();
                    }
                }
                System.out.println("La nómina total para los administradores es: " + nominatotal);
                break;
            case 3:
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(jornalero[i].getNombre());
                    if (!comparador) {
                        nominatotal = nominatotal + jornalero[i].getSalario();
                    }
                }
                System.out.println("La nómina total para los Jornaleros es: " + nominatotal);
                break;
            case 4:
                //Para la nómina total admito que me fui a la floja y anidé puros for jejejeje
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(empleado[i].getNombre());
                    if (!comparador) {
                        nominatotal = nominatotal + empleado[i].getSalario();
                    }
                }
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(administrador[i].getNombre());
                    if (!comparador) {
                        nominatotal = nominatotal + administrador[i].getSalario();
                    }
                }
                for (i = 0; i < maximo; i++) {
                    comparador = cadenaAux.equals(jornalero[i].getNombre());
                    if (!comparador) {
                        nominatotal = nominatotal + jornalero[i].getSalario();
                    }
                }
                System.out.println("La nómina total de la quincena es: " + nominatotal);
                break;
        }

    }
}
