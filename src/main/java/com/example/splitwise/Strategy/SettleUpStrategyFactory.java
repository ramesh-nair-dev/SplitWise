package com.example.splitwise.Strategy;

import com.example.splitwise.models.SettleUpStrategyType;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(SettleUpStrategyType settleUpStrategyType){
        if(settleUpStrategyType.equals(SettleUpStrategyType.HEAP)){
            return new HeapStrategy();
        }
        return null;
    }
}
