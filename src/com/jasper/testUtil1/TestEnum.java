package com.jasper.testUtil1;

public class TestEnum {
	public static void main(String[] args) {
		Day day = Day.get("a");
		System.out.println(day.name());
		System.out.println(Day.get("Satuday"));
		System.out.println(Day.get("Satuday").toString() == "Satuday");
	}
}

enum Day {
	Monday, Satuday, Sunday;
	public static Day get(int i) {
		Day []days = values();
		return days[i%days.length];
	}
	public static Day get(String str) {
		Day []days = values();
		for(Day day : days) {
			if(day.name().equals(str)) {
				return day;
			}
		}
		return Monday;
	}
}
