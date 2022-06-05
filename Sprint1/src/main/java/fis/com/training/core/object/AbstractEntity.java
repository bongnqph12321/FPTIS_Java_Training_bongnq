package fis.com.training.core.object;

import java.time.LocalDateTime;


public class AbstractEntity {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
