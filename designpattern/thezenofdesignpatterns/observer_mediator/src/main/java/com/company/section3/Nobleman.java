package com.company.section3;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Nobleman extends EventCustomer {

    //��������ܹ������¼��ļ���
    public Nobleman() {
        super(EventCustomType.EDIT);
        super.addCustomType(EventCustomType.CLONE);
    }

    @Override
    public void exec(ProductEvent event) {
        //�¼���Դͷ
        Product p = event.getSource();
        //�¼�����
        ProductEventType type = event.getEventType();
        if (type.getValue() == EventCustomType.CLONE.getValue()) {
            System.out.println("���崦���¼�:" + p.getName() + "��¡,�¼�����=" + type);
        } else {
            System.out.println("���崦���¼�:" + p.getName() + "�޸�,�¼�����=" + type);
        }

    }

}