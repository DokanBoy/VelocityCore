package su.mcstudio.velocitycore.command;

import co.aikar.commands.VelocityCommandManager;
import com.velocitypowered.api.proxy.ProxyServer;
import su.mcstudio.velocitycore.VelocityCorePlugin;
import su.mcstudio.velocitycore.command.impl.CoreCommand;
import su.mcstudio.velocitycore.command.impl.OnlineCommand;
import su.mcstudio.velocitycore.command.impl.SendCommand;
import su.mcstudio.velocitycore.command.impl.ServerCommand;

/**
 * @author Alexey Zakharov
 * @since 20.06.2020
 */
public final class CommandManager {
    
    private final VelocityCommandManager commandManager;
    
    public CommandManager(ProxyServer server, VelocityCorePlugin plugin) {
        this.commandManager = new VelocityCommandManager(server, plugin);
        
        registerAll();
    }
    
    private void registerAll() {
        commandManager.registerCommand(new CoreCommand());
        commandManager.registerCommand(new OnlineCommand());
        commandManager.registerCommand(new SendCommand());
        commandManager.registerCommand(new ServerCommand());
    }
    
}
