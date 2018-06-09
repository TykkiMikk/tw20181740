import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private Interval interval;
    private String courtName;
    private Boolean cancel=false;
    private String userId;
    private double price=0;

    public void initByOrderStr(String orderStr)
    {
        String[] elements=orderStr.split(" ");
        if (elements.length == 4 || elements.length == 5) {
            String userId = elements[0];
            this.userId=userId;
            String day = elements[1];
            String[] time = elements[2].split("~");
            int start = Integer.parseInt(time[0]);
            int end = Integer.parseInt(time[1]);
            this.interval=new Interval(start,end,day,userId);
            if (elements.length == 5 && elements[4] == "C")
                cancel = true;
            courtName = elements[3];
            //if() format is not valid
        } else {
            throw new RuntimeException();
        }

    }



    public Date stringToDate(String string) throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return simFormat.parse("2008.01.23 22:45:56");
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }



    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void book() {

    }
}
