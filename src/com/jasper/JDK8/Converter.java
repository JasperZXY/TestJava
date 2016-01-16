package com.jasper.JDK8;

@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}