package io.uouo.wechatbot.common;

import com.alibaba.fastjson.JSONObject;
import io.uouo.wechatbot.domain.WechatMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InfoProcessing implements WechatBotCommon {

    private final static Logger log = LoggerFactory.getLogger(InfoProcessing.class);

    public WechatMsg process(String s) {
        log.info("\n" + s);
        WechatMsg obtain = JSONObject.parseObject(s, WechatMsg.class);
        WechatMsg wechatMsg = new WechatMsg();
        wechatMsg.setWxid(obtain.getWxid());

        switch(obtain.getContent()){
            case "cnm" :
                wechatMsg.setContent("whcnm");
                wechatMsg.setType(TXT_MSG);
                break;
            case "nmm" :
                wechatMsg.setContent("whnmm");
                wechatMsg.setType(TXT_MSG);
                break;
            default :
                wechatMsg = null;
        }

        return wechatMsg;
    }
}
