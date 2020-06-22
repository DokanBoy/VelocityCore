package su.mcstudio.velocitycore.message.impl;

import com.google.common.collect.ImmutableList;
import net.kyori.text.TextComponent;
import org.jetbrains.annotations.NotNull;
import su.mcstudio.velocitycore.message.Message;

import java.util.List;

/**
 * @author Alexey Zakharov
 * @since 21.06.2020
 */
public class MultiMessage implements Message {
    
    private final ImmutableList<String> lines;
    private final transient TextComponent textComponent;
    
    public MultiMessage(@NotNull List<String> lines) {
        this.lines = ImmutableList.copyOf(lines);
        this.textComponent = TextComponent.empty();
        
        for (int i = 0; i < lines.size(); i++) {
            textComponent.append(TextComponent.of(lines.get(i)).append(TextComponent.newline()));
            if (i != lines.size())
                textComponent.append(TextComponent.newline());
        }
    }
    
    @Override
    public TextComponent getComponent() {
        return textComponent;
    }
    
    public ImmutableList<String> getRawMessage() {
        return lines;
    }
    
    @Override
    public String toString() {
        return "MultiMessage{" + "message=[" + lines.toString() +
            "], textComponent=[" + textComponent.toString() +
            "]}";
    }
    
}
