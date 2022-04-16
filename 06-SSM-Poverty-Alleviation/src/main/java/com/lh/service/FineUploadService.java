package com.lh.service;

import com.lh.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;

public interface FineUploadService {
    ResultVo fileUpload(MultipartFile file, String type);
}
