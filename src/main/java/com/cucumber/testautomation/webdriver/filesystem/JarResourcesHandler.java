package com.cucumber.testautomation.webdriver.filesystem;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JarResourcesHandler {
    public static URI getClassURI(Class clazz) throws URISyntaxException {
        ProtectionDomain domain = clazz.getProtectionDomain();
        CodeSource source = domain.getCodeSource();
        URL location = source.getLocation();
        return location.toURI();
    }
    public static URI getResource(URI resourceLocation, String resourceFileName) throws IOException {
        File location = new File(resourceLocation);
        if(location.isDirectory()) {
            return URI.create(resourceLocation.toString() + resourceFileName);
        }
        try (ZipFile zipFile = new ZipFile(location)) {
            return  extract(zipFile, resourceFileName);
        }
    }
    private static URI extract(ZipFile zipFile, String fileName) throws IOException {
        File tempFile = File.createTempFile(fileName, "");
//        tempFile.setExecutable(true);
        tempFile.deleteOnExit();
        ZipEntry entry = zipFile.getEntry(fileName);
        if(entry == null)
            throw new FileNotFoundException("Cannot find file " + fileName + " inside jar " + zipFile.getName());
        try (InputStream zipStream = zipFile.getInputStream(entry);
             FileOutputStream fileStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int i;
            while ((i = zipStream.read(buffer)) != -1) {
                fileStream.write(buffer, 0, i);
            }
        }
        return tempFile.toURI();
    }
}
