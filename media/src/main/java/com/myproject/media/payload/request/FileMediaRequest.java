package com.myproject.media.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author nguyenle
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileMediaRequest {

    private String caption;

    @NotNull
    private MultipartFile multipartFile;

    private String fileName;

}
