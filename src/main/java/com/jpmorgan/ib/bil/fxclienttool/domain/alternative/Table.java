package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Table implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9123210629921200853L;
	private Set<String> headers;
	private List<Row> rows;
	
	public Table(){
		this.rows = Collections.emptyList();
		this.headers = Collections.emptySet();
	}
	
	public Table(List<Row> rows){
		this.headers = new HashSet<>();
		this.rows = rows;
		for (Row row : this.rows) {
			
			for (Entry<String, Object> entry : row.entrySet()) {
				headers.add(entry.getKey().toString());
			}
			
		}
		
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public Row getRowAt(Integer index){
		return this.rows.get(index);
	}
	
	public Row getFirstRow(){
		return getRowAt(0);
	}
	
	public Row getLastRow(){
		return getRowAt(this.rows.size() - 1);
	}
	
	public void add(Row row){
		this.rows.add(row);
	}
	
	public Set<String> getHeaders() {
		return this.headers;
	}

}