package com.iivan;

import jodd.util.ArraysUtil;
import jodd.util.StringUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class Py4jApp {
	private static Logger logger = LoggerFactory.getLogger(Py4jApp.class);

	public static void main(String[] args)
			throws BadHanyuPinyinOutputFormatCombination {
		// main1();
		convertWithP4j("里面都有工", HanyuPinyinToneType.WITH_TONE_MARK);
	}

	/**
	 * 用pinyin4j 进行转换
	 * 
	 * @param toneType
	 * @param ch
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public static String convertWithP4j(String toConv,
			HanyuPinyinToneType toneType)
			throws BadHanyuPinyinOutputFormatCombination {
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		// outputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
		// //ǜ的输出格式设置 'ü' 输出为 "u:"
		outputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE); // ǜ的输出格式设置
																		// 'ü'
																		// 输出为
																		// "ü"
																		// in
																		// Unicode
																		// form
		outputFormat.setToneType(toneType);
		StringBuffer sb = new StringBuffer();
		if (StringUtil.isNotEmpty(toConv)) {
			for (int i = 0; i < toConv.length(); i++) {
				char a = toConv.charAt(i);
				String[] py = PinyinHelper.toHanyuPinyinStringArray(a,
						outputFormat);
				sb.append(ArraysUtil.toString(py)).append(" \n");
			}
			logger.info(sb.toString());
		}
		return sb.toString();
	}

	public static void main1() throws BadHanyuPinyinOutputFormatCombination {
		char chineseCharacter = "绿".charAt(0);
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		outputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER); // 输出的声调为数字：第一声为1，第二声为2，第三声为3，第四声为4
																		// 如：lu:4
		// outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE); //
		// 输出拼音不带声调 如：lu:
		// outputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_MARK); //
		// 输出声调在拼音字母上 如：lǜ
		outputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON); // ǜ的输出格式设置
																			// 'ü'
																			// 输出为
																			// "u:"
		// outputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		// //ǜ的输出格式设置 'ü' 输出为 "ü" in Unicode form
		// outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V); //ǜ的输出格式设置
		// 'ü' 输出为 "v"
		outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE); // 输出拼音为大写
		// outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE); //输出拼音为小写
		String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(
				chineseCharacter, outputFormat); // 汉字拼音
		for (String str : pinyinArray) { // 多音字输出，会返回多音字的格式
			logger.info(str);
		}

		String pinyinstr = PinyinHelper.toHanyuPinyinString("绿色", outputFormat,
				"|");
		logger.info(pinyinstr);

		// 其他拼音系统的输出

		String[] GwoyeuRomatzyhStringArray = PinyinHelper
				.toGwoyeuRomatzyhStringArray(chineseCharacter);
		for (String str : GwoyeuRomatzyhStringArray) { // 多音字输出，会返回多音字的格式
			logger.info(str);
		}

		String[] MPS2PinyinStringArray = PinyinHelper
				.toMPS2PinyinStringArray(chineseCharacter);
		for (String str : MPS2PinyinStringArray) { // 多音字输出，会返回多音字的格式
			logger.info(str);
		}

		String[] TongyongPinyinStringArray = PinyinHelper
				.toTongyongPinyinStringArray(chineseCharacter);
		for (String str : TongyongPinyinStringArray) { // 多音字输出，会返回多音字的格式
			logger.info(str);
		}

		String[] WadeGilesPinyinStringArray = PinyinHelper
				.toWadeGilesPinyinStringArray(chineseCharacter);
		for (String str : WadeGilesPinyinStringArray) { // 多音字输出，会返回多音字的格式
			logger.info(str);
		}

		String[] YalePinyinStringArray = PinyinHelper
				.toYalePinyinStringArray(chineseCharacter);
		for (String str : YalePinyinStringArray) { // 多音字输出，会返回多音字的格式
			logger.info(str);
		}
	}

}
