package com.trevis.elasticsearch.fnc;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class EsIndexClient {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 创建索引
     */
    @RequestMapping("create/index")
    public void createIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("client-index");

        //执行创建请求
        restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);

        log.info("创建索引成功");
    }


    /**
     * 获取索引
     */
    @RequestMapping("get/index")
    public void getIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("client-index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        log.info("判断索引是否存在:{}", exists);
    }


    /**
     * 删除索引
     */
    @RequestMapping("delete/index")
    public void deleteIndex() throws  IOException{
        DeleteIndexRequest request = new DeleteIndexRequest("client-index");

        AcknowledgedResponse response = restHighLevelClient.indices().delete(request,RequestOptions.DEFAULT);

        log.info("测试删除索引:{}",response);

    }

}
