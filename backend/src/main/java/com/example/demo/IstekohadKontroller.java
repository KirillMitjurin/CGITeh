package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// Endpoint mis tagastab istekohad, sooviatatud istekohad.
@RestController
@RequestMapping("/api")
public class IstekohadKontroller {

    @Autowired
    IstekohadRepository istekohadRepository;

// tagastab kõik istekohad, mis on sellel lennukil.
    @GetMapping("/istekohad")
    public List<Istekohad> getAllIstekohad(@RequestParam("id") Long lennudId) {
        return istekohadRepository.findByLennudId(lennudId);
    }

// meetod, istekohade soovitamiseks.
    @GetMapping("/istekohadRekomendation")
    public List<Istekohad> getAllIstekohad(@RequestParam("id") Lennud lennud, @RequestParam("arv") int arv, @RequestParam("aken") boolean aken, @RequestParam("ruum") boolean jalaruum, @RequestParam("valjapaas") boolean valjapaas) {
        List<Istekohad> koikKohad = istekohadRepository.findByLennudId(lennud.getId()); // leiab kõik istekohad
        List<Istekohad> essaFilter = new ArrayList<>();
        for (Istekohad koht : koikKohad) { // Esiteks kontrollib, kas kohal peab olema ohkem jalaruumi ja kas see peab olema väljapääsu kõrval
            if (!koht.isSeatOccupied() && (!jalaruum || koht.isLegSpace()) && (!valjapaas || koht.isCloseToExit())) {
                essaFilter.add(koht); // tagastab kõik kohad mis sobivad.
            }
        } // kui pileti arv on 1
        if (arv == 1) {
            if (aken) {  // kui koht peab olema akna all
                return essaFilter.stream().filter(Istekohad::isUnderWindow).collect(Collectors.toList()); // filtreerib kohad.
            } else { // tagastab nagu nii.
                return essaFilter;
            }
        }
        // kui pileti arv on suurem kui 1
        List<List<Istekohad>> kohadkorval = leiaKohadKorval(essaFilter, arv); // leiab kõik kohad kõrval
        return filterKohadKorval(kohadkorval, aken); // filtreerib neid
    }

    private List<Istekohad> filterKohadKorval(List<List<Istekohad>> kohadkorval, boolean aken) {
        List<Istekohad> tulemus = new ArrayList<>();
            if (aken){ // kui on mõni piletid, ja valitud koht akna all, siis leiab need kohad kõrval, kus on 1 akna all
                for (List<Istekohad> rida : kohadkorval) {
                    for (Istekohad koht : rida) {
                        if (koht.isUnderWindow()) {
                            tulemus.addAll(rida);
                        }
                    }
                }
            }else{ // või lisab kõik kohad mis on kõrval.
                for (List<Istekohad> rida : kohadkorval) {
                    tulemus.addAll(rida);
                }
            }

            return tulemus;
    }


    private List<List<Istekohad>> leiaKohadKorval(List<Istekohad> koikKohad, int arv) {
        List<List<Istekohad>> koikKohadKorval = new ArrayList<>();
        for (int i = 0; i < koikKohad.size() - arv; i++) { // vaatab kõik kohad.
            List<Istekohad> kohad = koikKohad.subList(i, i + arv); // võtab osa hulk
            boolean kohadKorval = kasKohadKorval(kohad); // kutsub meetod, mis tagastab True kui kohad on kõrval
            if (kohadKorval){
                koikKohadKorval.add(kohad);
            }
        }
        return koikKohadKorval;
    }

    private boolean kasKohadKorval(List<Istekohad> kohad) {
        for (int i = 0; i < kohad.size() - 1; i++) {
            Istekohad koht = kohad.get(i);
            Istekohad jargmineKoht = kohad.get(i + 1);
            if (koht.getRowNumber() != jargmineKoht.getRowNumber() || koht.getColumnNumber() + 1 != jargmineKoht.getColumnNumber()){ // kui nad ei ole järjes, siis tagastab false.
                return false;
            }
        }
        return true;
    }
}
