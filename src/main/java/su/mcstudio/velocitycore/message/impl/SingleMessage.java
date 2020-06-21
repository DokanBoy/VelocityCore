package su.mcstudio.velocitycore.message.impl;

import net.kyori.text.TextComponent;
import su.mcstudio.velocitycore.message.Message;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */
public class SingleMessage implements Message {
    
    private final String message;
    private final TextComponent textComponent;
    
    public SingleMessage(String message) {
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
}
