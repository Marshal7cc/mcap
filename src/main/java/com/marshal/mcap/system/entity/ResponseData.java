package com.marshal.mcap.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/10/26
 * Time: 14:37
 * Description:返回数据
 */
public class ResponseData implements Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long total;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List rows;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public ResponseData() {
    }

    public ResponseData(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public ResponseData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseData(long total, List rows, boolean success, String message) {
        this.total = total;
        this.rows = rows;
        this.success = success;
        this.message = message;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
