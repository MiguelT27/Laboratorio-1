
package ejercicio2;


public class Ejercicio2 {
    public static void main(String[] args) {
        int cuenta_as = 1 ;
        int contador = 1;
        int blan = 1;
        int num = 5;
        String ast = "*";
        String esp = "";
        System.out.println(""+"\n");
        while(contador<=num){
            blan = num - contador;
        
        while(blan>0){
              System.out.println(esp);
              blan=blan-1;
        }
        cuenta_as=1;
        
        while(cuenta_as<(2*contador)){
           System.out.println(ast);
           cuenta_as=cuenta_as+1;
        }
        
        contador=contador+1;
        System.out.println(""+"\n");
        
        }
    }  
}
