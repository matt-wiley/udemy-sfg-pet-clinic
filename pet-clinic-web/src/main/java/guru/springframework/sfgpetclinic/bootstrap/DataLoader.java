package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;

  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = createOwner("Michael", "Weston");
    ownerService.save(owner1);

    Owner owner2 = createOwner("Fiona", "Glenanne");
    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = createVet("Sam", "Axe");
    vetService.save(vet1);

    Vet vet2 = createVet("Jessie", "Porter");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }

  private Owner createOwner(String firstName, String lastName) {
    Owner owner = new Owner();
    owner.setFirstName(firstName);
    owner.setLastName(lastName);
    return owner;
  }

  private Vet createVet(String firstName, String lastName) {
    Vet vet = new Vet();
    vet.setFirstName(firstName);
    vet.setLastName(lastName);
    return vet;
  }

}
