
package Hotel;

import java.util.ArrayList;

public class Guest {
    private String name;
    private int id;
    private int phoneNro;
    private String address;
    private int roomNro;
    private Bill bill;
    private Room room;                                                             //Atributo que guarda la room designada al Guest

    public Guest(String name, int id, int phoneNro, String address) {
        this.name = name;
        this.id = id;
        this.phoneNro = phoneNro;
        this.address = address;
        System.out.println("Guest");
    }
    
    /* 
    * Este metodo registra la entrada al huesped (Guest) en el hotel, se verifica que haya una habitacion disponible,
    * si la hay se asigna la misma al huesped, se cambia el estado de la habitacion a no disponible
    * y se agrega al huesped a un arraylist del administrador, si no hay habitacion disponible se emite un mensaje.
    */
    public void checkIn(Manager M, Receptionist R) {
        if(R.checkRoomAvailabity() != null) {
            Room room = R.checkRoomAvailabity();
            this.setRoom(room);
            this.roomNro = room.getRoomNro();
            room.setState("not available");
            M.registeInCostumer(this); 
        }else {
            System.out.println("No hay habitaciones disponibles para: " + this.getName());
        }
    }
    
    /* 
    * Este metodo registra la salida del huesped del hotel, el mismo genera una factura,se paga la factura,
    * se borra al husped del arraylist del administrador y se cambia el estado de su habitacion como disponible.
    */
    public void checkout(Manager M, Receptionist R) {
        R.generateBill(this, 2500);
        this.payBill();
        M.registerOutCostumer(this);
        this.room.setState("available");
        this.room = null;
        this.roomNro = 0;
        
    }
    
    /* 
    * Este metodo verifica si hay comida en el inventario y si su estado es disponible, si la hay cambia su estado a no disponible,
    * sino emite un mensaje
    */
    public void orderFood(Manager M) {
        for(Inventory I : M.getInventory()) {
            if(I.getType() == "Food") {
                if(I.getStatus() == "available") {
                    I.setStatus("not available");
                    System.out.println("Se entrega la orden de comida al Guest "+ this.getName());
                }else {
                    System.out.println("No hay comida disponible en el inventario para el Guest "+ this.getName());
                }
            }
        }
    }
    
    /* Este metodo genera una queja */
    public void submitFeedBack(Receptionist R) {
        FeedBack fb = new FeedBack();
        R.acceptCustumerFeedBack(fb);
    }

    /* Este metodo cambia en estado de la factura del Guest a Pagado*/
    public void payBill() {
        this.bill.setState("Pagado");
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoomNro() {
        return roomNro;
    }
  
}
