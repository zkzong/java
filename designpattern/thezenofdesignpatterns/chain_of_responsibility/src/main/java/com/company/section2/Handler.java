package com.company.section2;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 父系社会，那就是男性有至高权利，handler控制权
 */
public abstract class Handler {
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;
    //能处理的级别
    private int level = 0;

    //责任传递，下一个人责任人是谁
    private Handler nextHanlder;

    //每个类都要说明一下自己能处理哪些请求
    public Handler(int _level) {
        this.level = _level;
    }

    //一个女性（女儿，妻子或者是母亲）要求逛街，你要处理这个请求
    public final void HandleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHanlder != null) {  //有后续环节，才把请求往后递送
                this.nextHanlder.HandleMessage(women);
            } else { //已经没有后续处理人了，不用处理了
                System.out.println("-----------没地方请示了，按不同意处理---------\n");
            }

        }
    }

    /*
     * 如果你属于你处理的返回，你应该让她找下一个环节的人，比如
     * 女儿出嫁了，还向父亲请示是否可以逛街，那父亲就应该告诉女儿，应该找丈夫请示
     */
    public void setNext(Handler _handler) {
        this.nextHanlder = _handler;
    }

    //有请示那当然要回应
    protected abstract void response(IWomen women);
}
