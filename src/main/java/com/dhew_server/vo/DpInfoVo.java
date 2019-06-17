package com.dhew_server.vo;

/**
 * 部门信息表
 */
public class DpInfoVo {
    String dp_id; //部门编号
    String dp_name; //部门名

    public DpInfoVo() {
    }

    public DpInfoVo(String dp_id, String dp_name) {
        this.dp_id = dp_id;
        this.dp_name = dp_name;
    }

    public String getDp_id() {
        return dp_id;
    }

    public void setDp_id(String dp_id) {
        this.dp_id = dp_id;
    }

    public String getDp_name() {
        return dp_name;
    }

    public void setDp_name(String dp_name) {
        this.dp_name = dp_name;
    }

    @Override
    public String toString() {
        return "DpInfoVo{" +
                "dp_id='" + dp_id + '\'' +
                ", dp_name='" + dp_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DpInfoVo dpInfoVo = (DpInfoVo) o;

        if (dp_id != null ? !dp_id.equals(dpInfoVo.dp_id) : dpInfoVo.dp_id != null) return false;
        return dp_name != null ? dp_name.equals(dpInfoVo.dp_name) : dpInfoVo.dp_name == null;
    }

    @Override
    public int hashCode() {
        int result = dp_id != null ? dp_id.hashCode() : 0;
        result = 31 * result + (dp_name != null ? dp_name.hashCode() : 0);
        return result;
    }
}
