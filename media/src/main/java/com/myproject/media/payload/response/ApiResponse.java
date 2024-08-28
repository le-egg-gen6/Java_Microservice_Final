package com.myproject.media.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author nguyenle
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    @Builder.Default
    private int status = 200;

    private String message;

    private T data;

}
