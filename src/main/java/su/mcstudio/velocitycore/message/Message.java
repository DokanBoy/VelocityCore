package su.mcstudio.velocitycore.message;

import com.google.common.collect.ImmutableList;
import com.velocitypowered.api.command.CommandSource;
import net.kyori.text.TextComponent;
import org.jetbrains.annotations.NotNull;
import su.mcstudio.velocitycore.message.impl.MultiMessage;
import su.mcstudio.velocitycore.message.impl.SingleMessage;

/**
 * @author Alexey Zakharov
 * @since 21.06.2020
 */
public interface Message {
    
    TextComponent getComponent();
    
    default SingleMessage of(@NotNull String message) {
        return new SingleMessage(message);
    }
    
    default MultiMessage of(@NotNull ImmutableList<String> message) {
        return new MultiMessage(message);
    }
    
    default void send(@NotNull CommandSource source, @NotNull Message message) {
        source.sendMessage(message.getComponent());
    }
}
