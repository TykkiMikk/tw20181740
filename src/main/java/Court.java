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
            this.intervalsMap.put(day, Collections.singletonList(cur));
            bookSuccess=true;
        }
        else{
            if(orderedIntervalsForDay.size()==0)
            {
                orderedIntervalsForDay.add(cur);
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
                        orderedIntervalsForDay.add(i,cur);
                        insertInList=true;
                        bookSuccess=true;
                        break;
                    }
                }
                if(!insertInList)
                {
                    if(start>orderedIntervalsForDay.get(length-1).getEnd()) {
                        orderedIntervalsForDay.add(cur);
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
}
