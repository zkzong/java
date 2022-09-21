package org.example.itext.sign.bean;

public class KeyWordBean implements Comparable {
    public KeyWordBean() {
        super();
    }

    public KeyWordBean(float x, float y, int page, String text) {
        super();
        this.x = x;
        this.y = y;
        this.page = page;
        this.text = text;
    }

    private float x;
    private float y;
    private int page;
    private String text;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "KeyWordBean [x=" + x + ", y=" + y + ", page=" + page
                + ", text=" + text + "]";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof KeyWordBean) {
            KeyWordBean bean = (KeyWordBean) o;
            int i = (int) (bean.getY() - this.getY());//先按照Y轴排序
            if (i == 0) {
                return (int) (this.x - bean.getX());//如果Y轴相等了再按X轴进行排序
            }
            return i;
        }
        return 0;
    }
}
