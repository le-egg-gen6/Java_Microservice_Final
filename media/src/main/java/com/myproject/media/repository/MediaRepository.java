package com.myproject.media.repository;

import com.myproject.media.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nguyenle
 */
@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {



}
