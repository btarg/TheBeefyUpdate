package io.github.icrazyblaze.beefyupdate.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class BeefGolemEntity extends IronGolemEntity implements IAngerable {

    public BeefGolemEntity(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.45D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    protected int decreaseAirSupply(int pAir) {
        return super.decreaseAirSupply(pAir);
    }

    @Override
    protected void doPush(Entity pEntity) {
        super.doPush(pEntity);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    public boolean canAttackType(EntityType<?> pType) {
        return super.canAttackType(pType);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT pCompound) {
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT pCompound) {
        super.readAdditionalSaveData(pCompound);
    }

    @Override
    public void startPersistentAngerTimer() {
        super.startPersistentAngerTimer();
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return super.getRemainingPersistentAngerTime();
    }

    @Override
    public void setRemainingPersistentAngerTime(int pTime) {
        super.setRemainingPersistentAngerTime(pTime);
    }

    @Override
    public UUID getPersistentAngerTarget() {
        return super.getPersistentAngerTarget();
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pTarget) {
        super.setPersistentAngerTarget(pTarget);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return super.doHurtTarget(pEntity);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return super.hurt(pSource, pAmount);
    }

    @Override
    public IronGolemEntity.Cracks getCrackiness() {
        return super.getCrackiness();
    }

    @Override
    public void handleEntityEvent(byte pId) {
        super.handleEntityEvent(pId);
    }

    @Override
    public int getAttackAnimationTick() {
        return super.getAttackAnimationTick();
    }

    @Override
    public void offerFlower(boolean pHoldingRose) {
        super.offerFlower(pHoldingRose);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return super.getHurtSound(pDamageSource);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    @Override
    protected ActionResultType mobInteract(PlayerEntity pPlayer, Hand pHand) {
        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        super.playStepSound(pPos, pBlock);
    }

    @Override
    public int getOfferFlowerTick() {
        return super.getOfferFlowerTick();
    }

    @Override
    public boolean isPlayerCreated() {
        return super.isPlayerCreated();
    }

    @Override
    public void setPlayerCreated(boolean pPlayerCreated) {
        super.setPlayerCreated(pPlayerCreated);
    }

    @Override
    public void die(DamageSource pCause) {
        super.die(pCause);
    }

    @Override
    public boolean checkSpawnObstruction(IWorldReader pLevel) {
        return super.checkSpawnObstruction(pLevel);
    }

    @Override
    public Vector3d getLeashOffset() {
        return super.getLeashOffset();
    }


}
