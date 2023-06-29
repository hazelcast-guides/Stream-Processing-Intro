package hazelcast.platform.labs.machineshop.domain;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;

public class MachineStatusEvent implements Portable {
    private String serialNum;
    private long eventTime;
    private int bitRPM;
    private short bitTemp;
    private int bitPositionX;
    private int bitPositionY;
    private int bitPositionZ;

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public int getBitRPM() {
        return bitRPM;
    }

    public void setBitRPM(int bitRPM) {
        this.bitRPM = bitRPM;
    }

    public short getBitTemp() {
        return bitTemp;
    }

    public void setBitTemp(short bitTemp) {
        this.bitTemp = bitTemp;
    }

    public int getBitPositionX() {
        return bitPositionX;
    }

    public void setBitPositionX(int bitPositionX) {
        this.bitPositionX = bitPositionX;
    }

    public int getBitPositionY() {
        return bitPositionY;
    }

    public void setBitPositionY(int bitPositionY) {
        this.bitPositionY = bitPositionY;
    }

    public int getBitPositionZ() {
        return bitPositionZ;
    }

    public void setBitPositionZ(int bitPositionZ) {
        this.bitPositionZ = bitPositionZ;
    }

    @Override
    public String toString() {
        return "MachineStatusEvent{" +
                "serialNum='" + serialNum + '\'' +
                ", timestamp=" + eventTime +
                ", bitRPM=" + bitRPM +
                ", bitTemp=" + bitTemp +
                ", bitPositionX=" + bitPositionX +
                ", bitBitPositionY=" + bitPositionY +
                ", bitPositionZ=" + bitPositionZ +
                '}';
    }

    @Override
    public int getFactoryId() {
        return MachineShopPortableFactory.ID;
    }

    public static final int ID= 2;
    @Override
    public int getClassId() {
        return MachineStatusEvent.ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeString("serialNum", this.serialNum);
        writer.writeLong("eventTime", this.eventTime);
        writer.writeInt("bitRPM", this.bitRPM);
        writer.writeShort("bitTemp", this.bitTemp);
        writer.writeInt("bitPositionX", this.bitPositionX);
        writer.writeInt("bitPositionY", this.bitPositionY);
        writer.writeInt("bitPositionZ", this.bitPositionZ);
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.serialNum = reader.readString("serialNum");
        this.eventTime = reader.readLong("eventTime");
        this.bitRPM = reader.readInt("bitRPM");
        this.bitTemp = reader.readShort("bitTemp");
        this.bitPositionX = reader.readInt("bitPositionX");
        this.bitPositionY = reader.readInt("bitPositionY");
        this.bitPositionZ = reader.readInt("bitPositionZ");
    }

}
