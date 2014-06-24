package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

public class Main {
	
	public static void main(String[] args) {
		
		Table table = TableBuilder.withHeaders("id_operacao", "data_liq", "data_processo", "valor_liq", "cliente", "tipo_pessoa")
								  .addRow("1", "2014-06-24", "2014-06-01", "151.51", "123", "PJ")
								  .addRow("2", "2014-06-24", "2014-05-01", "252.52", "456", "PJ")
								  .addRow("3", "2014-06-24", "2014-04-01", "353.53", "789", "PJ")
								  .build();
		
		System.out.println("Table Headers are " + table.getHeaders());
		System.out.println("Table contains " + table.getRows().size() + " rows!");
		
		
		Row firstRow = table.getFirstRow();
		Row lastRow = table.getLastRow();
		
		System.out.println(firstRow);
		System.out.println(lastRow);
		
	}

}
