package com.cosmos.pojo;

import com.cosmos.model.Shareorder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shareorders {
    private List<Shareorder> shareorderList;
}
