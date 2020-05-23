package ua.lviv.iot.tableware.rest.writer;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;

public class DisponsableTableWareWriter {
	private Writer csvWriter;

	public void setWriter(Writer writer) {
		this.csvWriter = writer;

	}
	
	public void writeToFile(List<DisponsableTableWare> disponsableTableWareList) throws IOException {
		String textToWrite;
		for (DisponsableTableWare disponsableTableWareList1 : disponsableTableWareList) {
			textToWrite = disponsableTableWareList1.getHeaders() + ", " + disponsableTableWareList1.toCSV() + "\r\n";
			csvWriter.write(textToWrite);
		}
		csvWriter.flush();
	
	
	}

	public String toString() {
		return csvWriter.toString();
	}
}