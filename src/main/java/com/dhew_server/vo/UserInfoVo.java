package com.dhew_server.vo;

import java.util.Date;

/**
 * 用户信息表
 */
public class UserInfoVo {
    Integer user_id; //用户id
    String user_phone; //用户手机号
    //有改动
    String dp_id="000000"; //部门编号
    String user_name; //用户昵称
    String user_sex; //用户性别
    Date user_birth; //用户出生年月日
    Double user_height; //用户身高
    Double user_weight; //用户体重
    String user_blood; //用户血型
    String user_realname; //用户真实姓名

    public UserInfoVo() {
    }

    public UserInfoVo(Integer user_id, String user_phone, String dp_id, String user_name, String user_sex) {
        this.user_id = user_id;
        this.user_phone = user_phone;
        this.dp_id = dp_id;
        this.user_name = user_name;
        this.user_sex = user_sex;
    }

    public UserInfoVo(Integer user_id, String user_phone, String dp_id, String user_name, String user_sex, Date user_birth, Double user_height, Double user_weight, String user_blood, String user_realname) {
        this.user_id = user_id;
        this.user_phone = user_phone;
        this.dp_id = dp_id;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_birth = user_birth;
        this.user_height = user_height;
        this.user_weight = user_weight;
        this.user_blood = user_blood;
        this.user_realname = user_realname;
    }
  //新添加的，没有dp_id
    public UserInfoVo(Integer user_id, String user_phone, String user_name, String user_sex, Date user_birth,
			Double user_height, Double user_weight, String user_blood, String user_realname) {
		super();
		this.user_id = user_id;
		this.user_phone = user_phone;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_birth = user_birth;
		this.user_height = user_height;
		this.user_weight = user_weight;
		this.user_blood = user_blood;
		this.user_realname = user_realname;
	}
    
  //新添加，无id
  	public UserInfoVo(String user_phone, String user_name, String user_sex, Date user_birth, Double user_height,
  			Double user_weight, String user_blood, String user_realname) {
  		super();
  		this.user_phone = user_phone;
  		this.user_name = user_name;
  		this.user_sex = user_sex;
  		this.user_birth = user_birth;
  		this.user_height = user_height;
  		this.user_weight = user_weight;
  		this.user_blood = user_blood;
  		this.user_realname = user_realname;
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

    public String getDp_id() {
        return dp_id;
    }

    public void setDp_id(String dp_id) {
        this.dp_id = dp_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public Date getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(Date user_birth) {
        this.user_birth = user_birth;
    }

    public Double getUser_height() {
        return user_height;
    }

    public void setUser_height(Double user_height) {
        this.user_height = user_height;
    }

    public Double getUser_weight() {
        return user_weight;
    }

    public void setUser_weight(Double user_weight) {
        this.user_weight = user_weight;
    }

    public String getUser_blood() {
        return user_blood;
    }

    public void setUser_blood(String user_blood) {
        this.user_blood = user_blood;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "user_id=" + user_id +
                ", user_phone='" + user_phone + '\'' +
                ", dp_id='" + dp_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_birth=" + user_birth +
                ", user_height=" + user_height +
                ", user_weight=" + user_weight +
                ", user_blood='" + user_blood + '\'' +
                ", user_realname='" + user_realname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfoVo)) return false;

        UserInfoVo that = (UserInfoVo) o;

        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null) return false;
        if (user_phone != null ? !user_phone.equals(that.user_phone) : that.user_phone != null) return false;
        if (dp_id != null ? !dp_id.equals(that.dp_id) : that.dp_id != null) return false;
        if (user_name != null ? !user_name.equals(that.user_name) : that.user_name != null) return false;
        if (user_sex != null ? !user_sex.equals(that.user_sex) : that.user_sex != null) return false;
        if (user_birth != null ? !user_birth.equals(that.user_birth) : that.user_birth != null) return false;
        if (user_height != null ? !user_height.equals(that.user_height) : that.user_height != null) return false;
        if (user_weight != null ? !user_weight.equals(that.user_weight) : that.user_weight != null) return false;
        if (user_blood != null ? !user_blood.equals(that.user_blood) : that.user_blood != null) return false;
        return user_realname != null ? user_realname.equals(that.user_realname) : that.user_realname == null;
    }

    @Override
    public int hashCode() {
        int result = user_id != null ? user_id.hashCode() : 0;
        result = 31 * result + (user_phone != null ? user_phone.hashCode() : 0);
        result = 31 * result + (dp_id != null ? dp_id.hashCode() : 0);
        result = 31 * result + (user_name != null ? user_name.hashCode() : 0);
        result = 31 * result + (user_sex != null ? user_sex.hashCode() : 0);
        result = 31 * result + (user_birth != null ? user_birth.hashCode() : 0);
        result = 31 * result + (user_height != null ? user_height.hashCode() : 0);
        result = 31 * result + (user_weight != null ? user_weight.hashCode() : 0);
        result = 31 * result + (user_blood != null ? user_blood.hashCode() : 0);
        result = 31 * result + (user_realname != null ? user_realname.hashCode() : 0);
        return result;
    }
}
