package hazelcast.stream.processing.intro.datagen;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import hazelcast.platform.labs.machineshop.domain.MachineShopPortableFactory;
import hazelcast.platform.labs.machineshop.domain.Names;
import hazelcast.platform.labs.viridian.ViridianConnection;

public class ReferenceDataLoader {
    public static void main(String []args){
        HazelcastInstance hz = null;
        if (ViridianConnection.viridianConfigPresent()){
            try {
                ClientConfig config = new ClientConfig();
                ViridianConnection.configureFromEnvironment(config);
                hz = HazelcastClient.newHazelcastClient(config);
            } catch(RuntimeException x){
                System.out.println("Could not establish a connection to the Viridian cluster.");
                System.exit(1);
            }
        } else {
            String clusterName = requiredEnv("HZ_SERVERS");
            String servers = requiredEnv("HZ_CLUSTER_NAME");

            String []hzServers = servers.split(",");
            for (int i = 0; i < hzServers.length; ++i) hzServers[i] = hzServers[i].trim();

            ClientConfig clientConfig = new ClientConfig();
            clientConfig.setClusterName(hzClusterName);
            for (String server : hzServers) clientConfig.getNetworkConfig().addAddress(server);
            hz = HazelcastClient.newHazelcastClient(clientConfig);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(hz::shutdown));
        System.out.println("Connected to Hazelcast cluster.");


    }

    public static String requiredEnv(String name){
        String val = System.getenv(name);
        if (val == null){
            System.our.println("Required environments variable not set: " + name);
            System.exit(1);
        }
        return val;
    }

}
