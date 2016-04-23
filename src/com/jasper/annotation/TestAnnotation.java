package com.jasper.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 注解生成sql，暂时只支持int跟String类型
 * @author Jasper
 *
 */
public class TestAnnotation {
	public static void main(String[] args) {
		System.out.println(createTable(UserBean.class));
	}
	
	private static String getTableName(Class<?> bean) {
        String name = null;
        //判断是否有Table注解
        if (bean.isAnnotationPresent(Table.class)) {
            //获取注解对象
            Annotation annotation = bean.getAnnotation(Table.class);
            try {
                Method method = Table.class.getMethod("name");
                name = (String) method.invoke(annotation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }
	
	private static List<NameAndType> getColumns(Class<?> bean) {
        List<NameAndType> columns = new ArrayList<NameAndType>();
        Field[] fields = bean.getDeclaredFields();
        if (fields != null) {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if (field.isAnnotationPresent(Column.class)) {
                    String name = null;
                    String type = null;
                    Annotation annotation = field.getAnnotation(Column.class);
                    
                    try {
                    	Method methodName = Column.class.getMethod("name");
                    	//获取注解上的值
                    	name = (String) methodName.invoke(annotation);
                    	// FIXME 目的是判断注解上的值是否存在，不知这么判断是否正确
                    	if (methodName.getDefaultValue().equals(name)) {
                    		//注解上的值不存在，则用成员变量的名称
                    		name = field.getName();
                    	}
                        
                        Method methodType = Column.class.getMethod("type");
                    	type = (String) methodType.invoke(annotation);
                        if (methodType.getDefaultValue().equals(type)) {
                        	if (int.class.isAssignableFrom(field.getType())) {
                                type = "integer";
                            } else if (String.class.isAssignableFrom(field.getType())) {
                                type = "text";
                            } else {
                                throw new RuntimeException("unspported type=" + field.getType().getSimpleName());
                            }
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    columns.add(new NameAndType(name, type));
                }

            }
        }
        return columns;
    }
	
	private static String createTable(Class<?> bean) {
	    String tableName = getTableName(bean);
	    List<NameAndType> columns = getColumns(bean);
	    if (tableName != null && !tableName.equals("") && !columns.isEmpty()) {
	        StringBuilder createTableSql = new StringBuilder("create table ");
	        //加表名
	        createTableSql.append(tableName);
	        createTableSql.append("(");

	        //加表中字段
	        for (int i = 0; i < columns.size(); i++) {
	            NameAndType column = columns.get(i);
	            createTableSql.append(column.name);
	            createTableSql.append(" ");
	            createTableSql.append(column.type);
	            // 追加下一个字段定义前需要添加逗号
	            if (i != columns.size() - 1) {
	                createTableSql.append(",");
	            }
	        }
	        createTableSql.append(")");
	        return createTableSql.toString();
	    }

	    return null;
	}

}
