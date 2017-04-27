package oneyre.smfw;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class ValueTweakerCommand extends CommandBase {
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
	
	@Override
	public String getName() {
		return "tweak";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.smfw.tweak.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length != 2) throw new WrongUsageException("commands.smfw.tweak.usage");
		ValueTweaker.update(args[0], args[1]);
	}

}
