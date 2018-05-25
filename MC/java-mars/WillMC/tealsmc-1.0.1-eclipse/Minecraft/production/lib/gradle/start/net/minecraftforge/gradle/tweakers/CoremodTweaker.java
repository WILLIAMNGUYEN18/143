//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraftforge.gradle.tweakers;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.gradle.GradleStartCommon;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoremodTweaker implements ITweaker {
      protected static final Logger LOGGER = LogManager.getLogger("GradleStart");
      private static final String COREMOD_CLASS = "fml.relauncher.CoreModManager";
      private static final String TWEAKER_SORT_FIELD = "tweakSorting";

      public CoremodTweaker() {
      }

      public void acceptOptions(List<String> var1, File var2, File var3, String var4) {
      }

      public void injectIntoClassLoader(LaunchClassLoader var1) {
            try {
                  Field var2 = GradleStartCommon.getFmlClass("fml.relauncher.CoreModManager", var1).getDeclaredField("loadPlugins");
                  var2.setAccessible(true);
                  Class var3 = GradleStartCommon.getFmlClass("fml.relauncher.CoreModManager$FMLPluginWrapper", var1);
                  Constructor var4 = var3.getConstructors()[0];
                  var4.setAccessible(true);
                  Field[] var5 = var3.getDeclaredFields();
                  Field var6 = var5[1];
                  Field var7 = var5[3];
                  Field var8 = var5[2];
                  Field.setAccessible(var3.getConstructors(), true);
                  Field.setAccessible(var5, true);
                  List var9 = (List)var2.get((Object)null);

                  for(int var10 = 0; var10 < var9.size(); ++var10) {
                        ITweaker var11 = (ITweaker)var9.get(var10);
                        if(var3.isInstance(var11)) {
                              Object var12 = var6.get(var11);
                              Object var13 = var7.get(var11);
                              File var14 = (File)GradleStartCommon.coreMap.get(var12.getClass().getCanonicalName());
                              LOGGER.info("Injecting location in coremod {}", new Object[]{var12.getClass().getCanonicalName()});
                              if(var14 != null && var13 == null) {
                                    var9.set(var10, var4.newInstance(new Object[]{(String)var5[0].get(var11), var12, var14, Integer.valueOf(var5[4].getInt(var11)), ((List)var8.get(var11)).toArray(new String[0])}));
                              }
                        }
                  }
            } catch (Throwable var16) {
                  LOGGER.log(Level.ERROR, "Something went wrong with the coremod adding.");
                  var16.printStackTrace();
            }

            String var17 = "net.minecraftforge.gradle.tweakers.AccessTransformerTweaker";
            ((List)Launch.blackboard.get("TweakClasses")).add(var17);

            try {
                  Field var18 = GradleStartCommon.getFmlClass("fml.relauncher.CoreModManager", var1).getDeclaredField("tweakSorting");
                  var18.setAccessible(true);
                  ((Map)var18.get((Object)null)).put(var17, Integer.valueOf(1001));
            } catch (Throwable var15) {
                  LOGGER.log(Level.ERROR, "Something went wrong with the adding the AT tweaker adding.");
                  var15.printStackTrace();
            }

      }

      public String getLaunchTarget() {
            return null;
      }

      public String[] getLaunchArguments() {
            return new String[0];
      }
}
