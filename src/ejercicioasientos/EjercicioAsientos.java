package ejercicioasientos;

import java.util.Scanner;
public class EjercicioAsientos {

    public static void main(String[] args) {
        
        //Declara matriz asientos
        char asientos[][] = new char[10][10];
        //Declarar Bandera para while
        boolean bandera = false;
        //Scanner
        Scanner teclado = new Scanner(System.in);
        //Declarar fila y asiento
        int fila =0, asiento =0;
        //Declarar respuesta
        String respuesta;
        //Declarar ver mapa
        String verMapa;
        
        //Recorrer matriz para iniciar todos los asientos libres
        for(int f=0;f<10;f++){
            for(int c=0;c<10;c++){
                asientos[f][c] = 'L';
            }
        }
        
        System.out.println("------BIENVENIDO AL SISTEMA DE RESERVAS------");  
        
        //Reserva de asientos
        while(bandera!=true){
            System.out.println("¿Desea ver los asientos disponibles? S:si, cualquier otra letra: No");
            verMapa = teclado.next();
            //Ver mapa de asientos
            if(verMapa.equalsIgnoreCase("S")){
                dibujarMapa(asientos);
            }
           
            boolean estaOk = false;
            while(estaOk!=true){              
            //Pedir ingreso de fila y asiento mientas banderaa sea false
            System.out.println("\n Ingrese Fila y Asiento a reservar: ");
            System.out.print("Fila (entre 0 y 9): ");
            fila = teclado.nextInt();
            
            System.out.print("Asiento (entre 0 y 9): ");
            asiento = teclado.nextInt();
             if(fila<=9 && fila>=0){
                 if(asiento<=9 && asiento>=0){
                     estaOk = true;
                 }
                 else{
                     System.out.println("El número de asiento no es válido.");
                 }
             }
             else{
                 System.out.println("El número de fila no es válido");
             }
              
            }
            if(asientos[fila][asiento] == 'L'){
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente.");
                
            } 
            else{
                System.out.println("El asiento está ocupado. Por favor elija otro.");
            }
            
            System.out.println("¿Desea finalizar la reserva? S:si, cualquier otra letra: No");
            respuesta = teclado.next();
            
            if(respuesta.equalsIgnoreCase("S")){
                bandera = true;
            }
        }
        
    }
    
    //Procedimiento/Metodo que usa de parametro a matriz asientos pero no devuelve valor
    //Por eso es void y static significa que no va a cambiar.
    static void dibujarMapa(char asientos[][]){       
        for(int f=0;f<10;f++){
            System.out.print(f+ " ");
            for(int c=0;c<10;c++){
           
                System.out.print("[" + asientos[f][c] + "]"); 
                
            }
            System.out.println("");      
        }
    }
    
}
