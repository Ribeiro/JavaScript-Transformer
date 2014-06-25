package com.jpmorgan.ib.bil.fxclienttool.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.jpmorgan.ib.bil.fxclienttool.domain.alternative.Row;
import com.jpmorgan.ib.bil.fxclienttool.domain.alternative.RowBuilder;

public class RowTemplateLoader implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(Row.class).addTemplate("row_one_for_operations", new Rule(){{
			add("map", RowBuilder.withKeys(TableTemplateLoader.OPERATION_HEADERS)
								 .withValues("1", "2014-06-24", "2014-06-01", "151.51", "123", "PJ")
								 .build()
								 .getMap()
			);
            
        }});
		
		Fixture.of(Row.class).addTemplate("row_two_for_operations", new Rule(){{
			add("map", RowBuilder.withKeys(TableTemplateLoader.OPERATION_HEADERS)
								 .withValues("2", "2014-06-24", "2014-05-01", "252.52", "456", "PJ")
								 .build()
								 .getMap()
			);
            
        }});
		
		Fixture.of(Row.class).addTemplate("row_three_for_operations", new Rule(){{
			add("map", RowBuilder.withKeys(TableTemplateLoader.OPERATION_HEADERS)
								 .withValues("3", "2014-06-24", "2014-04-01", "353.53", "789", "PJ")
								 .build()
								 .getMap()
			);
            
        }});
		
	}

}