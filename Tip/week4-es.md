elasticsearch的一些操作
=========
 *产线出现了问题
    在测试环境和开发环境增加hotel_price_v1_index索引的hotel类型时，用head没什么毛病，(如下图所示)<br>
    
    1. http://localhost:9200/hotel_price_v1_index/
        _mapping/hotel PUT
        
        {
          "properties" : {
            "lables" : {
                "type" : "nested",
                "properties" : {
                  "lableName" :{
                    "type" : "keyword"
                  }
               }
            }
          }
        }
        
    2. http://localhost:9200/hotel_price_v1_index/
       _mapping/lowprice PUT
       {
        "_routing" : {
          "required" : true
        },
        "_parent" : {
          "type" : "hotel"
        },
        "properties" : {
          "traceId" : {
            "type" : "keyword"
          },
          "updateTime" : {
            "type" : "date"
          }
        }
       }
       
       但是在产线中出了问题，用上面添加字段时，却又在hotel_price_v1_index里面生成了一个_mapping的type..初步怀疑产线和测试实际请求的类型不一样。
       
       之后直接通过curl命令的方式直接在跳板机操作
       
       //查看mapping
       curl -X GET -H "Content-Type:application/json" 'http://localhost:9200/hotel_price_v1_index/_mapping'
       
       //查看别名在哪个索引那
        curl -X GET -H "Content-Type:application/json" 'http://localhost:9200/_alias/hotel_index'
        
       //新增hotel类型字段
       curl -XPOST -H "Content-Type:application/json" 'http://localhost:9200/hotel_price_v1_index/_mapping/hotel?pretty' -d '{
          "hotel" : {
            "properties" : {
              "lables" : {
                  "type" : "nested",
                  "properties" : {
                    "lableName" :{
                      "type" : "keyword"
                    }
                 }
              }
            }
          }
       }'
       
       //新增lowprice类型字段
        curl -XPOST -H "Content-Type:application/json" 'http://localhost:9200/hotel_price_v1_index/_mapping/lowprice?pretty' -d '{
          "lowprice" : {
            "_routing" : {
              "required" : true
            },
            "_parent" : {
              "type" : "hotel"
            },
            "properties" : {
              "traceId" : {
                "type" : "keyword"
              },
              "updateTime" : {
                "type" : "date"
              }
            }
          }'
          
          //查询文档
          curl -H -XPOST "Content-Type : application/json" 'http://localhost:9200/hotel_price_v1_index/lowprice/_search' -d '{
            "query" : {
                "bool" : { 
                    "must" : [
                      {
                        "exists" : {
                          "field" : "traceId"
                        }
                      }
                   ]
               }
            },
            "from" : 0,
            "size" : 1
          }'
     
       
