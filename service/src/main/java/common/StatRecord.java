package common;

import broker.utils.Operation;
import common.utils.RecordsTube;

/**
 * Created by aksndr on 26.05.14.
 */
public class StatRecord {
    private String time;
    private RecordsTube<TickRecord> rt;
    private Operation opType;
    private Double balanceInRur;

    public StatRecord(String time, RecordsTube<TickRecord> rt, Operation opType, Double balanceInRur) {
        this.time = time;
        this.rt = rt;
        this.opType = opType;
        this.balanceInRur = balanceInRur;
    }

    @Override
    public String toString() {
        return "Time: " + getTime() + ".  Operation: " + opType + ". Balance in Rur: " + balanceInRur;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public RecordsTube<TickRecord> getRt() {
        return rt;
    }

    public void setRt(RecordsTube<TickRecord> rt) {
        this.rt = rt;
    }

    public Operation getOpType() {
        return opType;
    }

    public void setOpType(Operation opType) {
        this.opType = opType;
    }

    public Double getBalanceInRur() {
        return balanceInRur;
    }

    public void setBalanceInRur(Double balanceInRur) {
        this.balanceInRur = balanceInRur;
    }
}
