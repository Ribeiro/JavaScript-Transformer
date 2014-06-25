package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

import java.util.HashMap;
import java.util.Map;

public class RowBuilder {
	private String [] keys;
	private Map<String, Object> rowMap;
	
	private RowBuilder(String [] keys){
		this.keys = keys;
		
	}

	public static RowBuilder withKeys(String... keys) {
		return new RowBuilder(keys);
	}
	
	public RowBuilder withValues(Object... values) {
		if (values.length != this.keys.length){
			throw new IllegalArgumentException(
					"Row values length is not equals to headers length!");
		}
		
		Map<String, Object> row = new HashMap<String, Object>();
		int index = 0;
		for (String header : this.keys) {
			row.put(header, values[index++]);
		}
		
		this.rowMap = row;
		return this;
	}
	
	public Row build() {
		return new Row(this.rowMap);
	}

}