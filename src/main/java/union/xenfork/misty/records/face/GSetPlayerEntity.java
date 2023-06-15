package union.xenfork.misty.records.face;

public interface GSetPlayerEntity {
    default double getStrength() {throw new AssertionError();}
    default void setStrength(double strength) {}
    default void addStrength(double d) {}
}
