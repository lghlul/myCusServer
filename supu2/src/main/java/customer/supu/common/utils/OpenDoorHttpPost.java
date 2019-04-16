package customer.supu.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;
import customer.supu.dto.OpenDoorDto;
import customer.supu.dto.returnMsg.returnMsg;
import customer.supu.jenum.OpenDoorMsgEnum;

public class OpenDoorHttpPost {
    public static String sendPost(String url, String param) throws Exception {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");    // POST方法
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(param);
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } finally {

            //System.out.println(result);
            //去掉前面的乱码
//	        	result=  result.substring(1, result.length());
            System.out.println(result);
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //验证开锁状况
        // getOpenDoorDtoByJSON(result);

        return result;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "{'state':0,'state_code':2001,'state_msg':'\u53c2\u6570\u9519\u8bef\u6216\u8d26\u6237\u88ab\u7981\u7528'}";
        JSONObject jsonObject = JSONObject.fromObject(a);
        OpenDoorDto dto = (OpenDoorDto) JSONObject.toBean(jsonObject, OpenDoorDto.class);
        System.out.println(1);


    }
}
/*if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.SUCCESS.getCode().toString())){
	 return result;
}
else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.FAIL.getCode().toString())){
      throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.FAIL.getCode()));

}else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.STATE2001.getCode().toString())){
	   throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.STATE2001.getCode()));

}else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.STATE2002.getCode().toString())){
	   throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.STATE2002.getCode()));

}else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.STATE2003.getCode().toString())){
	   throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.STATE2003.getCode()));

}else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.STATE2004.getCode().toString())){
	   throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.STATE2004.getCode()));

}else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.STATE2005.getCode().toString())){
	   throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.STATE2005.getCode()));

}else if(result.contains("\"state_code\""+":"+OpenDoorMsgEnum.STATE2006.getCode().toString())){
	   throw new Exception(OpenDoorMsgEnum.getName(OpenDoorMsgEnum.STATE2006.getCode()));
}else{
	 throw new Exception("未知错误");
}*/
