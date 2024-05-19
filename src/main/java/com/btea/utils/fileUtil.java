package com.btea.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 20:13
 * @Description: 文件上传工具类
 */
public class fileUtil {
    // 设置文件上传最大值（10MB）
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    // 限制上传文件的类型（file类型的文件则不用测验）
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    /**
     *
     * @param file
     * @param request
     * @return 文件的新名字
     */
    public String upload(MultipartFile file, HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            return "上传的文件是空的嘞~";
        }

        // 判断文件大小是否超出限制
        if (file.getSize() > AVATAR_MAX_SIZE) {
            return "上传的文件太大啦！";
        }

        // 判断文件类型
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)) {
            return "上传文件的类型不支持嘞~";
        }

        // 上传文件
        String basePath = request.getServletContext().getRealPath("uploads");
        File dir = new File(basePath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 获取文件的名称，用 Aurora + UUID 组成一个新字符串作为文件名
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String fileName = "Aurora" + UUID.randomUUID().toString() + suffix;
        File dest = new File(dir, fileName);

        // 将参数file中的数据写入空文件中
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

}
