package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        OutsourcedPart GPU = new OutsourcedPart(145, "GeForce 1080 GPU", 250.00, 4, "Nvidia");
        OutsourcedPart CPU = new OutsourcedPart(189, "Ryzen 7000 CPU", 275.00, 1, "AMD");
        OutsourcedPart RAM = new OutsourcedPart(15, "Vengeance DDR4 RAM", 100.00, 2, "Corsair");
        InhousePart Monitor = new InhousePart(5, "Dell Monitor 1080", 150.00, 3, 1);
        InhousePart Keyboard = new InhousePart(745, "RedDragon Keyboard", 80.00, 6, 2);

        if (outsourcedPartRepository.count() == 0 && inhousePartRepository.count() == 0) {
            outsourcedPartRepository.save(GPU);
            outsourcedPartRepository.save(CPU);
            outsourcedPartRepository.save(RAM);
            inhousePartRepository.save(Monitor);
            inhousePartRepository.save(Keyboard);
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        Product LowEnd= new Product("Beginner PC",300.0,4);
        Product MidRange= new Product("Average PC",600.0,5);
        Product HighEnd= new Product("Highend PC",1000.0,2);
        Product Alienware= new Product("Alienware Laptop",1200.0,3);
        Product Lenovo= new Product("Lenovo Laptop",1100.0,1);

        if (productRepository.count() == 0) {
            productRepository.save(LowEnd);
            productRepository.save(MidRange);
            productRepository.save(HighEnd);
            productRepository.save(Alienware);
            productRepository.save(Lenovo);
        }
        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

        }    }

