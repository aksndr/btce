package example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * User: a.arzamastsev Date: 03.05.14 Time: 15:48
 */
public class MillsToDateTest {
    @org.junit.Test
    public void test() throws Exception {
        String retVal = "";
        retVal = getDate();
        Long id = getCurrTimeInMills();

        assertNotNull(retVal);
        assertNotNull(id);
    }
    private String getDate() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date(getCurrTimeInMills());
            return (df.format(date));
    }

    private Long getCurrTimeInMills(){
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }
}
