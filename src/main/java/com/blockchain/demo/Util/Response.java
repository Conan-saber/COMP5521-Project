package com.blockchain.demo.Util;

import java.util.Date;
import java.util.Objects;

/**
 * @author conanlee
 */
public class
Response {
    private Integer code;
    private String msg;
    private String token;
    private String username;


    public Response(Integer code, String username, String msg, String token) {
        this.code = code;
        this.username = username;
        this.msg = msg;
        this.token = token;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", username='" + username + '\'' +
                ", msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Response response = (Response) o;
        return Objects.equals(code, response.code) &&
                Objects.equals(username, response.username) &&
                Objects.equals(msg, response.msg) &&
                Objects.equals(token, response.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, username, msg, token);
    }
}
