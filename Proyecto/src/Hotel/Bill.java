
package Hotel;

public class Bill {
    private int billNro;
    private String guestName;
    private String state;

    public Bill(int billNro, String guestName, String state) {
        this.billNro = billNro;
        this.guestName = guestName;
        this.state = state;                                     //esta variable sirve para ver el estado de la factura (Pagado o impago)
        System.out.println("Bill");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
