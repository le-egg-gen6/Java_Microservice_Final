package com.myproject.media.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author nguyenle
 */
@Entity
@Table(
        name = "t_media",
        indexes = {
                @Index(columnList = "fileName"),
                @Index(columnList = "caption")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Media extends AbstractTableObject {

    private String caption;

    private String fileName;

    private String filePath;

    private String mediaType;

}
