package com.dhew_server.vo;

import java.util.Date;

public class HealthInfoVo {
	Integer id;
	Date health_time; //数据采集时间
	String heart; //心率
	String body_temperature; //体温
	String room_temperature; //室温
	String humidity; //湿度
	public HealthInfoVo() {
		super();
	}
	public HealthInfoVo(Integer id, Date health_time) {
		super();
		this.id = id;
		this.health_time = health_time;
	}
	public HealthInfoVo(Integer id, Date health_time, String heart, String body_temperature, String room_temperature,
			String humidity) {
		super();
		this.id = id;
		this.health_time = health_time;
		this.heart = heart;
		this.body_temperature = body_temperature;
		this.room_temperature = room_temperature;
		this.humidity = humidity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getHealth_time() {
		return health_time;
	}
	public void setHealth_time(Date health_time) {
		this.health_time = health_time;
	}
	public String getHeart() {
		return heart;
	}
	public void setHeart(String heart) {
		this.heart = heart;
	}
	public String getBody_temperature() {
		return body_temperature;
	}
	public void setBody_temperature(String body_temperature) {
		this.body_temperature = body_temperature;
	}
	public String getRoom_temperature() {
		return room_temperature;
	}
	public void setRoom_temperature(String room_temperature) {
		this.room_temperature = room_temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body_temperature == null) ? 0 : body_temperature.hashCode());
		result = prime * result + ((health_time == null) ? 0 : health_time.hashCode());
		result = prime * result + ((heart == null) ? 0 : heart.hashCode());
		result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((room_temperature == null) ? 0 : room_temperature.hashCode());
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
		HealthInfoVo other = (HealthInfoVo) obj;
		if (body_temperature == null) {
			if (other.body_temperature != null)
				return false;
		} else if (!body_temperature.equals(other.body_temperature))
			return false;
		if (health_time == null) {
			if (other.health_time != null)
				return false;
		} else if (!health_time.equals(other.health_time))
			return false;
		if (heart == null) {
			if (other.heart != null)
				return false;
		} else if (!heart.equals(other.heart))
			return false;
		if (humidity == null) {
			if (other.humidity != null)
				return false;
		} else if (!humidity.equals(other.humidity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (room_temperature == null) {
			if (other.room_temperature != null)
				return false;
		} else if (!room_temperature.equals(other.room_temperature))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HealthInfoVo [id=" + id + ", health_time=" + health_time + ", heart=" + heart + ", body_temperature="
				+ body_temperature + ", room_temperature=" + room_temperature + ", humidity=" + humidity + "]";
	}
	
}
