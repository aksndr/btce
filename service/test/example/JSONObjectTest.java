package example;

/**
 * User: a.arzamastsev Date: 01.05.14 Time: 17:40
 */

import common.broker.TickRecord;
import common.utils.HttpUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JSONObjectTest {
    @org.junit.Test
    public void test() throws Exception {
        List<TickRecord> records = new ArrayList<TickRecord>(2);
        String url = "https://btc-e.com/api/2/btc_rur/ticker";
        String course = HttpUtils.httpGet(url);
        if (course!=null)  {
            TickRecord tr = new TickRecord(course);
            records.add(tr);
        }
        Thread.sleep(20*1000);
        course = HttpUtils.httpGet(url);
        if (course!=null)  {
            TickRecord tr = new TickRecord(course);
            records.add(tr);
        }

        String retVal = "";

        JSONObject jsonObj = new JSONObject();
        jsonObj.append("success",true);
        jsonObj.accumulate("ticker",records);

        retVal = jsonObj.toString();
        System.out.print(retVal);
        assertNotNull(retVal);
    }
}

