package com.san.utils;
import java.util.Random;
/**
 * 产生随机数
 * @return 生成的随机数
 * @author 001
 * @author Administrator
 *
 */
public class ActivationCode {
	public static String activationCode(){
		Random rd=new Random();
		String suiji="";
		for(int i=0;i<6;i++){
			String m=""+rd.nextInt(10);
			suiji=suiji+m;
		}
		return suiji;
	}
}
