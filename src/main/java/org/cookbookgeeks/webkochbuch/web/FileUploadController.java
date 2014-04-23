package org.cookbookgeeks.webkochbuch.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.annotation.Resource;

import org.cookbookgeeks.webkochbuch.domain.Image;
import org.cookbookgeeks.webkochbuch.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	/** Name of an environment variable that contains the path of the uploads storage. */
	public static final String destinationVarName = "WEBKOCHBUCH_UPLOADS_DESTINATION";
	
	/** Path of the uploads storage. */
	public String destination;
	
	/**
	 * Standard constructor. Initializes file storage path.
	 */
	public FileUploadController() {
		String env = System.getenv(destinationVarName);
		if(env == null) {
			logger.warn("Environment variable " + destinationVarName + " not found. File uploads will not work. "
					+ "Files will be redirected to: /tmp");
			destination = "/tmp";
		} else {
			destination = env;
			logger.info("Initializing file upload storage to use location: " + destination);
		}
	}
	
	/**
	 * Accepts a file and a description string, saves the file to a target directory
	 * and persists an image object to the database.
	 * 
	 * @param file
	 * @param description
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file,
			@RequestParam("description") String description) {
		Date date = new Date();
		String name = "recipe_image_" + date.getTime();
		
		if(!file.isEmpty()) {
			try {
				byte bytes[] = file.getBytes();
                File dir = new File(destination);
				if (!dir.exists()) {
					logger.debug("Directory " + destination + "does not exist. Will try to create it.");
					dir.mkdirs();
				}

                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Saved upload file to " + serverFile.getAbsolutePath());
                
                // Persist image metadata in db:
                Image image = new Image();
                image.setPath(serverFile.getAbsolutePath());
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
