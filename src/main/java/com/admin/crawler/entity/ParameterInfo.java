package com.admin.crawler.entity;

import com.admin.crawler.utils.StringUtils;

import java.util.List;

public class ParameterInfo {
    private String param;

    private String column;

    private boolean isAnd = true;

    private boolean isOr;

    private boolean isEq = true;


    private boolean isNe;

    private boolean isGt;

    private boolean isLt;

    private boolean isGe;

    private boolean isLe ;

    private boolean isLike;

    private boolean isLLike;

    private boolean isRLike;


    private boolean isIn;

    private boolean notIn;

    private boolean isEmpty;

    private boolean isNull;

    private boolean isNotEmpty;

    private boolean isNotNull;

    private boolean isIF;
    private List<String> ifParams;

    private boolean ifNull;
    private List<String> ifNullParams;

    private boolean isDateFormat;
    private String dateFormatParam;

    private boolean isBy;
    private String byParam;

    public boolean isBy() {
        return isBy;
    }

    public void setBy(boolean by) {
        isBy = by;
    }

    public String getByParam() {
        return byParam;
    }

    public void setByParam(String byParam) {
        this.byParam = byParam;
    }

    public boolean isDateFormat() {
        return isDateFormat;
    }

    public void setDateFormat(boolean dateFormat) {
        isDateFormat = dateFormat;
    }

    public String getDateFormatParam() {
        return dateFormatParam;
    }

    public void setDateFormatParam(String dateFormatParam) {
        this.dateFormatParam = dateFormatParam;
    }

    public boolean isIF() {
        return isIF;
    }

    public void setIF(boolean IF) {
        isIF = IF;
    }

    public List<String> getIfParams() {
        return ifParams;
    }

    public void setIfParams(List<String> ifParams) {
        this.ifParams = ifParams;
    }

    public boolean isIfNull() {
        return ifNull;
    }

    public void setIfNull(boolean ifNull) {
        this.ifNull = ifNull;
    }

    public List<String> getIfNullParams() {
        return ifNullParams;
    }

    public void setIfNullParams(List<String> ifNullParams) {
        this.ifNullParams = ifNullParams;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        if(StringUtils.isEmpty(column)){ //如果设置的值为空，则默认不覆盖
            return ;
        }
        this.column = column;
    }

    private List<String> by;//By 注解，用于更新


    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isAnd() {
        return isAnd;
    }

    public void setAnd(boolean and) {
        isAnd = and;
    }

    public boolean isOr() {
        return isOr;
    }

    public void setOr(boolean or) {
        isOr = or;
    }

    public boolean isEq() {
        return isEq;
    }

    public void setEq(boolean eq) {
        isEq = eq;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }



    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }


    public boolean isNotIn() {
        return notIn;
    }

    public void setNotIn(boolean notIn) {
        this.notIn = notIn;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public boolean isNotEmpty() {
        return isNotEmpty;
    }

    public void setNotEmpty(boolean notEmpty) {
        isNotEmpty = notEmpty;
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public void setNotNull(boolean notNull) {
        isNotNull = notNull;
    }

    public List<String> getBy() {
        return by;
    }

    public void setBy(List<String> by) {
        this.by = by;
    }

    public boolean isNe() {
        return isNe;
    }

    public void setNe(boolean ne) {
        isNe = ne;
    }


    public boolean isGt() {
        return isGt;
    }

    public void setGt(boolean gt) {
        isGt = gt;
    }


    public boolean isLt() {
        return isLt;
    }

    public void setLt(boolean lt) {
        isLt = lt;
    }


    public boolean isGe() {
        return isGe;
    }

    public void setGe(boolean ge) {
        isGe = ge;
    }



    public boolean isLe() {
        return isLe;
    }

    public void setLe(boolean le) {
        isLe = le;
    }

    public boolean isLLike() {
        return isLLike;
    }

    public void setLLike(boolean LLike) {
        isLLike = LLike;
    }

    public boolean isRLike() {
        return isRLike;
    }

    public void setRLike(boolean RLike) {
        isRLike = RLike;
    }

    @Override
    public String toString() {
        return "ParameterInfo{" +
                "param='" + param + '\'' +
                ", column='" + column + '\'' +
                ", isAnd=" + isAnd +
                ", isOr=" + isOr +
                ", isEq=" + isEq +
                ", isNe=" + isNe +
                ", isGt=" + isGt +
                ", isLt=" + isLt +
                ", isGe=" + isGe +
                ", isLe=" + isLe +
                ", isLike=" + isLike +
                ", isLLike=" + isLLike +
                ", isRLike=" + isRLike +
                ", isIn=" + isIn +
                ", notIn=" + notIn +
                ", isEmpty=" + isEmpty +
                ", isNull=" + isNull +
                ", isNotEmpty=" + isNotEmpty +
                ", isNotNull=" + isNotNull +
                ", isIF=" + isIF +
                ", ifParams=" + ifParams +
                ", ifNull=" + ifNull +
                ", ifNullParams=" + ifNullParams +
                ", isDateFormat=" + isDateFormat +
                ", dateFormatParam='" + dateFormatParam + '\'' +
                ", isBy=" + isBy +
                ", byParam='" + byParam + '\'' +
                ", by=" + by +
                '}';
    }
}
