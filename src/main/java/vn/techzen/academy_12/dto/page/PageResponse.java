package vn.techzen.academy_12.dto.page;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import vn.techzen.academy_12.entity.Student;

import java.util.List;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponse<T> {
    List<T> content;
    PageCustom<T> page;
    public PageResponse(Page<T> page) {
        content = page.getContent();
        this.page = new PageCustom<T>(page);
    }
}
