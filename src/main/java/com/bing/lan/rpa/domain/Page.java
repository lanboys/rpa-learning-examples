package com.bing.lan.rpa.domain;

import java.util.List;

import lombok.Data;

/**
 * Created by lanbing at 2024/2/5 16:51
 */

@Data
public class Page<T> {

  protected List<T> records;
  protected long total;
  protected long size;
  protected long current;

}