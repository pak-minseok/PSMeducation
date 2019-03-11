package itm.com.psmeducation;

/**
 * Created by myeongjin on 2015-10-30.
 */

public class Cu_Time {
    int time;
    public Cu_Time(int time){
        this.time=time;

    }
    public int getTime(){
        time = (int) System.currentTimeMillis();
        return time;
    }


}
