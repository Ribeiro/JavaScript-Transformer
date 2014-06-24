package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Row extends AbstractMap<String, Object> implements Serializable {

	private static final long serialVersionUID = -1802265016664924018L;

	private final Map<String, Object> map;

	public Map<String, Object> getMap() {
		return map;
	}

	public Row(String key, Object value) {
		this.map = new HashMap<>();
		this.map.put(key, value);
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return map.entrySet();
	}
	
	public Row(Map<String, Object> map){
		this.map = new HashMap<>(map);
	}

}
