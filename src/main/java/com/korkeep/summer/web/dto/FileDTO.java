package com.korkeep.summer.web.dto;

import com.korkeep.summer.domain.file.File;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDTO {
    private Long id;
    private String origFileName;
    private String fileName;
    private String filePath;

    public File toEntity(){
        return File.builder()
                .id(id)
                .origFileName(origFileName)
                .fileName(fileName)
                .filePath(filePath)
                .build();
    }

    @Builder
    public FileDTO(Long id, String origFileName, String fileName, String filePath){
        this.id = id;
        this.origFileName = origFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
