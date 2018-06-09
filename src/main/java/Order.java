import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int start, end;
    private String date, court;
    private Boolean cancel=false;
    private String userId;
    private double price=0;

    public void initByOrderStr(String orderStr)
    {
        String[] elements=orderStr.split(" ");
        if (elements.length == 4 || elements.length == 5) {
            userId = elements[0];
            date = elements[1];
            String[] time = elements[2].split("~");
            start = Integer.parseInt(time[0]);
            end = Integer.parseInt(time[1]);
            if (elements.length == 5 && elements[4] == "C")
                cancel = true;
            court = elements[3];
            //if() format is not valid
        } else {
            throw new RuntimeException();
        }

    }

    public Date stringToDate(String string) throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return simFormat.parse("2008.01.23 22:45:56");
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
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
}
