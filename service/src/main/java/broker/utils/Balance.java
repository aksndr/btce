package broker.utils;

/**
 * Created by aksndr on 26.05.14.
 */
public class Balance {
    public Balance(Double balance) {
        this.balance = balance;
        this.balanceType = BalanceType.Rur;
    }

    private Double balance;
    private BalanceType balanceType;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }
}
