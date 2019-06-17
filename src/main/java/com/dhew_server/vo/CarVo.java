package com.dhew_server.vo;

public class CarVo {

	Integer car_id;
	String user_phone;
	String brand;
	String plate;
	String type;
	Integer default_phone;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Integer getCar_id() {
		return car_id;
	}
	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Integer getDefault() {
		return default_phone;
	}
	public void setDefault(Integer default1) {
		default_phone = default1;
	}
	public CarVo() {
		super();
		default_phone=0;
	}
	
	
	
	public CarVo(String brand, String plate, String type) {
		super();
		this.brand = brand;
		this.plate = plate;
		this.type = type;
		default_phone=0;
	}
	public CarVo(String user_phone, String brand, String plate, String type, Integer default1) {
		super();
		this.user_phone = user_phone;
		this.brand = brand;
		this.plate = plate;
		this.type = type;
		default_phone = default1;
	}
	public CarVo(Integer car_id, String user_phone, String brand, String plate, String type) {
		super();
		this.car_id = car_id;
		this.user_phone = user_phone;
		this.brand = brand;
		this.plate = plate;
		this.type = type;
	}
	@Override
	public String toString() {
		return "CarVo [car_id=" + car_id + ", user_phone=" + user_phone + ", brand=" + brand + ", plate=" + plate
				+ ", type=" + type + ", Default=" + default_phone + "]";
	}
	
	
}
