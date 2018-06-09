import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private Map<String, Court> courtMap = new HashMap<>();

    public Manager() {
        courtMap.put("A", new Court("A"));
        courtMap.put("B", new Court("B"));
        courtMap.put("C", new Court("C"));
        courtMap.put("D", new Court("D"));

    }

    public Boolean cancel(Order order)
    {
        Boolean operationSuccess =false;
        String courtName = order.getCourtName();
        return(courtMap.get(courtName).cancelOrder(order));
    }

    public Boolean book(Order order) {
        Boolean operationSuccess =false;
        String courtName = order.getCourtName();
        return(courtMap.get(courtName).bookNewOrder(order));//return booksuccess
    }

    public Map<String, Court> getCourtMap() {
        return courtMap;
    }

    public void setCourtMap(Map<String, Court> courtMap) {
        this.courtMap = courtMap;
    }
}
