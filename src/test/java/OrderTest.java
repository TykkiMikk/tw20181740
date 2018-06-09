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
}
