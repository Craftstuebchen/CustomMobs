package de.hellfirepvp.cmd.cmob;

import de.hellfirepvp.CustomMobs;
import de.hellfirepvp.cmd.BaseCommand;
import de.hellfirepvp.cmd.MessageAssist;
import de.hellfirepvp.cmd.PlayerCmobCommand;
import de.hellfirepvp.data.mob.CustomMob;
import de.hellfirepvp.lib.LibLanguageOutput;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * HellFirePvP@Admin
 * Date: 19.05.2015 / 17:53
 * on Project CustomMobs
 * CommandCmobFireProof
 */
public class CommandCmobFireProof extends PlayerCmobCommand {

    @Override
    public void execute(Player p, String[] args) {
        String name = args[1];

        boolean b;
        try {
            b = Boolean.parseBoolean(args[2]);
        } catch (Exception exc) {
            MessageAssist.msgShouldBeABooleanValue(p, args[2]);
            BaseCommand.sendPlayerDescription(p, this, false);
            return;
        }

        CustomMob cmob = CustomMobs.instance.getMobDataHolder().getCustomMob(name);
        if(cmob == null) {
            MessageAssist.msgMobDoesntExist(p, name);
            BaseCommand.sendPlayerDescription(p, this, true);
            return;
        }
        cmob.getDataAdapter().setFireProof(b);
        p.sendMessage(LibLanguageOutput.PREFIX + ChatColor.GREEN + name +
                (b ? "won't take damage from fire and related anymore." : "will take damage from fire and related."));
    }

    @Override
    public String getCommandStart() {
        return "fireproof";
    }

    @Override
    public boolean hasFixedLength() {
        return true;
    }

    @Override
    public int getFixedArgLength() {
        return 3;
    }

    @Override
    public int getMinArgLength() {
        return 0;
    }

}
