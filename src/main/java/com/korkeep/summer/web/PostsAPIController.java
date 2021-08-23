package com.korkeep.summer.web;

import com.korkeep.summer.config.util.MD5Generator;
import com.korkeep.summer.service.file.FileService;
import com.korkeep.summer.service.posts.PostsService;
import com.korkeep.summer.web.dto.FileDTO;
import com.korkeep.summer.web.dto.PostsListResponseDTO;
import com.korkeep.summer.web.dto.PostsResponseDTO;
import com.korkeep.summer.web.dto.PostsSaveRequestDTO;
import com.korkeep.summer.web.dto.PostsUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsAPIController {
    private final PostsService postsService;
    private final FileService fileService;

//    @PostMapping("/api/v1/posts")
//    public Long save(@RequestBody PostsSaveRequestDTO requestDTO){
//        return postsService.save(requestDTO);
//    }

    @PostMapping(value = "/api/v1/posts")
    public Long save(@ModelAttribute PostsSaveRequestDTO requestDTO) {
        try {
            MultipartFile files = requestDTO.getFiles();
            String origFileName = files.getOriginalFilename();
            assert origFileName != null;

            // 실행되는 위치의 files 폴더에 파일이 저장됨
            String fileName = new MD5Generator(origFileName).toString();
            // 파일이 저장되는 폴더가 없으면 폴더를 생성함
            String savePath = System.getProperty("user.dir") + "\\files";

            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + fileName;
            files.transferTo(new File(filePath));

            FileDTO fileDTO = new FileDTO();
            fileDTO.setOrigFileName(origFileName);
            fileDTO.setFileName(fileName);
            fileDTO.setFilePath(filePath);

            Long fileId = fileService.saveFile(fileDTO);
            requestDTO.setFileId(fileId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return postsService.save(requestDTO);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDTO requestDTO) {
        return postsService.update(id, requestDTO);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDTO findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDTO> findAll() {
        return postsService.findAllDesc();
    }
}
