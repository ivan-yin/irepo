package com.iivan;

import jodd.util.StringUtil;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 * 
 */
public class JpyApp {
	private static Logger logger = LoggerFactory.getLogger(JpyApp.class);
	
	public static void main(String[] args) {
		
	}


	/**
	 * 用jpinyin 进行转换
	 * @param is 
	 * @param separator 
	 * @param pinyinFormat 
	 * @return
	 */
	public static String convertWithJp(String is, String separator, PinyinFormat pinyinFormat) {
//		PinyinFormat.WITH_TONE_MARK;
		PinyinHelper.convertToPinyinString(is, separator, pinyinFormat);
		return "";
	}
}
