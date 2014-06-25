package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;


public class TableBuilderTest {

	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("com.jpmorgan.ib.bil.fxclienttool.templates");
	}

	@Test
	public void shouldBuildTableAsExpected() {
		Row rowOne = Fixture.from(Row.class).gimme("row_one_for_operations");
		Row rowTwo = Fixture.from(Row.class).gimme("row_two_for_operations");
		Row rowThree = Fixture.from(Row.class).gimme("row_three_for_operations");

		Table table = Fixture.from(Table.class).gimme("table_with_three_operations");
		
		assertThat(table.getRows(), hasSize(3));
		assertThat(table.getRows(), hasItems(rowOne, rowTwo, rowThree));

	}

}
