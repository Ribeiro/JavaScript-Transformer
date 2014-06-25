package com.jpmorgan.ib.bil.fxclienttool.templates;

import java.util.Arrays;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.jpmorgan.ib.bil.fxclienttool.domain.alternative.RowBuilder;
import com.jpmorgan.ib.bil.fxclienttool.domain.alternative.Table;

public class TableTemplateLoader implements TemplateLoader {
	
	public static final String [] OPERATION_HEADERS = {"operation_id", "settlement_date", "process_date", "settlement_amount", "customer_id", "person_type"};

	@Override
	public void load() {
		Fixture.of(Table.class).addTemplate("table_with_three_operations", new Rule(){{
			String [] valuesForRowOne = {"1", "2014-06-24", "2014-06-01", "151.51", "123", "PJ"};
			String [] valuesForRowTwo = {"2", "2014-06-24", "2014-05-01", "252.52", "456", "PJ"};
			String [] valuesForRowThree = {"3", "2014-06-24", "2014-04-01", "353.53", "789", "PJ"};
			
            add("rows", Arrays.asList(RowBuilder.withKeys(OPERATION_HEADERS).withValues(valuesForRowOne).build(), 
            						  RowBuilder.withKeys(OPERATION_HEADERS).withValues(valuesForRowTwo).build(), 
            						  RowBuilder.withKeys(OPERATION_HEADERS).withValues(valuesForRowThree).build()
            		 				  )
            );
            
        }});

	}

}