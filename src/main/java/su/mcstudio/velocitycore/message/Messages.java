package su.mcstudio.velocitycore.message;

import net.kyori.text.TextComponent;
import su.mcstudio.velocitycore.VelocityCorePlugin;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */
public enum Messages {
    
    CORE_INFO("core_info"),
    ;
    
    private final String key;
    
    Messages(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
    
    public Message getMessage() {
        return VelocityCorePlugin.getMessagesRepository().getMessage(key);
    }
    
    public TextComponent getColorizedMessage() {
        return getMessage().getComponent();
    }
}
