package com.myproject.media.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author nguyenle
 */
public interface FileSystemService {

    String persistFile(String fileName, byte[] fileContent) throws IOException;

    InputStream getFile(String filePath);

}
