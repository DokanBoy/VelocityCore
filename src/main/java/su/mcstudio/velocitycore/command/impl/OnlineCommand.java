package su.mcstudio.velocitycore.command.impl;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;

/**
 * @author Alexey Zakharov
 * @since 21.06.2020
 */
@CommandAlias("core")
@CommandPermission("core.online")
@Description("Узнать онлайн на сервере")
public class OnlineCommand extends BaseCommand {
    
    public OnlineCommand() {
    
    }
    
    @Default
    @Syntax("[server]")
    public void onOnlineCommand() {
    
    }
    
}
