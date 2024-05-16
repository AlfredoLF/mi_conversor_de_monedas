import java.util.Scanner;
import java.util.InputMismatchException;

public class Bucle {
    public void ejecutar() {

        int opcion = 0;

        String menu = """
                *****=====*****=====*****=====*****=====*****=====*****=====*****
                
                Bienvenido/a seas a nuestro servicio de "Conversor de Monedas":
                
                1) Dólar Americano ($US) -----> Peso Argentino (ARS)
                2) Peso Argentino (ARS)  -----> Dólar Americano ($US)
                3) Dólar Americano ($US) -----> Real Brasilero (R$)
                4) Real Brasilero (R$)   -----> Dólar Americano ($US)
                5) Dólar Americano ($US) -----> Peso Colombiano (COP) 
                6) Peso Colombiano (COP) -----> Dólar Americano ($US)
                7) Salir del Programa
                
                Elije la opción de tu preferencia:
                
                *****=====*****=====*****=====*****=====*****=====*****=====*****
                """;
        String base_code, target_code;

        double monto;

        Busqueda deseoBuscar = new Busqueda();

        while (opcion != 7) {

            System.out.println(menu);
            Scanner teclado = new Scanner(System.in);
            try {
                opcion = teclado.nextInt();
                if (opcion == 7) {
                    System.out.println("Ejecución Finalizada, ¡Muchas Gracias por usar nuestros servicios!");
                    continue;
                } else if (opcion < 1 || opcion > 7) {
                    System.out.println("¡Opción no válida! Ingrese una opción válida, por favor...\n");
                    continue;
                }
            } catch (InputMismatchException I) {
                System.out.println("¡Opción no válida! Ingrese una opción válida, por favor...\n");
                continue;
            }

            System.out.println("Ingrese el valor de la moneda que desea convertir:\n");
            try {
                monto = teclado.nextDouble();
                if (monto < 0) {
                    System.out.println("Ingrese un valor númerico válido, por favor...\n");
                    continue;
                }
            } catch (InputMismatchException I) {
                System.out.println("Ingrese un valor númerico válido, por favor...\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    deseoBuscar.mostrarResultado(base_code, target_code, monto);
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    deseoBuscar.mostrarResultado(base_code, target_code, monto);
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    deseoBuscar.mostrarResultado(base_code, target_code, monto);
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    deseoBuscar.mostrarResultado(base_code, target_code, monto);
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "COP";
                    deseoBuscar.mostrarResultado(base_code, target_code, monto);
                    break;
                case 6:
                    base_code = "COP";
                    target_code = "USD";
                    deseoBuscar.mostrarResultado(base_code, target_code, monto);
                    break;
            }
        }
    }
}