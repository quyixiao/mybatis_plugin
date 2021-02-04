package com.admin.crawler.entity;

public class TableInfo {
    private String columnName;
    private String dataType;
    private String columnComment;

    public TableInfo() {

    }

    public TableInfo(String columnName, String dataType, String columnComment) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.columnComment = columnComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
