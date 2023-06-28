
package Main;

import Exceptions.ErrorInventory;
import Hotel.Guest;
import Hotel.Manager;
import Hotel.Receptionist;
import Hotel.Room;

public class Proyecto {

    public static void main(String[] args) {
         Manager M01 = new Manager("Diego",533,2612135,"Piso 1");                                       
         Receptionist R01 = M01.managerStaff("Julia",205,2612351,"Piso 0");
         try {
            M01.purchaseInventory("Food");
            M01.purchaseInventory("Wine");
            M01.purchaseInventory("Water");
         }catch(ErrorInventory E){
            System.out.println(E.getMessage()); 
        }
         Room room01 = new Room(01,"Piso 1");
         Room room02 = new Room(02,"Piso 1");
         R01.bookRoom(room01);
         R01.bookRoom(room02);
         Guest G01 = new Guest("Juan",231,2612312,"Calle Roca");
         Guest G02 = new Guest("Mario",131,2611235,"Calle Rioja");
         Guest G03 = new Guest("Ana",521,2613435,"Calle Ropolo");
         System.out.println("Se registra entrada de Juan, Mario y Ana en hotel");
         G01.checkIn(M01, R01);
         G02.checkIn(M01, R01);
         G03.checkIn(M01, R01);
         for(Guest g : M01.getGuests()) {
            System.out.println("A " + g.getName() + " se le asigno la room Nro " + g.getRoomNro());
         }
         for(Room r : R01.getRooms()) {
            System.out.println("Estado de room Nro " + r.getRoomNro() + " es: " + r.getState());
         } 
         G01.orderFood(M01);
         G02.orderFood(M01);
         M01.recordComplaints(G02.getName(),"Falta de comida");                                        //El Guest02 genera una queja con el Manager
         System.out.println("Se registra salida de Juan en hotel");
         G01.checkout(M01, R01);
         for(Room r : R01.getRooms()) {
            System.out.println("Estado de room Nro "+r.getRoomNro()+ " es: "+ r.getState());
         }
         G01.submitFeedBack(R01);                                                                       //El Guest01 genera un comentario con el Receptionist 
    }
    
}
