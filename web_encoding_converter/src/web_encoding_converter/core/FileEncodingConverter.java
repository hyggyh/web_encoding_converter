package web_encoding_converter.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class FileEncodingConverter {

	public void convert(String file, Charset coding) throws IOException {
		File f = new File(file);

		if (!f.exists()) {
			throw new FileNotFoundException("Can not find file: [" + file + "]");
		}

		String out = file.concat("out");
		
		convert(new FileInputStream(f), Charset.forName(""),
				new FileOutputStream(out), coding);
	}

	private void convert(InputStream in, Charset orignialCoding,
			OutputStream out, Charset targetCoding) throws IOException {
		byte[] buffer = new byte[1024 * 1024 * 2];
		StringBuilder sb = new StringBuilder();
		while (in.available() > 0) {
			in.read(buffer);
			sb.append(buffer);
		}
	}
}
