package com.example.JpaRelation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "file_server")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FileServer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob //CLOB: lưu character BLOB: lưu byte
    @Column(name = "data",columnDefinition = "LONGBLOB")
    private byte[] data;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // trước khi sinh ra entity thì tạo ra create at luôn.
    @PrePersist
    public void prePersist() {
        createAt = LocalDateTime.now();
    }
}