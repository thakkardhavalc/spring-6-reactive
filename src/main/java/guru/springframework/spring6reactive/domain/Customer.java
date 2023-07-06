package guru.springframework.spring6reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * Created By dhaval on 2023-07-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    private Integer id;
    private String customerName;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
