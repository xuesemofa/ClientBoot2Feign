package org.client.com.util.files;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileTool {
    /**
     * 下载文件
     *
     * @param filePath --文件完整路径
     * @param response
     */
    public static void downloadFile(
            String filePath,
            javax.servlet.http.HttpServletResponse response) {


        String fileName = "";
        try {
            if (filePath.lastIndexOf("/") > 0) {
                fileName = new String(filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length()).getBytes("GB2312"), "ISO8859_1");
            } else if (filePath.lastIndexOf("\\") > 0) {
                fileName = new String(filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length()).getBytes("GB2312"), "ISO8859_1");
            }

        } catch (Exception e) {
        }
        //打开指定文件的流信息
        FileInputStream fs = null;
        //设置响应头和保存文件名
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        PrintWriter out = null;
        try {
            fs = new FileInputStream(new File(filePath));
            //写出流信息
            int b = 0;
            out = response.getWriter();
            while ((b = fs.read()) != -1) {
                out.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (fs != null)
                    fs.close();
                if (out != null)
                    out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 新建目录
     *
     * @param folderPath 目录
     * @return 返回目录创建后的路径
     */
    public static void createFolder(String folderPath) {
        try {
            File myFilePath = new File(new String(folderPath.getBytes("UTF-8"), "UTF-8"), "UTF-8");
            if (!myFilePath.exists()) {
                boolean b = myFilePath.mkdir();
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除空目录
     *
     * @param folderPath 目录
     * @return 返回目录创建后的路径
     */
    public static void deleteFolder(String folderPath) {
        try {
            File myFilePath = new File(new String(folderPath.getBytes("UTF-8"), "UTF-8"), "UTF-8");
            if (myFilePath.exists()) {
                boolean b = myFilePath.delete();
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
