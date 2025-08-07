package com.project.afterFail.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="post")
@Data
public class Post {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name= "user_id", nullable=false)
            @OnDelete(action = OnDeleteAction.CASCADE)
            @JsonIgnore
            User user;

    String title;
    @Lob
    @Column(columnDefinition = "text")
    String text;

}
