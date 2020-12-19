package com.trevis.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *@author chenyijie
 *@Date  2020/12/19 6:43 下午
 * history内容entity
 */
@Document("history_desc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContentEntity {

    @Id
    private String id;


}
