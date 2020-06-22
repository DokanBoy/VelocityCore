package su.mcstudio.velocitycore.message.repository;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.mcstudio.velocitycore.message.Message;

import java.io.IOException;
import java.util.Map;

/**
 * @author Alexey Zakharov
 * @since 21.06.2020
 */
public class HoconMessagesRepository implements MessagesRepository {
    
    private final Map<String, Message> keyMessageMap;
    private final ConfigurationNode messagesNode;
    
    public HoconMessagesRepository(HoconConfigurationLoader loader) throws IOException {
        this.keyMessageMap = Maps.newHashMap();
        this.messagesNode = loader.load();
        
        load(messagesNode);
    }
    
    @Override
    public void load(@NotNull ConfigurationNode messagesNode) {
        try {
            keyMessageMap.putAll(messagesNode.getValue(TypeToken.of(Map.class)));
        } catch (ObjectMappingException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public @Nullable Message getMessage(@NotNull String key) {
        return keyMessageMap.get(key);
    }
    
}
