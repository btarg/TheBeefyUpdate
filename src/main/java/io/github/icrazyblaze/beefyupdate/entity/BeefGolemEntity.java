package io.github.icrazyblaze.beefyupdate.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public class BeefGolemEntity extends IronGolem implements NeutralMob {

    public BeefGolemEntity(EntityType<? extends IronGolem> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.45D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);
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
    protected int decreaseAirSupply(int p_28882_) {
        return super.decreaseAirSupply(p_28882_);
    }

    @Override
    protected void doPush(Entity p_28839_) {
        super.doPush(p_28839_);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    public boolean canAttackType(EntityType<?> p_28851_) {
        return super.canAttackType(p_28851_);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_28867_) {
        super.addAdditionalSaveData(p_28867_);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_28857_) {
        super.readAdditionalSaveData(p_28857_);
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
    public void setRemainingPersistentAngerTime(int p_28859_) {
        super.setRemainingPersistentAngerTime(p_28859_);
    }

    @Override
    public UUID getPersistentAngerTarget() {
        return super.getPersistentAngerTarget();
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID p_28855_) {
        super.setPersistentAngerTarget(p_28855_);
    }

    @Override
    public boolean doHurtTarget(Entity p_28837_) {
        return super.doHurtTarget(p_28837_);
    }

    @Override
    public boolean hurt(DamageSource p_28848_, float p_28849_) {
        return super.hurt(p_28848_, p_28849_);
    }

    @Override
    public Crackiness getCrackiness() {
        return super.getCrackiness();
    }

    @Override
    public void handleEntityEvent(byte p_28844_) {
        super.handleEntityEvent(p_28844_);
    }

    @Override
    public int getAttackAnimationTick() {
        return super.getAttackAnimationTick();
    }

    @Override
    public void offerFlower(boolean p_28886_) {
        super.offerFlower(p_28886_);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_28872_) {
        return super.getHurtSound(p_28872_);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    @Override
    protected InteractionResult mobInteract(Player p_28861_, InteractionHand p_28862_) {
        return super.mobInteract(p_28861_, p_28862_);
    }

    @Override
    protected void playStepSound(BlockPos p_28864_, BlockState p_28865_) {
        super.playStepSound(p_28864_, p_28865_);
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
    public void setPlayerCreated(boolean p_28888_) {
        super.setPlayerCreated(p_28888_);
    }

    @Override
    public void die(DamageSource p_28846_) {
        super.die(p_28846_);
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader p_28853_) {
        return super.checkSpawnObstruction(p_28853_);
    }

    @Override
    public Vec3 getLeashOffset() {
        return super.getLeashOffset();
    }


}
