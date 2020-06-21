package su.mcstudio.velocitycore.command.impl;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.velocitypowered.api.proxy.Player;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */

@CommandAlias("core")
@CommandPermission("core.admin")
public class CoreCommand extends BaseCommand {
    
    public CoreCommand() {
    
    }
    
    @Default
    @Subcommand("help")
    @Description("Получить информацию о плагине")
    public void onInfo(Player player) {
        for (String s : )
    }
}
