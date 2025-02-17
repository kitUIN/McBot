package cn.evole.mods.mcbot;

import cn.evole.mods.mcbot.init.config.ModConfig;
import net.fabricmc.loader.api.FabricLoader;
import cn.evole.onebot.sdk.util.BotUtils;
import java.nio.file.Path;
//#if MC >= 11700
//$$ import org.slf4j.Logger;
//$$ import org.slf4j.LoggerFactory;
//#else
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
//#endif

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/10/1 16:58
 * Version: 1.0
 */
public class Const {
    public static final String MODID = "mcbot";
    //#if MC >= 11700
    //$$ public static final Logger LOGGER = LoggerFactory.getLogger("McBot");
    //#else
    public static final Logger LOGGER = LogManager.getLogger("McBot");
    //#endif
    public static boolean isShutdown = false;
    public static Path configDir = FabricLoader.getInstance().getConfigDir();

    public static boolean isLoad(String modId){
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    public static void sendGroupMsg(String message){
        for (long id : ModConfig.INSTANCE.getCommon().getGroupIdList()){
            groupMsg(id, message);
        }
    }

    public static void groupMsg(long id, String message){
        // 发送消息时实际上所调用的函数。
        if (ModConfig.INSTANCE.getBotConfig().getMsgType().equalsIgnoreCase("string")){
            McBot.messageThread.submit(id, message, false);
        }
        else {
            McBot.messageThread.submit(id, BotUtils.rawToJson(message), false);
        }
    }

    public static void sendGuildMsg(String message){
        for (String id : ModConfig.INSTANCE.getCommon().getChannelIdList()){
            guildMsg(ModConfig.INSTANCE.getCommon().getGuildId(), id, message);
        }
    }

    public static void guildMsg(String guildId, String channelId, String message){
        if (ModConfig.INSTANCE.getBotConfig().getMsgType().equalsIgnoreCase("string")){
            McBot.messageThread.submit(guildId, channelId, message);
        }
        else {
            McBot.messageThread.submit(guildId, channelId, BotUtils.rawToJson(message));
        }
    }
}



