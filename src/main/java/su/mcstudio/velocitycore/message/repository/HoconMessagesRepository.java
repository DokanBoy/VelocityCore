package su.mcstudio.velocitycore.message.repository;

import com.google.common.collect.Maps;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.mcstudio.velocitycore.message.Message;
import su.mcstudio.velocitycore.message.impl.MultiMessage;
import su.mcstudio.velocitycore.message.impl.SingleMessage;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */
public class HoconMessagesRepository implements MessagesRepository {
    
    private final HashMap<String, Message> keyMessageMap;
    private final ConfigurationNode messagesNode;
    
    public HoconMessagesRepository(HoconConfigurationLoader loader) throws IOException {
        this.keyMessageMap = Maps.newHashMap();
        this.messagesNode = loader.load();
    }
    
    @Override
    public void addSingleMessage(@NotNull String key, @NotNull SingleMessage message) {
        keyMessageMap.put(key, message);
    }
    
    @Override
    public void addMultiMessage(@NotNull String key, @NotNull MultiMessage message) {
        keyMessageMap.put(key, message);
    }
    
    @Override
    public @Nullable Message getMessage(@NotNull String key) {
        return keyMessageMap.get(key);
    }
}
