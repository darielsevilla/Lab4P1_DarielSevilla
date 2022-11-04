/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_darielsevilla;

import java.util.Scanner;

public class Lab4P1_DarielSevilla {

    public static void sumaBinarios(String arg1, String arg2) {

        char uno = '0';
        String reves = "";
        String fin = "";
        
        //for suma
        for (int i = arg1.length() - 1; i >= 0; i--) {
            int a1 = (int) arg1.charAt(i);
            int a2 = (int) arg2.charAt(i);
            int sum = a1 + a2;
            if (uno == '1') {
                sum += (int) uno;
                uno = '0';
            }
            //resultados en ascii
            // 97 - 0 1 
            // 98 - 1 1
            // 96 - 0 0
            // 146 - 0 1 1
            //147 - 1 1 1
            //145- 0 0 1

            if (sum == 96 || sum == 98 || sum == 146) {
                reves += '0';
                if (sum == 98 || sum == 146) {
                    uno = '1';
                }
            } else if (sum == 97 || sum == 147 || sum == 145) {
                reves += '1';
                if (sum == 147) {
                    uno = '1';
                }

            }

        }

        //for organizar 
        if (uno == '1') {
            fin += uno;
        }
        for (int i = reves.length() - 1; i >= 0; i--) {
            fin += reves.charAt(i);
        }

        //imprimir respuesta final
        System.out.println("Suma: " + fin);
    }

    public static void contiene(String arg1, String arg2) {
        int equals = 0;
        int c2 = 0;

        for (int i = 0; i < arg1.length(); i++) {
            
            if (arg1.charAt(i) == arg2.charAt(c2)) {
                equals++;
                if (c2 < arg2.length()-1){
                    c2++;
                }
            } else if (equals != arg2.length()) {
                equals = 0;
                c2 = 0;

                if (arg1.charAt(i) == arg2.charAt(c2)) {
                    equals++;
                    c2++;
                }

            }

        }

        if (equals == arg2.length()) {
            System.out.printf("La cadena %s contiene la cadena %s", arg1, arg2);
        } else {
            System.out.printf("La cadena %s no contiene la cadena %s", arg1, arg2);
        }

    }
    
    public static void alpha(String arg1){
        String check = arg1.toLowerCase();
        
        int noes = 0; 
        for (int i = 0; i < check.length(); i++){
            //a - 97   z - 122
            int es = 0;
            for (int j = 97; j <= 122; j++){
                if (j ==  (int) check.charAt(i)){
                    es++;
                }
            }
            if (es == 0){
                noes++;
            }
        }
        
        if (noes == 0){
            System.out.println("La cadena solo contiene letras");
        }else{
            System.out.println("La cadena no solo contiene letras");
        }
    }

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);

        int menu;
        do {
            System.out.println("\n\nMenu\n");
            System.out.println("1- Suma de binario");
            System.out.println("2- contains");
            System.out.println("3- alpha");
            System.out.println("4- salida");
            System.out.print("Ingrese opcion: ");
            menu = lea.nextInt();

            switch (menu) {
                case 1:
                    //suma binario
                    System.out.println("\n--Opcion suma binarios--\n");
                    System.out.println("Ingrese 2 numeros binarios DE LONGITUDES IGUALES");
                    int check = 0;
                    String bin1;
                    String bin2;
                    //chequeo de entradas
                    int x = 0;
                    int y1 = 0;
                    int y2 = 0;
                    do {
                        if (x != 0){
                            System.out.println("Ingrese numeros nuevos");
                        }
                        y1 = 0;
                        y2 = 0;
                        do {
                            if (y1 != 0){
                              System.out.println("Ingrese numero valido");
                            }
                            check = 0;
                            System.out.print("Ingrese binario 1: ");
                            bin1 = lea.next();
                            for (int i = 0; i < bin1.length(); i++) {
                                if (bin1.charAt(i) != '0' && bin1.charAt(i) != '1') {
                                    check++;
                                }

                            }
                            y1++;

                        } while (check != 0);

                        do {
                            if (y2 != 0){
                                System.out.println("Ingrese numero valido");
                            }
                            check = 0;
                            System.out.print("Ingrese binario 2: ");
                            bin2 = lea.next();
                            for (int i = 0; i < bin2.length(); i++) {
                                if (bin2.charAt(i) != '0' && bin2.charAt(i) != '1') {
                                    check++;
                                }

                            }
                            y2++;
                         
                        } while (check != 0);
                        x++;
                    } while (bin1.length() != bin2.length());
                    //metodo suma
                    sumaBinarios(bin1, bin2);
                    break;
                case 2:
                    //opcion contains
                    System.out.println("Ingrese 2 cadenas. La segunda debe ser menor que la primera");
                    String cad1;
                    String cad2;
                    x = 0;
                    do {
                        if (x != 0){
                            System.out.println("Ingrese cadenas validas");
                        }
                        System.out.print("Ingrese cadena contenedora: ");
                        lea.nextLine();
                        cad1 = lea.nextLine();

                        System.out.print("Ingrese cadena contenida: ");
                        cad2 = lea.nextLine();
                        x++;
                    } while (cad2.length() > cad1.length());

                    contiene(cad1, cad2);
                    break;
                case 3:
                    //opcion alpha
                    System.out.print("Ingrese cadena: ");
                    lea.nextLine();
                    cad1 = lea.nextLine();
                    
                    alpha(cad1);
                    
                    break;

            }
        } while (menu != 4);
    }
}
