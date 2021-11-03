package com.util.orderno;

/**
 * * 枚举用来规范编码输出规范，可以自定义
 * eg: DB0001911220001,TR000191122000001,GD000191122000001
 */

public enum EnumUtil {
    PO("PO", "yyMMddHHmmss", 1000),
    //结算
    JS("JS", "yyMMdd", 1000),

    DRIVER_BOOK("DB", "HHmmss", 1000);

    private EnumUtil(String prefix, String format, int capacity) {
        this.prefix = prefix;
        this.format = format;
        this.capacity = capacity;
    }

    private String prefix;
    private String format;
    private int capacity;

    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
