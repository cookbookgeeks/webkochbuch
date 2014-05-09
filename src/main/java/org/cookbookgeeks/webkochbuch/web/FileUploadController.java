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

package org.cookbookgeeks.webkochbuch.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for the file upload.
 * 
 * @author Nils Sommer
 *
 */
@Controller
public class FileUploadController {
	
	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	@Autowired
	private String uploadsFolder;
	
	public static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	/**
	 * Accepts a file and a description string, saves the file to a target directory
	 * and persists an image object to the database.
	 * 
	 * @param file
	 * @param description
	 * @return the id of the created image database entry, null if anything failed
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file,
			@RequestParam("description") String description) {
		Date date = new Date();
		String name = "recipe_image_" + date.getTime();
		
		if(!file.isEmpty()) {
			try {
				byte bytes[] = file.getBytes();
				File dir = new File(uploadsFolder);
				logger.info(dir.toString());
				if (!dir.exists()) {
					logger.debug("Directory " + uploadsFolder + "does not exist. Will try to create it.");
					if(dir.mkdirs()) {
						logger.debug("Creating directory successful.");
					} else {
						logger.error("Failed creating directory. Uploading files impossible");
						return "null";
					}
				}

                File serverFile = new File(dir.getAbsolutePath() + File.separator + name + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Saved upload file to " + serverFile.getAbsolutePath());
                
                // Persist image metadata in db:                
                Image image = new Image();
                image.setPath(serverFile, dir);
                image.setDescription(description);
                
                Integer id = recipeService.saveImage(image);
 
                if(id != null) {
                	logger.info("Image with id " + id + " persisted.");
                	return id.toString();
                } else {
                	logger.debug("Failed to persist image object.");
                	return "null";
                }
			} catch(Exception ex) {
				logger.debug("Failed to save file to disk.");
				ex.printStackTrace();
				return "null";
			}
		} else {
			logger.debug("Failed to save file to disk because the file is empty.");
			return "null";
		}
	}
	
}
