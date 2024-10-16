package com.shenlan.springboot.entity;


import com.alibaba.excel.annotation.ExcelProperty;

public class MyEntity {

    @ExcelProperty("Column1")
    private String column1;

    @ExcelProperty("Column2")
    private String column2;

    @ExcelProperty("Column3")
    private String column3;

    @ExcelProperty("Column4")
    private String column4;

    @ExcelProperty("Column5")
    private String column5;

    @ExcelProperty("Column6")
    private String column6;

    @ExcelProperty("Column7")
    private String column7;

    // 构造函数和 getter/setter 方法
    public MyEntity(String column1, String column2, String column3, String column4, String column5, String column6, String column7) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
        this.column5 = column5;
        this.column6 = column6;
        this.column7 = column7;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn7() {
        return column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }
// getter 和 setter
}

