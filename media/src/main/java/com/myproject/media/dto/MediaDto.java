package com.myproject.media.dto;

import lombok.*;

import java.io.InputStream;

/**
 * @author nguyenle
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaDto {

    private InputStream content;

}
