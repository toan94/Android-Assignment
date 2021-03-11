package toan.bui.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class dummyData {

    private String time;
    private int icon;
    private double degree;

    public static ArrayList<dummyData> dummyDataList;
    static { //test data
        dummyDataList = new ArrayList<dummyData>();
        dummyDataList.add(new dummyData("1", R.drawable.icon, 20.3));
        dummyDataList.add(new dummyData("1", R.drawable.icon, 20.3));
        dummyDataList.add(new dummyData("1", R.drawable.icon, 21));
        dummyDataList.add(new dummyData("1", R.drawable.icon, 22.3));
    }

    public dummyData(String time, int icon, double degree) {
        this.time = time;
        this.icon = icon;
        this.degree = degree;
    }
    public String getTime(){return this.time;}
    public int getIcon(){return this.icon;}
    public double getDegree(){return this.degree;}

    public static String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }


}
