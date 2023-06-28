
package Hotel;

import Exceptions.ErrorInventory;
import java.util.ArrayList;

public class Manager {
    
    private String name;
    private int id;
    private int phoneNro;
    private String location;
    private ArrayList<Inventory> inventory = new ArrayList<>();                                       //ArrayList para guardar los objetos de inventario
    private ArrayList<Guest> guests = new ArrayList<>();                                              //ArrayList para guardar los Guest registrados en el hotel
    private ArrayList<Complaint> complaints = new ArrayList<>();                                      //ArrayList para guardar las quejas de los clientes

    public Manager(String name, int id, int phoneNro, String location) {
        this.name = name;
        this.id = id;
        this.phoneNro = phoneNro;
        this.location = location;  
        System.out.println("Manager");
    }
    
    /* Este metodo agrega un objeto de Inventory al arraylist invetory, con el tipo especificado */
    public void purchaseInventory(String type) throws ErrorInventory {
        inventory.add(new Inventory(type,"available"));  
    }
    
    /* Este metodo genera una queja de un huesped y la guarda en un arraylist junto con su descripcion */
    public void recordComplaints(String guestName,String description) {
        complaints.add(new Complaint(guestName,description)); 
    }
    
    /* Esta funcion agrega un recepcionista al personal, junto con sus datos y retorna el mismo */
    public Receptionist managerStaff(String name, int id, int phoneNro, String location) {
        Receptionist R1 = new Receptionist(name, id, phoneNro, location);
        return R1;
    }
    
    /* Este metodo agrega a un Guest al arraylist guests */ 
    public void registeInCostumer(Guest G) {
        guests.add(G);
    }
    
     /* Este metodo elimina a un Guest del arraylist guests */ 
    public void registerOutCostumer(Guest G) {
        guests.remove(G);
    }

    public ArrayList<Inventory> getInventory() {
        return inventory;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    } 
}
