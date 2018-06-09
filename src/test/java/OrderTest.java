import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    @Test
    public void shouldReturnIsEqual() throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date dtBeg = simFormat.parse("2008.01.23 22:45:56");
        Date dtBeg2 = simFormat.parse("2008.01.23 22:45:56");

        assertEquals(DateUtil.dateIsEqual(dtBeg, dtBeg2), true);
    }

    @Test(expected = RuntimeException.class)
    public void shouldInitOrder() {
        Order order = new Order();
        order.initByOrderStr("fsldkfjslkd");
    }

    @Test
    public void shouldBookACourt() {
        Order order = new Order();
        order.initByOrderStr("U002 2017-08-01 19~22 A");
        Manager manager = new Manager();
        manager.book(order);
        Interval expectInterval = new Interval(19, 22, "2017-08-01","U002");
        assertEquals(expectInterval, manager.getCourtMap().get("A").getIntervalsMap().get("2017-08-01").get(0));
    }

    @Test
    public void shouldCancel() {
        Order order = new Order();
        order.initByOrderStr("U002 2017-08-01 19~22 A");
        Order cancelOrder = new Order();
        cancelOrder.initByOrderStr("U002 2017-08-01 19~22 A C");
        Manager manager = new Manager();
        manager.book(order);
        Interval expectInterval = new Interval(19, 22, "2017-08-01","U002");
        assertEquals(expectInterval, manager.getCourtMap().get("A").getIntervalsMap().get("2017-08-01").get(0));
        manager.cancel(cancelOrder);
        assertEquals(0, manager.getCourtMap().get("A").getIntervalsMap().get("2017-08-01").size());
    }
}

