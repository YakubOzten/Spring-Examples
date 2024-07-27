package com.yakubozten.api;

import com.yakubozten.dto.ResponseMessageDto;
import com.yakubozten.dto.ResponsefileDto;
import com.yakubozten.entity.FileDb;
import com.yakubozten.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
public class fileUploadApi {


    @Autowired
    private FileUploadService fileUploadService;
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessageDto> fileUpload(@RequestParam("file") MultipartFile file){
    String message ="";

        try {
            fileUploadService.store(file);
            message = "Uploaded the File Successfully:" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageDto(message));
        } catch (IOException e) {
            message ="Could not  upload this file:" + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageDto(message));
        }

    }

    @GetMapping("/files")
    public  ResponseEntity<List<ResponsefileDto>> getListFiles(){
        List<ResponsefileDto> files= fileUploadService.GetALLFiles().map(dbFile ->{
            String FileDownUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return  new ResponsefileDto(
                    dbFile.getName(),
                    FileDownUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @GetMapping("/files/{id}")
    public ResponseEntity <byte[]> getFile(@PathVariable String id){

        FileDb fileDb = fileUploadService.getFile(id);
        if (fileDb == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileDb.getName() + "\"")
                .body(fileDb.getData());

//        FileDb fileDb = fileUploadService.getFile(id);
//
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment;filename=\""+ fileDb.getName()+"\"")
//                .body(fileDb.getData());
    }


}
