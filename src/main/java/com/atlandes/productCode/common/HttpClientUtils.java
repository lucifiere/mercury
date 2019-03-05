package com.atlandes.productCode.common;


import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.jd.baoxian.product.export.vo.res.*;
import com.jd.fastjson.JSON;


/**
 * 使用Apache httpcomponents-client 4.3版本以上实现的HTTP工具.
 * 字符集均为UTF-8
 */
public class HttpClientUtils {


    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final String  PREMIUM_TRIAL_URL ="http://ms.jr.jd.com/gw/generic/pc_bx/h5/m/searchProductSerials";

    /**
     * 处理输入URL
     *
     * @param url
     * @return
     */
    public static URI parse(String url, Map<String, String> parameters, Charset charset) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        builder.setCharset(charset);
        if (parameters != null) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> param : parameters.entrySet()) {
                params.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
            builder.addParameters(params);
        }
        return builder.build();
    }

    /**
     * 发送GET请求  保费试算
     *
     * @param url
     * @param parameters
     * @return
     */

    public static ProductAlternative HttpClientGet(String url ,String parameters) throws Exception {
        Map map =new HashMap();
        map.put("reqData", parameters);
        URI geturl= parse(url,map,DEFAULT_CHARSET);
        // 获取http客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过httpget方式来实现我们的get请求
        HttpGet httpGet = new HttpGet(geturl);
        // 通过client调用execute方法，得到我们的执行结果就是一个response，所有的数据都封装在response里面了
        CloseableHttpResponse Response = client.execute(httpGet);
        // HttpEntity
        // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
        // 所有的响应的数据，也全部都是封装在HttpEntity里面
        HttpEntity entity = Response.getEntity();
        // 通过EntityUtils 来将我们的数据转换成字符串
        String str = EntityUtils.toString(entity, DEFAULT_CHARSET);
        System.out.println(str);
        JSONObject object = JSONObject.parseObject(str);
        String code = object.getJSONObject("resultData").getString("code");
        ProductAlternative fd= null;
        if(code.equalsIgnoreCase("0000")){
            fd= JSON.parseObject(object.getJSONObject("resultData").getString("value"), ProductAlternative.class);
        }
        // 关闭
        Response.close();
        return fd;
    }

}
