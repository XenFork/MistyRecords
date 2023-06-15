package union.xenfork.misty.records.face;

public interface GSetPlayerEntity {
    default double getStrength() {throw new AssertionError();}
    default void setStrength(double strength) {}
    default void addStrength(double d) {}
    default double getAura() {throw new AssertionError();}
    default void setAura(double aura) {}
    default void addAura(double d) {}

}
