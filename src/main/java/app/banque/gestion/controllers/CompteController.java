    package app.banque.gestion.controllers;

    import app.banque.gestion.entities.Client;
    import app.banque.gestion.entities.Compte;
    import app.banque.gestion.entities.CompteCourant;
    import app.banque.gestion.entities.CompteEparne;
    import app.banque.gestion.repositorys.ClientRepository;
    import app.banque.gestion.repositorys.CompteRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    @RequestMapping("/compte")

    public class CompteController {

        @Autowired
        CompteRepository compteRepository;


        @Autowired
        ClientRepository clientRepository;



        @PostMapping("/createCourant/{codeClient}")
        @ResponseBody
        public String createCompteCourant(@PathVariable Long codeClient, @RequestBody CompteCourant compteCourant) {
            Client client = clientRepository.findById(codeClient).orElse(null);
            if (client != null) {
                compteCourant.setClient(client);
                compteRepository.save(compteCourant);
                return "Compte courant créé avec succès";
            }
            return "Client introuvable";
        }

        @PostMapping("/createEpargne/{codeClient}")
        @ResponseBody
        public String createCompteEpargne(@PathVariable Long codeClient, @RequestBody CompteEparne compteEpargne) {
            Client client = clientRepository.findById(codeClient).orElse(null);
            if (client != null) {
                compteEpargne.setClient(client);
                compteRepository.save(compteEpargne);
                return "Compte épargne créé avec succès";
            }
            return "Client introuvable";
        }



        @PostMapping("/versement/{codeCompte}/{montant}")
        @ResponseBody
        public String versement(@PathVariable Long codeCompte, @PathVariable double montant) {
            Compte compte = compteRepository.findById(codeCompte).orElse(null);
            if (compte != null) {
                if (compte instanceof CompteCourant) {
                    CompteCourant compteCourant = (CompteCourant) compte;
                    double nouveauSolde = compteCourant.getSolde() + montant;
                    compteCourant.setSolde(nouveauSolde);
                    compteRepository.save(compteCourant);
                    return "Versement effectué avec succès";
                } else if (compte instanceof CompteEparne) {
                    CompteEparne compteEparne = (CompteEparne) compte;
                    double nouveauSolde = compteEparne.getSolde() + (montant * compteEparne.getTaux());
                    compteEparne.setSolde(nouveauSolde);
                    compteRepository.save(compteEparne);
                    return "Versement effectué avec succès";
                }
            }
            return "Le compte n'existe pas";
        }

        @PostMapping("/retrait/{codeCompte}/{montant}")
        @ResponseBody
        public String retrait(@PathVariable Long codeCompte, @PathVariable double montant) {
            Compte compte = compteRepository.findById(codeCompte).orElse(null);
            if (compte != null) {
                if (compte instanceof CompteCourant) {
                    CompteCourant compteCourant = (CompteCourant) compte;
                    double nouveauSolde = compteCourant.getSolde() - (montant * compteCourant.getDecouvert());
                    if (nouveauSolde >= 0) {
                        compteCourant.setSolde(nouveauSolde);
                        compteRepository.save(compteCourant);
                        return "Retrait effectué avec succès";
                    } else {
                        return "Solde insuffisant pour effectuer le retrait";
                    }
                } else if (compte instanceof CompteEparne) {
                    CompteEparne compteEparne = (CompteEparne) compte;
                    double nouveauSolde = compteEparne.getSolde() - montant;
                    if (nouveauSolde >= 0) {
                        compteEparne.setSolde(nouveauSolde);
                        compteRepository.save(compteEparne);
                        return "Retrait effectué avec succès";
                    } else {
                        return "Solde insuffisant pour effectuer le retrait";
                    }
                }
            }
            return "Le compte n'existe pas";
        }



        @GetMapping("/all")
        @ResponseBody
        public List<Compte> getAllComptes() {
            return compteRepository.findAll();
        }

        @GetMapping("/courant")
        @ResponseBody
        public List<CompteCourant> getComptesCourant() {
            return compteRepository.findAllCompteCourant();
        }

        @GetMapping("/epargne")
        @ResponseBody
        public List<CompteEparne> getComptesEpargne() {
            return compteRepository.findAllCompteEpargne();
        }
    }
