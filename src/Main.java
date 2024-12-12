import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();//llamo al procedimiento que muestra el menú


    }
    public static void menu(){

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;//variable que determina si se sale o no del menu

        while (!exit){
            //bucle para repetir el menú tanto como el usuario desee
            System.out.println("-----MENU-----");
            System.out.println("a) Mayores de edad");
            System.out.println("b) Calculadora de ingresos de canal de Youtube");
            System.out.println("c) Cálculo horario");//no completado
            System.out.println("d) Salir");

            char option = scanner.nextLine().charAt(0);

            switch (option){
                case 'a'->{
                    int adultos = mayoresEdad();
                    System.out.println(adultos+ " persona(s) son mayores de edad");
                }
                case 'b'->{
                    double ingresos = videoscanal();
                    System.out.println("Has generado "+ingresos+".");
                }
                case 'c'->{
                    conversionHora();

                }
                case 'd'->{
                    System.out.println("Has salido del menú");
                    exit = true;
                }
            }
        }
    }
    public static int mayoresEdad(){

        Scanner scanner = new Scanner(System.in);


        int n;//variable para la cantidad de veces que se preguntará la edad
        int mayores = 0;//contador para los mayores de edad
        int anoreal = Year.now().getValue();

        System.out.println("¿Cuantas personas introducen su edad?");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Introduce el año de nacimiento");
            int ano = scanner.nextInt();
            int edad = anoreal - ano;//calcula la edad de la persona
            if (edad >= 18){//si son mayores suma al contador
                mayores++;
            }
        }
        return mayores;
    }
    public static double videoscanal() {

        Scanner scanner = new Scanner(System.in);

        String tematica = "";
        double valorCPM;
        double ingresostotal = 0;

        while (!tematica.equals("sal")){

            genero();

            tematica = scanner.nextLine().trim().toLowerCase();//le pido la temática del video

            switch (tematica){
                case "asmr"->{
                     valorCPM = 0.1;
                    System.out.println("¿Cuántas visitas tiene el video?");
                    double visitas = scanner.nextInt();
                    System.out.println("El video ha generado "+ingresosvideo(valorCPM, visitas)+ " euros.");

                    ingresostotal = ingresostotal + ingresosvideo(valorCPM, visitas);
                }
                case "deportes"->{
                     valorCPM = 1.0;
                    System.out.println("¿Cuántas visitas tiene el video?");
                    double visitas = scanner.nextInt();
                    System.out.println("El video ha generado "+ingresosvideo(valorCPM, visitas)+ " euros.");
                    ingresostotal = ingresostotal + ingresosvideo(valorCPM, visitas);
                }
                case "animales"->{
                    valorCPM = 0.2;
                    System.out.println("¿Cuántas visitas tiene el video?");
                    double visitas = scanner.nextInt();
                    System.out.println("El video ha generado "+ingresosvideo(valorCPM, visitas)+ " euros.");

                    ingresostotal = ingresostotal + ingresosvideo(valorCPM, visitas);
                }
                case "tecnología", "bebés" ->{
                    valorCPM = 0.5;
                    System.out.println("¿Cuántas visitas tiene el video?");
                    double visitas = scanner.nextInt();
                    System.out.println("El video ha generado "+ingresosvideo(valorCPM, visitas)+ " euros.");

                    ingresostotal = ingresostotal + ingresosvideo(valorCPM, visitas);
                }
                case "sal"->{
                    System.out.println("Has salido.");
                }
            }

        }
        return ingresostotal;
    }
    public static double ingresosvideo(double valorCPM, double visitas){

        return (valorCPM * visitas) / 1000;
    }
    public static void genero(){

        System.out.println("¿De qué temática es el vídeo?");
        System.out.println("(ASMR, Deportes, Animales, Tecnología, Bebés)");
        System.out.println("Disclaimer: No importa si usas mayúsculas o minúsculas, pero respeta las tildes");
        System.out.println("Introduce 'Sal' cuando quieras salir");

    }

    public static void conversionHora() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la hora");
        int hora = scanner.nextInt();
        System.out.println("introduce los minutos");
        int minutos = scanner.nextInt();
        System.out.println("Introduce la fase horaria (AM o PM)");
        String fase = scanner.nextLine().trim().toUpperCase();
        System.out.println("Introduce el huso");
        int huso = scanner.nextInt();

        while (huso < -11 || huso > 12){//Compruebo que el huso es válido
            System.out.println("Introduce un huso válido (Desde -11 hasta +12)");
            huso = scanner.nextInt();
        }

        int nuevahora = hora + huso;

        if (nuevahora > 12 || nuevahora < 1){

        }
    }
}