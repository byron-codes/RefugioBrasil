package br.com.byron.refugioBrasil.strategy.image.storage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class LocalImageStorage {

	public void saveImage(InputStream inputStream, String folder, String fileName) {
		try {
			File targetFile = new File(targetLocation(folder, fileName));
			copyInputStreamToFile(inputStream, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void copyInputStreamToFile(InputStream inputStream, File targetFile) throws IOException {
		FileUtils.copyInputStreamToFile(inputStream, targetFile);
	}

	public String targetLocation(String folder, String fileName) {
		if (ObjectUtils.isEmpty(folder) || ObjectUtils.isEmpty(fileName)) {
			return "";
		}
		return folder.concat(fileName);
	}

}
