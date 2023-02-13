package ma.emsi.roombookingsystem.imagesService;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class storageService {
    private final Path rootLocation = Paths.get(System.getProperty("user.home")+"/roomBooking/rooms");

    public void store(MultipartFile file) {
        try {

            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            System.out.println(this.rootLocation);
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
    public Resource loadFile(String filename) {
        Resource resource;
        try {
            Path file = rootLocation.resolve(filename);
            resource = (Resource) new UrlResource(file.toUri());

        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
        return resource;
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
