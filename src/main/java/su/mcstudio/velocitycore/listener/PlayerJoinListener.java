package su.mcstudio.velocitycore.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.util.title.TextTitle;
import net.kyori.text.KeybindComponent;
import net.kyori.text.TextComponent;
import net.kyori.text.format.TextColor;
import net.kyori.text.format.TextDecoration;
import org.slf4j.Logger;
import su.mcstudio.velocitycore.VelocityCorePlugin;

import java.util.concurrent.TimeUnit;

/**
 * @author Alexey Zakharov
 * @since  20.06.2020
 */
public class PlayerJoinListener {
    
    private final ProxyServer proxyServer;
    public PlayerJoinListener(ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }
    
    // TODO
    @Subscribe
    public void onPlayerJoin(PostLoginEvent event) {
        Player player = event.getPlayer();
    
        proxyServer.getScheduler().buildTask(VelocityCorePlugin.getInstance(), () -> {
            player.sendMessage(TextComponent.of("Hello!"));
            player.sendTitle(TextTitle
                .builder()
                .title(TextComponent.of("Hello, " + player.getUsername()))
                .subtitle(TextComponent.of("Your ping: " + player.getPing()))
                .build());
        }).repeat(10, TimeUnit.SECONDS);
        
        
        final TextComponent playerJoinMessage = TextComponent.of("You're a ")
            .color(TextColor.GRAY)
            .append(TextComponent.of("Bunny").color(TextColor.LIGHT_PURPLE))
            .append(TextComponent.of("Press "))
            .append(KeybindComponent.of("key.jump")
                .color(TextColor.LIGHT_PURPLE)
                .decoration(TextDecoration.BOLD, true)
            )
            .append(TextComponent.of(" to jump!"));
        
        player.sendMessage(playerJoinMessage);
        
        player.sendMessage(TextComponent.of(player.getPing()));
        player.sendMessage(TextComponent.of(player.getPlayerSettings().getLocale().getCountry()));
    }
}
