package broker.utils;

import common.TickRecord;
import common.utils.RecordsTube;

/**
 * Created by aksndr on 26.05.14.
 */
public class Advisor {

    public static Operation getAdvice(RecordsTube<TickRecord> rt) {
        if (rt.size() < 3) return Operation.Wait;

        TickRecord first = (TickRecord) rt.get(0);
        TickRecord second = (TickRecord) rt.get(1);
        TickRecord third = (TickRecord) rt.get(2);

        if (first.getLast() < second.getLast() &&
                second.getLast() < third.getLast() &&
                third.getLast().equals(third.getHigh())) {
            return Operation.Sell;
        }
        if (first.getLast() > second.getLast() &&
                second.getLast() > third.getLast() &&
                third.getLast().equals(third.getLow())) {
            return Operation.Buy;
        }
        return Operation.Wait;
    }


}
