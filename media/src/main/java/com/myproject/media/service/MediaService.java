package com.myproject.media.service;

import com.myproject.media.entity.Media;
import com.myproject.media.payload.request.FileMediaRequest;

/**
 * @author nguyenle
 */
public interface MediaService {

    Media saveMedia(FileMediaRequest request);

    void removeMedia

}
