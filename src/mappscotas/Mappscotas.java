/*
 Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo 
 String. El programa pedirá una raza de perro en un bucle, el mismo se guardará 
 en la lista y después se le preguntará al usuario si quiere guardar otro perro
 o si quiere salir. Si decide salir, se mostrará todos los perros guardados en 
 el ArrayList.

 Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
 un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
 está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
 ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
 la lista ordenada.
*/
package mappscotas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Leonardo Alvez
 */
public class Mappscotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ///Construimos un scanner para tomar la entrada del usuario.
        Scanner leer = new Scanner(System.in);
        ///Creamos una Lista donde guardaremos las razas.
        ArrayList<String> razas = new ArrayList();
        ///Generamos una variable del tipo String para la opción del bucle
        String opcion = "";

        ///Utilizamos un bucle do while donde lo que esté en do{} se vuelve a 
        ///ejecutar mientra las condición de while(la opción del usuario).
        do {
            System.out.println("Ingrese el nombre de la raza");
            String raza = leer.next();
            razas.add(raza);
            System.out.println("Desea continuar? si/no");
            opcion = leer.next();
        } while (opcion.equalsIgnoreCase("si"));
        
        System.out.println("La lista quedo conformada así:");
        //Luego recorremos la lista con un bucle for para mostrarlos.
        for (String raza : razas) {
            System.out.println(raza);
        }
        
        ///Pedimos al usuario que ingre la raza a buscar
        System.out.println("Ingrese la raza a eliminar");
        String razaABuscar = leer.next();
        
        ///Generamos un iterator para recorrer razas 
        Iterator<String> itRaza = razas.iterator();
        ///Generamos un contador que cuente las razas que se eliminaron
        int contador = 0;
        ///Armamos un bucle que recorra con el iterador y elimine la raza
        while (itRaza.hasNext()){
            if (itRaza.next().equalsIgnoreCase(razaABuscar)){
                itRaza.remove();
                contador++;
            }
        }
        ///Ordenamos la lista
        Collections.sort(razas); 
        
        ///Generamos un condicional donde si se elimino una raza mostramos la 
        ///lista ordenada y si no (else) informamos que no se encontró la raza.
        
        if (contador > 0){    
            System.out.println("La lista actualizada después de eliminar es:");
            for (String raza : razas) {
          
          System.out.println(raza);
            }
        } else {
            System.out.println("No se ha encontrado la raza en la lista por"
                    + " lo cuál no se eliminaron elementos");
            for (String raza : razas) {
                System.out.println(raza);    
            }            
        }
        
    }
}