package com.yakubozten.service;

import com.yakubozten.entity.FileDb;
import com.yakubozten.repo.FileDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileUploadService {


    @Autowired
    private FileDbRepository fileDbRepository;

    public FileDb store(MultipartFile file) throws IOException {
        String filename= StringUtils.cleanPath(file.getOriginalFilename());
        FileDb fileDb=new FileDb(filename,file.getContentType(),file.getBytes());

        return fileDbRepository.save(fileDb);
    }

    public FileDb getFile(String id){
        return fileDbRepository.findById(id).get();
    }
    public Stream<FileDb>GetALLFiles(){
        return fileDbRepository.findAll().stream();
    }




}
