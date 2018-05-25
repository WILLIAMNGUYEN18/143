//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraftforge.gradle;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GradleStartCommon {
      protected static Logger LOGGER = LogManager.getLogger("GradleStart");
      private static final String NO_CORE_SEARCH = "noCoreSearch";
      private Map<String, String> argMap = Maps.newHashMap();
      private List<String> extras = Lists.newArrayList();
      private static final File SRG_DIR = new File("", "\\lib\\gradle\\srgs");
      private static final File SRG_NOTCH_SRG = new File("", "\\lib\\gradle\\srgs\\notch-srg.srg");
      private static final File SRG_NOTCH_MCP = new File("", "\\lib\\gradle\\srgs\\notch-mcp.srg");
      private static final File SRG_SRG_MCP = new File("", "\\lib\\gradle\\srgs\\srg-mcp.srg");
      private static final File SRG_MCP_SRG = new File("", "\\lib\\gradle\\srgs\\mcp-srg.srg");
      private static final File SRG_MCP_NOTCH = new File("", "\\lib\\gradle\\srgs\\mcp-notch.srg");
      private static final File CSV_DIR = new File("", "\\lib\\gradle\\conf");
      private static final String MC_VERSION = "1.7.10";
      private static final String FML_PACK_OLD = "cpw.mods";
      private static final String FML_PACK_NEW = "net.minecraftforge";
      private static final String COREMOD_VAR = "fml.coreMods.load";
      private static final String COREMOD_MF = "FMLCorePlugin";
      private static final String MOD_ATD_CLASS = "fml.common.asm.transformers.ModAccessTransformer";
      private static final String MOD_AT_METHOD = "addJar";
      public static final Map<String, File> coreMap = Maps.newHashMap();

      public GradleStartCommon() {
      }

      protected abstract void setDefaultArguments(Map<String, String> var1);

      protected abstract void preLaunch(Map<String, String> var1, List<String> var2);

      protected abstract String getBounceClass();

      protected abstract String getTweakClass();

      protected void launch(String[] var1) throws Throwable {
            System.setProperty("net.minecraftforge.gradle.GradleStart.srgDir", SRG_DIR.getCanonicalPath());
            System.setProperty("net.minecraftforge.gradle.GradleStart.srg.notch-srg", SRG_NOTCH_SRG.getCanonicalPath());
            System.setProperty("net.minecraftforge.gradle.GradleStart.srg.notch-mcp", SRG_NOTCH_MCP.getCanonicalPath());
            System.setProperty("net.minecraftforge.gradle.GradleStart.srg.srg-mcp", SRG_SRG_MCP.getCanonicalPath());
            System.setProperty("net.minecraftforge.gradle.GradleStart.srg.mcp-srg", SRG_MCP_SRG.getCanonicalPath());
            System.setProperty("net.minecraftforge.gradle.GradleStart.srg.mcp-notch", SRG_MCP_NOTCH.getCanonicalPath());
            System.setProperty("net.minecraftforge.gradle.GradleStart.csvDir", CSV_DIR.getCanonicalPath());
            this.setDefaultArguments(this.argMap);
            this.parseArgs(var1);
            this.preLaunch(this.argMap, this.extras);
            System.setProperty("fml.ignoreInvalidMinecraftCertificates", "true");
            if(this.argMap.get("noCoreSearch") == null) {
                  this.searchCoremods();
            } else {
                  LOGGER.info("GradleStart coremod searching disabled!");
            }

            var1 = this.getArgs();
            this.argMap = null;
            this.extras = null;
            System.gc();
            String var2 = this.getBounceClass();
            if(var2.endsWith("launchwrapper.Launch")) {
                  Launch.main(var1);
            } else {
                  Class.forName(this.getBounceClass()).getDeclaredMethod("main", new Class[]{String[].class}).invoke((Object)null, new Object[]{var1});
            }

      }

      private String[] getArgs() {
            ArrayList var1 = new ArrayList(22);
            Iterator var2 = this.argMap.entrySet().iterator();

            while(var2.hasNext()) {
                  Entry var3 = (Entry)var2.next();
                  String var4 = (String)var3.getValue();
                  if(!Strings.isNullOrEmpty(var4)) {
                        var1.add("--" + (String)var3.getKey());
                        var1.add(var4);
                  }
            }

            if(!Strings.isNullOrEmpty(this.getTweakClass())) {
                  var1.add("--tweakClass");
                  var1.add(this.getTweakClass());
            }

            if(this.extras != null) {
                  var1.addAll(this.extras);
            }

            String[] var5 = (String[])var1.toArray(new String[0]);
            StringBuilder var6 = new StringBuilder();
            var6.append('[');

            for(int var7 = 0; var7 < var5.length; ++var7) {
                  var6.append(var5[var7]).append(", ");
                  if("--accessToken".equalsIgnoreCase(var5[var7])) {
                        var6.append("{REDACTED}, ");
                        ++var7;
                  }
            }

            var6.replace(var6.length() - 2, var6.length(), "");
            var6.append(']');
            LOGGER.info("Running with arguments: " + var6.toString());
            return var5;
      }

      private void parseArgs(String[] var1) {
            OptionParser var2 = new OptionParser();
            var2.allowsUnrecognizedOptions();
            Iterator var3 = this.argMap.keySet().iterator();

            while(var3.hasNext()) {
                  String var4 = (String)var3.next();
                  var2.accepts(var4).withRequiredArg().ofType(String.class);
            }

            var2.accepts("noCoreSearch");
            NonOptionArgumentSpec var8 = var2.nonOptions();
            OptionSet var9 = var2.parse(var1);
            Iterator var5 = this.argMap.keySet().iterator();

            while(var5.hasNext()) {
                  String var6 = (String)var5.next();
                  if(var9.hasArgument(var6)) {
                        String var7 = (String)var9.valueOf(var6);
                        this.argMap.put(var6, var7);
                        if(!"password".equalsIgnoreCase(var6)) {
                              LOGGER.info(var6 + ": " + var7);
                        }
                  }
            }

            if(var9.has("noCoreSearch")) {
                  this.argMap.put("noCoreSearch", "");
            }

            this.extras = Lists.newArrayList(var8.values(var9));
            LOGGER.info("Extra: " + this.extras);
      }

      protected static Class getFmlClass(String var0) throws ClassNotFoundException {
            return getFmlClass(var0, GradleStartCommon.class.getClassLoader());
      }

      public static Class getFmlClass(String var0, ClassLoader var1) throws ClassNotFoundException {
            if(!var0.startsWith("fml")) {
                  throw new IllegalArgumentException("invalid FML classname");
            } else {
                  if("1.7.10".startsWith("1.7")) {
                        var0 = "cpw.mods." + var0;
                  } else {
                        var0 = "net.minecraftforge." + var0;
                  }

                  return Class.forName(var0, true, var1);
            }
      }

      private void searchCoremods() throws Exception {
            Method var1 = null;

            try {
                  var1 = getFmlClass("fml.common.asm.transformers.ModAccessTransformer").getDeclaredMethod("addJar", new Class[]{JarFile.class});
            } catch (Throwable var10) {
                  ;
            }

            URL[] var2 = ((URLClassLoader)GradleStartCommon.class.getClassLoader()).getURLs();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                  URL var5 = var2[var4];
                  if(var5.getProtocol().startsWith("file")) {
                        File var6 = new File(var5.toURI().getPath());
                        Manifest var7 = null;
                        if(var6.exists()) {
                              if(var6.isDirectory()) {
                                    File var8 = new File(var6, "META-INF/MANIFEST.MF");
                                    if(var8.exists()) {
                                          FileInputStream var9 = new FileInputStream(var8);
                                          var7 = new Manifest(var9);
                                          var9.close();
                                    }
                              } else if(var6.getName().endsWith("jar")) {
                                    JarFile var12 = new JarFile(var6);
                                    var7 = var12.getManifest();
                                    if(var1 != null && var7 != null) {
                                          var1.invoke((Object)null, new Object[]{var12});
                                    }

                                    var12.close();
                              }

                              if(var7 != null) {
                                    String var13 = var7.getMainAttributes().getValue("FMLCorePlugin");
                                    if(!Strings.isNullOrEmpty(var13)) {
                                          LOGGER.info("Found and added coremod: " + var13);
                                          coreMap.put(var13, var6);
                                    }
                              }
                        }
                  }
            }

            HashSet var11 = Sets.newHashSet();
            if(!Strings.isNullOrEmpty(System.getProperty("fml.coreMods.load"))) {
                  var11.addAll(Splitter.on(',').splitToList(System.getProperty("fml.coreMods.load")));
            }

            var11.addAll(coreMap.keySet());
            System.setProperty("fml.coreMods.load", Joiner.on(',').join(var11));
            if(!Strings.isNullOrEmpty(this.getTweakClass())) {
                  this.extras.add("--tweakClass");
                  this.extras.add("net.minecraftforge.gradle.tweakers.CoremodTweaker");
            }

      }

      public static final class AccessTransformerTransformer implements IClassTransformer {
            public AccessTransformerTransformer() {
                  this.doStuff((LaunchClassLoader)this.getClass().getClassLoader());
            }

            private void doStuff(LaunchClassLoader var1) {
                  Class var2 = null;
                  IClassTransformer var3 = null;
                  Iterator var4 = var1.getTransformers().iterator();

                  IClassTransformer var5;
                  while(var4.hasNext()) {
                        var5 = (IClassTransformer)var4.next();
                        if(var5.getClass().getCanonicalName().endsWith("fml.common.asm.transformers.ModAccessTransformer")) {
                              var2 = var5.getClass();
                              var3 = var5;
                        }
                  }

                  if(var2 != null && var3 != null) {
                        var4 = null;

                        Collection var15;
                        Field var16;
                        try {
                              var16 = var2.getSuperclass().getDeclaredFields()[1];
                              var16.setAccessible(true);
                              var15 = ((Multimap)var16.get(var3)).values();
                        } catch (Throwable var13) {
                              GradleStartCommon.LOGGER.log(Level.ERROR, "AccessTransformer.modifiers field was somehow not found...");
                              return;
                        }

                        if(!var15.isEmpty()) {
                              var5 = null;

                              Iterator var7;
                              Object var8;
                              try {
                                    Object var6 = null;
                                    var7 = var15.iterator();
                                    if(var7.hasNext()) {
                                          var8 = var7.next();
                                          var6 = var8;
                                    }

                                    var16 = var6.getClass().getFields()[0];
                                    var16.setAccessible(true);
                              } catch (Throwable var14) {
                                    GradleStartCommon.LOGGER.log(Level.ERROR, "AccessTransformer.Modifier.name field was somehow not found...");
                                    return;
                              }

                              HashMap var17 = Maps.newHashMap();

                              try {
                                    this.readCsv(new File(GradleStartCommon.CSV_DIR, "fields.csv"), var17);
                                    this.readCsv(new File(GradleStartCommon.CSV_DIR, "methods.csv"), var17);
                              } catch (IOException var12) {
                                    GradleStartCommon.LOGGER.log(Level.ERROR, "Could not load CSV files!");
                                    var12.printStackTrace();
                                    return;
                              }

                              GradleStartCommon.LOGGER.log(Level.INFO, "Remapping AccessTransformer rules...");
                              var7 = var15.iterator();

                              while(var7.hasNext()) {
                                    var8 = var7.next();

                                    try {
                                          String var9 = (String)var16.get(var8);
                                          String var10 = (String)var17.get(var9);
                                          if(var10 != null) {
                                                var16.set(var8, var10);
                                          }
                                    } catch (Exception var11) {
                                          ;
                                    }
                              }

                        }
                  } else {
                        GradleStartCommon.LOGGER.log(Level.ERROR, "ModAccessTransformer was somehow not found.");
                  }
            }

            private void readCsv(File var1, Map<String, String> var2) throws IOException {
                  GradleStartCommon.LOGGER.log(Level.DEBUG, "Reading CSV file: {}", new Object[]{var1});
                  Splitter var3 = Splitter.on(',').trimResults().limit(3);
                  Iterator var4 = Files.readLines(var1, Charsets.UTF_8).iterator();

                  while(var4.hasNext()) {
                        String var5 = (String)var4.next();
                        if(!var5.startsWith("searge")) {
                              List var6 = var3.splitToList(var5);
                              var2.put((String) var6.get(0), (String) var6.get(1));
                        }
                  }

            }

            public byte[] transform(String var1, String var2, byte[] var3) {
                  return var3;
            }
      }
}
