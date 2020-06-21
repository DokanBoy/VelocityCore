package su.mcstudio.velocitycore.message.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.mcstudio.velocitycore.message.Message;
import su.mcstudio.velocitycore.message.impl.MultiMessage;
import su.mcstudio.velocitycore.message.impl.SingleMessage;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */
public interface MessagesRepository {
    
    void addSingleMessage(@NotNull String key, @NotNull SingleMessage message);
    
    void addMultiMessage(@NotNull String key, @NotNull MultiMessage message);
    
    @Nullable
    Message getMessage(@NotNull String key);
}
