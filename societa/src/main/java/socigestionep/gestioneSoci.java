package socigestionep;

import java.io.*;
import java.util.*;
class gestioneSoci {
    private  ArrayList<Socio> soci;
    public gestioneSoci(){
        soci=new ArrayList<>();
    }
    public void aggiungiSocio(Socio socio) {
        if (!soci.stream().anyMatch(s -> s.getNome().equals(socio.getNome()) && s.getCognome().equals(socio.getCognome()))) {
            soci.add(socio);
        } else {
            try {
                throw new memberAlreadyExistsExeption();
            } catch (memberAlreadyExistsExeption e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
    }


    public void modificaSocio(Socio socio, String nuovoNome, String nuovoCognome, int nuovaEta) {
        socio.setNome(nuovoNome);
        socio.setCognome(nuovoCognome);
        socio.setEta(nuovaEta);
    }

    public void rimuoviSocio(Socio socio) {
        if (soci.contains(socio)) {
            soci.remove(socio);
        } else {
           try {
            throw new memberDoesntExistExeption();
        } catch (memberDoesntExistExeption e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }

    public void incrementaEtaDiTutti() {
        soci.forEach(Socio::incrementaEta);
    }


    public double calcolaEtaMedia() {
        return soci.stream().mapToDouble(Socio::getEta).average().orElse(0);
    }

    public ArrayList<Double> calcolaEtaMediaPerSesso() {
        ArrayList<Double> etaMediaPerSesso = new ArrayList<>();
        for (char sesso : new char[]{'M', 'F'}) {
            double media = soci.stream()
                    .filter(s -> s.getSesso() == sesso)
                    .mapToInt(Socio::getEta)
                    .average().orElse(0);
            etaMediaPerSesso.add(media);
        }
        return etaMediaPerSesso;
    }

 
    public ArrayList<Double> calcolaDistribuzioneSesso() {
        ArrayList<Double> distribuzioneSesso = new ArrayList<>();
        for (char sesso : new char[]{'M', 'F'}) {
            long count = soci.stream().filter(s -> s.getSesso() == sesso).count();
            double percentuale = (count * 100.0) / soci.size();
            distribuzioneSesso.add(percentuale);
        }
        return distribuzioneSesso;
    }

    public void esportaSociSuFile(String nomeFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            for (Socio socio : soci) {
                writer.println(socio.getNome() + "," + socio.getCognome() + "," + socio.getEta() + "," + socio.getSesso());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getSoci() {
        return null;
    }
}