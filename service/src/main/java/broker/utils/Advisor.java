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
                isNear(third.getLast(), third.getBuy(), Tendency.up)) {
            return Operation.Sell;
        }
        if (first.getLast() > second.getLast() &&
                second.getLast() > third.getLast() &&
                isNear(third.getLast(), third.getSell(), Tendency.down)) {
            return Operation.Buy;
        }
        return Operation.Wait;
    }

    private static boolean isNear(Double last, Double bound, Tendency tn) {
        Double fluctuation = 100.0;

        if (last<bound && last>(bound-fluctuation)&& tn.equals(Tendency.up)) {
            return true;
        }

        if (last>bound && last<(bound+fluctuation)&& tn.equals(Tendency.down)) {
            return true;
        }

        return false;

    }
}
