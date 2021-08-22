package com.korkeep.summer.service.file;

import com.korkeep.summer.domain.file.File;
import com.korkeep.summer.domain.file.FileRepository;
import com.korkeep.summer.web.dto.FileDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDTO fileDTO) {
        return fileRepository.save(fileDTO.toEntity()).getId();
    }

    @Transactional
    public FileDTO getFile(Long id) {
        File file = fileRepository.findById(id).get();

        return FileDTO.builder()
                .id(id)
                .origFileName(file.getOrigFileName())
                .fileName(file.getFileName())
                .filePath(file.getFilePath())
                .build();
    }
}
