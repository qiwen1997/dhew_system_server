package com.dhew_server.vo;

/**
 * 用户账号表
 */
public class UserLoginVo {
    Integer user_id; //用户id
    String user_phone; //用户手机（用户名）
    String  user_password; //用户密码

    public UserLoginVo() {
    }

    public UserLoginVo(String user_phone, String user_password) {
        this.user_phone = user_phone;
        this.user_password = user_password;
    }

    public UserLoginVo(Integer user_id, String user_phone, String user_password) {
        this.user_id = user_id;
        this.user_phone = user_phone;
        this.user_password = user_password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "user_id=" + user_id +
                ", user_phone='" + user_phone + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLoginVo)) return false;

        UserLoginVo that = (UserLoginVo) o;

        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null) return false;
        if (user_phone != null ? !user_phone.equals(that.user_phone) : that.user_phone != null) return false;
        return user_password != null ? user_password.equals(that.user_password) : that.user_password == null;
    }

    @Override
    public int hashCode() {
        int result = user_id != null ? user_id.hashCode() : 0;
        result = 31 * result + (user_phone != null ? user_phone.hashCode() : 0);
        result = 31 * result + (user_password != null ? user_password.hashCode() : 0);
        return result;
    }
}
