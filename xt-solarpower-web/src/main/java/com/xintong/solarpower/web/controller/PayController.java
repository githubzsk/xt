package com.xintong.solarpower.web.controller;

import com.alipay.api.internal.util.AlipaySignature;
import com.xintong.solarpower.web.AliPayService;
import com.xintong.solarpower.web.config.AlipayConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("pay")
public class PayController {

    @Autowired
    private AliPayService aliPayService;

    @RequestMapping(value = "returnUrl")
    public String returnUrl(){
        System.out.println("return url");
        return "paySuccess";
    }

    @RequestMapping(value = "pay")
    public String aliPay(HttpServletRequest request , HttpServletResponse response){
        // 为防止订单号重否 此处模拟生成唯一订单号
       String outTradeNo = "123000123d4271";
       String subject = "王八犊子";
       String totalAmount  ="0.1";
       String body = "快快来买嘛";
            return aliPayService.alipay(outTradeNo,subject,totalAmount,body, AlipayConfig.NOTIFY_URL,request,response);

    }

    /**
     * 支付宝异步回调
     */
    @RequestMapping(value = "orderNotify", method = RequestMethod.POST)
    public void orderNotify(HttpServletResponse response, HttpServletRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        // 支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
        // 交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
        // 付款金额
        BigDecimal payMoney = new BigDecimal(request.getParameter("total_amount"));
        // 到账金额
        BigDecimal receiptMoney = new BigDecimal(request.getParameter("receipt_amount"));
        // 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//https://docs.open.alipay.com/270/
        boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.CHARSET, "RSA2");

        if (verify_result) {// 验证成功
            // ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
            if (trade_status.equals("TRADE_FINISHED")) {
                // 判断该笔订单是否在商户网站中已经做过处理
                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                // 请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                // 如果有做过处理，不执行商户的业务程序
                // 注意：
                // 如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                // 如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                System.out.println("交易完成");
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                // 支付交易成功  处理订单
                System.out.println("交易成功");
            }
        } else {// 验证失败
            System.out.println("验证失败");
        }

    }




    /**
     * 生成订单号
     *
     * @return
     */
    protected String doOrderNum() {
        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSSS");
        String subjectno = allTime.format(new Date())+random.nextInt(10);
        return subjectno+random.nextInt(10);
    }

}
