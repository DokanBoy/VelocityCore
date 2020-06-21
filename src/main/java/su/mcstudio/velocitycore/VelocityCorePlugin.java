package su.mcstudio.velocitycore;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import org.slf4j.Logger;
import su.mcstudio.velocitycore.listener.PlayerJoinListener;
import su.mcstudio.velocitycore.message.repository.HoconMessagesRepository;
import su.mcstudio.velocitycore.message.repository.MessagesRepository;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Alexey Zakharov
 * @date 20.06.2020
 */

@Plugin(id = "core",
    name = "My First Plugin",
    version = "1.0-SNAPSHOT",
    description = "I did it!",
    authors = {"DokanBoy"}
)
public class VelocityCorePlugin {
    
    private static VelocityCorePlugin instance;
    private static MessagesRepository messagesRepository;
    
    private final ProxyServer proxyServer;
    private final Logger logger;
    private final Path path;
    
    @Inject
    public VelocityCorePlugin(ProxyServer proxyServer, Logger logger, @DataDirectory Path path) {
        this.proxyServer = proxyServer;
        this.logger = logger;
        this.path = path;
        
        instance = this;
        try {
            messagesRepository = new HoconMessagesRepository(HoconConfigurationLoader.builder()
                .setPath(path.resolve("messages.conf"))
                .build());
        } catch (IOException e) {
            logger.error("Сообщения не подгрузились. Плагин выключен", e);
        }
    
        logger.info("Hello there, it's a test plugin I made!");
        logger.info("Now plugin init!");
    }
    
    public static VelocityCorePlugin getInstance() {
        return instance;
    }
    
    public static MessagesRepository getMessagesRepository() {
        return messagesRepository;
    }
    
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        //server.getEventManager().register(this, new PluginListener());
        //server.getCommandManager().register("message", new MessageCommand(server), "msg");
        proxyServer.getEventManager().register(this, new PlayerJoinListener(proxyServer, logger));
        
        logger.info("Now plugin enabled");
    }
    
}