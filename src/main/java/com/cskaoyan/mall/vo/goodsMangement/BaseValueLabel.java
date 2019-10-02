package com.cskaoyan.mall.vo.goodsMangement;

/**
 * category , brand 的返回参数
 */
public class BaseValueLabel {
    private int value;

    private String label;

    public BaseValueLabel() {
    }

    public BaseValueLabel(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
