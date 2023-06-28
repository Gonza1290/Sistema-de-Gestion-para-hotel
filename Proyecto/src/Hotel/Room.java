
package Hotel;

public class Room {
    private int roomNro;
    private String location;
    private String state;                      //variable que indica el estado de la habitacion

    public Room(int roomNro, String location) {
        this.roomNro = roomNro;
        this.location = location;
        System.out.println("Room");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRoomNro() {
        return roomNro;
    }
 
}
