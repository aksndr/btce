package common.broker;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: a.arzamastsev Date: 28.04.14 Time: 15:04
 */
public class TickRecord {
    private Double high, low, avg, last, buy, sell;
    private Long id;
    private String time;

    public TickRecord(String tick) {
        JSONObject obj = new JSONObject(tick);
        JSONObject record = obj.getJSONObject("ticker");
        setHigh(record.getDouble("high"));
        setLow(record.getDouble("low"));
        setAvg(record.getDouble("avg"));
        setLast(record.getDouble("last"));
        setBuy(record.getDouble("buy"));
        setSell(record.getDouble("sell"));
        setId(getCurrTimeInMills());
        setTime(getDate());
    }

    private String getDate() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date(getCurrTimeInMills());
        return (df.format(date));
    }

    private Long getCurrTimeInMills(){
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TickRecord)) return false;

        TickRecord that = (TickRecord) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);
    }

    @Override
    public String toString(){
        return String.valueOf(getId());
    }


    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getLast() {
        return last;
    }

    public Double getBuy() {
        return buy;
    }

    public Double getSell() {
        return sell;
    }

    public String getTime() {
        return time;
    }
}
