package LoadBalancerPackage;

public class LoadBalancingStrategyManager {
    LoadBalancingStrategy loadBalancingStrategy;
    private static LoadBalancingStrategyManager loadBalancingStrategyManager;
    private LoadBalancingStrategyManager(){

    }
    public static LoadBalancingStrategyManager getLoadBalancingManager()
    {
        if(loadBalancingStrategyManager == null)
        {
            loadBalancingStrategyManager = new LoadBalancingStrategyManager();
        }
        return loadBalancingStrategyManager;
    }
    public static LoadBalancingStrategy getLoadBalancingStrategy(String strategy){
        return switch (strategy) {
            case ("RoundRobin") -> new RoundRobinStrategy();
            case ("Random") -> new RandomStrategy();
            default -> throw new RuntimeException();
        };
    }
}
