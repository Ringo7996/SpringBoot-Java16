package com.example.JpaRelation.repository;

import com.example.JpaRelation.entity.FileServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileServerRepository extends JpaRepository<FileServer, Integer> {

    List<FileServer> findByUser_Id(Integer id);
}