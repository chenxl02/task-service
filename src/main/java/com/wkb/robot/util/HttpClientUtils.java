package com.wkb.robot.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * httpclient工具类
 */
public class HttpClientUtils {


	private final static String UTF8 = "UTF-8";

	public CloseableHttpClient httpclient = null;

	public static final int connectTimeOut = 200000; // 客户端和服务器建立连接的timeout
	public static final int connectRequestTimeOut = 40000; // 从连接池获取连接的timeout
	public static final int socketTimeOut = 30000; // 客户端从服务器读取数据的timeout

	public static RequestConfig params = RequestConfig.custom().setConnectTimeout(connectTimeOut).setConnectionRequestTimeout(connectRequestTimeOut)
		.setSocketTimeout(socketTimeOut).setExpectContinueEnabled(true)
		.build();
	public HttpClientUtils() {


		init();
	}
	

	private void init() {
		// 初始化线程池

		PoolingHttpClientConnectionManager pccm = new PoolingHttpClientConnectionManager();
		pccm.setMaxTotal(50); // 连接池最大并发连接数
		pccm.setDefaultMaxPerRoute(30); // 单路由最大并发数


		
		String HTTP = "http";
	    String HTTPS = "https";
	    SSLConnectionSocketFactory sslsf = null;
	    PoolingHttpClientConnectionManager cm = null;
	    SSLContextBuilder builder = null;
	        try {
	            builder = new SSLContextBuilder();
	            // 全部信任 不做身份鉴定
	            builder.loadTrustMaterial(null, new TrustStrategy() {
	                @Override
	                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
	                    return true;
	                }
	            });
	            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
	            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
	                    .register(HTTP, new PlainConnectionSocketFactory())
	                    .register(HTTPS, sslsf)
	                    .build();
	            cm = new PoolingHttpClientConnectionManager(registry);
	            cm.setMaxTotal(100);//max connection
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	    httpclient = HttpClients.custom()
            .setSSLSocketFactory(sslsf)
            .setConnectionManager(cm)
            .setConnectionManagerShared(true)
            .setDefaultRequestConfig(params)
            /*.setRetryHandler(retryHandler)*/
            .build();
	}

	public HttpClient getHttpClient() {
//		if(httpclient == null) {
//			init();
//		}
        return httpclient;
    }
	


	private String invoke(HttpUriRequest request) {
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, UTF8);
			}
		} catch (IOException e) {
			System.out.println(
					"[HttpClientUtils][invoke][method:" + request.getMethod()
							+ " URI:" + request.getURI()
							+ "] is request exception"+ e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					System.out.println(
							"[HttpClientUtils][invoke][method:"
									+ request.getMethod() + " URI:"
									+ request.getURI()
									+ "] is closed exception"+e);
				}
			}
		}
		return null;
	}
	

}
