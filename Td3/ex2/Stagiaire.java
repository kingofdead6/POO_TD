package ex2;

public class Stagiaire extends Fonctionnaire {
        public int dureeStage ;
        public Stagiaire(String name, String firstName, double salary, int dureeStage) {
            super(name, firstName, salary);
            this.dureeStage = dureeStage;
        }
    
        @Override
        public double augmenterSalaire(double salaire, double pourcentage) throws AugmentationImpossibleException {
            throw new AugmentationImpossibleException("Interns cannot receive a salary increase.");
        }
    

}
