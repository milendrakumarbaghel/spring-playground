package org.geofence.springplayground.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseDTO<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private boolean lastPage;
    private boolean firstPage;
    private int totalCount;
}
