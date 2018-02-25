package com.zxy.testClass;

import java.io.InputStreamReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestScript {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		//获得一个JavaScript的执行引擎
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		//建立上下文环境
		Bindings bind = engine.createBindings();
		bind.put("factor", 4);
		//绑定上下文，作用域当前引擎范围
		engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
		engine.eval(new InputStreamReader(TestScript.class.getClassLoader().getResourceAsStream("fun.js")));
		if(engine instanceof Invocable) {
			Invocable invocable = (Invocable)engine;
			System.out.println(invocable.invokeFunction("fun", 3, 4));
		}
	}

}

