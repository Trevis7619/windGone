package com.trevis.elasticsearch.controller;

import com.google.gson.Gson;
import com.trevis.elasticsearch.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class EsDocClient {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 添加文档
     */
    @RequestMapping("create/doc")
    public void createDoc() throws IOException {
        //创建文档
        UserEntity entity = UserEntity.builder()
                .id(1L)
                .name("陈艺杰")
                .age(23L)
                .hobby("打球").build();

        //创建霍或者新增索引 指定文档id
        IndexRequest request = new IndexRequest("client-index", "_doc", "1");

        //随机id文档
        //IndexRequest request  = new IndexRequest("client-index","_doc");

        //Json字符串数据放入请求
        request.source(new Gson().toJson(entity), XContentType.JSON);

        //客户端发送请求
        restHighLevelClient.index(request, RequestOptions.DEFAULT);
    }


    /**
     * 获取文档,判断是否存在
     */
    @RequestMapping("get/doc/{id}")
    public void getDoc(@PathVariable("id") String id) throws IOException {
        //发起get请求
        GetRequest request = new GetRequest("client-index", "_doc", id);

        //客户端发送请求
        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        log.info("当前文档是否存在?:{}", exists);
    }


    /**
     * 使用_update更新文档,更新的前提是有文档.
     */
    @RequestMapping("update/doc/{id}")
    public void updateDoc(@PathVariable("id") String id) throws IOException {
        //发起get请求
        UpdateRequest request = new UpdateRequest("client-index", "_doc", id);


        UserEntity entity = UserEntity.builder().name("陈艺杰").build();

        request.doc(new Gson().toJson(entity), XContentType.JSON);

        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        log.info("发起文档更新:{}", response.toString());
    }


    /**
     * 删除文档
     */
    @RequestMapping("delete/doc/{id}")
    public void deleteDoc(@PathVariable("id") String id) throws IOException {
        //发起delete请求
        DeleteRequest request = new DeleteRequest("client-index", "_doc", id);

        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);

        log.info("id{}删除状态:{}", id, response.toString());
    }

    /**
     * 批量插入
     */
    @RequestMapping("bulk/doc")
    public void bulkDoc() throws IOException {

        BulkRequest request = new BulkRequest();

        List<UserEntity> list = new ArrayList<>();

        list.forEach(l -> {
            //request.add()..
        });

        restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
    }


    /**
     * 查询
     */
    @RequestMapping("search/doc")
    public void searchDoc() throws IOException {
        SearchRequest request= new SearchRequest("client-index");

        //构造搜索条件,建造者模式
        SearchSourceBuilder builder = new SearchSourceBuilder();

        //精确查询
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery();

        //匹配所有
        //QueryBuilders.matchAllQuery();

       builder.query(QueryBuilders.matchQuery("name","陈艺杰"));

        //分页
        builder.from(0);
        builder.size(1);

        //排序
        //builder.sort("name");

        request.source(builder);
        SearchResponse response = restHighLevelClient.search(request,RequestOptions.DEFAULT);

        log.info("查询结果:{}",response.toString());
    }


}
