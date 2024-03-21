package com.bing.lan.rpa.controller;

import com.bing.lan.rpa.domain.ArticleData;
import com.bing.lan.rpa.domain.ListData;
import com.bing.lan.rpa.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lanbing at 2024/2/5 16:44
 */

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

  /**
   * http://localhost:8080/test/page?size=10&current=1
   * <p>
   * html
   * http://localhost:8080/pages/post-data.html
   */

  @RequestMapping("/page")
  public Page<ArticleData> page(long size, long current) {
    Page<ArticleData> page = new Page<>();
    List<ArticleData> list = new ArrayList<>();
    long dataSize = size;
    if (current == 4) {
      dataSize = 3;
    } else if (current > 4) {
      dataSize = 0;
    }

    String substring = UUID.randomUUID().toString().replace("-", "").substring(0, 10);

    for (int i = 0; i < dataSize; i++) {
      ArticleData articleData = new ArticleData();
      articleData.setTitle("文章标题 " + substring + " " + i);
      articleData.setLikes("33333" + substring + " " + i);
      articleData.setReads("33333" + substring + " " + i);
      list.add(articleData);
    }
    page.setCurrent(current);
    page.setRecords(list);
    page.setTotal(34);
    page.setSize(10);
    return page;
  }

  /**
   * http://localhost:8080/pages/post-list.html
   */
  @RequestMapping("/page2")
  public Page<ListData> page2(long size, long current) {
    Page<ListData> page = new Page<>();

    List<ListData> list = new ArrayList<>();
    long dataSize = size;
    if (current == 4) {
      dataSize = 3;
    } else if (current > 4) {
      dataSize = 0;
    }

    for (int i = 0; i < dataSize; i++) {
      List<ArticleData> listqqq = new ArrayList<>();

      int sizea = (i + 2) % 3 + 1;

      for (int j = 0; j < sizea; j++) {

        ArticleData articleData = new ArticleData();
        articleData.setTitle(current + "页 文章标题 " + i + "条 " + j);
        articleData.setLikes(current + "页 点赞 " + i + "条 " + j);
        articleData.setReads(current + "页 阅读数 " + i + "条 " + j);

        listqqq.add(articleData);
      }
      ListData listData = new ListData();
      listData.setDate(current + "页  " + i + "条   " + "2024-03-23 09:34:33");
      listData.setDataList(listqqq);
      list.add(listData);
    }

    page.setCurrent(current);
    page.setRecords(list);
    page.setTotal(34);
    page.setSize(10);
    return page;
  }

}
