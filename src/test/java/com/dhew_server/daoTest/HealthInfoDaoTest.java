package com.dhew_server.daoTest;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.HealthInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.HealthInfoVo;

public class HealthInfoDaoTest {

	@Test
	public void test() throws ParseException {
		String db_phone = "zhealth_15600000004";
		SqlSession session = MybatisUtil.openSession();
		HealthInfoDao dao = session.getMapper(HealthInfoDao.class);
		Date now = new Date();
		//System.out.println(now.getDay());
		
		
		for (int i = 2; i <= 6; i++) {
			//早上
			now.setHours(7);
			now.setMinutes(45);
			now.setSeconds(0);
			for (int j = 1; j <= 540; j++) {
				//Date user_birth = new SimpleDateFormat("yyyy-MM-dd").parse();		
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, -i);
				cal.add(Calendar.SECOND, j*10);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				int rh = new Random().nextInt(15);
				int rfh = new Random().nextInt(2);
				int heart = 80;
				if (rfh == 0) {
					heart += rh;
				} else {
					heart -= rh;
				}
				Double tem = 36.5;
				rfh = new Random().nextInt(3);
				int rt = new Random().nextInt(6);
				Double rdt = (double) (rt / 10.0);
				if (rfh == 0) {
					tem += rdt;
				} else if (rfh == 1) {
					tem -= rdt;
				}
				Double room = 25 + j / 10.0;
				if (room > 40) {
					room = 40 + j / 90.0;
				}
				Double hum = 20 + j / 10.0;
				if (hum > 30) {
					hum = 30 + j / 90.0;
				}
				HealthInfoVo health = new HealthInfoVo(null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date), String.valueOf(heart), String.valueOf(tem).substring(0, 4), String.valueOf(room).substring(0, 4), String.valueOf(hum).substring(0, 4));
				System.out.println(health);
				dao.addHealth(db_phone, health);
			}
			
			/*//中午
			now.setHours(11);
			now.setMinutes(45);
			
			for (int j = 1; j <= 540; j++) {
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, -i);
				cal.add(Calendar.SECOND, j*10);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				int rh = new Random().nextInt(15);
				int rfh = new Random().nextInt(2);
				
				int heart = 80;
				
				if (i == 3) {
					if (heart < 90) {
						heart = heart + j/10;
					} else {
						heart = 90;
					}
				}
				if (rfh == 0) {
					heart += rh;
				} else {
					heart -= rh;
				}
				Double tem = 36.8;
				rfh = new Random().nextInt(3);
				int rt = new Random().nextInt(6);
				Double rdt = (double) (rt / 10.0);
				if (rfh == 0) {
					tem += rdt;
				} else if (rfh == 1) {
					tem -= rdt;
				}
				Double room = 35 + j / 10.0;
				if (i == 3) {
					if (room > 40) {
						room = 40 + j / 40.0;
					}
					if (room > 50) {
						room = 40 + j / 60.0;
					}
				} else {
					if (room > 40) {
						room = 40 + j / 60.0;
					}
					if (room > 50) {
						room = 40 + j / 90.0;
					}
					
				}
				Double hum = 25 + j / 10.0;
				if (hum > 30) {
					hum = 30 + j / 120.0;
				}
				HealthInfoVo health = new HealthInfoVo(null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date), String.valueOf(heart), String.valueOf(tem).substring(0, 4), String.valueOf(room).substring(0, 4), String.valueOf(hum).substring(0, 4));
				System.out.println(health);
				dao.addHealth(db_phone, health);
			}
			
			//晚上
			now.setHours(18);
			now.setMinutes(45);
			for (int j = 1; j <= 540; j++) {
				
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, -i);
				cal.add(Calendar.SECOND, j*10);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				int rh = new Random().nextInt(15);
				int rfh = new Random().nextInt(2);
				int heart = 80;
				if (rfh == 0) {
					heart += rh;
				} else {
					heart -= rh;
				}
				Double tem = 36.5;
				rfh = new Random().nextInt(3);
				int rt = new Random().nextInt(6);
				Double rdt = (double) (rt / 10.0);
				if (rfh == 0) {
					tem += rdt;
				} else if (rfh == 1) {
					tem -= rdt;
				}
				Double room = 20 + j / 10.0;
				if (room > 40) {
					room = 40 + j / 120.0;
				}
				Double hum = 25 + j / 10.0;
				if (hum > 30) {
					hum = 30 + j / 90.0;
				}
				HealthInfoVo health = new HealthInfoVo(null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date), String.valueOf(heart), String.valueOf(tem).substring(0, 4), String.valueOf(room).substring(0, 4), String.valueOf(hum).substring(0, 4));
				System.out.println(health);
				dao.addHealth(db_phone, health);
			}*/
		session.commit();
		}
		
		
		
		
		
		
		
		
		
		
		
		/*List<Map<String, Object>> list = dao.getHalfHourByDay(db_phone, "2019-04-26");
		System.out.println(list);
		String date = "2019-04-26";
		String[] heart = new String[48];
		String[] tem = new String[48];
		String[] room = new String[48];
		String[] hum = new String[48];
		for (int i = 0; i < 48; i++) {
			String hour = null,half = null;
			heart[i] = "null";
			if (i < 10) {
				if (i % 2 == 0) {
					hour = date + " 0" + String.valueOf(i) + ":" + "00";
				} else {
					half = date + " 0" + String.valueOf(i) + ":" + "30";
				}
			} else {
				if (i % 2 == 0) {
					hour = date + " " + String.valueOf(i) + ":" + "00";
				} else {
					half = date + " " + String.valueOf(i) + ":" + "30";
				}	
			}
			
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).get("health_time").equals(hour)) {
					String he = String.valueOf(list.get(j).get("heart"));
					int h = he.indexOf(".");
					heart[i] = he.substring(0, h);
					tem[i] = String.valueOf(list.get(j).get("body_temperature")).substring(0, 4);
					room[i] = String.valueOf(list.get(j).get("room_temperature")).substring(0, 4);
					hum[i] = String.valueOf(list.get(j).get("humidity")).substring(0, 4);
					
				} else if (list.get(j).get("health_time").equals(half)) {
					String he = String.valueOf(list.get(j).get("heart"));
					int h = he.indexOf(".");
					heart[i] = he.substring(0, h);
					tem[i] = String.valueOf(list.get(j).get("body_temperature")).substring(0, 4);
					room[i] = String.valueOf(list.get(j).get("room_temperature")).substring(0, 4);
					hum[i] = String.valueOf(list.get(j).get("humidity")).substring(0, 4);
				}
			}
		}
		System.out.println(Arrays.toString(heart));
		System.out.println(Arrays.toString(tem));
		System.out.println(Arrays.toString(room));
		System.out.println(Arrays.toString(hum));*/
		
		/*for (int i = 0; i <= 6; i++) {
			HealthInfoVo info = dao.getByDay(db_phone, String.valueOf(-i));
			String heart = info.getHeart();
			int h = heart.indexOf(".");
			heart = heart.substring(0, h);
			String tem = info.getBody_temperature().substring(0, 4);
			String room = info.getRoom_temperature().substring(0, 4);
			String hum = info.getHumidity().substring(0, 4);
			Date day = info.getHealth_time();
			String date = new SimpleDateFormat("yyyy-MM-dd").format(day.getTime());
			System.out.println(heart + " " + tem + " " + room + " " + hum + date);
		}
		HealthInfoVo info = dao.getByDay(db_phone, "0");
		//System.out.println(info);
		String heart = info.getHeart();
		int h = heart.indexOf(".");
		heart = heart.substring(0, h);
		//System.out.println(heart);
		String tem = info.getBody_temperature().substring(0, 4);
		//System.out.println(tem);
		String room = info.getRoom_temperature().substring(0, 4);
		//System.out.println(room);
		String hum = info.getHumidity().substring(0, 4);
		*/
		//System.out.println(hum);
		
		
		/*for (int i = 0; i <= 6; i++) {	
			if (i % 3 ==0) {
				continue;
			}
			int heart;
			Double tem = 36.5;
			Double room = 25.0, hum = 20.0;
			if (i % 2 == 0) {
				heart = 80 + new Random().nextInt(5);
				tem += 0.5;
				room += new Random().nextInt(5);
				hum -= new Random().nextInt(5);
			} else {
				heart = 80 - new Random().nextInt(5);
				tem -= 0.5;
				room -= new Random().nextInt(5);
				hum -= new Random().nextInt(5);
			}
			for (int j = 1; j <= 90; j++) {
				//Date user_birth = new SimpleDateFormat("yyyy-MM-dd").parse();
				
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, -i);
				cal.add(Calendar.SECOND, j*10);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				int rh = new Random().nextInt(11);
				int rfh = new Random().nextInt(2);
				int hheart = heart;
				if (rfh == 0) {
					hheart += rh;
				} else {
					hheart -= rh;
				}
				Double rtem = tem;
				rfh = new Random().nextInt(3);
				int rt = new Random().nextInt(6);
				Double rdt = (double) (rt / 10.0);
				DecimalFormat df = new DecimalFormat("0.00");
				
				if (rfh == 0) {
					rtem += rdt;
				} else if (rfh == 1) {
					rtem -= rdt;
				}
				Double rroom = room;
				Double rhum = hum;
				rroom += j / 10.0;
				rhum += j / 10.0;
				//System.out.println(tem);
				//System.out.println(rh);
				//int heart = 80 +
				//System.out.println(date);
				HealthInfoVo health = new HealthInfoVo(null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date), String.valueOf(hheart), df.format(rtem), df.format(rroom), df.format(rhum));
				System.out.println(health);
				dao.addHealth(db_phone, health);
			}
		}
		session.commit();*/
		
		
		/*for (int i = 0; i <= 1; i++) {
			for (int j = 1; j <= 180; j++) {
				//Date user_birth = new SimpleDateFormat("yyyy-MM-dd").parse();
				
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, -i);
				cal.add(Calendar.SECOND, j*10);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
				int rh = new Random().nextInt(11);
				int rfh = new Random().nextInt(2);
				int heart = 80;
				if (rfh == 0) {
					heart += rh;
				} else {
					heart -= rh;
				}
				Double tem = 36.5;
				rfh = new Random().nextInt(3);
				int rt = new Random().nextInt(6);
				Double rdt = (double) (rt / 10.0);
				if (rfh == 0) {
					tem += rdt;
				} else if (rfh == 1) {
					tem -= rdt;
				}
				Double room = 25 + j / 10.0;
				Double hum = 20 + j / 10.0;
				//System.out.println(tem);
				//System.out.println(rh);
				//int heart = 80 +
				//System.out.println(date);
				HealthInfoVo health = new HealthInfoVo(null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date), String.valueOf(heart), String.valueOf(tem), String.valueOf(room), String.valueOf(hum));
				System.out.println(health);
				dao.addHealth(db_phone, health);
			}
		}
		session.commit();*/
		
		
		
	}

}
