package com.generation.Todoapp.component;

//This class is to "save/store" uploaded image file that is uploaded from the Client
//(Browser) through the PostMapping API in the Controller layer

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    //This method will be called by the Controller
    //3 parameters to pass in (1) Directory (2) filename of the image (3) image object itself
    public static void saveFile(String uploadDir1, String fileName,
                                MultipartFile multipartFile) throws IOException
    {

        //Paths.get() - convert a string/url to a directory path for the upload
        Path uploadPath1 = Paths.get(uploadDir1);

        //get Input Stream() method is from the MultipartFile Class package
        try (InputStream inputStream = multipartFile.getInputStream()) {

            Path filePath1 = uploadPath1.resolve(fileName);
            Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}
