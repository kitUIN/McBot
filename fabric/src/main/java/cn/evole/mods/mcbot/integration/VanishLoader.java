package cn.evole.mods.mcbot.integration;


//兼容1.20.1版本vanish
//#if MC == 12001
//$$ import cn.evole.mods.mcbot.init.compat.VanishCompat;
//$$ import me.drex.vanish.util.VanishManager;
//$$ import com.mojang.authlib.GameProfile;
//$$ import net.minecraft.server.level.ServerPlayer;
//$$ import java.util.UUID;
//#endif

public class VanishLoader {
    public static boolean ISLOADED;
    //#if MC == 12001
    //$$ public static boolean isVanished(ServerPlayer player) {
    //$$     if(!ISLOADED) return false;
    //$$     // 获取玩家的 GameProfile
    //$$     GameProfile gameProfile = player.getGameProfile();
    //$$     // 从 GameProfile 中获取 UUID
    //$$     UUID uuid = gameProfile.getId();
    //$$     // 使用 VanishManager.isVanished 方法检查玩家是否处于隐身状态
    //$$     return VanishCompat.VANISH && VanishManager.isVanished(player.getServer(), uuid);
    //$$ }
    //#endif
}