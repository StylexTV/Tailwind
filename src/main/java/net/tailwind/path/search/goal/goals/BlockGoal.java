package net.tailwind.path.search.goal.goals;

import net.minecraft.util.math.BlockPos;
import net.tailwind.path.search.goal.Goal;

public class BlockGoal extends Goal {
	
	private BlockPos position;
	
	@Override
	public double cost(BlockPos pos) {
		pos = pos.subtract(position);
		
		return absoluteCost(pos);
	}
	
	@Override
	public boolean isTerminal(BlockPos pos) {
		return pos.equals(position);
	}
	
	@Override
	public String toString() {
		return String.format("BlockGoal{pos=%s}", position);
	}
	
	public BlockPos getPosition() {
		return position;
	}
	
	public static double absoluteCost(BlockPos pos) {
		return XZGoal.absoluteCost(pos) + YLevelGoal.absoluteCost(pos);
	}
	
}