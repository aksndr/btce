package common.broker;

import common.utils.HttpUtils;

import java.util.List;

/**
 * User: a.arzamastsev Date: 17.03.14 Time: 17:01
 */
public class BtcRurTicker implements Runnable {
    private static String course;
    private static TickRecord tr;
    List<TickRecord> rec;

    public BtcRurTicker(List<TickRecord> records){
        this.rec = records;
    }

    public static void setCourse(String course) {
        BtcRurTicker.course = course;
    }

    public void run() {
        String url = "https://btc-e.com/api/2/btc_rur/ticker";
        course = HttpUtils.httpGet(url);
        if (course!=null)  {
            tr = new TickRecord(course);
            rec.add(tr);
        }
    }
}
