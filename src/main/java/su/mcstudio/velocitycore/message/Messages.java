package su.mcstudio.velocitycore.message;

import net.kyori.text.TextComponent;
import org.jetbrains.annotations.NotNull;
import su.mcstudio.velocitycore.VelocityCorePlugin;

/**
 * @author Alexey Zakharov
 * @since 21.06.2020
 */
public enum Messages {
    
    CORE_INFO("core_info"),
    ;
    
    private final String key;
    
    Messages(@NotNull String key) {
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
