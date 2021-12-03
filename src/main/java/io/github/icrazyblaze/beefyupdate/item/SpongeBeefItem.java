package io.github.icrazyblaze.beefyupdate.item;

import com.google.common.collect.Lists;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Queue;

import static net.minecraft.block.Block.dropResources;

public class SpongeBeefItem extends Item {

    public SpongeBeefItem(Properties properties) {
        super(properties);
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.WOOL_PLACE;
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {

        if (pEntityLiving instanceof ServerPlayerEntity) {
            tryAbsorbWater(pLevel, pEntityLiving.blockPosition());
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }


    protected void tryAbsorbWater(World level, BlockPos blockPos) {
        if (this.removeWaterBreadthFirstSearch(level, blockPos)) {
            level.levelEvent(2001, blockPos, Block.getId(Blocks.WATER.defaultBlockState()));
        }

    }

    private boolean removeWaterBreadthFirstSearch(World level, BlockPos blockPos) {
        Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
        queue.add(new Tuple<>(blockPos, 0));
        int i = 0;

        while (!queue.isEmpty()) {
            Tuple<BlockPos, Integer> tuple = queue.poll();
            BlockPos blockpos = tuple.getA();
            int j = tuple.getB();

            for (Direction direction : Direction.values()) {
                BlockPos blockpos1 = blockpos.relative(direction);
                BlockState blockstate = level.getBlockState(blockpos1);
                FluidState fluidstate = level.getFluidState(blockpos1);
                Material material = blockstate.getMaterial();
                if (fluidstate.is(FluidTags.WATER)) {
                    if (blockstate.getBlock() instanceof IBucketPickupHandler && !((IBucketPickupHandler) blockstate.getBlock()).takeLiquid(level, blockpos1, blockstate).getBucket().getDefaultInstance().isEmpty()) {
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple<>(blockpos1, j + 1));
                        }
                    } else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
                        level.setBlock(blockpos1, Blocks.AIR.defaultBlockState(), 3);
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple<>(blockpos1, j + 1));
                        }
                    } else if (material == Material.WATER_PLANT || material == Material.REPLACEABLE_WATER_PLANT) {
                        TileEntity blockentity = blockstate.hasTileEntity() ? level.getBlockEntity(blockpos1) : null;
                        dropResources(blockstate, level, blockpos1, blockentity);
                        level.setBlock(blockpos1, Blocks.AIR.defaultBlockState(), 3);
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple<>(blockpos1, j + 1));
                        }
                    }
                }
            }

            if (i > 64) {
                break;
            }
        }

        return i > 0;
    }
}