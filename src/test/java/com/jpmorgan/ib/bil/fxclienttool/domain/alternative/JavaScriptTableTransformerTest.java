package com.jpmorgan.ib.bil.fxclienttool.domain.alternative;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import javax.script.ScriptException;

import org.junit.Test;

import com.jpmorgan.ib.bil.fxclienttool.domain.JavaScriptTableTransformer;
import com.jpmorgan.ib.bil.fxclienttool.domain.Row;
import com.jpmorgan.ib.bil.fxclienttool.domain.TableOld;

public class JavaScriptTableTransformerTest {
	
	private TableOld buildFixture(){
		Row rowOne = new Row("ABC", "123");
		Row rowTwo = new Row("DEF", "456");
		return new TableOld(Arrays.asList(rowOne, rowTwo));
	}
	
	private TableOld buildExpected(){
		Row rowOne = new Row("GHI", "789");
		Row rowTwo = new Row("DEF", "456");
		return new TableOld(Arrays.asList(rowOne, rowTwo));
	}
	
	@Test
	public void shouldUpdateSpecificTableRowWithGivenKeyValuePair() throws ScriptException{
		String script = "table.getRowAt(0).set('GHI', '789');";
		TableOld tableUnderTesting = buildFixture();
		JavaScriptTableTransformer transformer = new JavaScriptTableTransformer(tableUnderTesting);
		transformer.getEngine().eval(script);
		
		TableOld expectedTable = buildExpected();
		Row expectedRowOne = expectedTable.getRowAt(0);
		Row expectedRowTwo = expectedTable.getRowAt(1);
		
		assertThat(tableUnderTesting.getRows(), hasSize(2));
		assertThat(tableUnderTesting.getRows(), hasItems(expectedRowOne, expectedRowTwo));
		
	}
	

}
