package org.lviv.lgs.homework.services;

import org.lviv.lgs.homework.entities.ParticipantCoverFile;
import org.lviv.lgs.homework.repositories.ParticipantCoverFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ParticipantCoverFileService {
    private final ParticipantCoverFileRepository participantCoverFileRepository;

    @Autowired
    public ParticipantCoverFileService(ParticipantCoverFileRepository participantCoverFileRepository) {
        this.participantCoverFileRepository = participantCoverFileRepository;
    }

    public ParticipantCoverFile save(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            ParticipantCoverFile participantCoverFile =
                    new ParticipantCoverFile(fileName, file.getContentType(), file.getBytes());
            return participantCoverFileRepository.save(participantCoverFile);
        } catch (IOException ex) {
            throw new RuntimeException("Can't save file " + fileName, ex);
        }
    }

    public ParticipantCoverFile findById(String fileId){
        return participantCoverFileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }
}
