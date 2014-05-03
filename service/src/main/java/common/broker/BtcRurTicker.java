package common.broker;

import common.utils.HttpUtils;

import java.util.List;

/**
 * User: a.arzamastsev Date: 17.03.14 Time: 17:01
 */
public class BtcRurTicker implements Runnable {
    List<TickRecord> rec;

    public BtcRurTicker(List<TickRecord> records){
        this.rec = records;
    }

    public void run() {
        String url = "https://btc-e.com/api/2/btc_rur/ticker";
        String course = HttpUtils.httpGet(url);
        if (course !=null)  {
            TickRecord tr = new TickRecord(course);
            rec.add(tr);
        }
    }
}
