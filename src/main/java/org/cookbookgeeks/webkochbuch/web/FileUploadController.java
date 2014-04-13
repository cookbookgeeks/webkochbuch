package org.cookbookgeeks.webkochbuch.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

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
	
	public FileUploadController() {
		
	}
	
	public static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	/** Name of an environment variable that contains the path of the uploads storage. */
	public static final String destinationVarName = "WEBKOCHBUCH_UPLOADS_DESTINATION";
	
	/** Path of the uploads storage. */
	public static final String destination = (System.getenv(destinationVarName) != null) ? System.getenv(destinationVarName) : "/tmp";
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {
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
 
                return "Successfully uploaded file.";
			} catch(Exception ex) {
				ex.printStackTrace();
				return "Failed to upload file.";
			}
		} else {
			return "Cannot upload empty files.";
		}
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public String uploadForm() {
		return "AjaxUploadForm";
	}
	
}
