package com.dhew_server.vo;

/**
 * 管理员账户表
 */
public class DpAdminVo {
	Integer admin_id;//管理员id
    String dp_id; //部门编号
    String dp_user; //管理员用户名
    String dp_password; //管理员密码
    Integer super_admin; //是否为超级管理员 是为1 不是为0
    String admin_name;
    String admin_sex;
    String admin_phone;
    String admin_remark;
    public DpAdminVo() {
    }

    
    
    public DpAdminVo(Integer admin_id, String dp_id, String dp_user, String dp_password, Integer super_admin) {
		super();
		this.admin_id = admin_id;
		this.dp_id = dp_id;
		this.dp_user = dp_user;
		this.dp_password = dp_password;
		this.super_admin = super_admin;
	}
    
	public DpAdminVo(Integer admin_id, String dp_id, String dp_user, String dp_password, Integer super_admin,
			String admin_name, String admin_sex, String admin_phone, String admin_remark) {
		super();
		this.admin_id = admin_id;
		this.dp_id = dp_id;
		this.dp_user = dp_user;
		this.dp_password = dp_password;
		this.super_admin = super_admin;
		this.admin_name = admin_name;
		this.admin_sex = admin_sex;
		this.admin_phone = admin_phone;
		this.admin_remark = admin_remark;
	}



	public String getAdmin_name() {
		return admin_name;
	}



	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}



	public String getAdmin_sex() {
		return admin_sex;
	}



	public void setAdmin_sex(String admin_sex) {
		this.admin_sex = admin_sex;
	}



	public String getAdmin_phone() {
		return admin_phone;
	}



	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}



	public String getAdmin_remark() {
		return admin_remark;
	}



	public void setAdmin_remark(String admin_remark) {
		this.admin_remark = admin_remark;
	}



	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public Integer getSuper_admin() {
		return super_admin;
	}

	public void setSuper_admin(Integer super_admin) {
		this.super_admin = super_admin;
	}

	public String getDp_id() {
        return dp_id;
    }

    public void setDp_id(String dp_id) {
        this.dp_id = dp_id;
    }

    public String getDp_user() {
        return dp_user;
    }

    public void setDp_user(String dp_user) {
        this.dp_user = dp_user;
    }

    public String getDp_password() {
        return dp_password;
    }

    public void setDp_password(String dp_password) {
        this.dp_password = dp_password;
    }



	@Override
	public String toString() {
		return "DpAdminVo [admin_id=" + admin_id + ", dp_id=" + dp_id + ", dp_user=" + dp_user + ", dp_password="
				+ dp_password + ", super_admin=" + super_admin + ", admin_name=" + admin_name + ", admin_sex="
				+ admin_sex + ", admin_phone=" + admin_phone + ", admin_remark=" + admin_remark + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_id == null) ? 0 : admin_id.hashCode());
		result = prime * result + ((admin_name == null) ? 0 : admin_name.hashCode());
		result = prime * result + ((admin_phone == null) ? 0 : admin_phone.hashCode());
		result = prime * result + ((admin_remark == null) ? 0 : admin_remark.hashCode());
		result = prime * result + ((admin_sex == null) ? 0 : admin_sex.hashCode());
		result = prime * result + ((dp_id == null) ? 0 : dp_id.hashCode());
		result = prime * result + ((dp_password == null) ? 0 : dp_password.hashCode());
		result = prime * result + ((dp_user == null) ? 0 : dp_user.hashCode());
		result = prime * result + ((super_admin == null) ? 0 : super_admin.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DpAdminVo other = (DpAdminVo) obj;
		if (admin_id == null) {
			if (other.admin_id != null)
				return false;
		} else if (!admin_id.equals(other.admin_id))
			return false;
		if (admin_name == null) {
			if (other.admin_name != null)
				return false;
		} else if (!admin_name.equals(other.admin_name))
			return false;
		if (admin_phone == null) {
			if (other.admin_phone != null)
				return false;
		} else if (!admin_phone.equals(other.admin_phone))
			return false;
		if (admin_remark == null) {
			if (other.admin_remark != null)
				return false;
		} else if (!admin_remark.equals(other.admin_remark))
			return false;
		if (admin_sex == null) {
			if (other.admin_sex != null)
				return false;
		} else if (!admin_sex.equals(other.admin_sex))
			return false;
		if (dp_id == null) {
			if (other.dp_id != null)
				return false;
		} else if (!dp_id.equals(other.dp_id))
			return false;
		if (dp_password == null) {
			if (other.dp_password != null)
				return false;
		} else if (!dp_password.equals(other.dp_password))
			return false;
		if (dp_user == null) {
			if (other.dp_user != null)
				return false;
		} else if (!dp_user.equals(other.dp_user))
			return false;
		if (super_admin == null) {
			if (other.super_admin != null)
				return false;
		} else if (!super_admin.equals(other.super_admin))
			return false;
		return true;
	}
     
}
