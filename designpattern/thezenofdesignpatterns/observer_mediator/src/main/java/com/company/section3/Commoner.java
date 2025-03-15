package com.company.section3;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Commoner extends EventCustomer {

    //����ƽ���ܹ������¼��ļ���
    public Commoner() {
        super(EventCustomType.NEW);
    }

    @Override
    public void exec(ProductEvent event) {
        //�¼���Դͷ
        Product p = event.getSource();
        //�¼�����
        ProductEventType type = event.getEventType();
        System.out.println("ƽ�����¼�:" + p.getName() + "������,�¼�����=" + type);
    }

}
