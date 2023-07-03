package model.sql;

import lombok.*;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Session {
    private long id;
    private String sessionKey;
    private Timestamp createdTime;
    private long buildNumber;
}
