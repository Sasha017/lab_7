package ua.lviv.iot.tableware.rest;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.StringWriter;
	import java.io.Writer;
    import java.util.List;

import org.junit.jupiter.api.Test;
	import ua.lviv.iot.tableware.rest.DisponsableTableWareManagerTest;
	import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;
	import ua.lviv.iot.tableware.rest.writer.DisponsableTableWareWriter;;

	public class DisponsableTableWareWriterTest extends DisponsableTableWareManagerTest {

	   @Test
	    public void testFile() throws IOException {
	    	
	        try (Writer fileWriter = new FileWriter("TableWare.csv")) {
	            DisponsableTableWareWriter writer = new DisponsableTableWareWriter();
	            writer.setWriter(fileWriter);
				writer.writeToFile(disponsableTableWareList);
	        }
	    }

	    @Test
	    public void testWriteToFile() throws IOException {
	        try (Writer csvWriter = new StringWriter()) {
	        	DisponsableTableWareWriter writer = new DisponsableTableWareWriter();
	            writer.setWriter(csvWriter);
	            writer.writeToFile(disponsableTableWareList);
	            String expectedString = "";
	            for (DisponsableTableWare disponsableTableWareList : disponsableTableWareList) {
	                expectedString += disponsableTableWareList.getHeaders() + ", " + disponsableTableWareList.toCSV() + "\r\n";
	           
	            }
	            assertEquals(expectedString, writer.toString());
	        }
	    }

	}
