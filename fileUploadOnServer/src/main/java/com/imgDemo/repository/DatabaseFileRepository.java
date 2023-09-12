package com.imgDemo.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imgDemo.model.DatabaseFile;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

	String findByFileName(String fileId);

	boolean existsByFileName(String fileName);

}