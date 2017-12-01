package com.san.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownloadUtils {
    public static String getFilename(HttpServletRequest request, String filename) throws UnsupportedEncodingException {
        String userAgent = request.getHeader("user-agent");
        // 针对以IE或者Edge为内核的浏览器
        if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
            filename = URLEncoder.encode(filename, "UTF-8");
        } else {
            // 非IE浏览器的处理
            filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        }

        return filename;
    }

}
