package br.com.byron.refugioBrasil.strategy.image;

import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Refugee;
import br.com.byron.refugioBrasil.strategy.refugee.IRefugeeStrategy;

@Component
public class ImageStrategy implements IRefugeeStrategy {

	private final UploadImage uploadImage;
	
	public ImageStrategy(UploadImage uploadImage) {
		this.uploadImage = uploadImage;
	}
	
	@Override
	public String execute(Refugee entity) {
		entity.getImage().setPath(uploadImage.uploadStorageImage(entity.getImage().getFile()));
		entity.getImage().setSize(entity.getImage().getFile().getSize());
		entity.getImage().setType(entity.getImage().getFile().getContentType());
		return "";
	}

}
