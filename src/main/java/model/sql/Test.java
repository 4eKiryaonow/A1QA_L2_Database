package model.sql;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Test {
    private long id;
    private String name;
    private long statusId;
    private String methodName;
    private long projectId;
    private long sessionId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String env;
    private String browser;
    private long authorId;
}