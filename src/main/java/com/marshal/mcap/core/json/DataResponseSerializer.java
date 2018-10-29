package com.marshal.mcap.core.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.activiti.rest.common.api.DataResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/10/29
 * Time: 20:34
 * Description:为工作流量身定制的序列化格式
 */
public class DataResponseSerializer extends JsonSerializer<DataResponse> {
    @Override
    public void serialize(DataResponse dataResponse, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(dataResponse!=null){
            Map<String,Object> result = new HashMap<>();
            result.put("total",dataResponse.getTotal());
            result.put("rows",dataResponse.getData());
            result.put("success","true");
            result.put("message","sucess");
            jsonGenerator.writeObject(result);
        }else {
            jsonGenerator.writeObject(JSON.toJSON(dataResponse));
        }
    }
}
