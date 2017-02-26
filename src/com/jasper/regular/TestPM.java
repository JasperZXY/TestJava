package com.jasper.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPM {
	public static void main(String []args) {
		m1();
		isNum("123");
		isNum("789a");
		isNum("a789");
		isNum("7a89");
	}
	
	/**
	 * 匹配数字+java开头的字符串
	 * matches()尝试将整个区域与模式匹配。如果匹配就返回true，否则返回false
	 */
	public static void m1() {
//		Pattern pattern = Pattern.compile("^\\d{1,}\\.{0,1}\\d*$");
		Pattern pattern = Pattern.compile("^[0-9]*java.");
		Matcher matcher = pattern.matcher("11javab");
		boolean b = matcher.matches();
		System.out.println(b);
	}
	
	/**
	 * 输出结果如下：
	 * a 0 1
	 * b 3 4
	 * da 7 9
	 * s 11 12
	 * 说明：\\D+匹配的是最少一个非数字
	 * 从下面这个例子可以看出，group得到的是所匹配的子字符串
	 * start( )会返回此次匹配的开始位置，
	 * end( )会返回此次匹配的结束位置，即最后一个字符的下标加一。
	 */
	public static void m2() {
		Pattern pattern = Pattern.compile("\\D+");
		Matcher matcher = pattern.matcher("a12b423da23s");
		while(matcher.find()) {   //find( )的功能是发现CharSequence里的，与pattern相匹配的多个字符序列
			System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
		}
	}
	
	/**
	 * 输入出结果如下：
group=bcd
bcd
bc
c
d
########################
group=dab
dab
da
a
b
########################
	 * 分析：(X) X作为捕获组，那么匹配后就会就会在左右两边加上括号
	 * group 0 代表整个匹配的正则表达式
	 * groupCount()我的理解是有多少个括号就等于多少
	 */
	public static void m3() {
		Pattern pattern = Pattern.compile("(\\D(\\D))(\\D)");
		Matcher matcher = pattern.matcher("a12bcd423dabcd232s");
		while(matcher.find()) {
			System.out.println("group=" + matcher.group());
			for(int i=0; i<=matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
			System.out.println("########################");
		}
	}
	
	/**
	 * 结果
	 * 	a 1 2
		b 3 4
		a 5 6
		b 6 7
	 * 简单的测试一下“|”或运算
	 */
	public static void m4() {
		Pattern pattern = Pattern.compile("a|b");
		Matcher matcher = pattern.matcher("3a3b1ab3");
		while(matcher.find()) {   //find( )的功能是发现CharSequence里的，与pattern相匹配的多个字符序列
			System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
		}
	}
	
	/**
	 * 结果
	 * aaa 6 9
	 * 测试一下匹配若干次
	 */
	public static void m5() {
		Pattern pattern = Pattern.compile("a{3}");   //匹配3次
		Matcher matcher = pattern.matcher("123a12aaa23");
		while(matcher.find()) {   //find( )的功能是发现CharSequence里的，与pattern相匹配的多个字符序列
			System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
		}		
	}
	
	/**
	 * 测试替换操作
	 * 下面测试的是把所有的空格转换为1
	 * 下面的输入结果是：ab1c1d1
	 */
	public static void m6() {
		Pattern pattern = Pattern.compile(" {1,}");
		String string = "ab c  d  ";
		string = pattern.matcher(string).replaceAll("1");
		System.out.println(string);
	}
	
	/**
	 * 用正则表达式进行分割字符串
	 * 下面的输出结果如下：
	 * 4->abcd
	 * 0->
	 * 0->
	 * 3->def
	 * 3->g h
	 * 从结果可以看出如果匹配后的正则表达式后面又是刚好匹配的字符串，那么该匹配项得到的字符串的长度就为0了
	 */
	public static void m7() {
		Pattern pattern = Pattern.compile("\\d");   //匹配数字
		String string = "abcd123def1g h";
		String []s = pattern.split(string);
		for(String str : s) {
			System.out.println(str.length() + "->" + str);
		}
	}
	
	/**
	 * 这个例子要结合m9()进行理解，主要是测试有没有?时的匹配情况
	 * 有?属于懒惰型的，只要匹配到了就停，
	 * 如果没有?那么就直接匹配到结尾
	 * ab12ab 12ab12ab 12ab12a 2 25
	 */
	public static void m8() {
		Pattern pattern = Pattern.compile("a.*a");
		Matcher matcher = pattern.matcher("12ab12ab 12ab12ab 12ab12ab");
		while(matcher.find()) {
			System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
		}
		System.out.println("现在调用m9()");
		m9();
	}
	
	/**
	 * 	ab12a 2 7
		ab12a 11 16
		ab12a 20 25
	 */
	public static void m9() {
		Pattern pattern = Pattern.compile("a.*?a");
		Matcher matcher = pattern.matcher("12ab12ab 12ab12ab 12ab12ab");
		while(matcher.find()) {
			System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
		}
	}
	
	/**
	 * 输出结果：
	 * mon
	 * mon
	 */
	public static void m10() {
		Pattern pattern = Pattern.compile("(mon (and dad)?)");
		Matcher matcher = pattern.matcher("mon and");
		while(matcher.find()) {
			for(int i=0; i<matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}
	
//	public static void m11() {
//		Pattern pattern = Pattern.compile("(\\d{1,9}).*?(\\d{1,5})");
//		Matcher matcher = pattern.matcher("				    <p  title=\" 本商品支持在线交易，可以直接网上订购。\" >        			<span class=\"sw-ui-font-priceIcon\" title=\" 本商品支持在线交易，可以直接网上订购。\">29<span class=\"smallSize\">.00</span><span class=\"priceUnit\"></span></span>			</p>	<p class=\"sw-mod-offerImg-attribute-p2\">成交 <strong>303</strong> 笔</p>	<p>评价 <a class=\"sw-fn-fw700\" href=\"http://detail.china.alibaba.com/offer/831437883.html?selected=evaluate#mod-detail-otabs\" target=\"_blank\" offer-stat=\"evaluate\" >282</a> 条</p>");
//		if(matcher.find()) {
//			System.out.println(matcher.groupCount());
//			for(int i=1; i<=matcher.groupCount(); i++) {
//				System.out.println(matcher.group(i));
//			}
//		} else {
//			System.out.println("dsafa");
//		}
//	}
	
	//one dog two dogs in the yard
	public static void m12() {
		Pattern p = Pattern.compile("cat");
		 Matcher m = p.matcher("one cat two cats in the yard");
		 StringBuffer sb = new StringBuffer();
		 while (m.find()) {
		     m.appendReplacement(sb, "dog");
		 }
		 m.appendTail(sb);
		 System.out.println(sb.toString());
	}
	
	//select * from user 
	public static void m13() {
		String string = "select * from user order by id";
		string = string.replaceAll("order\\s*by[\\w|\\W|\\s|\\S]*", "");
		System.out.println(string);
	}
	public static void m14() {
		Pattern pattern = Pattern.compile("compname\".*?>([^<].*?)<.*?");
		Matcher matcher = pattern.matcher("rinfo_compname\">广州富维信息科技有限公司</span></a>");
		if(matcher.find()) {
			System.out.println(matcher.group(1));
		} else {
			System.out.println("no no");
		}
	}
	public static void m15() {
		Pattern pattern = Pattern.compile("offerid=\"(.*?)\".*?\"(.*?)\"");
		Matcher matcher = pattern.matcher(" offerid=\"756186806\" memberid=\"lanwei888\" gotoDetail=");
		if(matcher.find()) {
			System.out.println(matcher.group(1));
		} else {
			System.out.println("no no");
		}
	}
	
	public static void m16() {
		Pattern pattern = Pattern.compile("(<div.*?>)");
		Matcher matcher = pattern.matcher("<div class=\"red\">很好</div>");
		while(matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
	
	public static void m17() {
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher = pattern.matcher("zhon+g-xianyao@ll.com");
		System.out.println(matcher.matches());
	}
	
	public static void isNum(String str) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(str);
		boolean b = matcher.matches();
		System.out.println(b);
	}
}
