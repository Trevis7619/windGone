package com.trevis.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "history")
public class HistoryEntity {


    @Id
    private String id;


    /**
     * 文档标题
     */
    private String title;

    /**
     * 文档内容
     */
    private String content;


    /**
     * 文档创建者
     */
    private String createBy;


    /**
     * 逻辑删除时间
     */
    private Date deletedTime;

    /**
     * 逻辑删除标识
     */
    private boolean deleted;


}
