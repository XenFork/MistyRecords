package union.xenfork.misty.records.face;

public interface GSetPlayerEntity {
    default double getStrength() {throw new AssertionError();}
    default void setStrength(double strength) {}
    default void addStrength(double d) {}
    default double getAura() {throw new AssertionError();}
    default void setAura(double aura) {}
    default void addAura(double d) {}
    default double getDefense() {throw new AssertionError();}
    default void setDefense(double defense) {}
    default void addDefense(double d) {}
    default double getBlood() {throw new AssertionError();}
    default void setBlood(double blood) {}
    default void addBlood(double d) {}
    default double getCriticalHit() {throw new AssertionError();}
    default void setCriticalHit(double criticalHit) {}
    default void addCriticalHit(double d) {}
    default double getCriticalDamage() {throw new AssertionError();}
    default void setCriticalDamage(double criticalDamage) {}
    default void addCriticalDamage(double d) {}

    default double getSpeed() {throw new AssertionError();}

    default void setSpeed(double speed) {}

    default void addSpeed(double d) {}

    default double getEndurance() {throw new AssertionError();}

    default void setEndurance(double endurance) {}

    default void addEndurance(double d) {}

    default double getPotential() {throw new AssertionError();}

    default void setPotential(double potential) {}

    default void addPotential(double d) {}
}
