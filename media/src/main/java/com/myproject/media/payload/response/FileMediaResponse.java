package com.myproject.media.payload.response;

import lombok.*;

/**
 * @author nguyenle
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileMediaResponse {

    private Long id;

    private String caption;

    private String fileName;

    private String mediaType;

    private String url;

}
