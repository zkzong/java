package com.company.section4;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public abstract class State {

    //����һ��������ɫ���ṩ�������
    protected Context context;

    //���û�����ɫ
    public void setContext(Context _context) {
        this.context = _context;
    }

    //��Ϊ1
    public abstract void handle1();

    //��Ϊ2
    public abstract void handle2();
}
