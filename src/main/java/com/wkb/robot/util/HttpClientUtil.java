package com.wkb.robot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.*;

public class HttpClientUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	/**
	 *
	 * @param http
	 * @param headers  {[User-Agent=Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)]}
	 */
	public static void setHeader(HttpRequestBase http , String headers) {
		if(StringUtil.isNoEmpty(headers)) {
			if("{[".indexOf(headers.substring(0,2)) != -1) {
				int end = headers.indexOf("]");
				if(end!=-1) {
					String header = headers.substring(2,end);
					String key = header.substring(0,header.indexOf("="));
					String value = header.substring(header.indexOf("=")+1);
					if(StringUtil.isNoEmpty(value)) {
						http.setHeader(key, value);
					} else {
						http.removeHeaders(key);
					}
					headers = headers.replace("["+header+"]","");
					setHeader(http, headers);
				}
			}
		}
	}

	public static String doRequest(String httpType, String url, JSONObject param, HttpClient httpClient, String type) throws Exception {

		String result = "";
		HttpEntity entity = null;
		String status  = "";
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		if (httpType != null && url != null && !"".equals(url)) {
			if(param != null){
				Map<String, Object> props = param;
				Iterator<String> it = props.keySet().iterator();

				while (it.hasNext()) {
					String key = it.next();
					Object obj = props.get(key);
					String objstr = "";

					if (obj instanceof String) {
						objstr = (String) obj;
					} else if (obj instanceof Boolean) {
						objstr = ((Boolean) obj).toString();
					} else if (obj instanceof Integer) {
						objstr = ((Integer) obj).toString();
					} else {
						objstr = JSON.toJSONString(obj);
					}

					if (null == obj) {
						continue;
					}

					params.add(new BasicNameValuePair(key, objstr));
				}
			}

			if (httpType.equals("get")) {
				HttpGet getMethod = new HttpGet(url);
				if (!param.isEmpty()) {
					String str = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
					logger.info(str);
					getMethod.setURI(new URI(url + "?" + str));
				}
//				getMethod.setURI(new URI(url));

				HttpResponse httpresponse = httpClient.execute(getMethod);
				try {
					if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						status = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						//获取服务器返回Http的Content-Type的值
//                        String tempStr=httpresponse.getHeaders("Content-Type")[0].getValue().toString();
						entity = httpresponse.getEntity();
						result = EntityUtils.toString(entity);
//						logger.info(url + " 请求成功 ： " + status+" , 返回内容 : "+EntityUtils.toString(entity));
					} else {
						status = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						//获取服务器返回Http的Content-Type的值
//                        String tempStr=httpresponse.getHeaders("Content-Type")[0].getValue().toString();
						entity = httpresponse.getEntity();
						result = EntityUtils.toString(entity);
						logger.info("statusCode : "+status+", "+EntityUtils.toString(entity));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					getMethod.abort();
				}
			} else if (httpType.equals("post")) {
				HttpPost postMethod = new HttpPost(url);
//				postMethod.addHeader("accept", "application/json");
				if(type != null && type.equals("json")){
					postMethod.addHeader("Content-Type", "application/json;charset=UTF-8");
					postMethod.setEntity(new StringEntity(param.toString(),"UTF-8"));
				}else{
					postMethod.addHeader("accept", "application/json");
					postMethod.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
				}


				HttpResponse httpresponse = httpClient.execute(postMethod);

				try {
					if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						status = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						logger.info(url + " 请求成功 status： " + status);
						logger.info("请求内容 : " + param.toJSONString());
						entity = httpresponse.getEntity();
						result = EntityUtils.toString(entity);
					} else {
						logger.info(url + " 请求失败" + status);
						status = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						entity = httpresponse.getEntity();
						result = EntityUtils.toString(entity);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					postMethod.abort();
				}
			}
		}
		return result;
	}





	private static void setHeader(HttpRequestBase http, HttpClient client) {
		if (StringUtil.isNoEmpty((String) client.getParams().getParameter("http.header"))) {
			HttpClientUtil.setHeader(http, (String) client.getParams().getParameter("http.header"));
		}
		client.getParams().setParameter("Cache_Control", "no-cache");
		client.getParams().setParameter("Pragma", "no-cache");
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);

	}

	/**
	 * 回写数据方法
	 * @param httpType  回写方法类型  get post  put
	 * @param url  回写调用的url
	 * @param param  回写的json数据
	 * @return  回写内容字符串
	 * @throws Exception
	 */
	public static String callBack(String httpType, String url, JSONObject param) throws Exception {
		logger.info("执行数据请求");
		logger.info("执行数据请求数据："+param.toJSONString());


		String result = "false";
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		String callBackMsg = "";
		HttpClientUtils httpClientUtils = new HttpClientUtils();

		HttpClient httpClient = httpClientUtils.getHttpClient();
		if (httpType != null && url != null && !"".equals(url)) {
			if (httpType.equals("get")) {
				params.add(new BasicNameValuePair("param", param.toString()));
				HttpGet getMethod = new HttpGet(url);
				if (!param.isEmpty()) {
					String str = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
					logger.info(str);
					getMethod.setURI(new URI(url + "?" + str));
				}
				getMethod.setURI(new URI(url));

				HttpResponse httpresponse = httpClient.execute(getMethod);
				try {
					if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						result = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						//获取服务器返回Http的Content-Type的值
//                        String tempStr=httpresponse.getHeaders("Content-Type")[0].getValue().toString();
						HttpEntity entity = httpresponse.getEntity();
						callBackMsg = EntityUtils.toString(entity);
						logger.info(url + " 执行成功 ： " + result + " , 返回内容 : " + callBackMsg);
					} else {
						result = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						//获取服务器返回Http的Content-Type的值
//                        String tempStr=httpresponse.getHeaders("Content-Type")[0].getValue().toString();
						HttpEntity entity = httpresponse.getEntity();
						callBackMsg = EntityUtils.toString(entity);
						logger.info("statusCode : " + result + ", " + callBackMsg);
					}
				} catch (Exception e) {
					logger.info(e.getMessage(), e);
				} finally {
					getMethod.abort();
				}
			} else if (httpType.equals("post")) {
				HttpPost postMethod = new HttpPost(url);
				StringEntity paramEntity = new StringEntity(param.toString(), "utf-8");
				postMethod.setEntity(paramEntity);
				postMethod.addHeader("Content-Type", "application/json;charset=UTF-8");

				Date start = new Date();
				logger.info("对以下链接： " + url + " 请求时间为： " + start);
				HttpResponse httpresponse = httpClient.execute(postMethod);
				Date end = new Date();
				logger.info("对以下链接：" + url + " 消耗时间为： " + (end.getTime() - start.getTime()));
				try {
					if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						result = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						logger.info(url + " 执行成功 status： " + result);
						logger.info("执行内容 : " + param.toJSONString());
						HttpEntity entity = httpresponse.getEntity();
						callBackMsg = EntityUtils.toString(entity);
						logger.info(callBackMsg);
						logger.info(result);
					} else {
						logger.info(url + " 执行请求失败" + result);
						result = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						HttpEntity entity = httpresponse.getEntity();
						callBackMsg = EntityUtils.toString(entity);
						logger.info(callBackMsg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					postMethod.abort();
				}
			} else if (httpType.equals("put")) {
				HttpPut putMethod = new HttpPut(url);
				StringEntity paramEntity = new StringEntity(param.toString(), "utf-8");
				putMethod.setEntity(paramEntity);
				putMethod.addHeader("Content-Type", "application/json;charset=UTF-8");
				HttpResponse httpresponse = httpClient.execute(putMethod);
				try {
					if (httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						result = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						logger.info(url + "执行成功status:" + result);
						logger.info("执行内容: " + param.toJSONString());
						HttpEntity entity = httpresponse.getEntity();
						callBackMsg = EntityUtils.toString(entity);
						logger.info(callBackMsg);
						logger.info(result);
					} else {
						logger.info(url + " 执行请求失败" + result);
						result = String.valueOf(httpresponse.getStatusLine().getStatusCode());
						HttpEntity entity = httpresponse.getEntity();
						callBackMsg = EntityUtils.toString(entity);
						logger.info(callBackMsg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					putMethod.abort();
				}
			}
		}
		return result;
	}


}
