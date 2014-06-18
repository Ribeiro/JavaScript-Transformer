package com.jpmorgan.ib.bil.fxclienttool.domain;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JavaScriptTableTransformer {
	
	private ScriptEngine engine;

	public JavaScriptTableTransformer(Table table) {
		ScriptEngineManager manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName ("js");
		engine.getContext().setAttribute("table", table, ScriptContext.ENGINE_SCOPE);
	}
	
	public ScriptEngine getEngine() {
		return engine;
	}

}