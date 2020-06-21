package su.mcstudio.velocitycore.message.impl;

import com.google.common.collect.ImmutableList;
import net.kyori.text.TextComponent;
import su.mcstudio.velocitycore.message.Message;

import java.util.List;


/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */
public class MultiMessage implements Message {
    
    private final ImmutableList<String> message;
    private final TextComponent textComponent;
    
    public MultiMessage(List<String> message) {
        this.message = ImmutableList.copyOf(message);
        this.textComponent = TextComponent.empty();
        
        // TODO: Пересмотреть логику, в сообщение всегда будет последяя пустая строка
        for (String s : this.message) {
            textComponent.append(TextComponent.of(s).append(TextComponent.newline()));
        }
    }
    
    @Override
    public TextComponent getComponent() {
        return textComponent;
    }
    
    public ImmutableList<String> getRawMessage() {
        return message;
    }
    
    @Override
    public String toString() {
        return "MultiMessage{" + "message=[" + message.toString() +
            "], textComponent=[" + textComponent.toString() +
            "]}";
    }
    
}
