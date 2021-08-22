package com.korkeep.summer.domain.file;

import com.korkeep.summer.domain.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
