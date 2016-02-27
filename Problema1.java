/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

/**
 *
 * @author MiguelAngel
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int NumMun, NumCan, NumVot;
        int votos[][] = new int[20][20];
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        System.out.println("Ingrese el numero de municipios que participaron en las votaciones: ");
        NumMun = lectura.nextInt();
        System.out.println("Ingrese el numero de candidatos postulados a las elecciones: ");
        NumCan = lectura.nextInt();
        while(NumMun > 20){
            System.out.println("EL NUMERO DE MUNICIPIOS NO PUEDE SER MAYOR A 20 ");
            System.out.println("Ingrese de nuevo el numero de municipios que participaron en las votaciones: ");
            NumMun = lectura.nextInt();
        }
        while(NumCan >20){
            System.out.println("EL NUMERO DE CANDIDATOS NO PUEDE SER MAYOR A 20 ");
            System.out.println("Ingrese de nuevo el numero de candidatos postulados a las elecciones: ");
            NumCan = lectura.nextInt();
        }
        for (int j = 0; j < NumCan; j++){
            for(int i = 0; i < NumMun; i++){
		System.out.print("Ingrese el numero de votos del Candidato No." + (j + 1));
                System.out.println(" en el municipio " + (i + 1));
                NumVot= lectura.nextInt();
                votos[i][j] = NumVot;
            }
        }
        PresentarInforme(NumMun, NumCan, votos);
        Resultados(votos, NumMun, NumCan);
    }
    public static void PresentarInforme (int NumMun, int NumCan, int votos[][]){
        for (int i = 0; i <= NumCan; i++){
            if(i == 0){
                System.out.print("\t\t");
            }else if(i == NumCan){
                System.out.print("Candidato. "+i);
                System.out.print("\t ");
                System.out.println();
            }else{
                System.out.print("Candidato. "+i);
                System.out.print("\t ");
            }
        }
        for(int i = 0; i < NumMun; i++){
            for(int j = -1; j < NumCan; j++){
                if(j == -1){
                    System.out.print("Municipio. "+(i+1));
                    System.out.print("\t");
                }else{
                    System.out.print(votos[i][j]);
                    System.out.print("\t\t "); 
                }
                if(j == NumCan-1){                    
                    System.out.println("\t\t ");
                }
                            
            }
        }
    }
    public static void Resultados(int votos[][], int NumMun, int NumCan){
        int resultados[] = new int [NumCan];
        int i = 0, j = 0;
        int resultado = 0;
        while(i < NumMun){
            resultado += votos[i][j];
            i++;
            if(i == NumMun && j <= NumCan-1){
                resultados[j] = resultado;
                resultado = 0;
                j++;
                i = 0;
            }
        }
        double porcentajes[] = new double [NumCan];
        resultado = 0;
        for(int k = 0; k < NumCan; k++){
            resultado += resultados[k];
        }
        for(int k = 0; k < NumCan; k++){
            porcentajes[k] = (resultados[k]*100)/resultado;
        }
        System.out.println();
        System.out.println("TOTAL DE VOTOS");
        for (int k = 0; k < NumCan; k++){
            System.out.print("Candidato "+(k+1));
            System.out.print(":\t "+resultados[k]);
            System.out.print("\t"+porcentajes[k]);
            System.out.println("%");
        }
        System.out.println();
        System.out.println("CANDIDATO CON MAS VOTOS");
        int mayor = 0;
        int k = 0;
        for(k = 1; k < NumCan; k++){
            if(k == 1){
                if(resultados[k] >= resultados[k-1]){
                    mayor = resultados[k];
                }else{
                    mayor = resultados[k-1];
                }
            }else{
                if(resultados[k] >= mayor){
                    mayor = resultados[k];
                }else{
                    mayor = mayor;
                }
            }
        } 
        k = 0;
        while (resultados[k] != mayor){
            k++;
        }
        int Can1 = k+1;
        System.out.println("El candidato mas votado fue el No: "+Can1);        
        int medio = 0;
        for(int m = 1; m < NumCan; m++){
            if(m == Can1-1){
                ;
            }else{
                if(m == 1){
                    if(resultados[m] >= resultados[m-1]){
                        medio = resultados[m];
                    }else{
                        medio = resultados[m-1];
                    }
                }else{
                    if(resultados[m] >= medio){
                        medio = resultados[m];
                    }else{
                        medio = mayor;
                    }
                }
            }
        }
        k = 0;
        while (resultados[k] != medio){
            k++;
        }
        int Can2 = k+1;
        k = 0;
        boolean bandera = true;
        while (k < NumCan && bandera == true){
                if(porcentajes[k] > 50){
                    System.out.println("");
                    System.out.println("EL GANADOR ES EL CANDIDATO No."+(k+1));
                    bandera = false;
                }
                k++;
                if(bandera == true && k > NumCan-1){
                    System.out.println("");
                    System.out.println("CANDIDATOS QUE PASAN A LA SIGUIENTE RONDA");
                    System.out.print("El Candidato No."+Can1);
                    System.out.print(" y el Candidato No."+Can2);
                    System.out.println(" pasan a la siguiente ronda de votaciones.");
                    bandera = false;
                }
        }
    }

}
