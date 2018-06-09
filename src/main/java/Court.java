import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Court {
    private String name;
    private Map<String,List<Interval>> intervalsMap;


    public Court(String name) {
        this.name = name;
        intervalsMap = new HashMap<>();
    }

    public Boolean bookNewOrder(Order order) {
        Interval cur=order.getInterval();
        String day = cur.getDay();
        int start = cur.getStart();
        int end = cur.getEnd();
        Boolean bookSuccess=false;
        List<Interval> orderedIntervalsForDay=this.intervalsMap.get(day);
        if(orderedIntervalsForDay==null)
        {
            List<Interval> tempList = new ArrayList<>();
            tempList.add(cur);
            this.intervalsMap.put(day, tempList);
            bookSuccess=true;
        }
        else{
            if(orderedIntervalsForDay.size()==0)
            {
                this.intervalsMap.get(day).add(cur);
                bookSuccess=true;
            }
            else{
                Boolean insertInList=false;
                int length=orderedIntervalsForDay.size();
                for(int i=0;i<length;i++)
                {
                    if(end<orderedIntervalsForDay.get(i).getStart()&&
                            (i==0||orderedIntervalsForDay.get(i-1).getEnd()<start))
                    {
                        this.intervalsMap.get(day).add(i,cur);
                        insertInList=true;
                        bookSuccess=true;
                        break;
                    }
                }
                if(!insertInList)
                {
                    if(start>orderedIntervalsForDay.get(length-1).getEnd()) {
                        this.intervalsMap.get(day).add(cur);
                        bookSuccess = true;
                    }
                }
            }
        }
        return bookSuccess;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<Interval>> getIntervalsMap() {
        return intervalsMap;
    }

    public void setIntervalsMap(Map<String, List<Interval>> intervalsMap) {
        this.intervalsMap = intervalsMap;
    }

    public Boolean cancelOrder(Order order) {
        Boolean cancelSuccess=false;
        Interval cur=order.getInterval();
        String day = cur.getDay(),userId=order.getUserId();
        int start = cur.getStart();
        int end = cur.getEnd();
        List<Interval> canceledIntervalsForDay=this.intervalsMap.get(day);
        if(canceledIntervalsForDay==null||canceledIntervalsForDay.size()==0)
            return cancelSuccess;
        int length=canceledIntervalsForDay.size();
        for(int i=0;i<length;i++)
        {
            Interval cancelInterval=canceledIntervalsForDay.get(i);
            if(start==cancelInterval.getStart()&& end==cancelInterval.getEnd() && userId.equals(cancelInterval.getUserId()))
            {
                cancelSuccess=true;
                this.intervalsMap.get(day).remove(i);
                break;
            }
        }
        return cancelSuccess;
    }
}
