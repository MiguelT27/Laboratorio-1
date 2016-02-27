
package ejercicio1;
public class Ejercicio1 {

    
    public static void main(String[] args) {
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int mayor=0;
        int a, b, c;
        System.out.println("Ingrese a: "+"\t");
        a = lectura.nextInt();
        System.out.println("Ingrese b: "+"\t");
        b = lectura.nextInt();
        System.out.println("Ingrese c: "+"\t");
        c = lectura.nextInt();
        if(a>b){
            if(a>c){
                mayor=a;
            }else{
                mayor=c;
            }
        }else{
            if(b>c){
                mayor=b;
            }else{
                mayor=c;
            }
        }
        System.out.println("El mayor es:"+mayor);
    }
    
}
