package customer.supu.controller;

import customer.supu.common.utils.wx.util.WXAuthUtil;
import customer.supu.common.utils.wx.util.WXUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/ticket")
public class WXTicketController {
    @RequestMapping(value="/getWXConfig",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getWXConfig(HttpServletRequest request,String url) throws NoSuchAlgorithmException {
        String jsapi_ticket =WXUtil.getTicket(WXUtil.getAccessToken());
        Map<String, String> ret = WXUtil.sign(jsapi_ticket,url);
        return ret;
    }
}
