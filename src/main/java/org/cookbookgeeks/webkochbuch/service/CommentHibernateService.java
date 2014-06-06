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

import org.cookbookgeeks.webkochbuch.dao.CommentHibernateDao;
import org.cookbookgeeks.webkochbuch.domain.Comment;
import org.springframework.stereotype.Service;

/**
 * Service class for comment related database operations. This class contains methods
 * that are more business related than in the Daos.
 * 
 * @author Nils Sommer
 *
 */
@Service("commentService")
public class CommentHibernateService extends CommentHibernateDao implements
		CommentService {
	
	/** {@inheritDoc} */
	@Override
	public void update(Comment updated) {
		Comment comment = this.find(updated.getId());
		comment.setComment(updated.getComment());
		comment.setModification(updated.getModification());
		super.update(comment);
	}

}
