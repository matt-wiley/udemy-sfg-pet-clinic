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

  public DataLoader() {
    this.ownerService = new OwnerServiceMap();
    this.vetService = new VetServiceMap();
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = createOwner(1L, "Michael", "Weston");
    ownerService.save(owner1);

    Owner owner2 = createOwner(2L, "Fiona", "Glenanne");
    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = createVet(1L, "Sam", "Axe");
    vetService.save(vet1);

    Vet vet2 = createVet(2L, "Jessie", "Porter");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }

  private Owner createOwner(Long id, String firstName, String lastName) {
    Owner owner = new Owner();
    owner.setId(id);
    owner.setFirstName(firstName);
    owner.setLastName(lastName);
    return owner;
  }

  private Vet createVet(Long id, String firstName, String lastName) {
    Vet vet = new Vet();
    vet.setId(id);
    vet.setFirstName(firstName);
    vet.setLastName(lastName);
    return vet;
  }

}
