//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraftforge.gradle.tweakers;

import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class AccessTransformerTweaker implements ITweaker {
      public AccessTransformerTweaker() {
      }

      public void acceptOptions(List<String> var1, File var2, File var3, String var4) {
      }

      public void injectIntoClassLoader(LaunchClassLoader var1) {
            var1.registerTransformer("net.minecraftforge.gradle.GradleStartCommon$AccessTransformerTransformer");
      }

      public String getLaunchTarget() {
            return null;
      }

      public String[] getLaunchArguments() {
            return new String[0];
      }
}
