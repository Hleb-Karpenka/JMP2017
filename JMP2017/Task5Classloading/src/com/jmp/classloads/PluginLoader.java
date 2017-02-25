package com.jmp.classloads;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader extends ClassLoader {
    private Map<String, Class<?>> cacheClass = new HashMap<>();
    private ClassLoader parent;

    public PluginLoader(ClassLoader parent) {
        this.parent = parent;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = cacheClass.get(name);

        if (result == null) {
            result = parent.loadClass(name);
        }

        return result;
    }

    public void loadPlugin(String strPluginFile) throws IOException {
        JarFile jarFile = new JarFile("plugins/" + strPluginFile);

        Enumeration<JarEntry> jarEntries = jarFile.entries();

        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            if (jarEntry.isDirectory())
                continue;

            if (jarEntry.getName().endsWith(".class")) {
                byte[] classData = loadClassData(jarFile, jarEntry);

                if (classData != null) {
                    Class<?> clazz = defineClass(
                            jarEntry.getName().replace('/', '.').substring(0,jarEntry.getName().length() - 6),
                            classData, 0, classData.length);
                    cacheClass.put(clazz.getName(), clazz);
                }
            }
        }
    }

    public void loadPlugins() throws IOException {
        // get list of jars

        String[] jarList = new File("plugins/").list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.toLowerCase().endsWith(".jar");
            }
        });

        // load all jars

        for (String strJarFile : jarList) {
            loadPlugin(strJarFile);
        }
    }

    // get byte-code of class

    private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry)
            throws IOException {
        long size = jarEntry.getSize();
        if (size <= 0)
            return null;
        else if (size > Integer.MAX_VALUE) {
            throw new IOException("Class size too long");
        }

        byte[] buffer = new byte[(int) size];
        InputStream is = jarFile.getInputStream(jarEntry);
        is.read(buffer);

        return buffer;
    }
}
