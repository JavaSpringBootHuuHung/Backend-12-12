package vn.techzen.academy_12.dto.page;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageCustom<T> {
    long totalElements;
    int totalPages;
    int number;
    int size;
    public PageCustom(Page<T> page) {
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.number = page.getNumber();
        this.size = page.getSize();
    }
}
