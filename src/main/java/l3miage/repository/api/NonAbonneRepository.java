package l3miage.repository.api;


import l3miage.model.NonAbonne;

public interface NonAbonneRepository extends Repository<NonAbonne, Long> {



    NonAbonne findNonAbonneByCodeSecret(Integer codesecret);
}
