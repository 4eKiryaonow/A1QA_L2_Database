package model.api.dto;

import lombok.Data;

@Data
public class Post {
    private String id;
    private String title;
    private String body;
    private String userId;
}