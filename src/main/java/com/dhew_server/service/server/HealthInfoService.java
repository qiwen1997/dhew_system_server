package com.dhew_server.service.server;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.HealthInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.HealthInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HealthInfoService {
	public List<HealthInfoVo> getAllByPhone(@Param("db_phone") String db_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			HealthInfoDao dao = session.getMapper(HealthInfoDao.class);
			String db = "zhealth_" + db_phone;
			return dao.getAll(db);
		}
	}
	public JSONArray getByDay(@Param("db_phone") String db_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			HealthInfoDao dao = session.getMapper(HealthInfoDao.class);
			String db = "zhealth_" + db_phone;
			JSONArray array = new JSONArray();
			for (int i = 0; i <= 6; i++) {
				HealthInfoVo info = dao.getByDay(db, String.valueOf(-i));
				System.out.println(info);
				if (info != null) {
					String heart = info.getHeart();
					int h = heart.indexOf(".");
					heart = heart.substring(0, h);
					String tem = info.getBody_temperature();
					h = tem.indexOf(".");
					if (h != -1) {
						tem = tem.substring(0, h + 2);
					}
					String room = info.getRoom_temperature();
					h = room.indexOf(".");
					if (h != -1) {
						room = room.substring(0, h + 2);
					}
					String hum = info.getHumidity();
					h = hum.indexOf(".");
					if (h != -1) {
						hum = hum.substring(0, h + 2);
					}
					Date day = info.getHealth_time();
					String date = new SimpleDateFormat("yyyy-MM-dd").format(day.getTime());
					JSONObject obj = new JSONObject();
					obj.put("day", date);
					obj.put("heart", heart);
					obj.put("body_temperature", tem);
					obj.put("room_temperature", room);
					obj.put("humidity", hum);
					array.add(obj);
				} else {
					JSONObject obj = new JSONObject();
					Date day = new Date();
					Calendar cal = Calendar.getInstance();
					cal.setTime(day);
					cal.add(Calendar.DATE, -i);
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
					String date = sd.format(cal.getTime());	
					obj.put("day", date);
					obj.put("heart", "null");
					obj.put("body_temperature", "null");
					obj.put("room_temperature", "null");
					obj.put("humidity", "null");
					array.add(obj);
				}		
			}
			return array;
		}
	}
	
	public JSONObject getHalfHourByDay(@Param("db_phone") String db_phone, String date) throws JsonProcessingException {
		try (SqlSession session = MybatisUtil.openSession()) {
			HealthInfoDao dao = session.getMapper(HealthInfoDao.class);
			String db = "zhealth_" + db_phone;
			List<Map<String, Object>> list = dao.getHalfHourByDay(db, date);
			
			String[] heart = new String[48];
			String[] tem = new String[48];
			String[] room = new String[48];
			String[] hum = new String[48];
			for (int i = 0; i < 48; i++) {
				String hour = null,half = null;
				if (i < 20) {
					if (i % 2 == 0) {
						hour = date + " 0" + String.valueOf(i/2) + ":" + "00";
					} else {
						half = date + " 0" + String.valueOf(i/2) + ":" + "30";
					}
				} else {
					if (i % 2 == 0) {
						hour = date + " " + String.valueOf(i/2) + ":" + "00";
					} else {
						half = date + " " + String.valueOf(i/2) + ":" + "30";
					}	
				}
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).get("health_time").equals(hour)) {
						String he = String.valueOf(list.get(j).get("heart"));
						int h = he.indexOf(".");
						if (h != -1) {
							heart[i] = he.substring(0, h);
						}
						
						tem[i] = String.valueOf(list.get(j).get("body_temperature"));
						h = tem[i].indexOf(".");
						if (h != -1) {
							tem[i] = tem[i].substring(0, h + 2);
						}
						room[i] = String.valueOf(list.get(j).get("room_temperature"));
						h = room[i].indexOf(".");
						if (h != -1) {
							room[i] = room[i].substring(0, h + 2);
						}
						hum[i] = String.valueOf(list.get(j).get("humidity"));
						h = hum[i].indexOf(".");
						if (h != -1) {
							hum[i] = hum[i].substring(0, h + 2);
						}
						break;
						
					} else if (list.get(j).get("health_time").equals(half)) {
						String he = String.valueOf(list.get(j).get("heart"));
						int h = he.indexOf(".");
						if (h != -1) {
							heart[i] = he.substring(0, h);
						}
						
						tem[i] = String.valueOf(list.get(j).get("body_temperature"));
						h = tem[i].indexOf(".");
						if (h != -1) {
							tem[i] = tem[i].substring(0, h + 2);
						}
						room[i] = String.valueOf(list.get(j).get("room_temperature"));
						h = room[i].indexOf(".");
						if (h != -1) {
							room[i] = room[i].substring(0, h + 2);
						}
						hum[i] = String.valueOf(list.get(j).get("humidity"));
						h = hum[i].indexOf(".");
						if (h != -1) {
							hum[i] = hum[i].substring(0, h + 2);
						}
						break;
					}
				}
			}		
			JSONObject obj = new JSONObject();	
			ObjectMapper mapper = new ObjectMapper();
			String heartJson = mapper.writeValueAsString(heart);
			String temJson = mapper.writeValueAsString(tem);
			String roomJson = mapper.writeValueAsString(room);
			String humJson = mapper.writeValueAsString(hum);
			obj.put("heart", heartJson);
			obj.put("body_temperature", temJson);
			obj.put("room_temperature", roomJson);
			obj.put("humidity", humJson);		
			return obj;
		}	
	}
}