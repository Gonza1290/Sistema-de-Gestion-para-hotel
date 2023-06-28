
package Hotel;

/*
* Clase Auxiliar para las quejas de los huespedes (Guests)
*/
public class Complaint {
    private String guestName;
    private String description;

    public Complaint(String guestName, String description) {
        this.guestName = guestName;
        this.description = description;
        System.out.println("Complaint");
    }
      
}
