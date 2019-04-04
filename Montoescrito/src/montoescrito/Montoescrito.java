package montoescrito;

import java.util.Scanner;

public class Montoescrito {
    
    public static String monto(int numero){
        String cadena = new String();
        
        if((numero/1000000)>0){
            if ((numero/1000000)==1){
                cadena = " Un Millon "+ monto(numero%1000000);}
            else{cadena = monto(numero/1000000)+" Millones "+monto(numero%1000000);}    
        }
        else{
            if((numero/1000)>0){
                if((numero/1000)==1){
                    cadena = " Mil "+ monto(numero%1000);}
                else{cadena = monto(numero/1000)+" Mil "+monto(numero%1000);}
            }
            else{
                if((numero/100)>0){
                    if((numero/100)==1){
                        if((numero%100)==0){
                           cadena = " Cien ";}
                        else{cadena = " Ciento"+monto(numero%100);}
                    }
                    else{
                        if((numero/100)==5){
                            cadena = " Quinientos "+monto(numero%100);
                        }
                        else{
                            if((numero/100)==7){
                                cadena = " Setecientos "+monto(numero%100);
                            }
                            else{
                                if((numero/100)==9){
                                cadena = " Novecientos "+monto(numero%100);
                                }
                                else{
                                cadena = monto(numero/100)+"cientos"+monto(numero%100);
                                }
                            }
                        }
                    }
                }
                else{
                    if((numero/10)>0){
                        switch ((int)(numero/10)){
                            case 1:
                                switch ((int)(numero%10)){
                                    case 0: cadena= " Diez "; break;
                                    case 1: cadena= " Once "; break;
                                    case 2: cadena = " Doce "; break;
                                    case 3: cadena = " Trece "; break;
                                    case 4: cadena = " Catorce "; break;
                                    case 5: cadena = " Quince "; break;
                                    default: cadena = "Diez y "+monto(numero%10); break; 
                                }break;
                            case 2:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Veinte "; break;
                                    default: cadena = " Veinti"+monto(numero%10); break;
                                }break;
                            case 3:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Treinta "; break;
                                    default: cadena = " Treinta y "+monto(numero%10); break;
                                }break;
                            case 4:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Cuarenta "; break;
                                    default: cadena = " Cuarenta y "+monto(numero%10); break;
                                }break;
                           case 5:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Cincuenta "; break;
                                    default: cadena = " Cincuenta y "+monto(numero%10); break;
                                }break;
                            case 6:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Sesenta "; break;
                                    default: cadena = " Sesenta y "+monto(numero%10); break;
                                }break;    
                            case 7:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Setenta "; break;
                                    default: cadena = " Setenta y "+monto(numero%10); break;
                                }break;
                            case 8:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Ochenta "; break;
                                    default: cadena = " Ochenta y "+monto(numero%10); break;
                                }break;
                            case 9:
                                switch ((int)(numero%10)){
                                    case 0: cadena = " Noventa "; break;
                                    default: cadena = " Noventa y "+monto(numero%10); break;
                                }break;       
                        }             
                    }
                    else{
                        switch ((int)(numero)){
                            case 0:cadena= "Cero"; break;
                            case 1: cadena= "Uno"; break;
                            case 2: cadena = "Dos"; break;
                            case 3: cadena = "Tres"; break;
                            case 4: cadena = "Cuatro"; break;
                            case 5: cadena = "Cinco"; break;
                            case 6: cadena = "Seis"; break;
                            case 7: cadena = "Siete"; break;
                            case 8: cadena = "Ocho"; break;
                            case 9: cadena = "Nueve"; break;   
                        }
                    }
                }    
            }
        }
        return cadena;
    }
 
    public String principal(float numero,int frac, String unidad){
        String cadena;
        int ent = (int) numero;
        int fra=0;
        switch ((int)(frac)){
            case 0: fra = (int)((numero - ent)* 0); break;
            case 1: fra = (int)((numero - ent)* 10); break;
            case 2: fra = (int)((numero - ent)* 100); break;
            case 3: fra = (int)((numero - ent)* 1000); break;
            case 4: fra = (int)((numero - ent)* 10000); break;
            case 5: fra = (int)((numero - ent)* 100000); break;
            case 6: fra = (int)((numero - ent)* 1000000); break;
        }
        String a;
        a = monto(ent);
        String b;
        b = monto(fra);
        if(fra == 0){
            cadena = a +"  "+ unidad+"\n";
            return cadena;
        }
        else{
            cadena = a+" Con "+b+"  "+unidad+"\n";
            return cadena;
        }    
    }
    
    public static void menu(){
        float numero;
        int frac;
        String unidad, total;
        Montoescrito obj = new Montoescrito();
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nDigite el numero:\n");
        numero = teclado.nextFloat();
        int ent = (int) numero;
        int fra;
        fra = (int)((numero - ent)* 10);
        if (fra > 0){
            System.out.println("\nDigite el numero de fraccionarios a tener en cuenta:\n");
            frac = teclado.nextInt();
            System.out.println("\nDigite la unidad de medida:\n");
            unidad = teclado.next();
            total = obj.principal(numero, frac, unidad);
            System.out.print(total);
        }
        else{
            System.out.println("\nDigite la unidad de medida:\n");
            unidad = teclado.next();
            total = obj.principal(numero, 0, unidad);
            System.out.print(total);
        }
    }
    
    public static void main(String[] args) {
        int i=1;
        while(i!=0){
        menu();
        }   
    }    
}