package com.generation.Todoapp.controller.dto;

import com.generation.Todoapp.component.FileUploadUtil;
import com.generation.Todoapp.repository.Entity.Item;
import com.generation.Todoapp.controller.dto.ItemDTO;

import com.generation.Todoapp.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    //remove
    @Value("${image.folder}")
    private String imageFolder;

    private final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        //using the all() method in the ItemService
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }


    //POST request
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="header", required = true) String header,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="due", required = true) String due,

                        @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {
        //Part 1: provide the ability to save the image file into the directory in the Server
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        //Part 2: Other data (name, description, etc...) store into database
        String fullPath = imageFolder + '/' ;

        //Create an instance object of the ItemDTO (Date Transfer Object) to store all the data
        // that is sent from the Client
        ItemDTO itemDto = new ItemDTO(header, description, due);
        itemService.save(new Item(itemDto));








}}

