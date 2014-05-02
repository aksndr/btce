package common.broker;

import org.json.JSONObject;

/**
 * User: a.arzamastsev Date: 28.04.14 Time: 15:04
 */
public class TickRecord {

    private Double high, low, avg, last, buy, sell;
    private Long time;

    public TickRecord(String tick) {
        JSONObject obj = new JSONObject(tick);
        JSONObject record = obj.getJSONObject("ticker");
        this.high = record.getDouble("high");
        this.low = record.getDouble("low");
        this.avg = record.getDouble("avg");
        this.last = record.getDouble("last");
        this.buy = record.getDouble("buy");
        this.sell = record.getDouble("sell");
        this.time = record.optLong("server_time");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TickRecord)) return false;

        TickRecord that = (TickRecord) o;

        if (avg != null ? !avg.equals(that.avg) : that.avg != null) return false;
        if (buy != null ? !buy.equals(that.buy) : that.buy != null) return false;
        if (high != null ? !high.equals(that.high) : that.high != null) return false;
        if (last != null ? !last.equals(that.last) : that.last != null) return false;
        if (low != null ? !low.equals(that.low) : that.low != null) return false;
        if (sell != null ? !sell.equals(that.sell) : that.sell != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }


    @Override
    public String toString(){
        return last.toString();
    }


    @Override
    public int hashCode() {
        int result = high != null ? high.hashCode() : 0;
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (avg != null ? avg.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + (buy != null ? buy.hashCode() : 0);
        result = 31 * result + (sell != null ? sell.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
