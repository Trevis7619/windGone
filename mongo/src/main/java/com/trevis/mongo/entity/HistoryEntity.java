package com.trevis.mongo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "history")
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
     * 事件发生时间
     */

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date time;


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
