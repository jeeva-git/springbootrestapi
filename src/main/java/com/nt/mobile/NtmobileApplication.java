package com.nt.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NtmobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(NtmobileApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner (NtmobileRepository repository) {
//		return args -> {
//			Asset asset = new Asset( "MAC123456B13",
//					"123werghkll",
//					"laptop",
//					"windows",
//					"12-Jun-22",
//					"12-Jun-23",
//					"Nexturn",
//					true,
//					"Aravind@nexturn.com"
//			);
//
//			System.out.println("asset.getAllocatedTo()    "+asset.getAllocatedTo());
//			repository.findAssetByAllocatedTo(asset.getAllocatedTo())
//					.ifPresentOrElse(s -> {
//						System.out.println("Asset "+ s.getAssetId()+" is already allocated"+ s.getAllocatedTo());
//					}, ()->{
//						System.out.println("Inserting new asset allocation");
//						repository.insert(asset);
//					});
//		};
//	}
}
