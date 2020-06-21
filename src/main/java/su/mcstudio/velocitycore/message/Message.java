package su.mcstudio.velocitycore.message;


import com.google.common.collect.ImmutableList;
import net.kyori.text.TextComponent;
import su.mcstudio.velocitycore.message.impl.MultiMessage;
import su.mcstudio.velocitycore.message.impl.SingleMessage;

/**
 * @author Alexey Zakharov
 * @date 21.06.2020
 */
public interface Message {
    
    TextComponent getComponent();
    
    default SingleMessage of(String message) {
        return new SingleMessage(message);
    }
    
    default MultiMessage of(ImmutableList<String> message) {
        return new MultiMessage(message);
    }
}
