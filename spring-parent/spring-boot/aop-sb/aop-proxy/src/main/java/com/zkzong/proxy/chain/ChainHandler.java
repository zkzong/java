package com.zkzong.proxy.chain;

public abstract class ChainHandler {
    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();
}
