package com.answer.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * httpClien工具类
 * 
 * @author wang_lei4
 * 
 */
public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
	private static final String ENCODING_GZIP = "gzip";
	private HttpClient httpclient;

	/**
	 * 通过post提交方式获取url指定的资源和数据
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public String postData(String url) throws Exception {
		return postData(url, null);
	}

	/**
	 * 通过post提交方式获取url指定的资源和数据
	 * 
	 * @param url
	 * @param nameValuePairs
	 *            请求参数
	 * @return
	 * @throws Exception
	 */
	public String postData(String url, List<NameValuePair> nameValuePairs)
			throws Exception {
		return postData(url, nameValuePairs, null);
	}

	/**
	 * 通过post提交方式获取url指定的资源和数据
	 * 
	 * @param url
	 * @param nameValuePairs
	 *            请求参数
	 * @param headers
	 *            请求header参数
	 * @return
	 * @throws Exception
	 */
	public String postData(String url, List<NameValuePair> nameValuePairs,
			Map<String, String> headers) throws Exception {

		long start = System.currentTimeMillis();
		HttpPost httpPost = new HttpPost(url);

		try {

			// 判断请求url是否包含https,如果包含https,则初始化https认证证书
			if (url.indexOf("https") > -1) {
				this.initHttps();
			}

			if (headers != null && headers.size() > 0) {

				Set<Map.Entry<String, String>> set = headers.entrySet();

				for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {

					Map.Entry<String, String> header = it.next();

					if (header != null) {

						httpPost.setHeader(header.getKey(), header.getValue());

					}

				}

			}

			if (nameValuePairs != null && nameValuePairs.size() > 0) {

				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

			}

			HttpResponse response = httpclient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			if (entity == null) {

				return null;

			}

			String info = EntityUtils.toString(entity, "UTF-8");

			return info;

		} catch (Exception e) {
			logger.debug("postData Exception url: {}", url, e);
			throw e;

		} finally {

			httpPost.releaseConnection();

			long interval = System.currentTimeMillis() - start;

			logger.debug("{} 请求耗时：{} ", url, interval);

		}

	}

	/**
	 * 通过ContentType 为json的格式进行http传输
	 * 
	 * @param url
	 *            远程url
	 * @param content
	 *            传输内容
	 * @return
	 * @throws Exception
	 */
	public String postJSONData(String url, String content)
			throws Exception {

		long start = System.currentTimeMillis();

		HttpPost httpPost = new HttpPost(url);

		try {

			if (content != null && content.length() > 0) {

				httpPost.setEntity(new StringEntity(content,
						ContentType.APPLICATION_JSON));

			}

			HttpResponse response = httpclient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			if (entity == null) {

				return null;

			}

			String info = EntityUtils.toString(entity, "UTF-8");

			return info;
		} catch (Exception e) {

			logger.debug("postData Exception url: {}", url, e);

			throw new Exception(e);
		} finally {

			httpPost.releaseConnection();

			long interval = System.currentTimeMillis() - start;

			logger.debug("{} 请求耗时：{} ", url, interval);
		}
	}

	/**
	 * 通过get方法获取url资源的数据
	 * 
	 * @param url
	 *            服务器地址
	 * @return 返回响应的文本，如果请求发生异常，抛出Exception
	 * @throws Exception
	 */
	public String getData(String url) throws Exception {
		return getData(url, null);
	}

	/**
	 * 带header的get请求
	 * 
	 * @param url
	 *            服务器地址
	 * @param headers
	 *            添加的请求header信息
	 * @return 返回服务器响应的文本，出错抛出Exception异常
	 * @throws Exception
	 */
	public String getData(String url, Map<String, String> headers)
			throws Exception {
		long start = System.currentTimeMillis();
		HttpGet httpGet = new HttpGet(url);
		if (headers != null && headers.size() > 0) {
			Set<Map.Entry<String, String>> set = headers.entrySet();
			for (Iterator<Map.Entry<String, String>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<String, String> header = it.next();
				if (header != null) {
					httpGet.setHeader(header.getKey(), header.getValue());
				}
			}
		}
		try {
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				return null;
			}
			String info = EntityUtils.toString(entity, "UTF-8");
			return info;
		} catch (Exception e) {
			logger.debug("getData Exception url: {}", url, e);
			throw new Exception(e);
		} finally {
			httpGet.releaseConnection();
			long interval = System.currentTimeMillis() - start;
			logger.debug("{} 请求耗时：{} ", url, interval);
		}
	}

	/**
	 * 对httpclient 做压缩处理和解压缩处理
	 * 
	 * @param httpclient
	 */
	public void initClient() {
		((DefaultHttpClient) httpclient)
				.addRequestInterceptor(new HttpRequestInterceptor() {
					@Override
					public void process(HttpRequest request, HttpContext context) {
						if (!request.containsHeader(HEADER_ACCEPT_ENCODING)) {
							request.addHeader(HEADER_ACCEPT_ENCODING,
									ENCODING_GZIP);
						}
					}
				});

		((DefaultHttpClient) httpclient)
				.addResponseInterceptor(new HttpResponseInterceptor() {
					@Override
					public void process(HttpResponse response,
							HttpContext context) {
						final HttpEntity entity = response.getEntity();
						if (entity == null) {
							return;
						}
						final Header encoding = entity.getContentEncoding();
						if (encoding != null) {
							for (HeaderElement element : encoding.getElements()) {
								if (element.getName().equalsIgnoreCase(
										ENCODING_GZIP)) {
									response.setEntity(new GzipDecompressingEntity(
											response.getEntity()));
									break;
								}
							}
						}
					}
				});
	}

	/**
	 * 关闭客户端
	 */
	public void destroyClient() {
		httpclient.getConnectionManager().shutdown();
	}
	

	/**
	 * post方式处理文件和图片上传
	 * 
	 * @param url
	 *            服务器地址
	 * @param data
	 *            byte数组数据
	 * @param fileName
	 *            文件名
	 * @param uploadType http文件头中的类型
	 * @return 返回服务器响应信息，否则抛出Exception异常
	 * @throws Exception
	 */
	public String postMultipartData(String url, byte[] data, String fileName, String uploadType)
			throws Exception {
		long start = System.currentTimeMillis();
		HttpPost httpPost = new HttpPost(url);
		try {
			
			if (data != null && data.length > 0) {
				MultipartEntity reqEntity = new MultipartEntity();
				ContentBody contentBody = new ByteArrayBody(data, fileName);
				/*ContentBody body = new StringBody("{\"title\":\"aa\",\"introduction\":\"bb\"}");
				FormBodyPart sb = new FormBodyPart("description", body);*/
				reqEntity.addPart(uploadType, contentBody);
				//reqEntity.addPart(sb);
				
				httpPost.setEntity(reqEntity);
				
			}
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String info = EntityUtils.toString(entity, "UTF-8");
			return info;
		} catch (Exception e) {
			logger.debug("postMultipartData Exception url: {}", url, e);
			throw new Exception( e);
		} finally {
			httpPost.releaseConnection();
			long interval = System.currentTimeMillis() - start;
			logger.debug("{} 请求耗时：{} ", url, interval);
		}
	}

	/**
	 * put 方式提交数据
	 * 
	 * @param url
	 *            ：服务器地址
	 * @param nameValuePairs
	 *            ：参数
	 * @return 返回 服务器返回的文本信息，报错会抛出异常
	 * @throws Exception
	 */
	public String putData(String url, List<NameValuePair> nameValuePairs)
			throws Exception {
		long start = System.currentTimeMillis();
		HttpPut httpPut = new HttpPut(url);

		try {
			if (nameValuePairs != null && nameValuePairs.size() > 0) {
				httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs,
						"UTF-8"));
			}
			HttpResponse response = httpclient.execute(httpPut);
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				return null;
			}
			String info = EntityUtils.toString(entity, "UTF-8");
			return info;
		} catch (Exception e) {
			logger.debug("putData Exception url:{}", url, e);
			throw new Exception( e);
		} finally {
			httpPut.releaseConnection();
			long interval = System.currentTimeMillis() - start;
			logger.debug("{} 请求耗时：{} ", url, interval);
		}
	}

	/**
	 * delete 方式提交数据
	 * 
	 * @param url
	 *            服务器地址
	 * @return 返回 服务器返回的文本信息，报错会抛出异常
	 * @throws Exception
	 */
	public String deleteData(String url) throws Exception {
		return deleteData(url, null);
	}

	/**
	 * delete 方式提交数据
	 * 
	 * @param url
	 *            服务器地址
	 * @return 返回 服务器返回的文本信息，报错会抛出异常
	 */
	public String deleteData(String url, Map<String, String> headers)
			throws Exception {
		long start = System.currentTimeMillis();
		HttpDelete httpDelete = new HttpDelete(url);

		if (headers != null && headers.size() > 0) {
			Set<Map.Entry<String, String>> set = headers.entrySet();
			for (Iterator<Map.Entry<String, String>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<String, String> header = it.next();
				if (header != null) {
					httpDelete.setHeader(header.getKey(), header.getValue());
				}
			}
		}
		try {
			HttpResponse response = httpclient.execute(httpDelete);
			HttpEntity entity = response.getEntity();
			String info = EntityUtils.toString(entity, "UTF-8");
			return info;
		} catch (Exception e) {
			logger.debug("putData Exception url {} ", url, e);
			throw new Exception( e);
		} finally {
			httpDelete.releaseConnection();
			long interval = System.currentTimeMillis() - start;
			logger.debug("{} 请求耗时：{} ", url, interval);
		}
	}

	/**
	 * 下载媒体资源
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public byte[] getMultipartData(String url) throws Exception {
		long start = System.currentTimeMillis();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = httpclient.execute(httpGet);
			byte[] result = EntityUtils.toByteArray(response.getEntity());
			return result;
		} catch (Exception e) {
			logger.debug("putData Exception url {} ", url, e);
			throw new Exception( e);
		} finally {
			httpGet.releaseConnection();
			long interval = System.currentTimeMillis() - start;
			logger.debug("{} 请求耗时：{} ", url, interval);
		}
	}

	public void setHttpclient(HttpClient httpclient) {
		this.httpclient = httpclient;
	}

	private void initHttps() throws NoSuchAlgorithmException,
			KeyManagementException {

		// 创建TrustManager

		X509TrustManager xtm = new X509TrustManager() {

			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
			}

			@Override
            public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[] {};
			}
		};

		SSLContext ctx = SSLContext.getInstance("SSL");

		// 使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
		ctx.init(null, new TrustManager[] { xtm }, null);

		SSLSocketFactory sf = new SSLSocketFactory(ctx,
				SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		Scheme sch = new Scheme("https", 443, sf);
		httpclient.getConnectionManager().getSchemeRegistry().register(sch);

	}
	
	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}
	
	public String getDataByParamMap(String url , Map<String ,Object> paramMap) throws Exception{
		String paramStr = "";
		if(paramMap != null){
			paramStr += "?";
			for(String key : paramMap.keySet()){
				paramStr += key + "=" + paramMap.get(key) + "&";
			}
			paramStr = paramStr.substring(0,paramStr.length() - 1);
		}
		return this.getData(url + paramStr);
	}
	
}
