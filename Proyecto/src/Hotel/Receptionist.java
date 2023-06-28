
package Hotel;

import java.util.ArrayList;

public class Receptionist {
    private String name;
    private int id;
    private int phoneNro;
    private String location;
    private ArrayList<Room> rooms = new ArrayList<>();                                      //ArrayList para guardar las habitaciones del hotel
    private ArrayList<Bill> bills = new ArrayList<>();                                      //ArrayList para guardar todas las facturas 
    private ArrayList<FeedBack> feedBacks = new ArrayList<>();                              //ArrayList para guardar los comentarios de los huespedes

    public Receptionist(String name, int id, int phoneNro, String location) {
        this.name = name;
        this.id = id;
        this.phoneNro = phoneNro;
        this.location = location;
        System.out.println("Receptionist");
    }
    
    /*Este metodo agrega una habitacion al registro de habitaciones y la pone como disponible */
    public void bookRoom(Room r) {
        r.setState("available");
        rooms.add(r);
    }
    
    /*Esta funcion verifica si hay una habitacion disponible y si la hay la retorna, si no hay retorna null */
    public Room checkRoomAvailabity() {
        for(Room r : rooms) {
            if(r.getState() == "available") {
                return r;
            }
        }
        return null; 
    }
    
    /* 
    * Este metodo genera una factura con el nombre del huesped, el costo, y con estado impaga 
    * luego se la asigna al huesped y se guarda en el arraylist del recepcionista
    */
    public void generateBill(Guest G,int billNro) {
        Bill b = new Bill(billNro,G.getName(),"impago");
        G.setBill(b);
        this.bills.add(b);
    }
    
    /* Este metodo acepta una queja de un Guest */
    public void acceptCustumerFeedBack(FeedBack fb) {
        this.feedBacks.add(fb);
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }
       
}
