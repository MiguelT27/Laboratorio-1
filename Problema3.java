/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.pkg3;

/**
 *
 * @author MiguelAngel
 */
public class Problema3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] Parqueadero = new int [4][22];
        int[][] Puestos = new int [4][22];
        int[][] Matriculas = new int [4][22];
        int[][] Entrada = new int [4][22];
        int[][] Salida = new int [4][22];
        Inicializar(Parqueadero);
        Inicializa(Puestos);
        Inicializa(Matriculas);
        Inicializa(Entrada);
        Inicializa(Salida);
        EscogerOperacion(Parqueadero, Puestos, Matriculas, Entrada, Salida);
    }
    public static void EscogerOperacion(int[][] Parqueadero, int[][] Puestos, int[][] Matriculas, int[][]Entrada, int[][]Salida){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int eleccion;
        int respuesta;
        int IngresoTotal = 0, Factura = 0;
        do{
            System.out.println("*********************************************************************************");
            System.out.println("                         OPERACIONES DISPONIBLES:");
            System.out.println("*********************************************************************************");
            System.out.println("1. Asignar un puesto del parqueadero a un carro nuevo.");
            System.out.println("2. Cobrar.");
            System.out.println("3. Informe de Ganancias del dia.");
            System.out.println("4. Informe de Disponibilidad");
            System.out.println("*********************************************************************************");
            System.out.print("               Seleccione una opcion: ");
            eleccion = lectura.nextInt();
            switch(eleccion){
                case 1:
                    System.out.println("*********************************************************************************");
                    System.out.println("          ASIGNACION DE PUESTO:");
                    AsignarPuesto(Parqueadero, Puestos, Matriculas, Entrada);
                    break;
                case 2:
                    Factura = CalcularFactura(Puestos, Matriculas, Entrada, Salida);
                    System.out.println("*********************************************************************************");
                    System.out.print("++++++++++++++++++++++   COSTO PARQUEADERO: "+Factura);
                    System.out.println("    ++++++++++++++++++++++++");
                    System.out.println("*********************************************************************************");
                    IngresoTotal =+ Factura;
                    break;
                case 3:
                    System.out.println("*********************************************************************************");
                    System.out.print("++++++++++++++++++++++   INGRESOS DEL DIA: "+IngresoTotal);
                    System.out.println("   +++++++++++++++++++++++++");
                    System.out.println("*********************************************************************************");
                    break;
                case 4:
                    int PuestosDisponibles = InformeDisponibilidad(Puestos);
                    System.out.println("*********************************************************************************");
                    System.out.print("++++++++++++++++++++++   PUESTOS DISPONIBLES: "+(PuestosDisponibles-1));
                    System.out.println("   +++++++++++++++++++++++++");
                    System.out.println("*********************************************************************************");
                    break;
            }
            System.out.print("             Desea seleccionar otra operacion Si(1)/No(0): ");
            respuesta = lectura.nextInt();
        }while(respuesta == 1);
    }
    public static void Inicializar(int[][] Parqueadero){
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 22; j++){
                Parqueadero[i][j] = (22*i)+j+1;
            }
        }
    }
    public static void Inicializa(int[][] Informacion){
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 22; j++){
                Informacion[i][j] = 0;
            }
        }
    }
    public static void Imprimir(int[][] Parqueadero, int[][] Puestos){
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 22; j++){
                if((22*i)+j+1 != 88 ){
                    if(Puestos[i][j] == 0){
                        if((22*i)+j+1 >=10){
                            System.out.print("\t|"+Parqueadero[i][j]);
                            System.out.print("|");
                            if(j == 21){
                                System.out.println("");
                            }
                        }else{
                            System.out.print("\t|0"+Parqueadero[i][j]);
                            System.out.print("|");
                            if(j == 21){
                            System.out.println("");
                            }
                        }
                    }else{
                        if((22*i)+j+1 >=10){
                            System.out.print("\t|  ");
                            System.out.print("|");
                            if(j == 21){
                                System.out.println("");
                            }
                        }else{
                            System.out.print("\t|  ");
                            System.out.print("|");
                            if(j == 21){
                            System.out.println("");
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
    }
    public static void AsignarPuesto(int[][] Parqueadero, int[][] Puestos, int[][] Matriculas, int[][] Entrada){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int respuesta;
        boolean salir = false;
        int Matricula;
        int Puesto;
        System.out.println("*********************************************************************************");
        System.out.print("               Que puesto desea asignar:");
        Puesto = lectura.nextInt();
        System.out.println("*********************************************************************************");
        int HoraEntrada;
        int coori, coorj;
        while(salir == false){
            coori = Puesto/22;
            coorj = (Puesto%22) - 1;
            if(Disponibilidad(coori, coorj, Puestos) == true){
                System.out.print("               Ingrese la matricula del automovil: ");
                Matricula = lectura.nextInt();
                System.out.println("*********************************************************************************");
                System.out.print("               Indique la hora de entrada: ");
                HoraEntrada = lectura.nextInt();
                System.out.println("*********************************************************************************");
                Puestos[coori][coorj] = 1;
                Matriculas [coori][coorj] = Matricula;
                Entrada [coori][coorj] = HoraEntrada;
                System.out.println("***************LA INFORMACION SE REGISTRO CORRECTAMENTE**************************");
                System.out.println("*********************************************************************************");
                salir = true;
            }else{
                System.out.print("\tEL PUESTO No."+Puesto);
                System.out.println(" ESTA OCUPADO.LOS PUESTOS DISPONIBLES SON LOS SIGUIENTES.");
                Imprimir(Parqueadero, Puestos);
                System.out.println("*********************************************************************************");
                System.out.print("               Desea seleccionar otro puesto Si(1)/No(0): ");
                respuesta = lectura.nextInt();
                System.out.println("*********************************************************************************");
                if(respuesta == 1){
                    System.out.print("               Que puesto desea asignar: ");
                    Puesto = lectura.nextInt();
                }else if(respuesta == 0){
                    salir =true;
                }
            }
        }
    }
    public static boolean Disponibilidad (int coori, int coorj, int[][] Puestos){
        if(Puestos[coori][coorj] == 0){
            return true;
        }else{
            return false;
        }
        
    }
    public static int CalcularFactura(int [][] Puestos, int[][]Matriculas, int[][] Entrada, int[][] Salida){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int Matricula, HoraEntrada, HoraSalida, coori = 0, coorj = 0, PrecioHora = 2000;
        System.out.println("*********************************************************************************");
        System.out.print("               Ingrese el numero de matricula: ");
        Matricula = lectura.nextInt();
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 22; j++){
                if(Matriculas[i][j] == Matricula){
                    coori = i;
                    coorj = j;
                }
            }
        }
        Puestos[coori][coorj] = 0;
        HoraEntrada = Entrada[coori][coorj];
        System.out.println("*********************************************************************************");
        System.out.print("               Ingrese la hora de salida: ");
        HoraSalida = lectura.nextInt();
        int Tiempo = HoraSalida - HoraEntrada;
        int Factura = Tiempo*PrecioHora;
        return Factura;    
    }
    public static int InformeDisponibilidad(int[][] Puestos){
        int cont = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 22; j++){
                if(Puestos[i][j] == 0){
                    cont++;
                }
            }
        }
        return cont;
    }
    
}
