//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.Proxy;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraftforge.gradle.GradleStartCommon;
import net.minecraftforge.gradle.OldPropertyMapSerializer;

public class GradleStart extends GradleStartCommon {
      private static final Gson GSON;

      public GradleStart() {
      }

      public static void main(String[] var0) throws Throwable {
            hackNatives();
            (new GradleStart()).launch(var0);
      }

      protected String getBounceClass() {
            return "net.minecraft.launchwrapper.Launch";
      }

      protected String getTweakClass() {
            return "cpw.mods.fml.common.launcher.FMLTweaker";
      }

      protected void setDefaultArguments(Map<String, String> var1) {
            var1.put("version", "1.7.10");
            var1.put("assetIndex", "1.7.10");
            var1.put("assetsDir", new File("").getAbsolutePath() + "\\lib\\gradle\\assets");
            var1.put("accessToken", "FML");
            var1.put("userProperties", "{}");
            var1.put("username", null);
            var1.put("password", null);
      }

      protected void preLaunch(Map<String, String> var1, List<String> var2) {
            if(!Strings.isNullOrEmpty(var1.get("password"))) {
                  GradleStartCommon.LOGGER.info("Password found, attempting login");
                  this.attemptLogin(var1);
            }

            if(!Strings.isNullOrEmpty(var1.get("assetIndex"))) {
                  this.setupAssets(var1);
            }

      }

      private static void hackNatives() {
            String var0 = System.getProperty("java.library.path");
            String var1 = new File("").getAbsolutePath() + "\\lib\\gradle\\natives";
            if(Strings.isNullOrEmpty(var0)) {
                  var0 = var1;
            } else {
                  var0 = var0 + File.pathSeparator + var1;
            }

            System.setProperty("java.library.path", var0);

            try {
                  Field var2 = ClassLoader.class.getDeclaredField("sys_paths");
                  var2.setAccessible(true);
                  var2.set((Object)null, (Object)null);
            } catch (Throwable var3) {
                  ;
            }

      }

      private void attemptLogin(Map<String, String> var1) {
            YggdrasilUserAuthentication var2 = (YggdrasilUserAuthentication)(new YggdrasilAuthenticationService(Proxy.NO_PROXY, "1")).createUserAuthentication(Agent.MINECRAFT);
            var2.setUsername((String)var1.get("username"));
            var2.setPassword((String)var1.get("password"));
            var1.put("password", null);

            try {
                  var2.logIn();
            } catch (AuthenticationException var4) {
                  LOGGER.error("-- Login failed!  " + var4.getMessage());
                  Throwables.propagate(var4);
                  return;
            }

            LOGGER.info("Login Succesful!");
            var1.put("accessToken", var2.getAuthenticatedToken());
            var1.put("uuid", var2.getSelectedProfile().getId().toString().replace("-", ""));
            var1.put("username", var2.getSelectedProfile().getName());
            var1.put("userType", var2.getUserType().getName());
            var1.put("userProperties", (new GsonBuilder()).registerTypeAdapter(PropertyMap.class, new OldPropertyMapSerializer()).create().toJson(var2.getUserProperties()));
      }

      private void setupAssets(Map<String, String> var1) {
            if(Strings.isNullOrEmpty((String)var1.get("assetsDir"))) {
                  throw new IllegalArgumentException("assetsDir is null when assetIndex is not! THIS IS BAD COMMAND LINE ARGUMENTS, fix them");
            } else {
                  File var2 = new File((String)var1.get("assetsDir"));
                  File var3 = new File(var2, "objects");
                  File var4 = new File(new File(var2, "indexes"), (String)var1.get("assetIndex") + ".json");

                  try {
                        GradleStart.AssetIndex var5 = this.loadAssetsIndex(var4);
                        if(!var5.virtual) {
                              return;
                        }

                        File var6 = new File(new File(var2, "virtual"), (String)var1.get("assetIndex"));
                        var1.put("assetsDir", var6.getAbsolutePath());
                        GradleStartCommon.LOGGER.info("Setting up virtual assets in: " + var6.getAbsolutePath());
                        Map var7 = this.gatherFiles(var6);
                        Iterator var8 = var5.objects.entrySet().iterator();

                        while(var8.hasNext()) {
                              Entry var9 = (Entry)var8.next();
                              String var10 = (String)var9.getKey();
                              String var11 = ((GradleStart.AssetIndex.AssetEntry)var9.getValue()).hash.toLowerCase();
                              File var12 = new File(var6, var10);
                              File var13 = new File(new File(var3, var11.substring(0, 2)), var11);
                              if(var7.containsKey(var10)) {
                                    if(((String)var7.get(var10)).equals(var11)) {
                                          var7.remove(var10);
                                    } else {
                                          GradleStartCommon.LOGGER.info("  " + var10 + ": INVALID HASH");
                                          var12.delete();
                                    }
                              } else if(!var13.exists()) {
                                    GradleStartCommon.LOGGER.info("  " + var10 + ": NEW MISSING " + var11);
                              } else {
                                    GradleStartCommon.LOGGER.info("  " + var10 + ": NEW ");
                                    File var14 = var12.getParentFile();
                                    if(!var14.exists()) {
                                          var14.mkdirs();
                                    }

                                    Files.copy(var13, var12);
                              }
                        }

                        var8 = var7.keySet().iterator();

                        while(var8.hasNext()) {
                              String var16 = (String)var8.next();
                              GradleStartCommon.LOGGER.info("  " + var16 + ": REMOVED");
                              File var17 = new File(var6, var16);
                              var17.delete();
                        }
                  } catch (Throwable var15) {
                        Throwables.propagate(var15);
                  }

            }
      }

      private GradleStart.AssetIndex loadAssetsIndex(File var1) throws JsonSyntaxException, JsonIOException, IOException {
            FileReader var2 = new FileReader(var1);
            GradleStart.AssetIndex var3 = (GradleStart.AssetIndex)GSON.fromJson(var2, GradleStart.AssetIndex.class);
            var2.close();
            return var3;
      }

      private String getDigest(File var1) {
            DigestInputStream var2 = null;

            Object var4;
            try {
                  var2 = new DigestInputStream(new FileInputStream(var1), MessageDigest.getInstance("SHA"));
                  byte[] var3 = new byte[65536];

                  int var16;
                  do {
                        var16 = var2.read(var3);
                  } while(var16 > 0);

                  return String.format("%1$040x", new Object[]{new BigInteger(1, var2.getMessageDigest().digest())});
            } catch (Exception var14) {
                  var4 = null;
            } finally {
                  if(var2 != null) {
                        try {
                              var2.close();
                        } catch (Exception var13) {
                              ;
                        }
                  }

            }

            return (String)var4;
      }

      private Map<String, String> gatherFiles(File var1) {
            HashMap var2 = new HashMap();
            this.gatherDir(var2, var1, var1);
            return var2;
      }

      private void gatherDir(Map<String, String> var1, File var2, File var3) {
            if(var3.exists() && var3.isDirectory()) {
                  File[] var4 = var3.listFiles();
                  int var5 = var4.length;

                  for(int var6 = 0; var6 < var5; ++var6) {
                        File var7 = var4[var6];
                        if(var7.isDirectory()) {
                              this.gatherDir(var1, var2, var7);
                        } else {
                              String var8 = var2.toURI().relativize(var7.toURI()).getPath().replace("\\", "/");
                              String var9 = this.getDigest(var7).toLowerCase();
                              var1.put(var8, var9);
                        }
                  }

            }
      }

      static {
            GsonBuilder var0 = new GsonBuilder();
            var0.enableComplexMapKeySerialization();
            var0.setPrettyPrinting();
            GSON = var0.create();
      }

      private static class AssetIndex {
            public boolean virtual;
            public Map<String, GradleStart.AssetIndex.AssetEntry> objects;

            private AssetIndex() {
            }

            public static class AssetEntry {
                  public String hash;

                  public AssetEntry() {
                  }
            }
      }
}
