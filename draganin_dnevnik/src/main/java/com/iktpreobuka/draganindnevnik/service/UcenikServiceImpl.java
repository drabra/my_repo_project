package com.iktpreobuka.draganindnevnik.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iktpreobuka.draganindnevnik.dto.OcenaDto;
import com.iktpreobuka.draganindnevnik.entities.Ocena;
import com.iktpreobuka.draganindnevnik.entities.Predmet;
import com.iktpreobuka.draganindnevnik.entities.Ucenik;
import com.iktpreobuka.draganindnevnik.repositories.OcenaRepository;
import com.iktpreobuka.draganindnevnik.repositories.PredmetRepository;
import com.iktpreobuka.draganindnevnik.repositories.UcenikRepository;

@Service
public class OcenaServiceImpl implements OcenaService {

    private static final int  PRVO_POLUGODISTE = 1;
    private static final int  DRUGO_POLUGODISTE = 2;

    @Autowired
    private UcenikRepository ucenikRepository;

    @Autowired
    private PredmetRepository predmetRepository;

   
    @Autowired
    private OcenaRepository ocenaRepository;

    @Override
    @Transactional
    public ResponseEntity<Ocena> oceni(OcenaDto ocenaDto) {
        Ucenik ucenik = ucenikRepository.findOne(ocenaDto.getIdUcenik());
        if (ucenik == null) {
            return new ResponseEntity("Ne postoji ucenik sa datim ID-jem.", HttpStatus.BAD_REQUEST);
        }
        
        Predmet predmet = predmetRepository.findOne(ocenaDto.getIdPredmet());
        if (predmet == null) {
            return new ResponseEntity("Ne postoji predmet sa datim ID-jem.", HttpStatus.BAD_REQUEST);
        }
       
      
        
        if (ocenaDto.getOcena() < 1 || ocenaDto.getOcena() > 5) {
            return new ResponseEntity("Ocene moraju biti 1 - 5.", HttpStatus.BAD_REQUEST);
        }
        if (ocenaDto.getPolugodiste() != PRVO_POLUGODISTE && ocenaDto.getPolugodiste() != DRUGO_POLUGODISTE) {
            return new ResponseEntity("Polugodiste mora biti 1 ili 2.", HttpStatus.BAD_REQUEST);
        }
        if (ocenaDto.getZakljucnaOcena()) {
            List<Ocena> ocene = ocenaRepository.findAllByUcenikOrderByVremeOcenjivanjaDesc(ucenik);
            if (ocene != null) {
                for (Ocena ocena : ocene) {
                    if (ocena.getPredaje().getGrupa().getSkolskaGodina().getTrenutna() && ocena.getPolugodiste() == ocenaDto.getPolugodiste() && ocena.getZakljucnaOcena()) {
                        return new ResponseEntity("Vec postoji zakljucna ocena.", HttpStatus.BAD_REQUEST);
                    }
                }
                if (ocenaDto.getPolugodiste() == DRUGO_POLUGODISTE && !zakljucenoPrvoPolugodiste(ocene)) {
                    return new ResponseEntity("Nema zakljucne ocene u prvom polugodisto, tako da se ne moze zakljuciti u drugom.", HttpStatus.BAD_REQUEST);
                }
            }
        }
        Ocena ocenaZaDodavanje = new Ocena();
        ocenaZaDodavanje.setUcenik(ucenik);
        ocenaZaDodavanje.setVrednost(ocenaDto.getOcena());
        ocenaZaDodavanje.setPolugodiste(ocenaDto.getPolugodiste());
        ocenaZaDodavanje.setZakljucnaOcena(ocenaDto.getZakljucnaOcena());
        Date date = new Date();
        ocenaZaDodavanje.setVremeOcenjivanja(new Timestamp(date.getTime()));
        ocenaZaDodavanje.setPredaje(predaje);
        Ocena dodataOcena = ocenaRepository.save(ocenaZaDodavanje);
        if (dodataOcena == null) {
            return new ResponseEntity("Greska prilikom dodavanja ocene u bazu.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dodataOcena, HttpStatus.OK);
    }

    /*
    * Privatne metode
    * */
 /*   private boolean ucenikPripadaGrupi(List<Grupa> ucenikGrupe, int grupa) {
        boolean pripada = false;
        for (Grupa gr : ucenikGrupe) {
            int tekuca = gr.getIdGrupa();
            if (tekuca == grupa) {
                pripada = true;
                break;
            }
        }
        return pripada;
    }
*/
    private boolean zakljucenoPrvoPolugodiste(List<Ocena> ocene) {
        boolean zakljuceno = false;
        for (Ocena ocena : ocene) {
            if (ocena.getPolugodiste() == PRVO_POLUGODISTE && ocena.getPredaje().getGrupa().getSkolskaGodina().getTrenutna() && ocena.getZakljucnaOcena()) {
                zakljuceno = true;
                break;
            }
        }
        return zakljuceno;
    }
}