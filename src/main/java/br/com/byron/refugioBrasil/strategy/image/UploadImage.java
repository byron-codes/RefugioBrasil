package br.com.byron.refugioBrasil.strategy.image;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.byron.refugioBrasil.strategy.image.storage.LocalImageStorage;

@Service
public class UploadImage {

	@Autowired
	private LocalImageStorage storage;
	
	@Value("${image.storage.folder}")
	private String PATH;
	
	public String uploadStorageImage(MultipartFile image) {
		try {
			String imageName = "";
			
			do {
				imageName = UUID.randomUUID()
						+ image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
			} while ((new File(PATH + imageName)
					.exists()));
			
			storage.saveImage(image.getInputStream(), PATH, imageName);
			return storage.targetLocation(PATH, imageName);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
