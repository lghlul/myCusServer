/*
 * Copyright 2015 Focus Technology, Co., Ltd. All rights reserved.
 */
package customer.supu.common.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HttpClientUtils.java
 *
 * @author Administrator
 */
public class HttpClientUtils {
    private final static Log LOG = LogFactory.getLog("controller");

    private int _maxRetryTimes = 0;
    private static final int DEFAULT_MAX_RETRY_TIMES = 0;
    private static final String KEYWORDS_READ_TIMED_OUT = "Read timed out";

    public static final String CHARSET = "UTF-8";

    public static final String IO_ERROR_MESSAGE = "Connection IO error.";
    public static final String CONNECT_TIMED_OUT_MESSAGE = "connect timed out.";
    public static final String READ_TIMED_OUT_MESSAGE = "Read timed out.";

    // 设置连接超时时间
    public static final int DEFAULT_CONNECTION_TIMEOUT = (10 * 1000);
    // 设置读取超时时间
    public static final int DEFAULT_READ_TIMEOUT = (30 * 1000);

    public HttpClientUtils() {
        this(DEFAULT_MAX_RETRY_TIMES);
    }

    public HttpClientUtils(int maxRetryTimes) {
        this._maxRetryTimes = maxRetryTimes;
    }

    public ResponseWrapper sendGet(String url) throws Exception {
        return sendGet(url, EContentType.HTML);
    }

    public ResponseWrapper sendGet(String url, EContentType type) throws Exception {
        return doRequest(url, null, RequestMethod.GET, type, null, null);
    }

    public ResponseWrapper sendGet(String url, EContentType type, Map<String, String> map, Integer statusCode)
            throws Exception {
        return doRequest(url, null, RequestMethod.GET, type, map, statusCode);
    }

    public ResponseWrapper sendPost(String url, String content) throws Exception {
        return sendPost(url, content, EContentType.HTML);
    }

    public ResponseWrapper sendPost(String url, String content, EContentType type) throws Exception {
        return doRequest(url, content, RequestMethod.POST, type, null, null);
    }

    public ResponseWrapper sendPost(String url, String content, EContentType type, Map<String, String> map,
            Integer statusCode) throws Exception {
        return doRequest(url, content, RequestMethod.POST, type, map, statusCode);
    }

    public ResponseWrapper doRequest(String url, String content, RequestMethod method, EContentType type,
            Map<String, String> map, Integer statusCode) throws Exception {
        ResponseWrapper response = null;
        for (int retryTimes = 0;; retryTimes++) {
            try {
                response = _doRequest(url, content, method, type, map, statusCode);
                break;
            }
            catch (SocketTimeoutException e) {
                if (KEYWORDS_READ_TIMED_OUT.equals(e.getMessage())) {
                    throw new Exception(READ_TIMED_OUT_MESSAGE, e);
                }
                else {
                    if (retryTimes >= _maxRetryTimes) {
                        throw new Exception(CONNECT_TIMED_OUT_MESSAGE, e);
                    }
                    else {
                        LOG.debug("connect timed out - retry again - " + (retryTimes + 1));
                    }
                }
            }
        }
        return response;
    }

    private ResponseWrapper _doRequest(String url, String content, RequestMethod method, EContentType type,
            Map<String, String> map, Integer statusCode) throws SocketTimeoutException, Exception {
        ResponseWrapper wrapper = new ResponseWrapper();
        LOG.debug("Send request - " + method.toString() + " " + url);
        if (null != content) {
            LOG.debug("Request Content - " + content);
        }

        HttpURLConnection conn = null;
        OutputStream out = null;
        StringBuffer sb = new StringBuffer();
        String boundary = RandomStringUtils.randomAlphanumeric(20);
        try {
            URL aUrl = new URL(url);

            conn = (HttpURLConnection) aUrl.openConnection();

            conn.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
            conn.setReadTimeout(DEFAULT_READ_TIMEOUT);
            conn.setUseCaches(false);
            conn.setRequestMethod(method.name());
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Accept-Charset", CHARSET);
            conn.setRequestProperty("Charset", CHARSET);
            conn.setRequestProperty("Content-Type", type.type() + ";boundary=" + boundary);
            if (null != map) {
                for (String entry : map.keySet()) {
                    conn.addRequestProperty(entry, map.get(entry));
                }
                // conn.addRequestProperty();

            }
            // conn.addRequestProperty("Authorization",
            // "Basic ZTkwNzE2NDJmMTUwOTI2MTA3MDg1NmExOmE5MzhjNWZkNjkzNGJlMmY1ZWI4OWM3ZQ==");
            if (RequestMethod.GET == method) {
                conn.setDoOutput(false);
            }
            else if (RequestMethod.POST == method) {
                conn.setDoOutput(true);
                if (type.isFile()) {
                    File file = new File(content);

                    String pack =
                            "--" + boundary + "\r\n" + "Content-Type: application/octet-stream" + "\r\n"
                                    + "Content-Disposition: form-data; filename=\"" + file.getName()
                                    + "\"; name=\"Filedata\"" + "\r\n" + "\r\n";
                    out = new BufferedOutputStream(conn.getOutputStream());
                    out.write(pack.getBytes());

                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bytes = new byte[1024];
                    int numReadByte = 0;
                    while ((numReadByte = fileInputStream.read(bytes, 0, 1024)) > 0) {
                        out.write(bytes, 0, numReadByte);
                    }
                    out.write(("\r\n--" + boundary + "--").getBytes());
                    out.flush();
                    fileInputStream.close();
                }
                else {
                    byte[] data = content.getBytes(CHARSET);
                    conn.setRequestProperty("Content-Length", String.valueOf(data.length));
                    out = conn.getOutputStream();
                    out.write(data);
                    out.flush();
                }
            }

            int status = conn.getResponseCode();
            InputStream in = null;
            if (status == 200) {
                in = conn.getInputStream();
            }
            else if (status == statusCode) {
                in = conn.getInputStream();
            }
            else {
                in = conn.getErrorStream();
            }

            if (null != in) {
                InputStreamReader reader = new InputStreamReader(in, CHARSET);
                char[] buff = new char[1024];
                int len;
                while ((len = reader.read(buff)) > 0) {
                    sb.append(buff, 0, len);
                }
            }

            String responseContent = sb.toString();
            wrapper.responseCode = status;
            wrapper.responseContent = responseContent;

            if (status == 200) {
                LOG.debug("Succeed to get response - 200 OK");
                LOG.debug("Response Content - " + responseContent);

            }
            else if (status > 200 && status < 400) {
                LOG.warn("Normal response but unexpected - responseCode:" + status + ", responseContent:"
                        + responseContent);
            }
            else {
                LOG.warn("Got error response - responseCode:" + status + ", responseContent:" + responseContent);

                switch (status) {
                    case 400 :
                        LOG.error("Your request params is invalid. Please check them according to error message.");
                        break;
                    case 401 :
                        LOG.error("Authentication failed! Please check authentication params according to docs.");
                        break;
                    case 403 :
                        LOG.error("Request is forbidden! Maybe your appkey is listed in blacklist?");
                        break;
                    case 410 :
                        LOG.error("Request resource is no longer in service. Please according to notice on official website.");
                    case 429 :
                        LOG.error("Too many requests! Please review your appkey's request quota.");
                        break;
                    case 500 :
                    case 502 :
                    case 503 :
                    case 504 :
                        LOG.error("Seems encountered server error. Please retry later.");
                        break;
                    default :
                        LOG.error("Unexpected response.");
                }

                // throw new Exception();
            }

        }
        catch (SocketTimeoutException e) {
            if (e.getMessage().contains(KEYWORDS_READ_TIMED_OUT)) {
                throw new SocketTimeoutException(KEYWORDS_READ_TIMED_OUT);
            }
            LOG.debug(IO_ERROR_MESSAGE, e);
            throw new Exception(IO_ERROR_MESSAGE, e);

        }
        catch (IOException e) {
            LOG.debug(IO_ERROR_MESSAGE, e);
            throw new Exception(IO_ERROR_MESSAGE, e);

        }
        finally {
            if (null != out) {
                try {
                    out.close();
                }
                catch (IOException e) {
                    LOG.error("Failed to close stream.", e);
                }
            }
            if (null != conn) {
                conn.disconnect();
            }
        }
        return wrapper;
    }
    public static class ResponseWrapper {
        private int responseCode;
        private String responseContent;

        public int getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(int responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseContent() {
            return responseContent;
        }

        public void setResponseContent(String responseContent) {
            this.responseContent = responseContent;
        }

        @Override
        public String toString() {
            return JSONObject.fromObject(this).toString();
        }
    }

    public enum EContentType {

        XML("text/xml"), JSON("application/json"), HTML("text/html"), FORM("application/x-www-form-urlencoded"), FILE(
                "multipart/form-data");
        private String type;

        private EContentType(String type) {
            this.type = type;
        }

        public String type() {
            return this.type;
        }

        public boolean isFile() {
            return FILE.type.equals(this.type);
        }
    }

    public static void main(String[] args) throws Exception {
        HttpClientUtils client = new HttpClientUtils();
        ResponseWrapper wrapper = client.sendPost("http://192.168.1.96:8080/upload", "D:\\usb.txt", EContentType.FILE);
        System.out.println(wrapper.toString());
    }
}
