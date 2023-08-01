package by.testtask.bootcamp.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageDTO<T> {
    @JsonProperty("number")
    private int number = 0;
    @JsonProperty("size")
    private int size = 10;
    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_elements")
    private long totalElements;

    @JsonProperty("first")
    private boolean first;

    @JsonProperty("number_of_elements")
    private int numberOfElements;

    @JsonProperty("last")
    private boolean last;

    @JsonProperty("content")
    List<T> content;

}
