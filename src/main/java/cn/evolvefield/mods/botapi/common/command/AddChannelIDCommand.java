package cn.evolvefield.mods.botapi.common.command;

import cn.evolvefield.mods.botapi.init.handler.ConfigHandler;
import cn.evolvefield.mods.multi.common.ComponentWrapper;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;

public class AddChannelIDCommand {


    public static int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var id = context.getArgument("ChannelID", String.class);
        ConfigHandler.cached().getCommon().setGuildOn(true);
        if (ConfigHandler.cached().getCommon().getChannelIdList().contains(id)) {
            context.getSource().sendSuccess(ComponentWrapper.literal("子频道号:" + id + "已经出现了！"), true);
        } else {
            ConfigHandler.cached().getCommon().addChannelId(id);
        }
        ConfigHandler.save();
        return 1;
    }


}
