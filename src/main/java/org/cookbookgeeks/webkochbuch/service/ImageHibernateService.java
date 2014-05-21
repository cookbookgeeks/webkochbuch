/*
 * Copyright (C) 2014  Cookbookgeeks
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

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
