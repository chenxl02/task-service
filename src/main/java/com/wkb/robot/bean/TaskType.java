package com.wkb.robot.bean;

/**
 * Created by chenxl on 2017/7/20.
 */
public class TaskType {

    /*报价类型的任务*/
    public static final String QUOTE ="quote" ;
    /*报价查询的任务*/
    public static final String QUOTEQUERY ="quoteQuery" ;

    /*核保类型的任务*/
    public static final String INSURE ="insure" ;
    /*核保查询的任务*/
    public static final String INSUREQUERY ="insureQuery" ;
    /*保单查询的任务*/
    public static final String APPROVEDQUERY ="approvedQuery" ;


    /*支付任务，获取支付二维码或者支付链*/
    public static final String PAY ="pay" ;

    /*信息采集接口任务（北京单独有）*/
    public static final String PERSONINFOCONFIRM ="personInfoConfirm" ;

    /*短信验证发起（北京独有）*/
        public static final String SUBMITPIN ="submitPin" ;

    /*短信验证填写（北京独有）*/
    public static final String INPUTPIN ="inputPin" ;

    /*车辆信息带出（北京独有）*/
    public static final String CARINFOQUERY ="carInfoQuery" ;

    /*车型查询，同步操作*/
    public static final String CARTYPEQUERY ="carTypeQuery" ;

    /*对账功能，查询保单列表*/
    public static final String APPROVEDLISTQUERY ="approvedListQuery" ;

    //续保信息查询
    public static final String CONTINUEINFOQUERY ="continueInfoQuery" ;
    
    /*保单下载的任务 add by zhangyulong 20180126*/
    public static final String GETELECTRICPOLICYPDF ="getElectricPolicyPdf" ;
    
    /*续保核保任务*/
	public static final String CONTINUEINSURE = "continueInsure";
	
	/*二维码支付任务*/
	public static final String QRCODEPAY = "QRCodePay";
	
	/*保持登录任务*/
	public static final String KEEPLOGIN = "keepLogin";

}
