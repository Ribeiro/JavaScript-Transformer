package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TableBuilder {
	
	private final List<String> headers;
	private final List<Row> rows = new ArrayList<>();
	
	private TableBuilder(String [] headers){
		this.headers = Arrays.asList(headers);
	}

	public static TableBuilder withHeaders(String... headers) {
		return new TableBuilder(headers);
	}
	
	public TableBuilder addRow(Object... values) {
		if (values.length != headers.size()){
			throw new IllegalArgumentException(
					"Row values length is not equals to headers length!");
		}
		
		Map<String, Object> row = new HashMap<String, Object>();
		int index = 0;
		for (String header : this.headers) {
			row.put(header, values[index++]);
		}
		
		rows.add(new Row(row));
		
		return this;
	}

	public Table build() {
		return new Table(this.rows);
	}

}
