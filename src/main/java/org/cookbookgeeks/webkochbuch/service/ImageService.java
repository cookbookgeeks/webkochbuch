package org.cookbookgeeks.webkochbuch.service;

import org.cookbookgeeks.webkochbuch.dao.ImageDao;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.domain.Recipe;

/**
 * Service interface for an image service.
 * 
 * @author nils
 *
 */
public interface ImageService extends ImageDao {
	
	/** {@inheritDoc} */
	@Override
	public void update(Image updated);
	
	/**
	 * Sets the recipe relation for an image.
	 * 
	 * @param updated image to set the relation on
	 * @param recipe recipe the image belongs to
	 */
	public void setRecipeRelation(Image updated, Recipe recipe);

}
