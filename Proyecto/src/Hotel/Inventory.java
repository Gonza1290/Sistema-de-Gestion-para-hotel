
package Hotel;

import Exceptions.ErrorInventory;

public class Inventory {
    private String type;
    private String status;
    private static int i= 0;                                          //variable para controlar instancias de inventory

    public Inventory(String type, String status) throws ErrorInventory {
        if(i>=2) {
            throw new ErrorInventory ("No se pueden instanciar 3 objetos de Inventory, error producido en clase Inventory");
        }else {
            this.type = type;
            this.status = status;
            System.out.println("Inventory");
            i = i + 1;            
        }
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  
    
}
