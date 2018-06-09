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

    public void book(Order order) {
        if (!order.getCancel()) {
            String courtName = order.getCourtName();
            courtMap.get(courtName).bookNewOrder(order);//return booksuccess
//        } else {
//
        }
    }

    public Map<String, Court> getCourtMap() {
        return courtMap;
    }

    public void setCourtMap(Map<String, Court> courtMap) {
        this.courtMap = courtMap;
    }
}
