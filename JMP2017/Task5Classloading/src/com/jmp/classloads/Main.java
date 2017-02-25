package com.jmp.classloads;

import com.jmp.classloads.IPlugin;
import com.jmp.classloads.PluginLoader;

public class Main {

    public static void main(String[] args) throws Exception {
        PluginLoader loader = new PluginLoader(Main.class.getClassLoader());

        loader.loadPlugins();

        IPlugin plugin = (IPlugin) loader.loadClass("com.jmp.classloads.Plugin")
                .newInstance();

        plugin.run();
    }
}
