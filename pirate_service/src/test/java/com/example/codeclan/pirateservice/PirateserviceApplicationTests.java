package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.pirates.PirateRepository;
import com.example.codeclan.pirateservice.repository.raids.RaidRepository;
import com.example.codeclan.pirateservice.repository.ships.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createPirateAndShipThenSave(){

		Raid foundRaid = raidRepository.getOne(1L);
		List<Pirate> oldPirates = pirateRepository.getPiratesOverCertainAge(35);
	}

	@Test
	public void createPirateAndRaidThenSave(){
		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);

		Raid raid = new Raid("Tortuga", 100);
		raidRepository.save(raid);

		jack.addRaid(raid);
		raid.addPirate(jack);
		raidRepository.save(raid);
		
	}


}
