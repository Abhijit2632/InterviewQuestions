package com.cosmos.service;

import com.cosmos.model.Shareorder;
import com.cosmos.pojo.Note;
import com.cosmos.pojo.Shareorders;
import com.cosmos.repository.ShareRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@Slf4j
public class ShareService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ShareRepository shareRepository;
    public Shareorder buyShare(Shareorder shareorder) {
        shareorder.setOrderType("Buy");
        shareorder.setOrderedAt(LocalDate.now());
        shareorder.setTotalSpend(shareorder.getPriceAt()*shareorder.getQuantityOf());
        shareorder.setOrderStatus(true);
        saveNoteAsWell(shareorder.getCompanyName(),shareorder.getComment());
        return shareRepository.save(shareorder);
    }

    private void saveNoteAsWell(String companyName, String comment) {
        Note note = Note.builder()
                .companyName(companyName)
                .noteDescription(comment)
                .build();
        String saveNoteUrl = "http://localhost:9191/notes/save" ;
        ResponseEntity<Note> response = restTemplate.postForEntity(saveNoteUrl,note,Note.class);
                //.getForObject(saveNoteUrl, Note.class);
        log.info("Note taken successfully.");
    }

    public Shareorders getAllOrders() {
        return  new Shareorders(shareRepository.findAll());
    }

    public Shareorder sellShare(Shareorder shareorder) {
        shareorder.setOrderType("Sell");
        shareorder.setOrderedAt(LocalDate.now());
        shareorder.setOrderStatus(false);
        //shareorder.setTotalSpend(shareorder.getPriceAt()*shareorder.getQuantityOf());
        saveNoteAsWell(shareorder.getCompanyName(),shareorder.getComment());
        return shareRepository.save(shareorder);
    }
}
