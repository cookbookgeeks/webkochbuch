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
