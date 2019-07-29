package com.cskaoyan.wdjava.service;

import com.cskaoyan.wdjava.exception.WdTermExistException;
import org.springframework.web.multipart.MultipartFile;

public interface WdFileService {
    public boolean parseStudentInfo(String termName, MultipartFile multipartFile) throws Exception;
}
