package su.mcstudio.velocitycore.command;

import co.aikar.commands.VelocityCommandManager;
import com.velocitypowered.api.proxy.ProxyServer;
import su.mcstudio.velocitycore.VelocityCorePlugin;
import su.mcstudio.velocitycore.command.impl.OnlineCommand;
import su.mcstudio.velocitycore.command.impl.SendCommand;

/**
 * @author Alexey Zakharov
 * @date 20.06.2020
 */
public class CommandManager {
    
    private final VelocityCommandManager commandManager;
    
    public CommandManager(ProxyServer server, VelocityCorePlugin plugin) {
        this.commandManager = new VelocityCommandManager(server, plugin);
        
        registerAll();
    }
    
    private void registerAll() {
        commandManager.registerCommand(new OnlineCommand());
        commandManager.registerCommand(new SendCommand());
    }
}
