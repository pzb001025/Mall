package com.angle.mvplib.data.entity;
//  封装一个Bean类
public class HttpReult<D> {

    /*  {
          'code': '状态码', 'message': '相关提示', 'data': '数据包'
      }*/
    private int code;
    private String message;
    private D data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
