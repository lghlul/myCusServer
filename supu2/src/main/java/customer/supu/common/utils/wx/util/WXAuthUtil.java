package customer.supu.common.utils.wx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WXAuthUtil {

    //速扑公众号
//    public static final String APPID="wxf807c2429fa726f8";
//    public static final String APPSECRET ="87c12b7bbb15fa8b5ab50db00c6a6eb0";
//    public static final String redirect_uri = "http://www.spartner.cn/wx/callBack";
//
//    private static final String TOKEN = "immco";

    //测试公众号
    public static final String APPID="wx8be994d65a7bc6f0";
    public static final String APPSECRET ="081a42b9956d5f37662ef65aca618525";
    public static final String redirect_uri = "http://n1987212y0.51mypc.cn/wx/callBack";
    private static final String TOKEN = "immco";
    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
        JSONObject jsonObject =null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet =new HttpGet(url);
        HttpResponse response =  client.execute(httpGet);
        HttpEntity entity =response.getEntity();
        if(entity!=null)
        {
            //把返回的结果转换为JSON对象
            String result =EntityUtils.toString(entity, "UTF-8");
            jsonObject =JSON.parseObject(result);
        }

        return jsonObject;
    }

}