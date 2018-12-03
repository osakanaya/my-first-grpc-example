package uk.me.uohiro.grpc.example.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

import uk.me.uohiro.grpc.example.client.CalcClient;
import uk.me.uohiro.grpc.example.service.CalcService;

public class GrpcTest {
	public GrpcServerRule grpcServerRule = new GrpcServerRule(8080, new CalcService());
	public ManagedChannelRule managedChannelRule = new ManagedChannelRule("localhost", 8080);
	
	@Rule
	public RuleChain ruleChain = RuleChain.outerRule(grpcServerRule).around(managedChannelRule);
	
	@Test
	public void test() throws Exception {
		CalcClient client = new CalcClient(managedChannelRule.getManagedChannel());
		
		System.out.println("add: " + client.add(1, 2));
		System.out.println("sum: " + client.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}	
}
