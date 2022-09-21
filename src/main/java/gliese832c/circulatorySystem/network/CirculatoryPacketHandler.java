package gliese832c.circulatorySystem.network;

import gliese832c.circulatorySystem.CirculatorySystem;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class CirculatoryPacketHandler {
    public static final SimpleNetworkWrapper CIRCULATORY_NETWORK_WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel(CirculatorySystem.MOD_ID);
}
