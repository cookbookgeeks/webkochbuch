package org.cookbookgeeks.webkochbuch.service;

import org.cookbookgeeks.webkochbuch.dao.ImageHibernateDao;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.domain.Recipe;
import org.springframework.stereotype.Service;

/**
 * Service class for image related database operation. This class contains methods
 * that are more business related than in the Daos.
 * 
 * @author Nils Sommer
 *
 */
@Service("imageService")
public class ImageHibernateService extends ImageHibernateDao implements
		ImageService {
	
	/** {@inheritDoc} */
	@Override
	public void update(Image updated) {
		Image image = this.find(updated.getId());
		image.setDescription(updated.getDescription());
		image.setModification(updated.getModification());
		image.setRecipe(updated.getRecipe());
		super.update(image);
	}
	
	/** {@inheritDoc} */
	public void setRecipeRelation(Image updated, Recipe recipe) {
		Image image = this.find(updated.getId());
		image.setRecipe(recipe);
		super.update(image);
	}

}
