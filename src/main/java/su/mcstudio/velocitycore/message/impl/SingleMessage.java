package su.mcstudio.velocitycore.message.impl;

import net.kyori.text.TextComponent;
import org.jetbrains.annotations.NotNull;
import su.mcstudio.velocitycore.message.Message;

/**
 * @author Alexey Zakharov
 * @since 21.06.2020
 */
public class SingleMessage implements Message {
    
    private final String message;
    private final transient TextComponent textComponent;
    
    public SingleMessage(@NotNull String message) {
        this.message = message;
        this.textComponent = TextComponent.of(message);
    }
    
    @Override
    public TextComponent getComponent() {
        return textComponent;
    }
    
    public String getRawMessage() {
        return message;
    }
    
    @Override
    public String toString() {
        return "SingleMessage{" + "message='" + message +
            ", textComponent=" + textComponent +
            '}';
    }
    
}
