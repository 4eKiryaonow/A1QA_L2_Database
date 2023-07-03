package model.sql;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {
    private long id;
    private String name;
    private String login;
    private String email;
}