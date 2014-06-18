package com.jpmorgan.ib.bil.fxclienttool.domain;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import javax.script.ScriptException;

import org.junit.Test;

public class JavaScriptTableTransformerTest {
	
	private Table buildFixture(){
		Row rowOne = new Row("ABC", "123");
		Row rowTwo = new Row("DEF", "456");
		return new Table(Arrays.asList(rowOne, rowTwo));
	}
	
	private Table buildExpected(){
		Row rowOne = new Row("GHI", "789");
		Row rowTwo = new Row("DEF", "456");
		return new Table(Arrays.asList(rowOne, rowTwo));
	}
	
	@Test
	public void shouldUpdateSpecificTableRowWithGivenKeyValuePair() throws ScriptException{
		String script = "table.getRowAt(0).set('GHI', '789');";
		Table tableUnderTesting = buildFixture();
		JavaScriptTableTransformer transformer = new JavaScriptTableTransformer(tableUnderTesting);
		transformer.getEngine().eval(script);
		
		Table expectedTable = buildExpected();
		Row expectedRowOne = expectedTable.getRowAt(0);
		Row expectedRowTwo = expectedTable.getRowAt(1);
		
		assertThat(tableUnderTesting.getRows(), hasSize(2));
		assertThat(tableUnderTesting.getRows(), hasItems(expectedRowOne, expectedRowTwo));
		
	}
	

}
