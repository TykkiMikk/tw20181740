import java.util.Objects;

public class Interval{
    private int start,end;
    private String day;

    public Interval(int start, int end,String day) {
        this.start = start;
        this.end = end;
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start &&
                end == interval.end &&
                Objects.equals(day, interval.day);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end, day);
    }
}