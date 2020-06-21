package su.mcstudio.velocitycore.message.repository;

import com.google.common.collect.Maps;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.mcstudio.velocitycore.message.Message;

import java.io.IOException;
import java.util.Map;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
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
        // TODO
    }
    
    @Override
    public @Nullable Message getMessage(@NotNull String key) {
        return keyMessageMap.get(key);
    }
    
/*    private Map<String, Message> loadMessages(ConfigurationNode messagesNode) {
        Map<String, Message> messages = Maps.newHashMap();
    
        messagesNode.getChildrenMap().forEach(new BiConsumer<Object, ConfigurationNode>() {
            @Override
            public void accept(Object o, ConfigurationNode configurationNode) {
                messages.put((String) o, configurationNode.getString());
            }
        });
        
        return messages;
    }*/
}
