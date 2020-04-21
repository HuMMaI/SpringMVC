package org.lviv.lgs.homework.controllers;

import org.lviv.lgs.homework.entities.ParticipantCoverFile;
import org.lviv.lgs.homework.services.ParticipantCoverFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ParticipantCoverFileRestController {
    @Autowired
    private ParticipantCoverFileService participantCoverFileService;

    @PostMapping("/participant-cover-files/upload")
    public String uploadFile(@RequestParam("coverFile") MultipartFile file){
        ParticipantCoverFile participantCoverFile = participantCoverFileService.save(file);
        return participantCoverFile.getId();
    }

    @GetMapping("/participant-cover-files/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId){
        ParticipantCoverFile participantCoverFile = participantCoverFileService.findById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(participantCoverFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + participantCoverFile.getFileName())
                .body(new ByteArrayResource(participantCoverFile.getData()));
    }
}
