package com.jpmorgan.ib.bil.fxclienttool.domain;

import java.util.List;

public class Table {
	
	private List<Row> rows;
	
	public List<Row> getRows() {
		return rows;
	}
	
	public Table(){
		
	}

	public Table(List<Row> rows) {
		this.rows = rows;
	}
	
	public Row getRowAt(Integer index){
		return rows.get(index);
	}

}