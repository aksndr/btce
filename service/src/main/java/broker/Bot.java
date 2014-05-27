package broker;

import broker.utils.Advisor;
import broker.utils.Balance;
import broker.utils.BalanceType;
import broker.utils.Operation;
import common.StatRecord;
import common.TickRecord;
import common.utils.RecordsTube;

import java.util.Date;
import java.util.List;

/**
 * Created by aksndr on 26.05.14.
 */
public class Bot implements Runnable {

    public Bot(Double balanceIntRur, RecordsTube<TickRecord> rt, List<StatRecord> statistic) {
        this.balance = new Balance(balanceIntRur);
        this.rt = rt;
        this.statistic = statistic;
    }

    public Bot(RecordsTube<TickRecord> rt, List<StatRecord> statistic) {
        this.balance = new Balance((double) 2000);
        this.rt = rt;
        this.statistic = statistic;
    }

    Balance balance;
    Double startAtBtcCourse;
    RecordsTube<TickRecord> rt;
    List<StatRecord> statistic;


    @Override
    public void run() {
        Operation advice = Advisor.getAdvice(rt);
        BalanceType bType = balance.getBalanceType();
        if (!advice.equals(Operation.Wait))  {
            System.out.println(advice);
        }
        startAtBtcCourse = ((TickRecord) rt.get(0)).getLast();
        if (advice.equals(Operation.Buy) && bType.equals(BalanceType.Rur)) {
            makeBet(((TickRecord) rt.get(1)).getLast(), advice);
        }
        if (advice.equals(Operation.Sell) && bType.equals(BalanceType.Btc)) {
            makeBet(((TickRecord) rt.get(1)).getLast(), advice);
        }
    }

    private void makeBet(Double last, Operation advice) {
        if (advice.equals(Operation.Buy)) {
            Double rur = balance.getBalance();
            Double btc = rur / last;

            balance.setBalance(btc);
            balance.setBalanceType(BalanceType.Btc);

            StatRecord sr = new StatRecord(new Date().toString(), rt, advice, rur);
            statistic.add(sr);
            System.out.println("");
        }
        if (advice.equals(Operation.Sell)) {

            Double btc = balance.getBalance();
            Double rur = btc * last;

            balance.setBalance(rur);
            balance.setBalanceType(BalanceType.Rur);

            StatRecord sr = new StatRecord(new Date().toString(), rt, advice, rur);
            statistic.add(sr);
            System.out.println("Balance after sell: "+rur);
        }
    }
}
