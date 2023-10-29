package pl.lelakowski.spring.jpa.postgresql.service;

import pl.lelakowski.spring.jpa.postgresql.model.Tutorial;
import pl.lelakowski.spring.jpa.postgresql.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class TutorialService {

    private final TutorialRepository tutorialRepository;


    public List<Tutorial> findByTitleContaining(String title) {
        log.info("Init TutorialService. findByTitleContaining with argument {}", title);
        log.debug("Test debug message start TutorialService.findByTitleContaining");
        List<Tutorial> tutorials;

        if (title == null) {
            log.info("title == null");
            tutorials = tutorialRepository.findAll();
        } else {
            log.info("title != null");
            tutorials = tutorialRepository.findByTitleContaining(title);
        }
        log.debug("Test debug message end TutorialService.findByTitleContaining");
        return tutorials;
    }

    public Optional<Tutorial> findById(Long id) {
        log.info("Init TutorialService. findById with argument {}", id);
        log.debug("Test debug message start TutorialService.findById");
        return tutorialRepository.findById(id);
    }

    public Tutorial save(Tutorial tutorial) {
        log.info("Start saving tutorial: {}", tutorial);
        Tutorial tutorialToSave = new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false);
        log.info("After create entity: {}", tutorialToSave);
        tutorialRepository.save(tutorialToSave);
        log.warn("After save: {}", tutorialToSave);
        return tutorialToSave;
    }
}
